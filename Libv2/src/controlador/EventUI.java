package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.function.Predicate;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import modelo.Libreria;
import modelo.Libro;
import utiles.Validaciones;
import vista.AccesoUI;

public class EventUI {
	private AccesoUI UI;
	private Libreria libreria;
	
	
	public EventUI(AccesoUI uI) {
		super();
		UI = uI;
		this.libreria = new Libreria(null);
		instanciarMetodos();
		rellenarTabla(UI.tablaEstanteria());
	}
	public void instanciarMetodos() {
		clickSalir();
		clickBorrar();
		clickGuardar();
		clickConsultar();
		clickModificar();
	}

	private void clickModificar() {
	    UI.botonModificar().addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	            int indice = libreria.obtenerIdSeleccionado(UI.tablaEstanteria());
	            if (indice == -1) {
	                JOptionPane.showMessageDialog(null, "Selecciona un libro para modificar.", "Aviso", JOptionPane.WARNING_MESSAGE);
	                return;
	            }

	            Libro libro = libreria.getArrayLibros().get(indice);
	            String isbnActual = libro.getISBN();

	            String isbn = pedirValidado("ISBN", isbnActual,
	                    s -> Validaciones.validarISBN(s)
	                    && (s.equals(isbnActual) || !libreria.comprobarIsbnExistente(s)));
	            String titulo = pedirValidado("Título", libro.getTitulo(), Validaciones::validarLetras);
	            String editorial = pedirValidado("Editorial", libro.getEditorial(), Validaciones::validarLetras);
	            String autor = pedirValidado("Autor", libro.getAutor(), Validaciones::validarLetras);
	            String precio = pedirValidado("Precio", String.valueOf(libro.getPrecio()), Validaciones::esUnFloat);
	            String stock = pedirValidado("Stock", String.valueOf(libro.getStock()),
	                    s -> Validaciones.esUnNumero(s) && s.length() <= 9);

	            libro.setISBN(isbn);
	            libro.setTitulo(titulo);
	            libro.setEditorial(editorial);
	            libro.setAutor(autor);
	            libro.setPrecio(Float.parseFloat(precio));
	            libro.setStock(Integer.parseInt(stock));

	            rellenarTabla(UI.tablaEstanteria());
	            JOptionPane.showMessageDialog(null, "Libro modificado correctamente");
	        }
	    });
	}



	private void clickConsultar() {
		UI.botonConsultar().addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        String ISBNsel = JOptionPane.showInputDialog("Introduce ISBN");
		        if (libreria.comprobarIsbnExistente(ISBNsel))
		            JOptionPane.showMessageDialog(null, libreria.obtenerLibro(ISBNsel) + ISBNsel);
		    }
		});
	}
	public void clickSalir() {
	    UI.botonSalir().addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	            int respuesta = JOptionPane.showConfirmDialog(
	                null,
	                "¿Está seguro de que desea salir?",
	                "Confirmar salida",
	                JOptionPane.YES_NO_OPTION,
	                JOptionPane.QUESTION_MESSAGE
	            );

	            if (respuesta == JOptionPane.YES_OPTION) {
	                System.exit(0);
	            }
	        }
	    });
	}
	public void clickGuardar() {
		UI.botonGuardar().addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    		if(aplicarTodasLasValidaciones()) {
		            Libro libro = crearLibro();
		            if (!libreria.comprobarIsbnExistente(libro.getISBN())) {
		                libreria.aniadirLibro(libro);
		                rellenarTabla(UI.tablaEstanteria());
						limpiarCamposLibro();
						limpiarRadioButtons();
		                JOptionPane.showMessageDialog(null, "Libro guardado correctamente");
		            }else {
		            	libreria.sumarAlStockPorIsbn(UI.campoTxtISBN().getText());
		            	rellenarTabla(UI.tablaEstanteria());
		                JOptionPane.showMessageDialog(null, "ISBN existente, libro añadido al stock");
		            }
		        }else 
		        	
		        	JOptionPane.showMessageDialog(null, "Campos erroneos");
		        
		    }
		});
	}

	public void clickBorrar() {
	    UI.botonBorrar().addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	            int indice = libreria.obtenerIdSeleccionado(UI.tablaEstanteria());
	            
	            if (indice == -1) {
	                JOptionPane.showMessageDialog(null, "Por favor, selecciona un libro de la estantería para borrar.", "Aviso", JOptionPane.WARNING_MESSAGE);
	                return;
	            }
	            
	            Libro libroSeleccionado = libreria.getArrayLibros().get(indice);
	            
	            if (libroSeleccionado.getStock() > 1) {
	                libroSeleccionado.setStock(libroSeleccionado.getStock() - 1);
	                rellenarTabla(UI.tablaEstanteria()); 
	                JOptionPane.showMessageDialog(null, "Se ha descontado 1 unidad del stock.");
	            } else {
	                libreria.borrarLibros(indice);
	                rellenarTabla(UI.tablaEstanteria());
	                JOptionPane.showMessageDialog(null, "Libro borrado por completo de la estantería.");
	            }
	        }
	    });
	}
	public void rellenarTabla(JTable tablaLibros) {
	    String nombresColumnas[] = { "ISBN", "TITULO", "EDITORIAL", "AUTOR", "PRECIO","STOCK" };
	    String[][] filasTabla = new String[this.libreria.getArrayLibros().size()][6];
	    for (int i = 0; i < this.libreria.getArrayLibros().size(); i++) {
	        filasTabla[i][0] = this.libreria.getArrayLibros().get(i).getISBN();
	        filasTabla[i][1] = this.libreria.getArrayLibros().get(i).getTitulo();
	        filasTabla[i][2] = this.libreria.getArrayLibros().get(i).getEditorial();
	        filasTabla[i][3] = this.libreria.getArrayLibros().get(i).getAutor();
	        filasTabla[i][4] = String.valueOf(this.libreria.getArrayLibros().get(i).getPrecio());
	        filasTabla[i][5] = String.valueOf(this.libreria.getArrayLibros().get(i).getStock());
	    }
	    DefaultTableModel tablaCompleta = new DefaultTableModel(filasTabla, nombresColumnas);
	    tablaLibros.setModel(tablaCompleta);
	}
	
	public String getRadioButtonFormato() {
	    if (UI.rdbtnCartone().isSelected()) {
	        return UI.rdbtnCartone().getText();
	    }
	    if (UI.rdbtnEspiral().isSelected()) {
	        return UI.rdbtnEspiral().getText();
	    }
	    if (UI.rdbtnGrapada().isSelected()) {
	        return UI.rdbtnGrapada().getText();
	    }
	    if (UI.rdbtnRustica().isSelected()) {
	        return UI.rdbtnRustica().getText();
	    }
	    return null;
	}
	public String getRadioButtonEstado() {
	    if (UI.rdbtnNovedad().isSelected()) {
	        return UI.rdbtnNovedad().getText();
	    }
	    if (UI.rdbtnReedicion().isSelected()) {
	        return UI.rdbtnReedicion().getText();
	    }
	    return null;
	}
	
	public void limpiarRadioButtons() {
		UI.grupoEstado().clearSelection();
		UI.grupoFormato().clearSelection();
	}
	
	public boolean aplicarTodasLasValidaciones() {
        if (Validaciones.validarISBN(UI.campoTxtISBN().getText()) 
        		&& Validaciones.validarLetras(UI.campoTxtAutor().getText())
        		&& Validaciones.validarLetras(UI.campoTxtEditorial().getText()) 
        		&& Validaciones.validarLetras(UI.campoTxtTitulo().getText()) 
        		&& Validaciones.esUnFloat(UI.campoTxtPrecio().getText())) {
        	return true;
        }
        return false;	
	}
	
	private String pedirValidado(String campo, String valorActual, Predicate<String> validacion) {
	    while (true) {
	        String nuevo = JOptionPane.showInputDialog(null, "Nuevo valor para " + campo + ":", valorActual);
	        if (nuevo == null || nuevo.isBlank()) {
	            return valorActual;
	        }
	        if (validacion.test(nuevo)) {
	            return nuevo;
	        }
	        JOptionPane.showMessageDialog(null, "Valor no válido para " + campo, "Error", JOptionPane.ERROR_MESSAGE);
	    }
	}
	
	public Libro crearLibro() {
		Libro libro = new Libro(
				UI.campoTxtTitulo().getText(),
				UI.campoTxtAutor().getText(), 
				UI.campoTxtISBN().getText(), 
				UI.campoTxtEditorial().getText(), 
				getRadioButtonFormato(),
				getRadioButtonEstado(),
				Float.parseFloat(UI.campoTxtPrecio().getText()),
				1);
		return libro;
	}

	public void limpiarCamposLibro() {
		UI.campoTxtAutor().setText("");
		UI.campoTxtEditorial().setText("");
		UI.campoTxtISBN().setText("");
		UI.campoTxtPrecio().setText("");;
		UI.campoTxtTitulo().setText("");;
	}
}

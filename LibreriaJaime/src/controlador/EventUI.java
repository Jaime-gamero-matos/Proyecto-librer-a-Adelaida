package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import modelo.Libreria;
import modelo.Libro;
import vista.AccesoUI;

public class EventUI {
	private AccesoUI UI;
	private Libreria libreria;
	
	public EventUI(AccesoUI uI) {
		super();
		UI = uI;
		libreria = new Libreria(new ArrayList<Libro>());
		inicializarMetodosVista();
	}
	public void inicializarMetodosVista() {
		clickGuardar();
		clickSalir();
		clickMostrar();
	}
	public void clickSalir() {
		UI.botonSalir().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
	}
	public void clickMostrar() {
		try {
			UI.botonMostrar().addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ArrayList<Libro> listaLibros = libreria.getLibreria();
					String tablaLibreria = "<html><table border='1' cellspacing='0' cellpadding='5'>><tr><th>Titulo</th><th>Autor</th><th>ISBN</th><th>Editorial</th><th>Precio</th></tr>";
					for (Libro libro : listaLibros) {
						tablaLibreria +="<tr><td>"+libro.getTitulo()+"</td><td>"+libro.getAutor()+"</td><td>"+libro.getISBN()+"</td><td>"+libro.getEditorial()+"</td><td>"+libro.getPrecio()+"</td>";
						
					}
					tablaLibreria += "</tr></table></html>";
					UI.textoLibreria().setText(tablaLibreria);
				}
			});
		} catch (Exception exc) {
			System.err.println(exc);
		}
		
	}
	public void clickGuardar() {
		UI.botonGuardar().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Libro libro = new Libro(
							UI.campoTxtTitulo().getText(),
							UI.campoTxtAutor().getText(), 
							UI.campoTxtISBN().getText(), 
							UI.campoTxtEditorial().getText(), 
							Float.parseFloat(UI.campoTxtPrecio().getText()));
					libreria.aniadirLibro(libro);
					limpiarCamposLibro();
				} catch (Exception exc) {
					System.err.println(exc);
				}
			}
		});
		
	}
	
	
	public void limpiarCamposLibro() {
		UI.campoTxtAutor().setText("");
		UI.campoTxtEditorial().setText("");
		UI.campoTxtISBN().setText("");
		UI.campoTxtPrecio().setText("");;
		UI.campoTxtTitulo().setText("");;
	}
}

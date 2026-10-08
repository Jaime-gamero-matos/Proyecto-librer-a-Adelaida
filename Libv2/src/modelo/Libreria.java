package modelo;

import java.util.ArrayList;

import javax.swing.JTable;


public class Libreria {
	private ArrayList<Libro> arrayLibros = new ArrayList<Libro>();

	

 	public Libreria(ArrayList<Libro> arrayLibros) {
		super();
		this.arrayLibros = establecerListaDeLibroPorDefecto();
	}

	public void aniadirLibro(Libro libro) {
		arrayLibros.add(libro);
	}
	
 	public void borrarLibros(Libro libro) {
 		arrayLibros.remove(libro);
 	}
 	public void borrarLibros(int indice) {
 		arrayLibros.remove(indice);
 	}

	public ArrayList<Libro> getArrayLibros() {
		return arrayLibros;
	}
	
	public int obtenerIdSeleccionado(JTable tablaLibros) {
	    for (int i = 0; i < this.arrayLibros.size(); i++) {
	        if (tablaLibros.getSelectedRow() == i) {
	            return i;
	        }
	    }
	    return -1;
	}
	
	public Libro obtenerLibroDos(String ISBN) {
	    for (int i = 0; i < this.arrayLibros.size(); i++) {
	        if (this.arrayLibros.get(i).getISBN().equals(ISBN)) {
	            return arrayLibros.get(i);
	        }
	    }
	    return null;
	}
	


	public void setArrayLibros(ArrayList<Libro> libreria) {
		this.arrayLibros = libreria;
	}

	public void sumarAlStockPorIsbn(String isbn) {
			Libro libroIsbnRepetido;
			libroIsbnRepetido = obtenerLibroDos(isbn);
			int stockActualLibro = libroIsbnRepetido.getStock();
			libroIsbnRepetido.setStock(stockActualLibro + 1);
		}
	
	public boolean comprobarIsbnExistente(String iSBNsel) {
		for (int i = 0; i < arrayLibros.size(); i++) {
			if (arrayLibros.get(i).getISBN().equals(iSBNsel)) {
				return true;
			}
		}
		return false;
	}

	public ArrayList<Libro> establecerListaDeLibroPorDefecto(){
		ArrayList<Libro> libros = new ArrayList<>();
		libros.add(new Libro("Los pilares de la tierra", "Ken Follett", "9788401328764", "Plaza & Janés", "Cartoné", "Novedad", 24.90f, 9));
		libros.add(new Libro("El nombre del viento", "Patrick Rothfuss", "9788401352836", "Plaza & Janés", "Rústica", "Reedición", 19.90f, 14));
		libros.add(new Libro("Rebelión en la granja", "George Orwell", "9788499890951", "Debolsillo", "Rústica", "Novedad", 8.95f, 20));
		libros.add(new Libro("El gran Gatsby", "F. Scott Fitzgerald", "9788437615959", "Cátedra", "Rústica", "Reedición", 11.20f, 12));
		libros.add(new Libro("El psicoanalista", "John Katzenbach", "9788466319287", "Ediciones B", "Rústica", "Reedición", 10.00f, 7));
		libros.add(new Libro("La comunidad del anillo", "J.R.R. Tolkien", "9788445073797", "Minotauro", "Cartoné", "Novedad", 22.00f, 10));
		libros.add(new Libro("Los renglones torcidos de Dios", "Torcuato Luca de Tena", "9788408087779", "Planeta", "Rústica", "Reedición", 13.90f, 18));
		libros.add(new Libro("IT (Eso)", "Stephen King", "9788466333924", "Debolsillo", "Cartoné", "Novedad", 23.50f, 6));
		libros.add(new Libro("El guardián entre el centeno", "J.D. Salinger", "9788420471686", "Alfaguara", "Rústica", "Reedición", 14.00f, 15));
		libros.add(new Libro("El arte de la guerra", "Sun Tzu", "9788497774291", "Edaf", "Grapada", "Novedad", 9.50f, 30));
		libros.add(new Libro("Tokyo Blues", "Haruki Murakami", "9788483830581", "Tusquets Editores", "Rústica", "Reedición", 18.50f, 11));
		libros.add(new Libro("Elantris", "Brandon Sanderson", "9788417347057", "Nova", "Cartoné", "Novedad", 26.00f, 8));
		libros.add(new Libro("La ladrona de libros", "Markus Zusak", "9788498381786", "Círculo de Lectores", "Cartoné", "Reedición", 16.00f, 13));
		libros.add(new Libro("Marina", "Carlos Ruiz Zafón", "9788408088080", "Planeta", "Espiral", "Novedad", 12.90f, 16));
		return libros;
	}

	public String obtenerLibro(String iSBNsel) {
		String libroObtenido = "";
		for (int i = 0; i < arrayLibros.size(); i++) {
			if (arrayLibros.get(i).getISBN().equals(iSBNsel)) {
				libroObtenido = arrayLibros.get(i).toString();
			}
		}
		return libroObtenido;
	}
	
}

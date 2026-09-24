package modelo;

import java.util.ArrayList;

public class Libreria {
	private ArrayList<Libro> arrayLibros = new ArrayList<Libro>();

	
	public Libreria(ArrayList<Libro> libreria) {
		super();
		this.arrayLibros = libreria;
		libreria.add(new Libro("El Quijote", "Miguel de Cervantes", "978-84-376-0494-7", "Cátedra", 18.50f));
		libreria.add(new Libro("Cien años de soledad", "Gabriel García Márquez", "978-84-376-0495-4", "Sudamericana", 22.00f));
		libreria.add(new Libro("1984", "George Orwell", "978-84-998-9094-4", "Debolsillo", 9.95f));
		libreria.add(new Libro("Fahrenheit 451", "Ray Bradbury", "978-84-450-7164-9", "Minotauro", 14.50f));
		libreria.add(new Libro("El Hobbit", "J.R.R. Tolkien", "978-84-450-7348-3", "Minotauro", 16.90f));
		libreria.add(new Libro("Crimen y castigo", "Fiódor Dostoyevski", "978-84-206-7422-3", "Alianza Editorial", 19.00f));
		libreria.add(new Libro("La sombra del viento", "Carlos Ruiz Zafón", "978-84-080-7954-5", "Planeta", 21.50f));
		libreria.add(new Libro("Neuromante", "William Gibson", "978-84-450-7456-5", "Minotauro", 15.00f));
		libreria.add(new Libro("Los pilares de la tierra", "Ken Follett", "978-84-013-3720-8", "Plaza & Janés", 25.00f));
		libreria.add(new Libro("Dune", "Frank Herbert", "978-84-663-5164-5", "Debolsillo", 17.95f));
	}

	public void aniadirLibro(Libro libro) {
		arrayLibros.add(libro);
		
	}


	public ArrayList<Libro> getLibreria() {
		return arrayLibros;
	}



	public void setLibreria(ArrayList<Libro> libreria) {
		this.arrayLibros = libreria;
	}
	
}

package modelo;

public class Libro {
	private String titulo, autor,ISBN, editorial;
	private float precio;
	public Libro(String titulo, String autor, String iSBN, String editorial, float precio) {
		super();
		this.titulo = titulo;
		this.autor = autor;
		ISBN = iSBN;
		this.editorial = editorial;
		this.precio = precio;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public String getISBN() {
		return ISBN;
	}
	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}
	public String getEditorial() {
		return editorial;
	}
	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}
	public float getPrecio() {
		return precio;
	}
	public void setPrecio(float precio) {
		this.precio = precio;
	}
	@Override
	public String toString() {
		return "titulo=" + titulo + ", autor=" + autor + ", ISBN=" + ISBN + ", editorial=" + editorial
				+ ", precio=" + precio;
	}
	
	
}

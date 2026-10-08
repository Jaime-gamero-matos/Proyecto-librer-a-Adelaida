package modelo;


public class Libro {
	private String titulo, autor,ISBN, editorial, formato, estado;
	private float precio;
	private int stock;

	public Libro(String titulo, String autor, String iSBN, String editorial, String formato, String estado,
			float precio, int stock) {
		super();
		this.titulo = titulo;
		this.autor = autor;
		this.ISBN = iSBN;
		this.editorial = editorial;
		this.formato = formato;
		this.estado = estado;
		this.precio = precio;
		this.stock = stock;
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
	
	public String getFormato() {
		return formato;
	}
	public void setFormato(String formato) {
		this.formato = formato;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	@Override
	public String toString() {
	    return "ISBN: " + ISBN + "\nTitulo: " + titulo + "\nAutor: " + autor + "\nEditorial: " + editorial
	        + "\nFormato: " + formato + "\nEstado: " + estado +"\nPrecio: " + precio +"\nStock: " + stock;
	}
	
	
}

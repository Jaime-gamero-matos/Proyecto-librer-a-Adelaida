package utiles;

import java.util.regex.Pattern;
public class Validaciones {
	
	
	public static boolean validarLetras(String nombre) {
	    return Pattern.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑüÜ\\s]+", nombre);
	}
	
	public static boolean validarISBN(String nombre) {
	    return nombre.length()==13 && esUnNumero(nombre); 
	}

	public static boolean esUnNumero(String nombre) {
	    return Pattern.matches("[0-9]*", nombre);
	}
	public static boolean esUnFloat(String nombre) {
	    try {
	        Float.parseFloat(nombre);
	        char charAt = nombre.charAt(nombre.length() - 1);
	        if (charAt == 'f' || charAt == 'd')
	            return false;
	    } catch (NumberFormatException e) {
	        return false;
	    }
	    return true;
	}
}

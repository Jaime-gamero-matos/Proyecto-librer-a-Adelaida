package vista;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JTextField;

public interface AccesoUI {
	JButton botonGuardar();
	JButton botonBorrar();
	JButton botonSalir();
	JButton botonConsultar();
	JButton botonModificar();
	JTextField campoTxtPrecio();
	JTextField campoTxtISBN();
	JTextField campoTxtTitulo();
	JTextField campoTxtEditorial();
	JTextField campoTxtAutor();
	JTable tablaEstanteria();
	JRadioButton rdbtnCartone();
	JRadioButton rdbtnRustica();
	JRadioButton rdbtnGrapada();
	JRadioButton rdbtnEspiral();
	JRadioButton rdbtnReedicion();
	JRadioButton rdbtnNovedad();
	ButtonGroup grupoFormato();
	ButtonGroup grupoEstado();
}

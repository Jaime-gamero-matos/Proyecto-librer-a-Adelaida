package vista;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTabbedPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class UI extends JFrame implements AccesoUI {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	protected JButton botonGuardar;
	protected JButton botonSalir;
	private JLabel textoLibreria;
	private JTextField campoTxtPrecio;
	private JTextField campoTxtISBN;
	private JTextField campoTxtTitulo;
	private JTextField campoTxtEditorial;
	private JTextField campoTxtAutor;
	private JButton botonMostrar;


	public UI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1046, 525);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(159, 240, 145));
		panel.setForeground(new Color(255, 255, 255));
		contentPane.add(panel, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("LIBRERÍA JAIME");
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 176, 216));
		contentPane.add(panel_1, BorderLayout.SOUTH);
		
		botonGuardar = new JButton("GUARDAR");

		panel_1.add(botonGuardar);
		
		botonSalir = new JButton("SALIR");

		panel_1.add(botonSalir);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane, BorderLayout.CENTER);
		
		JPanel panelLibro = new JPanel();
		panelLibro.setBackground(new Color(255, 255, 191));
		tabbedPane.addTab("LIBRO", null, panelLibro, null);
		
		JLabel lblNewLabel_1 = new JLabel("ISBN: ");
		
		JLabel lblNewLabel_1_1 = new JLabel("Título: ");
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Autor: ");
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Editorial: ");
		
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("Precio: ");
		
		campoTxtISBN = new JTextField();
		campoTxtISBN.setColumns(10);
		
		campoTxtTitulo = new JTextField();
		campoTxtTitulo.setColumns(10);
		
		campoTxtAutor = new JTextField();
		campoTxtAutor.setColumns(10);
		
		campoTxtEditorial = new JTextField();
		campoTxtEditorial.setColumns(10);
		
		campoTxtPrecio = new JTextField();
		campoTxtPrecio.setColumns(10);
		GroupLayout gl_panelLibro = new GroupLayout(panelLibro);
		gl_panelLibro.setHorizontalGroup(
			gl_panelLibro.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelLibro.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panelLibro.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelLibro.createSequentialGroup()
							.addComponent(lblNewLabel_1_1_1_1_1)
							.addGap(18)
							.addComponent(campoTxtPrecio, GroupLayout.PREFERRED_SIZE, 216, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panelLibro.createParallelGroup(Alignment.LEADING, false)
							.addGroup(gl_panelLibro.createSequentialGroup()
								.addComponent(lblNewLabel_1)
								.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(campoTxtISBN, GroupLayout.PREFERRED_SIZE, 216, GroupLayout.PREFERRED_SIZE))
							.addGroup(gl_panelLibro.createSequentialGroup()
								.addComponent(lblNewLabel_1_1)
								.addGap(18)
								.addComponent(campoTxtTitulo, GroupLayout.PREFERRED_SIZE, 216, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_panelLibro.createParallelGroup(Alignment.TRAILING, false)
							.addGroup(gl_panelLibro.createSequentialGroup()
								.addComponent(lblNewLabel_1_1_1_1)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(campoTxtEditorial))
							.addGroup(Alignment.LEADING, gl_panelLibro.createSequentialGroup()
								.addComponent(lblNewLabel_1_1_1)
								.addGap(18)
								.addComponent(campoTxtAutor, GroupLayout.PREFERRED_SIZE, 216, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(139, Short.MAX_VALUE))
		);
		gl_panelLibro.setVerticalGroup(
			gl_panelLibro.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelLibro.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panelLibro.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(campoTxtISBN, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panelLibro.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1_1)
						.addComponent(campoTxtTitulo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panelLibro.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1_1_1)
						.addComponent(campoTxtAutor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panelLibro.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1_1_1_1)
						.addComponent(campoTxtEditorial, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panelLibro.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1_1_1_1_1)
						.addComponent(campoTxtPrecio, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(46, Short.MAX_VALUE))
		);
		panelLibro.setLayout(gl_panelLibro);
		
		JPanel panelEstanteria = new JPanel();
		panelEstanteria.setBackground(new Color(255, 255, 191));
		tabbedPane.addTab("ESTANTERIA", null, panelEstanteria, null);
		
		textoLibreria = new JLabel("");
		textoLibreria.setHorizontalAlignment(SwingConstants.CENTER);
		
		botonMostrar = new JButton("MOSTRAR");
		botonMostrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});

		GroupLayout gl_panelEstanteria = new GroupLayout(panelEstanteria);
		gl_panelEstanteria.setHorizontalGroup(
			gl_panelEstanteria.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelEstanteria.createSequentialGroup()
					.addGroup(gl_panelEstanteria.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelEstanteria.createSequentialGroup()
							.addGap(466)
							.addComponent(botonMostrar))
						.addGroup(gl_panelEstanteria.createSequentialGroup()
							.addGap(20)
							.addComponent(textoLibreria, GroupLayout.PREFERRED_SIZE, 980, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(15, Short.MAX_VALUE))
		);
		gl_panelEstanteria.setVerticalGroup(
			gl_panelEstanteria.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panelEstanteria.createSequentialGroup()
					.addGap(25)
					.addComponent(textoLibreria, GroupLayout.PREFERRED_SIZE, 232, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 101, Short.MAX_VALUE)
					.addComponent(botonMostrar)
					.addGap(10))
		);
		panelEstanteria.setLayout(gl_panelEstanteria);
		


	}

	@Override
	public JButton botonGuardar() {
		return botonGuardar;
	}
	@Override
	public JButton botonSalir() {
		return botonSalir;
	}
	
	@Override
	public JButton botonMostrar() {
		return botonMostrar;
	}

	@Override
	public JLabel textoLibreria() {
		return textoLibreria;
	}
	@Override
	public JTextField campoTxtPrecio() {
		return campoTxtPrecio;
	}
	@Override
	public JTextField campoTxtISBN() {
		return campoTxtISBN;
	}
	@Override
	public JTextField campoTxtTitulo() {
		return campoTxtTitulo;
	}
	@Override
	public JTextField campoTxtEditorial() {
		return campoTxtEditorial;
	}
	@Override
	public JTextField campoTxtAutor() {
		return campoTxtAutor;
	}
}

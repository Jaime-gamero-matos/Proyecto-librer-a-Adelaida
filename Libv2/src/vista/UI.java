package vista;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import java.awt.AlphaComposite;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.Image;
import java.io.File;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTabbedPane;
import javax.swing.ButtonGroup;
import javax.swing.JTextField;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTable;
import javax.swing.JRadioButton;
import javax.swing.border.LineBorder;
import javax.swing.JScrollPane;
import javax.swing.plaf.basic.BasicTabbedPaneUI;
import javax.swing.table.TableCellRenderer;

public class UI extends JFrame implements AccesoUI {

	private static final long serialVersionUID = 1L;

	private static final String RUTA_IMAGEN = "imagenes/necronomicon.png";

	private static final Color COLOR_FONDO        = new Color(246, 243, 250);
	private static final Color COLOR_SUPERFICIE   = Color.WHITE;
	private static final Color COLOR_PRIMARIO     = new Color(88, 64, 150);
	private static final Color COLOR_ACENTO       = new Color(214, 122, 31);
	private static final Color COLOR_PELIGRO      = new Color(185, 56, 46);
	private static final Color COLOR_TEXTO        = new Color(38, 33, 56);
	private static final Color COLOR_TEXTO_SUAVE  = new Color(115, 108, 135);
	private static final Color COLOR_BORDE        = new Color(224, 218, 236);
	private static final Color COLOR_FILA_ALTERNA = new Color(250, 248, 253);
	private static final Color COLOR_SELECCION    = new Color(255, 236, 209);

	private static final Font FUENTE_TITULO  = new Font("Georgia", Font.BOLD, 28);
	private static final Font FUENTE_SECCION = new Font("Segoe UI", Font.BOLD, 12);
	private static final Font FUENTE_BASE    = new Font("Segoe UI", Font.PLAIN, 14);
	private static final Font FUENTE_NEGRITA = new Font("Segoe UI", Font.BOLD, 14);

	private JPanel contentPane;
	protected JButton botonGuardar;
	protected JButton botonSalir;
	private JTextField campoTxtPrecio;
	private JTextField campoTxtISBN;
	private JTextField campoTxtTitulo;
	private JTextField campoTxtEditorial;
	private JTextField campoTxtAutor;
	private JButton botonBorrar;
	private JButton botonConsultar;
	private JRadioButton rdbtnCartone;
	private JRadioButton rdbtnRustica;
	private JRadioButton rdbtnGrapada;
	private JRadioButton rdbtnEspiral;
	private JRadioButton rdbtnReedicion;
	private JRadioButton rdbtnNovedad;
	private ButtonGroup grupoEstado;
	private ButtonGroup grupoFormato;
	private JTable tablaEstanteria;
	protected JButton botonModificar;

	public UI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 740, 560);
		setMinimumSize(new Dimension(660, 520));
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(COLOR_FONDO);
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		panel.setBackground(COLOR_PRIMARIO);
		panel.setForeground(Color.WHITE);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
		panel.setBorder(new CompoundBorder(
				new MatteBorder(0, 0, 4, 0, COLOR_ACENTO),
				new EmptyBorder(16, 0, 16, 0)));
		contentPane.add(panel, BorderLayout.NORTH);

		JLabel lblNewLabel = new JLabel("LIBRERÍA JAIME");
		lblNewLabel.setFont(FUENTE_TITULO);
		lblNewLabel.setForeground(Color.WHITE);
		panel.add(lblNewLabel);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(COLOR_SUPERFICIE);
		panel_1.setLayout(new BorderLayout(0, 0));
		panel_1.setBorder(new CompoundBorder(
				new MatteBorder(1, 0, 0, 0, COLOR_BORDE),
				new EmptyBorder(14, 24, 14, 24)));
		contentPane.add(panel_1, BorderLayout.SOUTH);

		botonGuardar = new BotonModerno("GUARDAR", COLOR_ACENTO, Color.WHITE, COLOR_ACENTO, true);

		botonSalir = new BotonModerno("SALIR", COLOR_SUPERFICIE, COLOR_TEXTO_SUAVE, COLOR_BORDE, false);
		
		botonBorrar = new BotonModerno("BORRAR", COLOR_SUPERFICIE, COLOR_PELIGRO, COLOR_PELIGRO, false);
		
		botonConsultar = new BotonModerno("CONSULTAR", COLOR_SUPERFICIE, COLOR_PRIMARIO, COLOR_PRIMARIO, false);

		JPanel panelAcciones = new JPanel(new FlowLayout(FlowLayout.RIGHT, 12, 0));
		panelAcciones.setOpaque(false);
		panelAcciones.add(botonConsultar);
		botonModificar = new BotonModerno("MODIFICAR", COLOR_SUPERFICIE, COLOR_PRIMARIO, COLOR_PRIMARIO, false);
		panelAcciones.add(botonModificar);
		panelAcciones.add(botonBorrar);
		panelAcciones.add(botonGuardar);

		panel_1.add(botonSalir, BorderLayout.WEST);
		panel_1.add(panelAcciones, BorderLayout.CENTER);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setUI(new PestanasModernas());
		tabbedPane.setOpaque(true);
		tabbedPane.setBackground(COLOR_FONDO);
		tabbedPane.setForeground(COLOR_TEXTO_SUAVE);
		tabbedPane.setFont(FUENTE_NEGRITA);
		contentPane.add(tabbedPane, BorderLayout.CENTER);

		JPanel panelLibro = new JPanel();
		panelLibro.setBackground(COLOR_FONDO);
		panelLibro.setBorder(new EmptyBorder(20, 24, 20, 24));
		tabbedPane.addTab("LIBRO", null, panelLibro, null);

		JLabel lblNewLabel_1 = new JLabel("ISBN: ");

		JLabel lblNewLabel_1_1 = new JLabel("Título: ");

		JLabel lblNewLabel_1_1_1 = new JLabel("Autor: ");

		JLabel lblNewLabel_1_1_1_1 = new JLabel("Editorial: ");

		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("Precio: ");

		estilizarEtiqueta(lblNewLabel_1);
		estilizarEtiqueta(lblNewLabel_1_1);
		estilizarEtiqueta(lblNewLabel_1_1_1);
		estilizarEtiqueta(lblNewLabel_1_1_1_1);
		estilizarEtiqueta(lblNewLabel_1_1_1_1_1);

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

		estilizarCampo(campoTxtISBN);
		estilizarCampo(campoTxtTitulo);
		estilizarCampo(campoTxtAutor);
		estilizarCampo(campoTxtEditorial);
		estilizarCampo(campoTxtPrecio);
		
		JPanel panelFormato = new JPanel();
		panelFormato.setOpaque(false);
		panelFormato.setLayout(new FlowLayout(FlowLayout.LEFT, 18, 0));
		
		JLabel lblNewLabel_2 = new JLabel("Formato: ");
		
		JLabel lblNewLabel_2_1 = new JLabel("Estado: ");

		estilizarEtiqueta(lblNewLabel_2);
		estilizarEtiqueta(lblNewLabel_2_1);
		
		JPanel panelEstado = new JPanel();
		panelEstado.setOpaque(false);
		panelEstado.setLayout(new FlowLayout(FlowLayout.LEFT, 18, 0));
		
		rdbtnReedicion = new JRadioButton("Reedición");
		
		rdbtnNovedad = new JRadioButton("Novedad");
		grupoEstado = new ButtonGroup();
		grupoEstado.add(rdbtnReedicion);
		grupoEstado.add(rdbtnNovedad);

		estilizarRadio(rdbtnReedicion);
		estilizarRadio(rdbtnNovedad);
		panelEstado.add(rdbtnReedicion);
		panelEstado.add(rdbtnNovedad);
		
		rdbtnCartone = new JRadioButton("Cartoné");
		
		rdbtnRustica = new JRadioButton("Rústica");
		
		rdbtnGrapada = new JRadioButton("Grapada");
		
		rdbtnEspiral = new JRadioButton("Espiral");
		grupoFormato = new ButtonGroup();
		grupoFormato.add(rdbtnCartone);
		grupoFormato.add(rdbtnRustica);
		grupoFormato.add(rdbtnGrapada);
		grupoFormato.add(rdbtnEspiral);

		estilizarRadio(rdbtnCartone);
		estilizarRadio(rdbtnRustica);
		estilizarRadio(rdbtnGrapada);
		estilizarRadio(rdbtnEspiral);
		panelFormato.add(rdbtnCartone);
		panelFormato.add(rdbtnRustica);
		panelFormato.add(rdbtnGrapada);
		panelFormato.add(rdbtnEspiral);

		JPanel tarjetaDatos = new JPanel(new GridBagLayout());
		tarjetaDatos.setBackground(COLOR_SUPERFICIE);
		tarjetaDatos.setBorder(new CompoundBorder(
				new LineBorder(COLOR_BORDE, 1, true),
				new EmptyBorder(16, 20, 16, 20)));

		JLabel tituloDatos = new JLabel("DATOS DEL LIBRO");
		tituloDatos.setFont(FUENTE_SECCION);
		tituloDatos.setForeground(COLOR_ACENTO);
		GridBagConstraints g = new GridBagConstraints();
		g.gridx = 0; g.gridy = 0; g.gridwidth = 2;
		g.anchor = GridBagConstraints.WEST;
		g.insets = new Insets(0, 0, 8, 0);
		tarjetaDatos.add(tituloDatos, g);

		GridBagConstraints gbc_isbnEtiqueta = new GridBagConstraints();
		gbc_isbnEtiqueta.gridx = 0; gbc_isbnEtiqueta.gridy = 1;
		gbc_isbnEtiqueta.anchor = GridBagConstraints.WEST;
		gbc_isbnEtiqueta.insets = new Insets(6, 0, 6, 20);
		tarjetaDatos.add(lblNewLabel_1, gbc_isbnEtiqueta);

		GridBagConstraints gbc_isbnControl = new GridBagConstraints();
		gbc_isbnControl.gridx = 1; gbc_isbnControl.gridy = 1;
		gbc_isbnControl.anchor = GridBagConstraints.WEST;
		gbc_isbnControl.weightx = 1.0;
		gbc_isbnControl.fill = GridBagConstraints.HORIZONTAL;
		gbc_isbnControl.insets = new Insets(6, 0, 6, 0);
		tarjetaDatos.add(campoTxtISBN, gbc_isbnControl);

		GridBagConstraints gbc_tituloEtiqueta = new GridBagConstraints();
		gbc_tituloEtiqueta.gridx = 0; gbc_tituloEtiqueta.gridy = 2;
		gbc_tituloEtiqueta.anchor = GridBagConstraints.WEST;
		gbc_tituloEtiqueta.insets = new Insets(6, 0, 6, 20);
		tarjetaDatos.add(lblNewLabel_1_1, gbc_tituloEtiqueta);

		GridBagConstraints gbc_tituloControl = new GridBagConstraints();
		gbc_tituloControl.gridx = 1; gbc_tituloControl.gridy = 2;
		gbc_tituloControl.anchor = GridBagConstraints.WEST;
		gbc_tituloControl.weightx = 1.0;
		gbc_tituloControl.fill = GridBagConstraints.HORIZONTAL;
		gbc_tituloControl.insets = new Insets(6, 0, 6, 0);
		tarjetaDatos.add(campoTxtTitulo, gbc_tituloControl);

		GridBagConstraints gbc_autorEtiqueta = new GridBagConstraints();
		gbc_autorEtiqueta.gridx = 0; gbc_autorEtiqueta.gridy = 3;
		gbc_autorEtiqueta.anchor = GridBagConstraints.WEST;
		gbc_autorEtiqueta.insets = new Insets(6, 0, 6, 20);
		tarjetaDatos.add(lblNewLabel_1_1_1, gbc_autorEtiqueta);

		GridBagConstraints gbc_autorControl = new GridBagConstraints();
		gbc_autorControl.gridx = 1; gbc_autorControl.gridy = 3;
		gbc_autorControl.anchor = GridBagConstraints.WEST;
		gbc_autorControl.weightx = 1.0;
		gbc_autorControl.fill = GridBagConstraints.HORIZONTAL;
		gbc_autorControl.insets = new Insets(6, 0, 6, 0);
		tarjetaDatos.add(campoTxtAutor, gbc_autorControl);

		GridBagConstraints gbc_editorialEtiqueta = new GridBagConstraints();
		gbc_editorialEtiqueta.gridx = 0; gbc_editorialEtiqueta.gridy = 4;
		gbc_editorialEtiqueta.anchor = GridBagConstraints.WEST;
		gbc_editorialEtiqueta.insets = new Insets(6, 0, 6, 20);
		tarjetaDatos.add(lblNewLabel_1_1_1_1, gbc_editorialEtiqueta);

		GridBagConstraints gbc_editorialControl = new GridBagConstraints();
		gbc_editorialControl.gridx = 1; gbc_editorialControl.gridy = 4;
		gbc_editorialControl.anchor = GridBagConstraints.WEST;
		gbc_editorialControl.weightx = 1.0;
		gbc_editorialControl.fill = GridBagConstraints.HORIZONTAL;
		gbc_editorialControl.insets = new Insets(6, 0, 6, 0);
		tarjetaDatos.add(campoTxtEditorial, gbc_editorialControl);

		GridBagConstraints gbc_precioEtiqueta = new GridBagConstraints();
		gbc_precioEtiqueta.gridx = 0; gbc_precioEtiqueta.gridy = 5;
		gbc_precioEtiqueta.anchor = GridBagConstraints.WEST;
		gbc_precioEtiqueta.insets = new Insets(6, 0, 6, 20);
		tarjetaDatos.add(lblNewLabel_1_1_1_1_1, gbc_precioEtiqueta);

		GridBagConstraints gbc_precioControl = new GridBagConstraints();
		gbc_precioControl.gridx = 1; gbc_precioControl.gridy = 5;
		gbc_precioControl.anchor = GridBagConstraints.WEST;
		gbc_precioControl.weightx = 1.0;
		gbc_precioControl.fill = GridBagConstraints.HORIZONTAL;
		gbc_precioControl.insets = new Insets(6, 0, 6, 0);
		tarjetaDatos.add(campoTxtPrecio, gbc_precioControl);

		JLabel lblImagen = new JLabel(cargarImagen());
		GridBagConstraints gi = new GridBagConstraints();
		gi.gridx = 2; gi.gridy = 1; gi.gridheight = 5;
		gi.anchor = GridBagConstraints.CENTER;
		gi.insets = new Insets(0, 28, 0, 0);
		tarjetaDatos.add(lblImagen, gi);

		JPanel tarjetaOpciones = new JPanel(new GridBagLayout());
		tarjetaOpciones.setBackground(COLOR_SUPERFICIE);
		tarjetaOpciones.setBorder(new CompoundBorder(
				new LineBorder(COLOR_BORDE, 1, true),
				new EmptyBorder(16, 20, 16, 20)));

		JLabel tituloOpciones = new JLabel("CARACTERÍSTICAS");
		tituloOpciones.setFont(FUENTE_SECCION);
		tituloOpciones.setForeground(COLOR_ACENTO);
		GridBagConstraints g2 = new GridBagConstraints();
		g2.gridx = 0; g2.gridy = 0; g2.gridwidth = 2;
		g2.anchor = GridBagConstraints.WEST;
		g2.insets = new Insets(0, 0, 8, 0);
		tarjetaOpciones.add(tituloOpciones, g2);

		GridBagConstraints gbc_formatoEtiqueta = new GridBagConstraints();
		gbc_formatoEtiqueta.gridx = 0; gbc_formatoEtiqueta.gridy = 1;
		gbc_formatoEtiqueta.anchor = GridBagConstraints.WEST;
		gbc_formatoEtiqueta.insets = new Insets(6, 0, 6, 20);
		tarjetaOpciones.add(lblNewLabel_2, gbc_formatoEtiqueta);

		GridBagConstraints gbc_formatoControl = new GridBagConstraints();
		gbc_formatoControl.gridx = 1; gbc_formatoControl.gridy = 1;
		gbc_formatoControl.anchor = GridBagConstraints.WEST;
		gbc_formatoControl.weightx = 1.0;
		gbc_formatoControl.fill = GridBagConstraints.HORIZONTAL;
		gbc_formatoControl.insets = new Insets(6, 0, 6, 0);
		tarjetaOpciones.add(panelFormato, gbc_formatoControl);

		GridBagConstraints gbc_estadoEtiqueta = new GridBagConstraints();
		gbc_estadoEtiqueta.gridx = 0; gbc_estadoEtiqueta.gridy = 2;
		gbc_estadoEtiqueta.anchor = GridBagConstraints.WEST;
		gbc_estadoEtiqueta.insets = new Insets(6, 0, 6, 20);
		tarjetaOpciones.add(lblNewLabel_2_1, gbc_estadoEtiqueta);

		GridBagConstraints gbc_estadoControl = new GridBagConstraints();
		gbc_estadoControl.gridx = 1; gbc_estadoControl.gridy = 2;
		gbc_estadoControl.anchor = GridBagConstraints.WEST;
		gbc_estadoControl.weightx = 1.0;
		gbc_estadoControl.fill = GridBagConstraints.HORIZONTAL;
		gbc_estadoControl.insets = new Insets(6, 0, 6, 0);
		tarjetaOpciones.add(panelEstado, gbc_estadoControl);

		panelLibro.setLayout(new GridBagLayout());
		GridBagConstraints p = new GridBagConstraints();
		p.gridx = 0; p.gridy = 0;
		p.weightx = 1.0;
		p.fill = GridBagConstraints.HORIZONTAL;
		p.insets = new Insets(0, 0, 16, 0);
		panelLibro.add(tarjetaDatos, p);

		GridBagConstraints p1 = new GridBagConstraints();
		p1.gridx = 0; p1.gridy = 1;
		p1.weightx = 1.0;
		p1.fill = GridBagConstraints.HORIZONTAL;
		p1.insets = new Insets(0, 0, 0, 0);
		panelLibro.add(tarjetaOpciones, p1);

		GridBagConstraints p2 = new GridBagConstraints();
		p2.gridx = 0; p2.gridy = 2;
		p2.weightx = 1.0;
		p2.weighty = 1.0;
		p2.fill = GridBagConstraints.BOTH;
		JPanel relleno = new JPanel();
		relleno.setOpaque(false);
		panelLibro.add(relleno, p2);

		JPanel panelEstanteria = new JPanel();
		panelEstanteria.setBackground(COLOR_FONDO);
		panelEstanteria.setBorder(new EmptyBorder(20, 24, 20, 24));
		panelEstanteria.setLayout(new BorderLayout(0, 0));
		tabbedPane.addTab("ESTANTERIA", null, panelEstanteria, null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(new LineBorder(COLOR_BORDE, 1, true));
		scrollPane.getViewport().setBackground(COLOR_SUPERFICIE);
		panelEstanteria.add(scrollPane, BorderLayout.CENTER);
		
		tablaEstanteria = new JTable() {
			private static final long serialVersionUID = 1L;

			@Override
			public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
				Component c = super.prepareRenderer(renderer, row, column);
				if (!isRowSelected(row)) {
					c.setBackground(row % 2 == 0 ? COLOR_SUPERFICIE : COLOR_FILA_ALTERNA);
				}
				return c;
			}
		};
		estilizarTabla(tablaEstanteria);
		scrollPane.setViewportView(tablaEstanteria);

	}

	private Icon cargarImagen() {
		ImageIcon icono = null;
		java.net.URL url = UI.class.getResource("/" + RUTA_IMAGEN);
		if (url != null) {
			icono = new ImageIcon(url);
		} else {
			File archivo = new File(RUTA_IMAGEN);
			if (archivo.exists()) {
				icono = new ImageIcon(archivo.getAbsolutePath());
			}
		}
		if (icono == null || icono.getIconWidth() <= 0 || icono.getIconHeight() <= 0) {
			return new IconoLibros(170, 160);
		}
		double escala = Math.min(1.0, Math.min(170.0 / icono.getIconWidth(), 160.0 / icono.getIconHeight()));
		int nuevoAncho = Math.max(1, (int) (icono.getIconWidth() * escala));
		int nuevoAlto = Math.max(1, (int) (icono.getIconHeight() * escala));
		Image escalada = icono.getImage().getScaledInstance(nuevoAncho, nuevoAlto, Image.SCALE_SMOOTH);
		return new ImageIcon(escalada);
	}

	private void estilizarEtiqueta(JLabel etiqueta) {
		etiqueta.setFont(FUENTE_NEGRITA);
		etiqueta.setForeground(COLOR_TEXTO);
		etiqueta.setPreferredSize(new Dimension(90, etiqueta.getPreferredSize().height));
	}

	private void estilizarCampo(final JTextField campo) {
		final CompoundBorder reposo = new CompoundBorder(
				new LineBorder(COLOR_BORDE, 1, true), new EmptyBorder(7, 10, 7, 10));
		final CompoundBorder enfoque = new CompoundBorder(
				new LineBorder(COLOR_PRIMARIO, 2, true), new EmptyBorder(6, 9, 6, 9));
		campo.setFont(FUENTE_BASE);
		campo.setForeground(COLOR_TEXTO);
		campo.setCaretColor(COLOR_PRIMARIO);
		campo.setSelectionColor(COLOR_SELECCION);
		campo.setBackground(COLOR_SUPERFICIE);
		campo.setBorder(reposo);
		campo.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				campo.setBorder(enfoque);
			}

			@Override
			public void focusLost(FocusEvent e) {
				campo.setBorder(reposo);
			}
		});
	}

	private void estilizarRadio(JRadioButton radio) {
		radio.setOpaque(false);
		radio.setFont(FUENTE_BASE);
		radio.setForeground(COLOR_TEXTO);
		radio.setFocusPainted(false);
		radio.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	}

	private void estilizarTabla(JTable tabla) {
		tabla.setFont(FUENTE_BASE);
		tabla.setForeground(COLOR_TEXTO);
		tabla.setRowHeight(30);
		tabla.setShowVerticalLines(false);
		tabla.setGridColor(COLOR_BORDE);
		tabla.setIntercellSpacing(new Dimension(0, 1));
		tabla.setSelectionBackground(COLOR_SELECCION);
		tabla.setSelectionForeground(COLOR_TEXTO);
		tabla.setFillsViewportHeight(true);
		tabla.getTableHeader().setBackground(COLOR_PRIMARIO);
		tabla.getTableHeader().setForeground(Color.WHITE);
		tabla.getTableHeader().setFont(FUENTE_NEGRITA);
		tabla.getTableHeader().setPreferredSize(new Dimension(0, 36));
	}

	private static class IconoLibros implements Icon {

		private final int ancho;
		private final int alto;

		IconoLibros(int ancho, int alto) {
			this.ancho = ancho;
			this.alto = alto;
		}

		@Override
		public int getIconWidth() {
			return ancho;
		}

		@Override
		public int getIconHeight() {
			return alto;
		}

		@Override
		public void paintIcon(Component c, Graphics g, int x, int y) {
			Graphics2D g2 = (Graphics2D) g.create();
			g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
			g2.translate(x, y);

			Color[] colores = {
				new Color(88, 64, 150),
				new Color(214, 122, 31),
				new Color(150, 120, 200),
				new Color(51, 41, 80)
			};
			int[] desplazamientos = {0, 14, -10, 8};
			int anchoLibro = 120;
			int altoLibro = 28;
			int separacion = 3;
			int margenInferior = 24;

			g2.setColor(new Color(0, 0, 0, 30));
			g2.fillOval((ancho - anchoLibro) / 2 - 5, alto - margenInferior - 4, anchoLibro + 30, 12);

			for (int i = 0; i < colores.length; i++) {
				int bx = (ancho - anchoLibro) / 2 + desplazamientos[i];
				int by = alto - margenInferior - (i + 1) * altoLibro - i * separacion;

				g2.setColor(new Color(253, 246, 227));
				g2.fillRoundRect(bx + anchoLibro - 16, by + 4, 18, altoLibro - 8, 4, 4);

				g2.setColor(colores[i]);
				g2.fillRoundRect(bx, by, anchoLibro, altoLibro, 8, 8);

				g2.setColor(colores[i].darker());
				g2.fillRect(bx + 14, by, 4, altoLibro);
				g2.fillRect(bx + anchoLibro - 22, by, 4, altoLibro);

				g2.setColor(new Color(255, 255, 255, 110));
				g2.fillRoundRect(bx + 30, by + 8, 50, altoLibro - 16, 4, 4);
			}
			g2.dispose();
		}
	}

	private static class BotonModerno extends JButton {

		private static final long serialVersionUID = 1L;
		private final Color fondo;
		private final Color borde;
		private final boolean relleno;
		private boolean encima = false;

		BotonModerno(String texto, Color fondo, Color textoColor, Color borde, boolean relleno) {
			super(texto);
			this.fondo = fondo;
			this.borde = borde;
			this.relleno = relleno;
			setForeground(textoColor);
			setFont(FUENTE_NEGRITA);
			setContentAreaFilled(false);
			setBorderPainted(false);
			setFocusPainted(false);
			setOpaque(false);
			setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			setPreferredSize(new Dimension(relleno ? 130 : 120, 40));
			addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					encima = true;
					repaint();
				}

				@Override
				public void mouseExited(MouseEvent e) {
					encima = false;
					repaint();
				}
			});
		}

		@Override
		protected void paintComponent(Graphics g) {
			Graphics2D g2 = (Graphics2D) g.create();
			g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
			if (!isEnabled()) {
				g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.5f));
			}

			Color pintura;
			if (relleno) {
				pintura = getModel().isPressed() ? fondo.darker().darker()
						: (encima ? fondo.darker() : fondo);
			} else {
				pintura = getModel().isPressed() ? new Color(232, 228, 242)
						: (encima ? new Color(244, 241, 250) : fondo);
			}

			g2.setColor(pintura);
			g2.fillRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 12, 12);
			g2.setColor(borde);
			g2.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 12, 12);
			g2.dispose();

			super.paintComponent(g);
		}
	}

	private static class PestanasModernas extends BasicTabbedPaneUI {

		@Override
		protected void installDefaults() {
			super.installDefaults();
			tabAreaInsets = new Insets(8, 24, 0, 0);
			contentBorderInsets = new Insets(0, 0, 0, 0);
			tabInsets = new Insets(10, 26, 10, 26);
			selectedTabPadInsets = new Insets(0, 0, 0, 0);
		}

		@Override
		protected void paintTabBackground(Graphics g, int tabPlacement, int tabIndex,
				int x, int y, int w, int h, boolean isSelected) {
			g.setColor(isSelected ? COLOR_SUPERFICIE : COLOR_FONDO);
			g.fillRect(x, y, w, h);
		}

		@Override
		protected void paintTabBorder(Graphics g, int tabPlacement, int tabIndex,
				int x, int y, int w, int h, boolean isSelected) {
			if (isSelected) {
				g.setColor(COLOR_ACENTO);
				g.fillRect(x, y, w, 3);
			}
		}

		@Override
		protected void paintContentBorder(Graphics g, int tabPlacement, int selectedIndex) {
		}

		@Override
		protected void paintFocusIndicator(Graphics g, int tabPlacement, Rectangle[] rects,
				int tabIndex, Rectangle iconRect, Rectangle textRect, boolean isSelected) {
		}
	}

	@Override
	public JButton botonGuardar() {
		return botonGuardar;
	}
	
	@Override
	public JButton botonBorrar() {
		return botonBorrar;
	}

	@Override
	public JButton botonSalir() {
		return botonSalir;
	}
	
	
	@Override
	public JButton botonConsultar() {
		return botonConsultar;
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

	@Override
	public JTable tablaEstanteria() {
		return tablaEstanteria;
	}

	@Override
	public JRadioButton rdbtnCartone() {
		return rdbtnCartone;
	}

	@Override
	public JRadioButton rdbtnRustica() {
		return rdbtnRustica;
	}

	@Override
	public JRadioButton rdbtnGrapada() {
		return rdbtnGrapada;
	}

	@Override
	public JRadioButton rdbtnEspiral() {
		return rdbtnEspiral;
	}

	@Override
	public JRadioButton rdbtnReedicion() {
		return rdbtnReedicion;
	}

	@Override
	public JRadioButton rdbtnNovedad() {
		return rdbtnNovedad;
	}

	@Override
	public ButtonGroup grupoFormato() {
		return grupoFormato;
	}
	

	@Override
	public JButton botonModificar() {
		return botonModificar;
	}

	@Override
	public ButtonGroup grupoEstado() {
		return grupoEstado;
	}
}

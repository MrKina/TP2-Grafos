package tp2;

import java.awt.EventQueue;
import javax.swing.JFrame;
import org.openstreetmap.gui.jmapviewer.JMapViewer;
import org.openstreetmap.gui.jmapviewer.interfaces.MapMarker;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JTextField;
import java.awt.TextField;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JTextArea;
import javax.swing.JFormattedTextField;
import javax.swing.JEditorPane;
import java.awt.ComponentOrientation;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;

public class Pantalla {

	private JFrame frame;
	private JMapViewer Mapa;
	private MapMarker marker;
	private int Zoom = 14;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Pantalla window = new Pantalla();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Pantalla() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		frame = new JFrame();
		frame.setBounds(100, 100, 1000, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		Mapa = new JMapViewer();
		Mapa.setZoomContolsVisible(false);
		Coordenadas Puntos = new Coordenadas("instancia1.json");
		
		Mapa.setDisplayPositionByLatLon(-34.521, -58.7008, Zoom);
		frame.setContentPane(Mapa);
		Mapa.setLayout(null);
		
		JTextField formattedTextField = new JTextField();
		formattedTextField.setHorizontalAlignment(SwingConstants.CENTER);
		formattedTextField.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		formattedTextField.setEditable(false);
		formattedTextField.setForeground(Color.WHITE);
		formattedTextField.setFont(new Font("Tahoma", Font.BOLD, 12));
		formattedTextField.setBackground(Color.BLACK);
		formattedTextField.setFocusable(false);
		formattedTextField.setFocusTraversalPolicyProvider(true);
		formattedTextField.setText("C: Centrar / +: Acercar Zoom / -: Alejar Zoom / P: Poner Puntos del JSON / G: Mostrar AGM Armado");
		formattedTextField.setBounds(10, 11, 972, 20);
		Mapa.add(formattedTextField);

		Resultado Grafo = new Resultado(Puntos);
		Grafo.RealizarAGM();
		Grafo.Clustering();
		

		frame.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				int keyCode = e.getKeyCode();
				switch (keyCode) {
				case KeyEvent.VK_C:
					Mapa.setDisplayPositionByLatLon(Puntos.LatitudPromedio(), Puntos.LongitudPromedio(), Zoom);
					break;
				case KeyEvent.VK_ADD:
					Mapa.setDisplayPositionByLatLon(Puntos.LatitudPromedio(), Puntos.LongitudPromedio(), Zoom++);
					break;
				case KeyEvent.VK_SUBTRACT:
					Mapa.setDisplayPositionByLatLon(Puntos.LatitudPromedio(), Puntos.LongitudPromedio(), Zoom--);
					break;
				case KeyEvent.VK_P:
					Puntos.MarcarPuntos(marker, Mapa);
					break;
				case KeyEvent.VK_G:
					Grafo.MostrarAGM(marker, Mapa);
					break;

				
				}
			}
		});

	}
}

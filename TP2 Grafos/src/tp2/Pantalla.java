package tp2;

import java.awt.EventQueue;
import javax.swing.JFrame;
import org.openstreetmap.gui.jmapviewer.JMapViewer;
import org.openstreetmap.gui.jmapviewer.interfaces.MapMarker;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

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
		Coordenadas Puntos = new Coordenadas("instancia4.json");
		Puntos.MarcarPuntos(marker, Mapa);
		Mapa.setDisplayPositionByLatLon(-34.521, -58.7008, Zoom);
		frame.setContentPane(Mapa);

		Resultado Grafo = new Resultado(Puntos);
		Grafo.RealizarAGM();
		Grafo.clustering();
		Grafo.MostrarAGM(marker, Mapa);

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
				}
			}
		});

	}
}

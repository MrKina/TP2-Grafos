package tp2;

import java.awt.EventQueue;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

import javax.swing.JFrame;

import org.openstreetmap.gui.jmapviewer.JMapViewer;
import org.openstreetmap.gui.jmapviewer.MapMarkerDot;
import org.openstreetmap.gui.jmapviewer.interfaces.MapMarker;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Pantalla {

	private JFrame frame;
	private JMapViewer Mapa;

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
		frame.setBounds(100, 100, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		Mapa = new JMapViewer();
		Mapa.setZoomContolsVisible(false);
		Mapa.setDisplayPositionByLatLon(-34.521, -58.7008, 15);

		frame.setContentPane(Mapa);
		// ArrayList <Coordenada> puntos = new Coordenada();

	}

	public static Coordenada leerJson() {
		Gson gson = new Gson();
		Coordenada ret = null;
		try {
			BufferedReader br = new BufferedReader(
					new FileReader("C:\\Users\\San\\Desktop\\Instancias\\instancia1.json"));
			ret = gson.fromJson(br, Coordenada.class);
		} catch (Exception e) {
		}
		return ret;
	}
}

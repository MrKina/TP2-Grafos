package tp2;

import java.awt.EventQueue;
import javax.swing.JFrame;

import org.json.simple.JSONObject;
import org.openstreetmap.gui.jmapviewer.JMapViewer;
import org.openstreetmap.gui.jmapviewer.MapMarkerDot;
import org.openstreetmap.gui.jmapviewer.interfaces.MapMarker;




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
		

		
		
		
		
	}

}

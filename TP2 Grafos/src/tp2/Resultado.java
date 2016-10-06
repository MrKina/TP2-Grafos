package tp2;

import java.util.ArrayList;

public class Resultado {

	ArrayList<SuperCoordenada> Resultado = new ArrayList<SuperCoordenada>();
	ArrayList<AGM> ArbolGM = new ArrayList<AGM>();
	ArrayList<Coordenada> Tocado = new ArrayList<Coordenada>();

	Resultado(Coordenadas puntos) {
		for (int x = 0; x < puntos.Coordenadas.size(); x++) {
			SuperCoordenada Prueba = new SuperCoordenada(puntos.Coordenadas.get(x),
					CargarVecinos(puntos.Coordenadas.get(x), puntos));

			Resultado.add(Prueba);
		}

	}

	private ArrayList<Vecino> CargarVecinos(Coordenada Nueva, Coordenadas Coordenadas) {
		ArrayList<Vecino> Vecinos = new ArrayList<Vecino>();
		for (int x = 0; x < Coordenadas.Coordenadas.size(); x++) {
			if (!Coordenadas.Coordenadas.get(x).EsIgual(Nueva)) {
				Coordenada CoordenadaVecino = new Coordenada();
				CoordenadaVecino.setCoordenadaCoor(Coordenadas.Coordenadas.get(x));
				Vecino Agregar = new Vecino(CoordenadaVecino, distanciaCoord(Nueva.getLatitud(), Nueva.getLongitud(),
						Coordenadas.Coordenadas.get(x).getLatitud(), Coordenadas.Coordenadas.get(x).getLongitud()));
				Vecinos.add(Agregar);
			}
		}

		return Vecinos;
	}

	public static double distanciaCoord(double lat1, double lng1, double lat2, double lng2) {
		// double radioTierra = 3958.75;//en millas
		double radioTierra = 6371;// en kilómetros
		double dLat = Math.toRadians(lat2 - lat1);
		double dLng = Math.toRadians(lng2 - lng1);
		double sindLat = Math.sin(dLat / 2);
		double sindLng = Math.sin(dLng / 2);
		double va1 = Math.pow(sindLat, 2)
				+ Math.pow(sindLng, 2) * Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2));
		double va2 = 2 * Math.atan2(Math.sqrt(va1), Math.sqrt(1 - va1));
		double distancia = radioTierra * va2;

		return distancia * 1000;

	}

	public void Mostrar() {
		for (int x = 0; x < Resultado.size(); x++) {
			System.out.println("Coordenada " + x + " : " + Resultado.get(x).Coordenada.latitud
					+ Resultado.get(x).Coordenada.longitud);
			for (int y = 0; y < Resultado.get(x).Vecinos.size(); y++) {
				System.out.println(
						"Coordenada de Vecino " + y + " : " + Resultado.get(x).Vecinos.get(y).Vecino.latitud
								+ " / " + Resultado.get(x).Vecinos.get(y).Vecino.longitud);
				System.out.println("Arista de Vecino " + y + " : " + Resultado.get(x).Vecinos.get(y).Arista);
			}
		}
	}

	public void RealizarAGM() {
		Coordenada Primero = new Coordenada();
		AGM Auxiliar = new AGM();
		AGM MenorCamino = new AGM();
		Primero.setCoordenada(Resultado.get(0).Coordenada.latitud, Resultado.get(0).Coordenada.longitud);
		Tocado.add(Primero);
		while (Tocado.size() < Resultado.size()) {
			for (int x = 0; x < Resultado.size(); x++) {
				if (EstaTocado(Resultado.get(x).Coordenada)) {
					MenorCamino = BuscarAristaMinima(Resultado.get(x).Coordenada, Resultado.get(x).Vecinos);
					if (MenorCamino.Arista < Auxiliar.Arista) {
						Auxiliar.Inicio = MenorCamino.Inicio;
						Auxiliar.Fin = MenorCamino.Fin;
						Auxiliar.Arista = MenorCamino.Arista;
					}
				}
			}
			System.out.println(Auxiliar.Arista);
			ArbolGM.add(Auxiliar);
			Tocado.add(Auxiliar.Fin);
			

		}

	}

	private AGM BuscarAristaMinima(Coordenada CoordenadaInicio, ArrayList<Vecino> Vecinos) {
		AGM Nuevo = new AGM();
		Nuevo.Inicio = CoordenadaInicio;
		double Arista = Double.MAX_VALUE;

		for (int x = 0; x < Vecinos.size(); x++) {
			if (Vecinos.get(x).Arista < Arista) {
				Arista = Vecinos.get(x).Arista;
				Nuevo.Arista = Vecinos.get(x).Arista;
				Nuevo.Fin = Vecinos.get(x).Vecino;
			}
		}
		return Nuevo;
	}

	private boolean EstaTocado(Coordenada Coor) {
		for (int x = 0; x < Tocado.size(); x++) {
			System.out.println(Coor.latitud);
			System.out.println(Tocado.get(x).latitud);
			System.out.println(Coor.longitud);
			System.out.println(Tocado.get(x).longitud);

			if (Coor.latitud == Tocado.get(x).latitud && Coor.longitud == Tocado.get(x).longitud) {
				return true;
			}
		}

		return false;
	}
}

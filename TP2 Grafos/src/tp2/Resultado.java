package tp2;

import java.util.ArrayList;

public class Resultado {

	ArrayList<SuperCoordenada> Resultado = new ArrayList<SuperCoordenada>();
	
	Resultado(Coordenadas puntos){
	for(int x=0;x<puntos.Coordenadas.size();x++){
		SuperCoordenada Prueba = new SuperCoordenada(puntos.Coordenadas.get(x),CargarVecinos(puntos.Coordenadas.get(x),puntos));
		Resultado.add(Prueba);
		}
	
	}
	
	private ArrayList<Vecino> CargarVecinos(Coordenada Nueva, Coordenadas Coordenadas){
		ArrayList<Vecino> Vecinos = new ArrayList<Vecino>();
		for(int x = 0; x<Coordenadas.Coordenadas.size();x++){
			if(!Coordenadas.Coordenadas.get(x).EsIgual(Nueva)){
				Vecino Agregar = new Vecino(Nueva,distanciaCoord(Nueva.getLatitud(),
						Nueva.getLongitud(),Coordenadas.Coordenadas.get(x).getLatitud(),
						Coordenadas.Coordenadas.get(x).getLongitud()));
				Vecinos.add(Agregar);
			}
		}
	return Vecinos;
	}
	
	public static double distanciaCoord(double lat1, double lng1, double lat2, double lng2) {  
	    //double radioTierra = 3958.75;//en millas  
	    double radioTierra = 6371;//en kilómetros  
	    double dLat = Math.toRadians(lat2 - lat1);  
	    double dLng = Math.toRadians(lng2 - lng1);  
	    double sindLat = Math.sin(dLat / 2);  
	    double sindLng = Math.sin(dLng / 2);  
	    double va1 = Math.pow(sindLat, 2) + Math.pow(sindLng, 2)  
	            * Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2));  
	    double va2 = 2 * Math.atan2(Math.sqrt(va1), Math.sqrt(1 - va1));  
	    double distancia = radioTierra * va2;  
	 
	    return distancia;  
	 
	}
	
	public void Mostrar(){
		System.out.println("Latitud Pos 0: " + Resultado.get(0).Coordenada.latitud);
		System.out.println("Long Pos 0: " + Resultado.get(0).Coordenada.longitud);
		System.out.println("Cantidad Vecinos: " + Resultado.get(0).Vecinos.size());
		System.out.println("Vecino Latitud: " + Resultado.get(0).Vecinos.get(0).Vecino.getLatitud());
		System.out.println("Vecino Longitud: " + Resultado.get(0).Vecinos.get(0).Vecino.getLongitud());
		System.out.println("Distancia Vecino 0: " + Resultado.get(0).Vecinos.get(0).Arista);
		
	}
	
}

package tp2;

public class Coordenada {
	public double latitud;
	public double longitud;

	public double getLatitud() {
		return this.latitud;
	}

	public double getLongitud() {
		return this.longitud;
	}

	public void setCoordenada(double Lat, double Long){
		this.latitud = Lat;
		this.longitud = Long;
	}
	
	public boolean EsIgual(Coordenada Comparar){
		return latitud == Comparar.latitud && Comparar.longitud == longitud; 
	}
}

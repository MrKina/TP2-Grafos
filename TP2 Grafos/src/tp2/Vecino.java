package tp2;

public class Vecino {
	Coordenada Vecino;
	double Arista;
	
	public Vecino(Coordenada nueva, double distanciaCoord) {
		this.Vecino = nueva;
		this.Arista = distanciaCoord;
	}
}

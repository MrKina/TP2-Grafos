package tp2;

import java.util.ArrayList;

public class SuperCoordenada {
	Coordenada Coordenada;
	ArrayList<Vecino> Vecinos = new ArrayList<Vecino>();

	SuperCoordenada(Coordenada Nueva, ArrayList<Vecino> Nuevos) {
		this.Coordenada = Nueva;
		this.Vecinos = Nuevos;
	}

}

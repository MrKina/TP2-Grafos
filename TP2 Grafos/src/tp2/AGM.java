package tp2;

public class AGM {
	
	Coordenada Inicio;
	Coordenada Fin;
	double Arista;
	
	public void setAGM(Coordenada Ini, Coordenada End, double Peso){
		this.Inicio.setCoordenadaCoor(Ini); ;
		this.Fin.setCoordenadaCoor(End);
		this.Arista = Peso;
	}
}

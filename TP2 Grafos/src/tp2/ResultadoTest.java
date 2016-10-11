package tp2;

import static org.junit.Assert.*;

import org.junit.Test;

public class ResultadoTest {

	@Test
	public void Resultado() {

		Coordenadas PuntosTest = new Coordenadas("instancia1.json");
		assertNotNull(PuntosTest);
		Resultado GrafoTest = new Resultado(PuntosTest);
		assertNotNull(GrafoTest.ArbolGM);
		GrafoTest.RealizarAGM();

		assertEquals(PuntosTest.Coordenadas.size(), GrafoTest.Resultado.size());
		assertTrue(GrafoTest.Resultado.size() > GrafoTest.ArbolGM.size());
		assertTrue(GrafoTest.Tocado.size() > GrafoTest.ArbolGM.size());

	}

}

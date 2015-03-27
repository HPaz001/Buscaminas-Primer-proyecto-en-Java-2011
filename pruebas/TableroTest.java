import java.util.*;

import junit.framework.TestCase;


public class TableroTest extends TestCase {

	Tablero nTablero= new Tablero(4,5);
	Tablero nTableroBombas;
	Tablero nTableroBlanco;
	
	public void testTablero() {
		assertEquals(nTablero.getLista().size(),16);// getLista es private(se puso public para la prueba)
		assertEquals(nTablero.getNroBombas(), 5);
		assertEquals(nTablero.getTamano(),4);
	}

	public void testGetLista() {
		assertNotNull(nTablero.getLista());// getLista es private(se puso public para la prueba)
	}
	public void testColocarCasillas() {
		assertEquals(nTablero.getLista().size(), 16);// getLista es private(se puso public para la prueba)
	}


	public void testColocarBombas() {
		int cont=0;
		Casilla nCasilla;
		Iterator<Casilla> itr = nTablero.getIterador();// getIterador es private(se puso public para la prueba)
		while (itr.hasNext()){
			nCasilla= itr.next();
			if (nCasilla instanceof CasillaBomba){
				cont++;
			}
		}
		assertEquals(nTablero.getNroBombas(), cont);
	}

	
	public void testPulsarCasilla() {
		nTablero= new Tablero(4,5);
		//dentro del rango
		assertEquals(nTablero.buscarCasilla(5).getPulsado(), false);
		nTablero.pulsarCasilla(5);
		assertEquals(nTablero.buscarCasilla(5).getPulsado(), true);
		//fuera del rango
		nTablero.pulsarCasilla(20);
		//fail("mirar que ha imprimido por pantalla el fallo");
	}

	public void testBuscarCasilla() {
		//dentro del rango
		Casilla nCasilla = nTablero.buscarCasilla(5);
		Casilla n2Casilla =nTablero.getLista().get(5);// getLista es private(se puso public para la prueba)
		assertEquals(nCasilla, n2Casilla);
		//fuera del rango
		nCasilla = nTablero.buscarCasilla(25);
		assertNull(nCasilla);
		//fail("mirar que ha imprimido por pantalla el fallo");
		
	}
	
	public void testBuscarCasillaporIdString(){
		//dentro del rango
		Casilla nCasilla = nTablero.buscarCasillaporIdString("b5");
		Casilla n2Casilla =nTablero.buscarCasilla(5);
		assertEquals(nCasilla, n2Casilla);
		//fuera del rango
		nCasilla = nTablero.buscarCasillaporIdString("b25");
		assertNull(nCasilla);
	}

	public void testMarcarDesmarcar() {
		//fail("Not yet implemented");
		//dentro del rango
		boolean nMarcado = nTablero.buscarCasilla(6).getMarcado();
		nTablero.marcarDesmarcar(6);
		assertEquals(nTablero.buscarCasilla(6).getMarcado(), !nMarcado);
		//fuera del rango
		nTablero.marcarDesmarcar(20);
		//fail("mirar que ha imprimido por pantalla el fallo");
	}

	public void testContarBombasAlrededor() {
		nTableroBombas= new Tablero(5,25);
		//hay bombas
		assertEquals(nTableroBombas.contarBombasAlrededor(0),3);
		assertEquals(nTableroBombas.contarBombasAlrededor(4),3);
		assertEquals(nTableroBombas.contarBombasAlrededor(20),3);
		assertEquals(nTableroBombas.contarBombasAlrededor(24),3);
		assertEquals(nTableroBombas.contarBombasAlrededor(2),5);
		assertEquals(nTableroBombas.contarBombasAlrededor(10),5);
		assertEquals(nTableroBombas.contarBombasAlrededor(14),5);
		assertEquals(nTableroBombas.contarBombasAlrededor(22),5);
		assertEquals(nTableroBombas.contarBombasAlrededor(12),8);
		//fuera de rango
		assertEquals(nTableroBombas.contarBombasAlrededor(30),-1);
		//fail("mirar que ha imprimido por pantalla el fallo");
		
		//no hay bombas
		nTableroBlanco= new Tablero(5, 0);
		assertEquals(nTableroBlanco.contarBombasAlrededor(0),0);
		assertEquals(nTableroBlanco.contarBombasAlrededor(4),0);
		assertEquals(nTableroBlanco.contarBombasAlrededor(20),0);
		assertEquals(nTableroBlanco.contarBombasAlrededor(24),0);
		assertEquals(nTableroBlanco.contarBombasAlrededor(2),0);
		assertEquals(nTableroBlanco.contarBombasAlrededor(10),0);
		assertEquals(nTableroBlanco.contarBombasAlrededor(14),0);
		assertEquals(nTableroBlanco.contarBombasAlrededor(22),0);
		assertEquals(nTableroBlanco.contarBombasAlrededor(12),0);
	}

	public void testEsBomba() {
		nTablero= new Tablero(4,5);
		if(nTablero.buscarCasilla(0)instanceof CasillaBomba){
			assertTrue(nTablero.esBomba(0));//si es bomba
		}else{assertFalse(nTablero.esBomba(0));}//si no es bomba
		
	}

	public void testMostrarBombas() {
		nTablero.mostrarBombas();
		//fail("mirar que ha imprimido por pantalla el mensaje correspondiente");
		//fail("mirar que ha imprimido por pantalla las posiciones de todas las bombas");
	}
	
	public void testCuantasQuedan(){
		nTablero= new Tablero(4,5);
		assertEquals(nTablero.cuantasQuedan(),11);
		nTableroBombas= new Tablero(5,25);
		assertEquals(nTableroBombas.cuantasQuedan(), 0);
		JuegoNuevo.getMiJuegoNuevo().juego(5, 0);
		//nTableroBlanco= new Tablero(5, 0);
		assertEquals(JuegoNuevo.getMiJuegoNuevo().getNTablero().cuantasQuedan(), 25);
		JuegoNuevo.getMiJuegoNuevo().getNTablero().pulsarCasilla(10);
		assertEquals(JuegoNuevo.getMiJuegoNuevo().getNTablero().cuantasQuedan(), 0);
	}
	
}

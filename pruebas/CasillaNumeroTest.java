import junit.framework.TestCase;


public class CasillaNumeroTest extends TestCase {
	Tablero t;

	protected void setUp() throws Exception {
		super.setUp();
		t = new Tablero(5,7);
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}
	

	public void testMostrarCasilla() {
		Tablero tNoBombas = new Tablero(2,0);
		// miro si no esta marcada ni pulsada
		assertFalse(tNoBombas.buscarCasilla(0).getMarcado());
		assertFalse(tNoBombas.buscarCasilla(0).getPulsado());
		tNoBombas.pulsarCasilla(0);
		System.out.println("deberia tener 0 bombas alrededor y tiene"+ tNoBombas.contarBombasAlrededor(0)+ "bombas");
		System.out.println("el idTableroVisual deberia ser 0b y es"+ tNoBombas.buscarCasilla(0).getIdTableroVisual());
		
	}

	public void testCasillaNumero() {
		assertFalse(t.buscarCasilla(8).getMarcado());
		assertFalse(t.buscarCasilla(8).getPulsado());
		assertEquals(t.buscarCasilla(8).getPosicion(),8);
		assertEquals(t.buscarCasilla(8).getIdTableroVisual(),"b8");
	}

	public void testMostrarCasillasAlrededor() {
		Tablero t1 = new Tablero(2,0);
         //miro que ninguna este marcada ni pulsada
		assertFalse(t1.buscarCasilla(0).getMarcado());
		assertFalse(t1.buscarCasilla(1).getMarcado());
		assertFalse(t1.buscarCasilla(2).getMarcado());
		assertFalse(t1.buscarCasilla(3).getMarcado());
		assertFalse(t1.buscarCasilla(0).getPulsado());
		assertFalse(t1.buscarCasilla(1).getPulsado());
		assertFalse(t1.buscarCasilla(2).getPulsado());
		assertFalse(t1.buscarCasilla(3).getPulsado());
        //pulso la casilla 0 
		t1.pulsarCasilla(0);
         //como no hay ninguna bomba todas las casillas deberian estar pulsadas 
		assertTrue(t1.buscarCasilla(1).getPulsado());
		assertTrue(t1.buscarCasilla(2).getPulsado());
		assertTrue(t1.buscarCasilla(3).getPulsado());
		
	}
	public void testLlamarArriba() {
		Tablero t = new Tablero(3,0);
		t.pulsarCasilla(4);
		// miro la casilla de arriba solo aunque deberian estar todas pulsadas, las demas las compruebo
		// en otro los otros metodos de "llamar"
		assertTrue(t.buscarCasilla(1).getPulsado());
	}

	public void testLlamarAbajo() {
		Tablero t = new Tablero(3,0);
		t.pulsarCasilla(4);
		assertTrue(t.buscarCasilla(7).getPulsado());
	}

	public void testLlamarArribaDch() {
		Tablero t = new Tablero(3,0);
		t.pulsarCasilla(4);
		assertTrue(t.buscarCasilla(2).getPulsado());
	}

	public void testLlamarAbajoIzqu() {
		Tablero t = new Tablero(3,0);
		t.pulsarCasilla(4);
		assertTrue(t.buscarCasilla(6).getPulsado());
	}

	public void testLlamarAbajoDcha() {
		Tablero t = new Tablero(3,0);
		t.pulsarCasilla(4);
		assertTrue(t.buscarCasilla(8).getPulsado());
	}

	public void testLlamarArribaIzqu() {
		Tablero t = new Tablero(3,0);
		t.pulsarCasilla(4);
		assertTrue(t.buscarCasilla(0).getPulsado());
	}

	public void testLlamarIzqu() {
		Tablero t = new Tablero(3,0);
		t.pulsarCasilla(4);
		assertTrue(t.buscarCasilla(3).getPulsado());
	}

	public void testLlamarLaDerecha() {
		Tablero t = new Tablero(3,0);
		t.pulsarCasilla(4);
		assertTrue(t.buscarCasilla(5).getPulsado());
	}
	
	// metodos que hereda de casilla
	public void testCasilla() {
		
	}

	public void testGetPosicion() {
		assertEquals(t.buscarCasilla(2).getPosicion(),2);
		
	}

	public void testGetIdTableroVisual() {
		assertNotNull(t.buscarCasilla(3).getIdTableroVisual());
	}

	public void testGetMarcado() {
		assertFalse(t.buscarCasilla(3).getMarcado());
		t.marcarDesmarcar(3);
		assertTrue(t.buscarCasilla(3).getMarcado());
	}

	public void testGetPulsado() {
		assertFalse(t.buscarCasilla(8).getPulsado());
		t.pulsarCasilla(8);
		assertTrue(t.buscarCasilla(8).getPulsado());
	}

	public void testSetPulsado() {
		t.pulsarCasilla(8);
		t.buscarCasilla(8).setPulsado();
		assertTrue(t.buscarCasilla(8).getPulsado());
	}

	public void testMarcarDesmarcar() {
		boolean marcado = false;
		t.marcarDesmarcar(5);
		t.buscarCasilla(5).marcarDesmarcar();
		assertEquals(t.buscarCasilla(5).getMarcado(), !marcado);
	}
}

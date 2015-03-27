import junit.framework.TestCase;

public class CasillaBombaTest extends TestCase {
	Tablero t;

	protected void setUp() throws Exception {
		super.setUp();
		Tablero t = new Tablero(5,7);
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testMostrarCasilla() {
		Tablero tBombas = new Tablero(5,25);
		assertFalse(tBombas.buscarCasilla(2).getMarcado());
		assertFalse(tBombas.buscarCasilla(2).getPulsado());
		tBombas.buscarCasilla(2).mostrarCasilla();
		System.out.println("deberia salir la posicion 2");
		System.out.println("el idTableroVisual deberia ser 2b y es"+ tBombas.buscarCasilla(2).getIdTableroVisual());
	}

	public void testCasillaBomba() {
		assertFalse(t.buscarCasilla(8).getMarcado());
		assertFalse(t.buscarCasilla(8).getPulsado());
		assertEquals(t.buscarCasilla(8).getPosicion(),8);
		assertEquals(t.buscarCasilla(8).getIdTableroVisual(),"b8");
	}

	public void testGetPosicion() {
		assertEquals(t.buscarCasilla(6).getPosicion(),6);
		
	}

	public void testGetIdTableroVisual() {
		// movida helen
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

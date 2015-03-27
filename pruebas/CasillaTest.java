import junit.framework.TestCase;


public class CasillaTest extends TestCase {
	Tablero t;
	protected void setUp() throws Exception {
		super.setUp();
		Tablero t = new Tablero(5,7);
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testCasilla() {}

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
		assertTrue(t.buscarCasilla(8).getPulsado());
	}

	public void testMarcarDesmarcar() {
		boolean marcado = false;
		t.marcarDesmarcar(5);
		t.buscarCasilla(5).marcarDesmarcar();
		assertEquals(t.buscarCasilla(5).getMarcado(), !marcado);
	}

}

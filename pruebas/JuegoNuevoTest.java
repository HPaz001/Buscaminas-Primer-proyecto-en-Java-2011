import junit.framework.TestCase;


public class JuegoNuevoTest extends TestCase {

	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testGetMiJuegoNuevo() {
		assertNotNull(JuegoNuevo.getMiJuegoNuevo());
	}

	public void testJuego() {
		JuegoNuevo.getMiJuegoNuevo().juego(10, 15);
		assertEquals(JuegoNuevo.getMiJuegoNuevo().getNTablero().getTamano(),10);
		assertEquals(JuegoNuevo.getMiJuegoNuevo().getNTablero().getNroBombas(),15);
	}


	public void testGetNTablero() {
		assertNotNull(JuegoNuevo.getMiJuegoNuevo().getNTablero());
	}

}

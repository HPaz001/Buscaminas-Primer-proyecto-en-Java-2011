
public class CasillaBomba extends Casilla{

	public CasillaBomba(String pId, int pPos) {
		super(pId, pPos);
	}

	public void mostrarCasilla(){
		if(this.getMarcado() == false && this.getPulsado() == false){
			System.out.println("Habia una bomba en "+super.getIdTableroVisual());
			this.setPulsado();
		}
	}
}

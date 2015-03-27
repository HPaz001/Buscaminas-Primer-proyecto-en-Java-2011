
public class CasillaNumero extends Casilla {

	public CasillaNumero(String pId, int pPos) {
		super(pId, pPos);
	}

	public void mostrarCasilla(){
		if(this.getMarcado() == false && this.getPulsado() == false){
			this.setPulsado();
			int numBombasAlrededor =JuegoNuevo.getMiJuegoNuevo().getNTablero().contarBombasAlrededor(this.getPosicion());
			System.out.println("La casilla: "+this.getIdTableroVisual()+" tiene "+numBombasAlrededor+" bombas alrededor.");
			if(numBombasAlrededor == 0){
				this.mostrarCasillasAlrededor();
			}
		}else{System.out.println("La casilla ya esta marcada o pulsada.");}
	}
	
	private void mostrarCasillasAlrededor(){
		int tam= JuegoNuevo.getMiJuegoNuevo().getNTablero().getTamano();
		int pIndice = this.getPosicion();
		if((pIndice%tam)==0)
		{
			//Es la primera columna
			if(pIndice< tam)
			{
				//Es la esquina sup izqu
				this.llamarLaDerecha(pIndice+1);                   //dcha
				this.llamarAbajo(pIndice+tam);               	   //abajo
				this.llamarAbajoDcha(pIndice+tam+1);               //abajo dcha
				}
			else
				{
					if(tam*(tam-1)<pIndice&&pIndice<(tam*tam))
						{
						//Es la esquina inferiro izqu
						this.llamarLaDerecha(pIndice+1);               //dcha
						this.llamarArribaDch(pIndice-tam+1);           //arriba dcha
						this.llamarArriba(pIndice-tam);                //arriba
						}
					else
						{
						//Es la primera columna menos la primera y ultima fila
						this.llamarLaDerecha(pIndice+1);             //drcha
						this.llamarArribaDch(pIndice+tam+1);         //arriba drcha
						this.llamarArriba(pIndice+tam);              //arriba
						this.llamarAbajo(pIndice-tam);               //abajo
						this.llamarAbajoDcha(pIndice-tam+1);         //abajo drcha
						}
				}
		}
		else
		{
			//no es la primera columna
			if((pIndice+1)%tam ==0){
				//es la ultima columna
				if(pIndice<tam){
					//es la esquina sup drch
					this.llamarIzqu(pIndice-1);                      //izqu
					this.llamarAbajoIzqu(pIndice+tam-1);             //abajo izqu
					this.llamarAbajo(pIndice+tam);                   //abajo
				}
				else
				{
					//no es eskina sup
					if(tam*(tam-1)<pIndice&&pIndice<(tam*tam)){
						//es la eskina inf drch
						this.llamarArriba(pIndice-tam);                 //arriba
						this.llamarArribaIzqu(pIndice-tam-1);           //arriba izqu
						this.llamarIzqu(pIndice-1);                     //izqu
					}
					else
					{
						//es la ultima colum, no es eskina sup ni eskina infe
						this.llamarArriba(pIndice-tam);                  //arriba
						this.llamarArribaIzqu(pIndice-tam-1);            //arriba izqu
						this.llamarIzqu(pIndice-1);                      //izqu
						this.llamarAbajoIzqu(pIndice+tam-1);             //abajo izqu
						this.llamarAbajo(pIndice+tam);                   //abajo
					}
				}
			}
			else
			{
				//no es la primera colum ni la ultima
				if(pIndice< tam){
					//es la primera fila menos las eskinas
					this.llamarLaDerecha(pIndice+1);                     //drch
					this.llamarIzqu(pIndice-1);                          //izqu
					this.llamarAbajoIzqu(pIndice+tam-1);                 //abajo izqu
					this.llamarAbajo(pIndice+tam);                       //abajo
					this.llamarAbajoDcha(pIndice+tam+1);                 //abajo drch
					}
				else
				{
					//no es la primera fila
					if(tam*(tam-1)<pIndice&&pIndice<(tam*tam)){
						//es la ultima fila menos las esquinas
						this.llamarLaDerecha(pIndice+1);                 //drch
						this.llamarArribaDch(pIndice-tam+1);             //arriba dcha
						this.llamarArriba(pIndice-tam);                  //arriba
						this.llamarArribaIzqu(pIndice-tam-1);            //arriba izqu
						this.llamarIzqu(pIndice-1);                      //izqu
					}
					else
					{
						//no es la primera fila ni la ultima, no es ni la primera colum ni la ultima
						//es centro
						this.llamarLaDerecha(pIndice+1);                  //drcha
						this.llamarArribaDch(pIndice-tam+1);              //arriba drcha
						this.llamarArriba(pIndice-tam);                   //arriba
						this.llamarArribaIzqu(pIndice-tam-1);             //arriba izqu
						this.llamarIzqu(pIndice-1);                       //izqu
						this.llamarAbajoIzqu(pIndice+tam-1);              //abajo izqu
						this.llamarAbajo(pIndice+tam);                    //abajo
						this.llamarAbajoDcha(pIndice+tam+1);              //abajo drcha
					}
				}
			}
		}
	}
	
	//Estos metodos son privados, pero para realizar las pruebas los hemos puesto public
	
	private void llamarArriba(int pIndice){
		JuegoNuevo.getMiJuegoNuevo().getNTablero().pulsarCasilla(pIndice);
		
	}
	
	private void llamarAbajo(int pIndice){
		JuegoNuevo.getMiJuegoNuevo().getNTablero().pulsarCasilla(pIndice);
	}
	
	private void llamarArribaDch(int pIndice){
		JuegoNuevo.getMiJuegoNuevo().getNTablero().pulsarCasilla(pIndice);
	}
	
	private void llamarAbajoIzqu(int pIndice){
		JuegoNuevo.getMiJuegoNuevo().getNTablero().pulsarCasilla(pIndice);
	}
	
	private void llamarAbajoDcha(int pIndice){
		JuegoNuevo.getMiJuegoNuevo().getNTablero().pulsarCasilla(pIndice);
	}
	
	private void llamarArribaIzqu(int pIndice){
		JuegoNuevo.getMiJuegoNuevo().getNTablero().pulsarCasilla(pIndice);
	}
	
	private void llamarIzqu(int pIndice){
		JuegoNuevo.getMiJuegoNuevo().getNTablero().pulsarCasilla(pIndice);
	}
	
	private void llamarLaDerecha(int pIndice){
		JuegoNuevo.getMiJuegoNuevo().getNTablero().pulsarCasilla(pIndice);
	}
}

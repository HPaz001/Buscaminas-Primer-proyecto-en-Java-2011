//package org.proyecto.pack1;
import java.util.*;
//import java.math.*;
/*
import java.util.ArrayList;
import java.util.Iterator;
*/
public class Tablero {

	//atributos
	private ArrayList<Casilla> lista;
	private int nroBombas;
	private int tamano;
	
	//Constructora
	public Tablero (int pTamano,int pNroBombas){
		this.lista = new ArrayList<Casilla>();
		this.nroBombas= pNroBombas;
		this.tamano= pTamano;// es el nº de filas y columnas
		this.colocarCasillas();
		this.colocarBombas();
	}
	
	//getters y setters
	public int getNroBombas(){return this.nroBombas;}
	
	public int getTamano(){return this.tamano;}
	
	private ArrayList<Casilla> getLista(){return this.lista;}
	
	private Iterator<Casilla> getIterador(){return this.getLista().iterator();}
	
	//metodos casilla
	
	private void colocarCasillas(){
		Casilla nCasilla=null;
		String id=null;// para casilla
		int cont=0;
		while (cont < (this.getTamano()*this.getTamano())){
			id="b"+cont;
			nCasilla= new CasillaNumero(id, cont);
			this.getLista().add(nCasilla);
			cont++;
			id="";
		}
	}
	
	public void pulsarCasilla(int pIndice){
		if(pIndice<(this.getTamano()*this.getTamano())&& pIndice>=0 ){
			Casilla nCasilla = this.buscarCasilla(pIndice);
			if(nCasilla instanceof CasillaNumero && nCasilla.getPulsado()==false){nCasilla.mostrarCasilla(); }
			else{
				if(nCasilla instanceof CasillaBomba){this.mostrarBombas();}}
		}
		else{
			System.out.println("El indice esta fuera del rango del tablero.1");
		}
	}
	
	public Casilla buscarCasilla(int pIndice){
		//Tengo k cambiarlo para hacerlo x string
		Casilla nCasilla;
		if(pIndice<(this.getTamano()* this.getTamano())&& pIndice>=0 ){
			nCasilla = this.getLista().get(pIndice);
		}
		else{
			System.out.println("El indice esta fuera del rango del tablero.2");
			nCasilla= null;
		}
		return nCasilla;
	}
	
	public Casilla buscarCasillaporIdString (String pID){
		Casilla casi = null;
		Iterator<Casilla> itr = this.getIterador();
		boolean enc = false;
		while(itr.hasNext()&&!enc ){
			casi=itr.next();
			if (casi.getIdTableroVisual().equals(pID)){
				enc=true;
			}
		}
		if (!enc){
			casi=null;
		}
		return casi;
	}
	
	public void marcarDesmarcar(int pIndice){
		if(pIndice<(this.getTamano()*this.getTamano())&& pIndice>0 ){
			Casilla nCasilla = this.buscarCasilla(pIndice);
			nCasilla.marcarDesmarcar();}
		else {
			System.out.println("El indice esta fuera del rango del tablero.3");
		}
	}
	
	public int contarBombasAlrededor(int pIndice){
		int cont=0;
		int tam= this.getTamano();
		if(pIndice>=0 && pIndice < tam*tam ){
			if((pIndice%tam)==0){
				//Es la primera columna
				if(pIndice< tam){
					//Es la esquina sup izqu
					System.out.println("Es la esquina superior izquierda.");
					if(this.esBomba(pIndice+1)){cont++;}                   //dcha
					if(this.esBomba(pIndice+tam)){cont++;}                 //abajo
					if(this.esBomba(pIndice+tam+1)){cont++;}               //abajo dcha
					}
				else
					{
						if(tam*(tam-1) <= pIndice && pIndice <= (tam*tam))
							{
							System.out.println("Es la esquina inferior izquierda.");
							//Es la esquina inferiro izqu
							if(this.esBomba(pIndice+1)){cont++;}            //dcha
							if(this.esBomba(pIndice-tam)){cont++;}          //arriba
							if(this.esBomba(pIndice-tam+1)){cont++;}        //arriba dcha
							}
						else{
							System.out.println("Es el lateral izquierdo.");
							//Es la primera columna menos la primera y ultima fila
							if(this.esBomba(pIndice+1)){cont++;}             //drcha
							if(this.esBomba(pIndice-tam)){cont++;}           //arriba
							if(this.esBomba(pIndice-tam+1)){cont++;}         //arriba drcha
							if(this.esBomba(pIndice+tam)){cont++;}           //abajo
							if(this.esBomba(pIndice+tam+1)){cont++;}         //abajo drcha
							}
					}
			}
			else{//no es la primera columna
				if((pIndice+1)%tam ==0){
					//es la ultima columna
					if( tam > pIndice){
						System.out.println("Es la esquina superior derecha.");
						//es la esquina sup drch
						if(this.esBomba(pIndice-1)){cont++;}                  //izqu
						if(this.esBomba(pIndice+tam)){cont++;}                //abajo
						if(this.esBomba(pIndice+tam-1)){cont++;}              //abajo izqu
					}else{//no es eskina sup
						if( tam*(tam-1) <= pIndice && (tam*tam) > pIndice){
							//es la eskina inf drch
							System.out.println("Es la esquina inferior derecha.");
							if(this.esBomba(pIndice-1)){cont++;}              //izqu
							if(this.esBomba(pIndice-tam)){cont++;}            //arriba
							if(this.esBomba(pIndice-tam+1)){cont++;}          //arriba izqu
						}else{
							//es la ultima colum, no es eskina sup ni eskina infe
							System.out.println("Es el lateral derecho.");
							if(this.esBomba(pIndice-1)){cont++;}               //izqu
							if(this.esBomba(pIndice+tam)){cont++;}             //abajo
							if(this.esBomba(pIndice+tam-1)){cont++;}           //abajo izqu
							if(this.esBomba(pIndice-tam)){cont++;}             //arriba
							if(this.esBomba(pIndice-tam-1)){cont++;}           //arriba izqu
						}
					}
				}else{
					//no es la primera colum ni la ultima
					if(pIndice< tam){
						System.out.println("Es el lateral superior.");
						//es la primera fila menos las eskinas
						if(this.esBomba(pIndice+1)){cont++;}                    //drch
						if(this.esBomba(pIndice-1)){cont++;}                    //izqu
						if(this.esBomba(pIndice+tam)){cont++;}                  //abajo
						if(this.esBomba(pIndice+tam+1)){cont++;}                //abajo drch
						if(this.esBomba(pIndice+tam-1)){cont++;}                //abajo izqu
					}else{
						//no es la primera fila
						if(tam*(tam-1)<pIndice&&pIndice<(tam*tam)){
							System.out.println("Es el lateral inferior.");
							//es la ultima fila menos las esquinas
							if(this.esBomba(pIndice+1)){cont++;}                 //drch
							if(this.esBomba(pIndice-1)){cont++;}                 //izqu
							if(this.esBomba(pIndice-tam)){cont++;}               //arriba
							if(this.esBomba(pIndice-tam+1)){cont++;}             //arriba dcha
							if(this.esBomba(pIndice-tam-1)){cont++;}             //arriba izqu
						}else{
							System.out.println("Es casilla central.");
							//no es la primera fila ni la ultima, no es ni la primera colum ni la ultima
							if (this.esBomba(pIndice+1)){cont++;}                 //drcha
							if (this.esBomba(pIndice-1)){cont++;}                 //izqu
							if (this.esBomba(pIndice+getTamano())){cont++;}       //abajo
							if (this.esBomba(pIndice+getTamano()+1)){cont++;}     //abajo drcha
							if (this.esBomba(pIndice+getTamano()-1)){cont++;}     //abajo izqu
							if (this.esBomba(pIndice-getTamano())){cont++;}       //arriba
							if (this.esBomba(pIndice-getTamano()+1)){cont++;}     //arriba drcha
							if (this.esBomba(pIndice-getTamano()-1)){cont++;}     //arriba izqu
						}
					}
				}
			}
		}else{
			System.out.println("El indice esta fuera del rango del tablero.4");
			cont = -1;
		}
		return cont;
	}
	
	//metodos bomba
	public boolean esBomba(int pIndice){
		boolean es;
		if (0<=pIndice &&  (this.getTamano()*this.getTamano())> pIndice){
			Casilla nCasilla = this.buscarCasilla(pIndice);
			es = nCasilla instanceof CasillaBomba; 
			// da fallo xk no tngo Casilla + herencia
		}else {
			es = false;
			System.out.println("El indice esta fuera del rango del tablero.5..."+ pIndice);
		}
		
		return es;
	}
	
	public void mostrarBombas(){
		System.out.println("Has perdido. Mira donde estaban las bombas. Intentalo de nuevo.");
		Iterator<Casilla> itr = this.getIterador();
		Casilla nCasilla;
		//int fila, columna;
		while (itr.hasNext()){
			nCasilla = itr.next();
			if(nCasilla instanceof CasillaBomba){
				nCasilla.mostrarCasilla();
			}
		}
	}
	
	private void colocarBombas(){
		Casilla nCasilla=null;
		CasillaBomba nBomba=null;
		String id = null;
		int max= ((this.getTamano()*this.getTamano()));
		int min=0;
		int azar;
		int cont= this.getNroBombas();
		while(cont != 0){
			azar= (int)(Math.random()*(max-min)+min);
			if(0<=azar && azar< this.getTamano()*this.getTamano()){
				nCasilla= this.buscarCasilla(azar);
					if (nCasilla instanceof CasillaNumero){
						id="b"+azar;
						this.getLista().remove(azar);
						nBomba= new CasillaBomba(id, azar);
						this.getLista().add(azar, nBomba);
						cont--;
					}
			}else{System.out.println("Sale del rango ");}
		}
	}
	
	public int cuantasQuedan(){
		Iterator<Casilla> itr = this.getIterador();
		Casilla nCasilla;
		int cont=0;
		while(itr.hasNext()){
			nCasilla= itr.next();
			if(nCasilla instanceof CasillaNumero && !nCasilla.getPulsado()){
				cont++;
			}
		}
		return cont;
	}
	
}

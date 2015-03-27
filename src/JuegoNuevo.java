import java.util.Scanner;

import javax.swing.SwingUtilities;

public class JuegoNuevo {
	// atributos
	private  Tablero nTablero;
	private static JuegoNuevo miJuegoNuevo = new JuegoNuevo();;
		
    //Constructora
	private JuegoNuevo(){ /*no hace nada */}
	
	//metodos
	public static JuegoNuevo getMiJuegoNuevo(){
		return miJuegoNuevo;
	}
	
	public void juego(int pTamanoTablero, int pNroBombas){
		this.nTablero = new Tablero(pTamanoTablero, pNroBombas);
	}

	//getters
	public Tablero getNTablero(){	
		return this.nTablero;
	}

	public static void main(String[] args) {
		Scanner sc; String sPos; int pos; boolean enc= true;
		JuegoNuevo.miJuegoNuevo.juego(10, 15);
		System.out.println("Bienvenido al Buscaminas");	
		System.out.println("Tu tamblero consta de 100 Casillas que van del 0 al 99");	
		while(enc){
			try{
				System.out.println("Escribe la posicion de la casilla");
				sc=new Scanner(System.in); sPos= sc.next();
				pos = Integer.parseInt(sPos);
					if (pos>99 || pos<0){
						throw (new Exception());
					}
				JuegoNuevo.miJuegoNuevo.getNTablero().pulsarCasilla(pos);
				if(JuegoNuevo.miJuegoNuevo.getNTablero().cuantasQuedan()==0){
					enc= false;     System.out.println("Has ganado");
				}
				else if (JuegoNuevo.miJuegoNuevo.getNTablero().buscarCasilla(pos) instanceof CasillaBomba){
					enc= false;     JuegoNuevo.miJuegoNuevo.getNTablero().mostrarBombas();
				}
			}
			catch(Exception e){
				System.out.println("Debes introducir un número dentro del rango [0-99]");
			}
		}
	}
}

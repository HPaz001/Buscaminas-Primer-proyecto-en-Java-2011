//package org.proyecto.pack1;

public abstract class Casilla {
	
	private boolean marcado;
	private boolean pulsado;
	private String idTableroVisual;
	private int posicion;
	
	//constructora
	
	public Casilla(String pId, int pPos){
		this.idTableroVisual = pId;
		this.marcado = false;
		this.pulsado = false;
		this.posicion= pPos;
	}
	
	//getters y setters

	public int getPosicion() {
		return posicion;
	}

	public String getIdTableroVisual() {
		return idTableroVisual;
	}

	public boolean getMarcado() {
		return marcado;
	}

	public boolean getPulsado() {
		return pulsado;
	}

	protected void setPulsado() {
			this.pulsado = true;
	}
	//otros metodos
	
	public abstract void mostrarCasilla();


	public void marcarDesmarcar() {
		if(getMarcado() == false){
			this.marcado = true;
			}
		else{
			this.marcado = false;
			}
		
	}
	
	
}

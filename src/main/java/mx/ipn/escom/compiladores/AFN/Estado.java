package mx.ipn.escom.compiladores.AFN;

import java.util.ArrayList;
import java.util.List;

public class Estado {
	protected static Integer contadorID = 0;
	protected static Integer tab = -1;
	private Integer id;
	private Boolean aceptacion;
	private List<Transicion> transiciones;
	private Integer cuentaTransiciones;//Transiciones de llegada al estado
	private Boolean impreso;
	
	public Estado(){
		contadorID++;
		id = contadorID;
		aceptacion = false;
		transiciones = new ArrayList<Transicion>();
		cuentaTransiciones = 0;
		impreso = false;
	}
	public Estado(Boolean aceptacion) {
		contadorID++;
		id = contadorID;
		this.aceptacion = aceptacion;
		transiciones = new ArrayList<Transicion>();
		cuentaTransiciones = 0;
		impreso = false;
	}
	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * @return the aceptacion
	 */
	public Boolean getAceptacion() {
		return aceptacion;
	}
	/**
	 * @param aceptacion the aceptación to set
	 */
	public void setAceptacion(Boolean aceptacion) {
		this.aceptacion = aceptacion;
	}
	
	public void setTransicion(Transicion transicion){
		transiciones.add(transicion);
	}
	
	/**
	 * @return the cuentaTransiciones
	 */
	public Integer getCuentaTransiciones() {
		return cuentaTransiciones;
	}
	/**
	 * @param cuentaTransiciones the cuentaTransiciones to set
	 */
	public void setCuentaTransiciones(Integer cuentaTransiciones) {
		this.cuentaTransiciones = cuentaTransiciones;
	}
	public Transicion getTransicion(Simbolo sim){
		Transicion tran = null;
		for (Transicion transicion : transiciones) {
			if (transicion.getSim().equals(sim)) {
				tran = transicion;
				break;
			}
		}
		return tran;
	}
	
	/**
	 * @return the transiciones
	 */
	public List<Transicion> getTransiciones() {
		return transiciones;
	}
	/**
	 * @param transiciones the transiciones to set
	 */
	public void setTransiciones(List<Transicion> transiciones) {
		this.transiciones = transiciones;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean equals(Estado edo) {
		// TODO Auto-generated method stub
		return this.aceptacion.equals(edo.getAceptacion());
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String edo;
		Boolean flag = true;
		if (aceptacion) {
			edo = "((" + this.id + "))";
		}
		else{
			edo = "(" + this.id + ")";
		}
		if (cuentaTransiciones > 1) {
			if (impreso) {
				flag = false;
			}
		}
		impreso = true;
		if (!transiciones.isEmpty() && flag) {
			if (transiciones.size() == 1) {
				edo += "" + transiciones.get(0);
			}
			else{
				edo += "{<br><blockquote>";
				tab++;
				for (Transicion transicion : transiciones) {
//					for (int i = 0; i < tab; i++) {
//						edo += "\t";
//					}
					edo += transicion + "<br>";
				}
//				for (int i = 0; i < tab; i++) {
//					edo += "\t";
//				}
				tab--;
				edo += "</blockquote>}";
			}
		}
		return edo;
	}
	/* (non-Javadoc)
	 * Se debe de resetear la impresión después de cada llamada a imprimir.
	 */
	public void resetImpresion(){
		impreso = false;
		if (!transiciones.isEmpty()) {
			for (Transicion transicion : transiciones) {
				if (!transicion.getEstado().reseteado()) {
					transicion.getEstado().resetImpresion();
				}
			}
		}
	}
	
	public Boolean reseteado(){
		return !impreso;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#finalize()
	 */
	@Override
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
		super.finalize();
		contadorID--;
		id = 0;
		aceptacion = null;
	}
}

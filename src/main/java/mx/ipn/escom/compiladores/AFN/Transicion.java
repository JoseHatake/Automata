package mx.ipn.escom.compiladores.AFN;


public class Transicion {
	private Simbolo sim;
	private Estado estado;
	
	public Transicion(){
		super();
		this.sim = new Simbolo();
		this.estado = new Estado();
		this.estado.setCuentaTransiciones(1);
	}

	public Transicion(Simbolo sim) {
		super();
		this.sim = sim;
		this.estado = new Estado();
		this.estado.setCuentaTransiciones(1);
	}
	
	public Transicion(Simbolo sim,Estado estado){
		super();
		this.sim = sim;
		this.estado = estado;
		this.estado.setCuentaTransiciones(this.estado.getCuentaTransiciones()+1);
	}

	/**
	 * @return the sim
	 */
	public Simbolo getSim() {
		return sim;
	}

	/**
	 * @param sim the sim to set
	 */
	public void setSim(Simbolo sim) {
		this.sim = sim;
	}

	/**
	 * @return the estado
	 */
	public Estado getEstado() {
		return estado;
	}

	/**
	 * @param estado the estado to set
	 */
	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean equals(Transicion tran) {
		// TODO Auto-generated method stub
		return this.sim.equals(tran.getSim()) && this.estado.equals(tran.getEstado());
	}
	
	public Boolean equals(Simbolo sim){
		return this.sim.equals(sim);
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "--" + sim + "-->" + estado;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#finalize()
	 */
	@Override
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
		super.finalize();
		sim.finalize();
		estado.finalize();
	}
}
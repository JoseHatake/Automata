package mx.ipn.escom.compiladores.AFN;

import java.util.List;

public class AFN {
	private Estado inicial;
	private Estado ultimo;
	private Alfabeto alfabet;
	
	public AFN(){
		this.inicial = new Estado();
		this.alfabet = new Alfabeto();
		this.ultimo = null;
	}
	
	public AFN(Transicion transicion){
		this.inicial = new Estado();
		this.inicial.setTransicion(transicion);
		this.ultimo = this.inicial.getTransicion(transicion.getSim()).getEstado();
		this.ultimo.setAceptacion(true);
	}

	public void unir(AFN afn){
		Estado aux1,aux2;
		aux1 = new Estado();
		aux2 = new Estado();
		aux1.setTransicion(new Transicion(new Simbolo(),inicial));
		aux1.setTransicion(new Transicion(new Simbolo(),afn.getInicial()));
		this.ultimo.setAceptacion(false);
		afn.getUltimo().setAceptacion(false);
		aux2.setAceptacion(true);
		this.ultimo.setTransicion(new Transicion(new Simbolo(),aux2));
		afn.getUltimo().setTransicion(new Transicion(new Simbolo(),aux2));
		this.inicial = aux1;
		this.ultimo = aux2;
	}
	
	public void concatenar(AFN afn){
		List<Transicion> tran;
		Estado aux;
		this.ultimo.setAceptacion(false);
		aux = this.ultimo;
		tran = afn.getInicial().getTransiciones();
		for (Transicion transicion : tran) {
			aux.setTransicion(transicion);
			this.ultimo = transicion.getEstado();
		}
	}
	
	public void cerraduraKleene(){
		Estado aux1, aux2;
		aux1 = new Estado();
		aux2 = new Estado();
		aux1.setTransicion(new Transicion(new Simbolo(),this.inicial));
		aux1.setTransicion(new Transicion(new Simbolo(),aux2));
		aux2.setAceptacion(true);
		this.ultimo.setAceptacion(false);
		this.ultimo.setTransicion(new Transicion(new Simbolo(),this.inicial));
		this.ultimo.setTransicion(new Transicion(new Simbolo(),aux2));
		this.inicial = aux1;
		this.ultimo = aux2;
	}
	
	public void cerraduraPositiva(){
		Estado aux1, aux2;
		aux1 = new Estado();
		aux2 = new Estado();
		aux1.setTransicion(new Transicion(new Simbolo(),this.inicial));
		aux2.setAceptacion(true);
		this.ultimo.setAceptacion(false);
		this.ultimo.setTransicion(new Transicion(new Simbolo(),this.inicial));
		this.ultimo.setTransicion(new Transicion(new Simbolo(),aux2));
		this.inicial = aux1;
		this.ultimo = aux2;
	}
	
	public void opcional(){
		Estado aux1, aux2;
		aux1 = new Estado();
		aux2 = new Estado();
		aux1.setTransicion(new Transicion(new Simbolo(),this.inicial));
		aux1.setTransicion(new Transicion(new Simbolo(),aux2));
		aux2.setAceptacion(true);
		this.ultimo.setAceptacion(false);
		this.ultimo.setTransicion(new Transicion(new Simbolo(),aux2));
		this.inicial = aux1;
		this.ultimo = aux2;
	}
	
	public void setTransicion(Transicion tran, Boolean aceptacion){
		this.inicial.setTransicion(tran);
		this.ultimo = tran.getEstado();
		this.ultimo.setAceptacion(aceptacion);
	}
	
	public Transicion getTransicion(Simbolo sim){
		return this.inicial.getTransicion(sim);
	}
	
	/**
	 * @return the inicial
	 */
	public Estado getInicial() {
		return inicial;
	}
	/**
	 * @param inicial the inicial to set
	 */
	public void setInicial(Estado inicial) {
		this.inicial = inicial;
	}
	/**
	 * @return the ultimo
	 */
	public Estado getUltimo() {
		return ultimo;
	}
	/**
	 * @param ultimo the ultimo to set
	 */
	public void setUltimo(Estado ultimo) {
		this.ultimo = ultimo;
	}
	/**
	 * @return the alfabet
	 */
	public Alfabeto getAlfabet() {
		return alfabet;
	}
	/**
	 * @param alfabet the alfabet to set
	 */
	public void setAlfabet(Alfabeto alfabet) {
		this.alfabet = alfabet;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "AFN [inicial:" + inicial + ", final=" + ultimo + "]";
	}
	
	public void resetImpresion(){
		inicial.resetImpresion();
		if (ultimo != null)
			ultimo.resetImpresion();
	}
	
	public void imprimirAFN(){
		System.out.println(this);
		this.resetImpresion();
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#finalize()
	 */
	@Override
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
		super.finalize();
		inicial = null;
		ultimo = null;
		alfabet.finalize();
	}
}
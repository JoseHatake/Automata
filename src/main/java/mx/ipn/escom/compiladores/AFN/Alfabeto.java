package mx.ipn.escom.compiladores.AFN;

import java.util.ArrayList;
import java.util.List;

public class Alfabeto {
	private List<Simbolo> simbolos;
	
	public Alfabeto(){
		simbolos = new ArrayList<Simbolo>();
		simbolos.add(new Simbolo());
	}

	public Alfabeto(List<Simbolo> simbolos) {
		this.simbolos = simbolos;
	}
	
	public Alfabeto(Simbolo sim){
		simbolos.add(sim);
	}

	/**
	 * @return the simbolos
	 */
	public List<Simbolo> getSimbolos() {
		return simbolos;
	}

	/**
	 * @param simbolos the simbolos to set
	 */
	public void setSimbolos(List<Simbolo> simbolos) {
		this.simbolos = simbolos;
	}
	
	public void setSimbolo(Simbolo sim){
		simbolos.add(sim);
	}
	
	public Simbolo getSimbolo(Integer index){
		return simbolos.get(index);
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean equals(Alfabeto alfabet) {
		// TODO Auto-generated method stub
		Boolean flag,desicion;
		desicion = true;
		if (simbolos.size() == alfabet.getSimbolos().size()) {
			for (Simbolo simbolo1 : simbolos) {
				flag = false;
				for (Simbolo simbolo2 : alfabet.getSimbolos()) {
					if(simbolo1.equals(simbolo2)){
						flag = true;
						break;
					}
				}
				if (!flag) {
					desicion = false;
					break;
				}
			}
		}
		else
			desicion = false;
		return desicion;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String concat = new String();
		concat = "{";
		for (Simbolo simbolo : simbolos) {
			concat += simbolo.getS() + ",";
		}
		concat = "}";
		return concat;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#finalize()
	 */
	@Override
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
		simbolos.clear();
		super.finalize();
	}
}

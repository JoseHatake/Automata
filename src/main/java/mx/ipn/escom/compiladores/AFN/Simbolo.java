package mx.ipn.escom.compiladores.AFN;

public class Simbolo {
	private char s;
	
	public Simbolo(){
		this.s = '\00';
	}
	
	public Simbolo(char s) {
		super();
		this.s = s;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return ""+s;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#finalize()
	 */
	@Override
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
		s = '\00';
		super.finalize();
	}

	/**
	 * @return the s
	 */
	public char getS() {
		return s;
	}

	/**
	 * @param s the s to set
	 */
	public void setS(char s) {
		this.s = s;
	}
}

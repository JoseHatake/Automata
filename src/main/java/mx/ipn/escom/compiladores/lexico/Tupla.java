package mx.ipn.escom.compiladores.lexico;

public class Tupla {
	private String lexema;
	private Integer token;
	
	public Tupla() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Tupla(String lexema, Integer token) {
		super();
		this.lexema = lexema;
		this.token = token;
	}

	public String getLexema() {
		return lexema;
	}

	public void setLexema(String lexema) {
		this.lexema = lexema;
	}

	public Integer getToken() {
		return token;
	}

	public void setToken(Integer token) {
		this.token = token;
	}
}

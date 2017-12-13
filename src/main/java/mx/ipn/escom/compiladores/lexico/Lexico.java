package mx.ipn.escom.compiladores.lexico;

public class Lexico{
	private String cadena;
	private String lexema;
	private Integer indexActual;
	
	public Lexico() {
		cadena = new String();
		lexema = null;
		indexActual = 0;
	}
	
	public Lexico(String s) {
		cadena = s;
		lexema = null;
		indexActual = 0;
	}
	
	public String getCadena() {
		return cadena;
	}

	public void setCadena(String cadena) {
		this.cadena = cadena;
	}
	
	public String getLexema() {
		return lexema;
	}

	public Integer getToken() {
		String auxLexema;
		lexema = new String();
		auxLexema = new String();
		if (!this.hasMoreString())
			return Token.FIN;
		while(this.hasMoreString()) {
			auxLexema += this.nextString();
			if (!auxLexema.equals(" ")) {
				while(this.esDigito(auxLexema)) {
					lexema += auxLexema;
					auxLexema = this.nextString();
					if(this.esPunto(auxLexema)) {
						lexema += auxLexema;
						auxLexema = this.nextString();
						if (!this.esDigito(auxLexema)) {
							return Token.ERROR;
						}
					}
					else if(!this.esDigito(auxLexema)) {
						indexActual--;
						return Token.NUMERO;
					}
				}
				lexema = auxLexema;
				if (auxLexema.equals("+"))
					return Token.MAS;
				else if(auxLexema.equals("-"))
					return Token.MENOS;
				else if(auxLexema.equals("*"))
					return Token.POR;
				else if(auxLexema.equals("/"))
					return Token.ENTRE;
				else if(auxLexema.equals("("))
					return Token.PARENTESIS_IZQUIERDO;
				else if(auxLexema.equals(")"))
					return Token.PARENTESIS_DERECHO;
				else if(auxLexema.equals("^"))
					return Token.EXP;
				else if(auxLexema.equals("e"))
					return Token.E;
				else if(auxLexema.equals("sin"))
					return Token.SIN;
				else if(auxLexema.equals("cos"))
					return Token.COS;
				else if(auxLexema.equals("tan"))
					return Token.TAN;
				else if(auxLexema.equals("log"))
					return Token.LOG;
				else if(auxLexema.equals("ln"))
					return Token.LN;
			}
			else {
				auxLexema = "";
			}
		}
		return Token.ERROR;
	}
	
	public void regresarToken() {
		Integer largo;
		largo = lexema.length();
		indexActual -= largo;
	}
	
	private String nextString() {
		if (hasMoreString())
			return cadena.substring(indexActual,++indexActual);
		else {
			indexActual++;
			return " ";
		}
	}
	
	public Boolean hasMoreString() {
		return cadena.length()>indexActual;
	}
	
	private Boolean esDigito(String x) {
		Boolean flag = false;
		try{
			flag = Integer.valueOf(x) > 0 || Integer.valueOf(x) < 0 || Integer.valueOf(x) == 0;
		}catch(Exception e){
			flag = false;
		}
		return flag;
	}
	
	private Boolean esPunto(String p) {
		return p.equals(".");
	}
}

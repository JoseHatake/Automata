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
				switch(auxLexema) {
					case "+":
						lexema = auxLexema;
						return Token.MAS;
					case "-":
						lexema = auxLexema;
						return Token.MENOS;
					case "*":
						lexema = auxLexema;
						return Token.POR;
					case "/":
						lexema = auxLexema;
						return Token.ENTRE;
					case "(":
						lexema = auxLexema;
						return Token.PARENTESIS_IZQUIERDO;
					case ")":
						lexema = auxLexema;
						return Token.PARENTESIS_DERECHO;
					case "^":
						lexema = auxLexema;
						return Token.EXP;
					case "e":
						lexema = auxLexema;
						return Token.E;
					case "sin":
						lexema = auxLexema;
						return Token.SIN;
					case "cos":
						lexema = auxLexema;
						return Token.COS;
					case "tan":
						lexema = auxLexema;
						return Token.TAN;
					case "log":
						lexema = auxLexema;
						return Token.LOG;
					case "ln":
						lexema = auxLexema;
						return Token.LN;
					default:
						break;
				}
			}
			else {
				auxLexema = "";
			}
		}
		return Token.ERROR;
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

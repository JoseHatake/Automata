package mx.ipn.escom.compiladores.descensosRecursivos;

import mx.ipn.escom.compiladores.lexico.Lexico;
import mx.ipn.escom.compiladores.lexico.Token;

public class Calcu extends Token{
	private Lexico lexico;

	public Calcu() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Calcu(Lexico lexico) {
		super();
		this.lexico = lexico;
	}

	public Lexico getLexico() {
		return lexico;
	}

	public void setLexico(Lexico lexico) {
		this.lexico = lexico;
	}
	
	public Referencia G(Referencia operacion) {
		Integer token;
		if (E(operacion)) {
			token = lexico.getToken();
			if (token == Token.FIN) {
				return operacion;
			}
		}
		return new Referencia();
	}
	
	public Boolean E(Referencia operacion) {
		if (T(operacion)) {
			if (Ep(operacion)) {
				return true;
			}
		}
		return false;
	}
	
	public Boolean T(Referencia operacion) {
		if (P(operacion)) {
			if (Tp(operacion)) {
				return true;
			}
		}
		return false;
	}
	
	public Boolean Ep(Referencia operacion) {
		Integer token;
		Double aux;
		Referencia valAux = new Referencia(new Double(0));
		token = lexico.getToken();
		if (token == Token.MAS || token == Token.MENOS) {
			if (T(valAux)) {
				aux = operacion.getValor() + (token == Token.MAS?valAux.getValor():-valAux.getValor());
				operacion.setValor(aux);
				if (Ep(operacion)) {
					return true;
				}
			}
			return false;
		}
		lexico.regresarToken();
		return true;
	}
	
	public Boolean Tp(Referencia operacion) {
		Integer token;
		Double aux;
		Referencia valAux = new Referencia(new Double(0));
		token = lexico.getToken();
		if (token == Token.POR || token == Token.ENTRE) {
			if (P(valAux)) {
				if (token == Token.POR) {
					aux = operacion.getValor();
					aux *= valAux.getValor();
					operacion.setValor(aux);
				}
				else {
					aux = operacion.getValor();
					aux /= valAux.getValor();
					operacion.setValor(aux);
				}
				if (Tp(operacion)) {
					return true;
				}
			}
			return false;
		}
		lexico.regresarToken();
		return true;
	}
	
	public Boolean P(Referencia operacion) {
		if (F(operacion)) {
			if (Pp(operacion)) {
				return true;
			}
		}
		return false;
	}
	
	public Boolean Pp(Referencia operacion) {
		Integer token;
		Double aux;
		Referencia valAux = new Referencia(new Double(0));
		token = lexico.getToken();
		if (token == Token.EXP || token == Token.E) {
			if (F(valAux)) {
				if (token == Token.EXP) {
					aux = operacion.getValor();
					aux = Math.pow(aux, valAux.getValor());
					operacion.setValor(aux);
				}
				else {
					aux = operacion.getValor();
					aux = aux * Math.exp(valAux.getValor());
					operacion.setValor(aux);
				}
				if (Pp(operacion)) {
					return true;
				}
			}
			return false;
		}
		lexico.regresarToken();
		return true;
	}
	
	public Boolean F(Referencia operacion) {
		Integer token;
		Double aux;
		token = lexico.getToken();
		if (token == Token.NUMERO) {
			operacion.setValor(Double.valueOf(lexico.getLexema()));
			return true;
		}
		else if ( token == Token.SIN) {
			if (F(operacion)) {
				aux = operacion.getValor();
				aux = Math.sin(aux);
				operacion.setValor(aux);
			}
			else
				return false;
			return true;
		}
		else if ( token == Token.COS) {
			if (F(operacion)) {
				aux = operacion.getValor();
				aux = Math.cos(aux);
				operacion.setValor(aux);
			}
			else
				return false;
			return true;
		}
		else if ( token == Token.TAN) {
			if (F(operacion)) {
				aux = operacion.getValor();
				aux = Math.tan(aux);
				operacion.setValor(aux);
			}
			else
				return false;
			return true;
		}
		else if ( token == Token.LOG) {
			if (F(operacion)) {
				aux = operacion.getValor();
				aux = Math.log10(aux);
				operacion.setValor(aux);
			}
			else
				return false;
			return true;
		}
		else if ( token == Token.LN) {
			if (F(operacion)) {
				aux = operacion.getValor();
				aux = Math.log(aux);
				operacion.setValor(aux);
			}
			else
				return false;
			return true;
		}
		else if ( token == Token.PARENTESIS_IZQUIERDO) {
			if (E(operacion)) {
				token = lexico.getToken();
				if (token == Token.PARENTESIS_DERECHO)
					return true;
				else
					return false;
			}
			return true;
		}
		
		return false;
	}
}

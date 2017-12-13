package mx.ipn.escom.compiladores.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mx.ipn.escom.compiladores.descensosRecursivos.Calcu;
import mx.ipn.escom.compiladores.descensosRecursivos.Referencia;
import mx.ipn.escom.compiladores.lexico.Lexico;
import mx.ipn.escom.compiladores.lexico.Tupla;

/**
 * Servlet implementation class Calcu
 */
public class Calculadora extends HttpServlet{
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Calculadora() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd;
		String operacion;
		Lexico lex1,lex2;
		List<Tupla> tuplas;
		Integer tokenId;
		Double resultado;
		Calcu calculadora;
		Referencia referencia;
		
		operacion = request.getParameter("operacion");
		lex1 = new Lexico(operacion);
		lex2 = new Lexico(operacion);
		
		calculadora = new Calcu(lex2);
		resultado = new Double(0);
		referencia = new Referencia(resultado);
		referencia = calculadora.G(referencia);
		resultado = referencia.getValor();
		
		tuplas = new ArrayList<Tupla>();
		while (lex1.hasMoreString()) {
			tokenId = lex1.getToken();
			tuplas.add(new Tupla(lex1.getLexema(),tokenId));
		}
		request.setAttribute("tabla", tuplas);
		request.setAttribute("resultado", resultado);
		rd = request.getRequestDispatcher("Calculadora.jsp");
		rd.forward(request, response);
	}

}

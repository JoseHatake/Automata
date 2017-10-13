package mx.ipn.escom.compiladores.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mx.ipn.escom.compiladores.AFN.AFN;
import mx.ipn.escom.compiladores.AFN.Simbolo;
import mx.ipn.escom.compiladores.AFN.Transicion;

/**
 * Servlet implementation class Automata
 */
public class Automata extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Automata() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer menu = Integer.parseInt(request.getParameter("menu"));
		HttpSession session = request.getSession();
		RequestDispatcher rd = request.getRequestDispatcher("opcionesAFN.jsp");
		switch (menu) {
		case 1:
			crearAFN(request,session);
			break;
		case 2:
			concatenarAFN(request,session);
			break;
		case 3:
			unirAFN(request,session);
			break;
		case 4:
			cerraduraKleene(request,session);
			break;
		case 5:
			cerraduraPositiva(request,session);
			break;
		case 6:
			opcional(request,session);
			break;
		case 7:
			unionEspecial(request,session);
		default:
			break;
		}
		rd.forward(request, response);
	}

	private void unionEspecial(HttpServletRequest request, HttpSession session) {
		AFN afn,especial;
		Integer opcion = Integer.parseInt(request.getParameter("cualEspecial"));
		Integer token = Integer.parseInt(request.getParameter("token"));
		String afnName;
		switch(opcion) {
			case 1:
				afnName = "afn1";
				break;
			case 2:
				afnName = "afn2";
				break;
			default:
				afnName = "afn3";
				break;
		}
		afn = (AFN) session.getAttribute(afnName);
		especial = (AFN) session.getAttribute("especial");
		afn.getUltimo().setToken(token);
		if (especial == null) {
			especial = new AFN();
			especial.setTransicion(new Transicion(new Simbolo(),afn.getInicial()),false);
			especial.setUltimo(null);
		}
		else {
			especial.setTransicion(new Transicion(new Simbolo(),afn.getInicial()),false);
			especial.setUltimo(null);
		}
		session.removeAttribute(afnName);
		session.setAttribute("especial", especial);
	}

	private void opcional(HttpServletRequest request, HttpSession session) {
		AFN afn;
		Integer opcion = Integer.parseInt(request.getParameter("cualOP"));
		String afnName;
		switch(opcion) {
			case 1:
				afnName = "afn1";
				break;
			case 2:
				afnName = "afn2";
				break;
			default:
				afnName = "afn3";
				break;
		}
		afn = (AFN)session.getAttribute(afnName);
		afn.opcional();
		session.setAttribute(afnName, afn);
	}

	private void cerraduraPositiva(HttpServletRequest request, HttpSession session) {
		AFN afn;
		Integer opcion = Integer.parseInt(request.getParameter("cualP"));
		String afnName;
		switch(opcion) {
			case 1:
				afnName = "afn1";
				break;
			case 2:
				afnName = "afn2";
				break;
			default:
				afnName = "afn3";
				break;
		}
		afn = (AFN)session.getAttribute(afnName);
		afn.cerraduraPositiva();
		session.setAttribute(afnName, afn);
	}

	private void cerraduraKleene(HttpServletRequest request, HttpSession session) {
		AFN afn;
		Integer opcion = Integer.parseInt(request.getParameter("cualK"));
		String afnName;
		switch(opcion) {
			case 1:
				afnName = "afn1";
				break;
			case 2:
				afnName = "afn2";
				break;
			default:
				afnName = "afn3";
				break;
		}
		afn = (AFN)session.getAttribute(afnName);
		afn.cerraduraKleene();
		session.setAttribute(afnName, afn);
	}

	private void unirAFN(HttpServletRequest request, HttpSession session) {
		AFN afn1,afn2;
		Integer union1,union2;
		union1 = Integer.parseInt(request.getParameter("cualUnir1"));
		union2 = Integer.parseInt(request.getParameter("cualUnir2"));
		afn1 = (AFN)session.getAttribute("afn"+union1);
		afn2 = (AFN)session.getAttribute("afn"+union2);
		if (afn2 != null) {
			afn1.unir(afn2);
			session.removeAttribute("afn"+union2);
			session.setAttribute("afn"+union1, afn1);
		}
	}

	private void concatenarAFN(HttpServletRequest request, HttpSession session) {
		AFN afn1,afn2;
		Integer union1,union2;
		union1 = Integer.parseInt(request.getParameter("concatenar1"));
		union2 = Integer.parseInt(request.getParameter("concatenar2"));
		afn1 = (AFN)session.getAttribute("afn"+union1);
		afn2 = (AFN)session.getAttribute("afn"+union2);
		if (afn1 != null && afn2 != null) {
			afn1.concatenar(afn2);
			session.removeAttribute("afn"+union2);
			session.setAttribute("afn"+union1, afn1);
		}
	}

	private void crearAFN(HttpServletRequest request, HttpSession session) {
		AFN afn1,afn2,afn3;
		String simbolo = request.getParameter("simbolo");
		char sim = simbolo.charAt(0);
		if (session.getAttribute("afn1") == null) {
			afn1 = new AFN();
			afn1.setTransicion(new Transicion(new Simbolo(sim)),true);
			session.setAttribute("afn1", afn1);
		}
		else if (session.getAttribute("afn2") == null){
			afn2 = new AFN();
			afn2.setTransicion(new Transicion(new Simbolo(sim)),true);
			session.setAttribute("afn2", afn2);
		}
		else {
			afn3 = new AFN();
			afn3.setTransicion(new Transicion(new Simbolo(sim)),true);
			session.setAttribute("afn3", afn3);
		}
	}
}

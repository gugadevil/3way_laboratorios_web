package saudacaoservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloSevlt
 */
public class HelloSevlt extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public HelloSevlt() {
		// TODO Auto-generated constructor stub
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		// then write the data of the response
		out.println("<html>" + "<head><title>Hello</title></head>");
		// then write the data of the response
		out.println("<body bgcolor=\"#ffffff\">" + "<h2>Olá, meu nome é Servlet. Qual é o seu nome?</h2>"
				+ "<form method=\"get\">" + "<input type=\"text\" name=\"nome\" size=\"25\">" + "<p></p>"
				+ "<input type=\"submit\" value=\"Enviar\">" + "<input type=\"reset\" value=\"Resetar\">" + "</form>");
		String nome = request.getParameter("nome");
		if ((nome != null) && (nome.length() > 0)) {
			out.println("<h2>Olá, " + nome + "! ");
		}
		out.println("</body></html>");
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
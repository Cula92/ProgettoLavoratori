package servlet;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import classes.MyConnection;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String pass = request.getParameter("password");

		// Query SQL
		String sql = "SELECT Username, Pass, tipo, stato FROM Utenti WHERE Username='" + username + "' AND Pass='"
				+ pass + "'";
		HttpSession session = request.getSession();
		session.setAttribute("errorLogin", "no");
		session.setAttribute("errorUtente", "no");
		MyConnection conn = new MyConnection();
		ResultSet rs = conn.getResult(sql);
		System.out.println(sql);

		try {

			if (rs.next()) { // Login eseguito
				String tipo = rs.getString("tipo");
				String stato = rs.getString("stato");

				if (stato == "1") 
				{
					session.setAttribute("Username", username);

					if (tipo == "lavoratore") 
					{
						session.setAttribute("tipo", "lavoratore");
						// System.out.println("Sessione LoginDone: "+session.getAttribute("LoginDone"));
						response.sendRedirect("HomePageLavoratore.jsp");

					} 
					else if (tipo == "azienda") 
					{
						session.setAttribute("tipo", "azienda");
						// System.out.println("Sessione LoginDone: "+session.getAttribute("LoginDone"));
						response.sendRedirect("HomePageAzienda.jsp");
					} 
					else if (tipo == "amministratore") 
					{
						session.setAttribute("tipo", "amministratore");
						// System.out.println("Sessione LoginDone: "+session.getAttribute("LoginDone"));
						response.sendRedirect("HomePageAmministratore.jsp");
					} else {
						// nessun tipo trovato
					}
				}
				else
				{
					session.setAttribute("errorUtente", "si");
					response.sendRedirect("Login.jsp");
				}
			} else {
				// System.out.println("non prende il resultSet");
				session.setAttribute("errorLogin", "si");
				response.sendRedirect("Login.jsp");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

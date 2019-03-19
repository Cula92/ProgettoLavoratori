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

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String pass = request.getParameter("password");
		//System.out.println(username + " pass:" + passAdmin);
		//Query SQL
		String sql = "SELECT Username, Pass, tipo FROM Utenti WHERE Username='" +username+"' AND Pass='"+pass+"'";
		HttpSession session = request.getSession();
		MyConnection conn = new MyConnection();
		ResultSet rs = conn.getResult(sql);
		System.out.println(sql);
		
		try {
			if(rs.next()) { //Login eseguito
				//System.out.println("c'� un result set");
				String tipo = rs.getString("tipo");
				if(tipo == "lavoratore")
				{
					session.setAttribute("tipo", "lavoratore");
					session.setAttribute("LoginDone", username);
					//System.out.println("Sessione LoginDone: "+session.getAttribute("LoginDone"));
					request.getRequestDispatcher("HomepageLavoratore.jsp").forward(request, response);
					
				}
				else if(tipo == "azienda")
				{
					session.setAttribute("tipo", "azienda");
					session.setAttribute("LoginDone", username);
					//System.out.println("Sessione LoginDone: "+session.getAttribute("LoginDone"));
					request.getRequestDispatcher("HomepageAzienda.jsp").forward(request, response);
				}
				else if(tipo == "amministratore")
				{
					session.setAttribute("tipo", "amministratore");
					session.setAttribute("LoginDone", username);
					//System.out.println("Sessione LoginDone: "+session.getAttribute("LoginDone"));
					request.getRequestDispatcher("Homepage.jsp").forward(request, response);
				}
				else
				{
					//nessun tipo trovato
				}
			}
			else {
				//System.out.println("non prende il resultSet");
				session.setAttribute("errorLogin", "si");
				request.getRequestDispatcher("HomeLogin.jsp").forward(request, response);				
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
}

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
		String usernameAdmin = request.getParameter("username");
		String passAdmin = request.getParameter("password");
		System.out.println(usernameAdmin + " pass:" + passAdmin);
		//Query SQL
		String sql = "SELECT Username, Pass FROM Admin WHERE Username='" +usernameAdmin+"' AND Pass='"+passAdmin+"'";
		HttpSession session = request.getSession();
		MyConnection conn = new MyConnection();
		ResultSet rs = conn.getResult(sql);
		System.out.println(sql);
		
		try {
			if(rs.next()) { //Login eseguito
				System.out.println("c'è un result set");
				session.setAttribute("LoginDone", usernameAdmin);
				System.out.println("Sessione LoginDone: "+session.getAttribute("LoginDone"));
				request.getRequestDispatcher("Homepage.jsp").forward(request, response);
			}
			else {
				System.out.println("non prende il resultSet");
				session.setAttribute("errorLogin", "si");
				request.getRequestDispatcher("Login.jsp").forward(request, response);				
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
}

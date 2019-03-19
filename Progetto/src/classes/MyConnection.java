package classes;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MyConnection {

	// Attributi della classe (connessione con database Oracle) 
	static String driver = "oracle.jdbc.OracleDriver";
	static String url = "jdbc:oracle:thin:@//Surface:1521/XE";
	static String username = "corso_java";
	static String password= "admin";
	
	public Connection conn = null;
	public Statement st = null;
	public ResultSet rs = null;
		
	public MyConnection() 
	{		
	}
	
	// apre connessione al DB
	public void openConnection()
	{
		try 
		{
			Class.forName(driver); // lancia una ClassNotFoundException
			conn = DriverManager.getConnection(url, username, password);
			st = conn.createStatement();
		} 
		catch (ClassNotFoundException e) 
		{
			System.out.println ("Error: unable to load driver class!");
			e.printStackTrace();
		}
		catch (SQLException e) 
		{
			System.out.println ("Error: connection error!");
			e.printStackTrace();
		}
	}
	
	// esegue la query passata come parametro e restituisce il ResultSet con il risultato
	public ResultSet getResult(String sql)
	{
		// apre connessione al DB
		openConnection();
		
		// ResultSet è un'interfaccia
		try 
		{
			rs = st.executeQuery(sql);	
		} 
		catch (SQLException e) 
		{				
			System.out.println ("Error: resultset error!");
			e.printStackTrace();
		} 
		
		// chiude connessione al DB
		//closeConnection();
		
		return rs;
	}
	
	// chiude la connessione al DB e tutti gli oggetti collegati (ResultSet e Statement)
	public void closeConnection()
	{
		// Chiusura oggetti connessione
		// gli oggetti vanno chiusi correttamente nell'ordine inverso a quello di apertura.
		try 
		{
			rs.close();
			st.close();
			conn.close();
		} 
		catch (SQLException e) 
		{
			System.out.println ("Error: close connection objects error!");
			e.printStackTrace();
		} 
	}
	
}
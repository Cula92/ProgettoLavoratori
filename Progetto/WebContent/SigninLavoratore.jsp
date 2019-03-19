<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Sign in</title>
</head>
<body>
<!-- Sign In Form -->
    <p>Registrazione Lavoratore</p>
    
  
  	<form id="frmSignin" name="frmSignin" method="post" action="SigninServlet">            
      <p> Email  <input type="text" id="email" name="email" placeholder="Email"></p>
      <br>
      <p> Password  <input type="password1" id="password1" name="password1" placeholder="Password"></p>
      <br>
      <p> Conferma password  <input type="password2" id="password2" name="password2" placeholder="ConfermaPassword"></p>
      <br>
      <p> Nome  <input type="text" id="nome" name="nome" placeholder="Nome"></p>
      <br>
      <p> Cognome  <input type="text" id="cognome" name="cognome" placeholder="Cognome"></p>
      <br>
      <p> Nazione  <input type="text" id="nazione" name="nazione" placeholder="Nazione"></p>
      <br>
      <p> Città  <input type="text" id="citta" name="citta" placeholder="Città"></p>
      <br>
      <p> Grado di istruzione  <input type="text" id="grado_istr " name="grado_istr " placeholder="GradoIstruzione"></p>
      <br>
  
      <input type="submit" style="margin:20px 20px 20px 20px;" value="Registrati">
    </form>
	    

</body>
</html>
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
    
    <c:if test="${errorPassword eq 'si'}">
    <b style="color:red;"> Errore: Password diverse</b>
    <br>
    </c:if>
    
  
  	<form id="frmSignin" name="frmSignin" method="post" action="SigninAziendaServlet">            
      <p> Email  <input type="text" id="email" name="email" placeholder="Email"></p>
      <br>
      <p> Password  <input type="password1" id="password1" name="password1" placeholder="Password"></p>
      <br>
      <p> Conferma password  <input type="password2" id="password2" name="password2" placeholder="ConfermaPassword"></p>
      <br>
      <p> Nome Azienda <input type="text" id="nomeAz" name="nomeAz" placeholder="NomeAzienda"></p>
      <br>
      <p> Nazione  <input type="text" id="nazioneAz" name="nazioneAz" placeholder="Nazione"></p>
      <br>
      <p> Città  <input type="text" id="cittaAz" name="cittaAz" placeholder="Città"></p>
      <br>

  
      <input type="submit" style="margin:20px 20px 20px 20px;" value="Registrati">
    </form>
	    

</body>
</html>
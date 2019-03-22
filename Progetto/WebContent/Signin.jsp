
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
    <p>Registrazione</p>
    <!-- Sign In Form -->
    
    <form name="inputHome" method="get">
		<br><br>
		<input type="button" value="Lavoratore" onclick="window.location.href='SigninLavoratore.jsp'">
		<input type="button" value="Azienda" onclick="window.location.href='SigninAzienda.jsp'">
	</form>
    
	    

</body>
</html>
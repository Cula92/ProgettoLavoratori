<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<sql:setDataSource driver="oracle.jdbc.OracleDriver"
		url="jdbc:oracle:thin:@localhost:1521:orclcdb" user="C##corso_java"
		password="oracle" />

	<sql:query var="result">
	 SELECT * FROM annunci
	 </sql:query>

	<form id="formLavoratore" name="formLavoratore">

		<select name="categorie">
		
			<c:forEach items="${result.rows}" var="row">
				<option><c:out value="${row.titolo}" /></option>
			</c:forEach>

		</select>

	</form>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  		<title>Dodaj film do wypożyczonych</title>
    	<style>
		table, th, td {
   	 		border: 1px solid black;
		}
     	</style>
	</head>
	<body>
		<a href="<c:url value="list"/>">Powrót do listy filmów</a><br>
       <table style=1>
 	 		<tr>
    			<th>#</th>
    			<th>Tytuł</th>
  			</tr>
				<c:forEach items="${movies}" var="movie" varStatus="status">
				<tr>
					<td>${status.index+1}</td>
					<td><a href="<c:url value="/mark-${status.index+1}"/>">${movie.title}</a></td>
				</tr>	
				</c:forEach>
		</table>
		<br>
		<hr>
	</body>
</html>

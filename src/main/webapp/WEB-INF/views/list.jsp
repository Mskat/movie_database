<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Lista filmów</title>
</head>
<body>
<a href="<c:url value="add" />">Dodaj film</a><br />
<a href="<c:url value="mark"/>">Dodaj film do wypożyczonych</a><br>
<a href="<c:url value="unmark"/>">Usuń film z wypożyczonych</a><br>

<table border="1">
    <thead>
    <tr>
        <th>#</th>
        <th>Tytuł</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${movies}" var="movie" varStatus="status">
        <tr>
            <td>${status.index+1}</td>
            <td><a href="<c:url value="movie-${status.index+1}" />">${movie.title}</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<br />
<hr />
</body>
</html>
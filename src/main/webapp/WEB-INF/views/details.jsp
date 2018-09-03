<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Szczegóły filmu</title>
</head>
<body>
<a href="list">Powrót do listy filmów</a><br />
<table border="1">
    <tbody>
    <tr>
        <th>Tytuł</th>
        <td><center>${movie.title}</center></td>
    </tr>
    <tr>
        <th>Autor</th>
        <td><center>${movie.author}</center></td>
    </tr>
    <tr>
        <th>Rok wydania</th>
        <td><center>${movie.year}</center></td>
    </tbody>
</table>
<br />
<hr />
</body>
</html>
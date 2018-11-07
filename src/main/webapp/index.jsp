<%@ page import="java.util.List" %>
<%@ page import="jdbc.JdbcFullName" %>
<%@ page import="connection.ConnectionDB" %><%--
  Created by IntelliJ IDEA.
  User: Andrey
  Date: 06.11.2018
  Time: 14:04
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/xml" prefix="x" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>FullName DataTable:</title>
</head>
<style>
    table, th, td {
        border: 1px solid black;
        border-collapse: collapse;
    }
    th, td {
        padding: 5px;
        text-align: center;
    }
    </style>
<body>
<h3 style="text-align: left">Таблица ФИО</h3>
<table>
    <tr>
        <th>№</th>
        <th>Фамилия</th>
        <th>Имя</th>
        <th>Очество</th>
    </tr>
<c:forEach var="item" items="${listName}">
        <tr>
            <td>${item.id}</td>
            <td>${item.lastName}</td>
            <td>${item.firstName}</td>
            <td>${item.middleName}</td>
        </tr>
</c:forEach>
</table>


</body>
</html>

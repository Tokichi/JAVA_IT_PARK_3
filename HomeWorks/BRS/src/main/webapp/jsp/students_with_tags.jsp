<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Студенты</title>
    <link href="/css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
<h1>${hello}</h1>
<table>
    <tr>
        <th>Id</th>
        <th>Имя</th>
        <th>Фамилия</th>
        <th>Отчество</th>
        <th>Логин</th>
        <th>Пароль</th>
        <th>Почта</th>
    </tr>
    <c:forEach items="${students}" var="student">
        <tr>
            <td>${student.id}</td>
            <td>${student.name}</td>
            <td>${student.surname}</td>
            <td>${student.patronymic}</td>
            <td>${student.login}</td>
            <td>${student.password}</td>
            <td>${student.email}</td>
        </tr>
    </c:forEach>
</table>
<form action="/students_as_jsp" method="post">
    <input type="text" name="name" placeholder="Имя">
    <input type="text" name="surname" placeholder="Фамилия">
    <input type="text" name="patronymic" placeholder="Отчество">
    <input type="text" name="login" placeholder="Логин">
    <input type="text" name="password" placeholder="Пароль">
    <input type="text" name="email" placeholder="Почта">
    <input type="submit">
</form>
</body>
</html>
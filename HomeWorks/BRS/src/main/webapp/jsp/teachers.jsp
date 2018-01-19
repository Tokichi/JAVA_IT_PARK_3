<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Преподаватели</title>
    <link href="/css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
<h1>Список преподавателей</h1>
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
    <c:forEach items="${teachers}" var="teacher">
        <tr>
            <td>${teacher.id}</td>
            <td>${teacher.name}</td>
            <td>${teacher.surname}</td>
            <td>${teacher.patronymic}</td>
            <td>${teacher.login}</td>
            <td>${teacher.password}</td>
            <td>${teacher.email}</td>
        </tr>
    </c:forEach>
</table>
<h1>Добавление нового преподавателя</h1>
<form action="/teachers" method="post">
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
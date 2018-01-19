<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Группы</title>
    <link href="/css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
<h1>Список групп</h1>
<table>
    <tr>
        <th>Id</th>
        <th>Номер группы</th>
    </tr>
    <c:forEach items="${groups}" var="group">
        <tr>
            <td>${group.id}</td>
            <td>${group.name}</td>
        </tr>
    </c:forEach>
</table>
<h1>Добавление новой группы</h1>
<form action="/groups" method="post">
    <input type="text" name="name" placeholder="Номер группы">
    <input type="submit">
</form>
</body>
</html>
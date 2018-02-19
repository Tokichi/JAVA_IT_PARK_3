<#ftl encoding='UTF-8'>
<#import 'spring.ftl' as spring>
<@spring.bind "model"/>
<html>
<head>
    <title>Список преподавателей</title>
    <link rel="stylesheet" href="/css/style.css">
</head>
<body>
<#include 'common/header.ftl'/>
<ul class="menu-main">
    <li><a href="/addTeacher">Добавить нового преподавателя</a></li>
</ul>
<div align="center">
    <h1>Список преподавателей</h1>
    <table class="table_blur">
        <tr>
            <th>Имя</th>
            <th>Фамилия</th>
            <th>Отчество</th>
            <th>Почта</th>
            <th>Редактировать</th>
            <th>Удалить</th>
        </tr>
<#list model.users as user>
    <tr>
        <td>${user.name}</td>
        <td>${user.surname}</td>
        <td>${user.patronymic}</td>
        <td>${user.email}</td>
        <td>
            <div align="center">
                <form method="GET" action="/teachers/${user.id}">
                    <input type="hidden" name="teacher" value=""/>
                    <input type="submit" value="Редактировать"/>
                </form>
            </div>
        </td>
        <td>
            <div align="center">
                <form method="GET" action="/teachers/delete/${user.id}">
                    <input type="hidden" name="teacher" value=""/>
                    <input type="submit" value="Удалить"/>
                </form>
            </div>
        </td>
    </tr>
</#list>
    </table>
</div>
</body>
</html>
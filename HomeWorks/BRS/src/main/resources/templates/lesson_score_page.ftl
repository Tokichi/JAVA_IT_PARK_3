<#ftl encoding='UTF-8'>
<#import 'spring.ftl' as spring>
<@spring.bind "model"/>
<html>
<head>
    <title>Список студентов группы </title>
    <link rel="stylesheet" href="/css/style.css">
</head>
<body>
<#include 'common/header.ftl'/>
<div align="center">
    <h1>Список студентов</h1>
    <form method="post" action="/addScore">
    <table class="table_blur">
        <tr>
            <th>Судент</th>
            <th>Оценка</th>
        </tr>
    <#list model.users as user>
        <tr>
            <td>${user.surname} ${user.name} ${user.patronymic}</td>
            <td><input type="text" name="score"></td>
        </tr>
    </#list>
    </table>
        <input type="submit">
    </form>
</div>
</body>
</html>
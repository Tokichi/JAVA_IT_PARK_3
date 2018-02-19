<#ftl encoding='UTF-8'>
<#import 'spring.ftl' as spring>
<@spring.bind "model"/>
<html>
<head>
    <title>Добавление курса</title>
    <link rel="stylesheet" href="/css/style.css">
</head>
<body>
<#include 'common/header.ftl'/>
<br>
<br>
<div align="center">
    <h1> Добавление курса</h1>
    <br>
</div>
<div align="center">
    <b>
    </form>
    <form method="post" action="/addCourse">
        <br>
        <text>Выберите группу</text>
        <br>
        <select name="group">
        <#list model.groups as group>
            <option value="${group.id}">${group.name}</option>
        </#list>
        </select>
        <br>
        <br>
        <text>Выберите дисциплину</text>
        <br>
        <select name="discipline">
        <#list model.disciplines as discipline>
            <option value="${discipline.id}">${discipline.name}</option>
        </#list>
        </select>
        <br>
        <br>
        <text>Выберите преподавателя</text>
        <br>
        <select name="user">
        <#list model.users as user>
            <option value="${user.id}">${user.surname} ${user.name} ${user.patronymic}</option>
        </#list>
        </select>
        <br>
        <br>
        <input type="submit">
    </form>
        </b>
</div>
</body>
</html>
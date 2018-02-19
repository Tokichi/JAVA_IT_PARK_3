<#ftl encoding='UTF-8'>
<#import 'spring.ftl' as spring>
<@spring.bind "model"/>
<html>
<head>
    <title>Добавление студента</title>
    <link rel="stylesheet" href="/css/style.css">
</head>
<body>
<#include 'common/header.ftl'/>
<br>
<br>
<div align="center">
    <h1> Добавление студента</h1>
    <br>
</div>
<div align="center">
    <b>
        </form>
        <form method="post" action="/addStudent">
            <br>
            <input type="text" name="formName" placeholder="Имя">
            <br>
            <br>
            <input type="text" name="surname" placeholder="Фамилия">
            <br>
            <br>
            <input type="text" name="patronymic" placeholder="Отчество">
            <br>
            <br>
            <input type="text" name="email" placeholder="EMAIL">
            <br>
            <br>
            <input type="password" name="password" placeholder="Пароль">
            <br>
            <br>
            <text>Выберите группу</text>
            <select name="group">
            <#list model.groups as group>
                <option value="${group.id}">${group.name}</option>
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
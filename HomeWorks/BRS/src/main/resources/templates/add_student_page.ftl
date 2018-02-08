<#ftl encoding='UTF-8'>
<#import 'spring.ftl' as spring>
<@spring.bind "model"/>
<html>
<head>
    <title>Добавление нового студента</title>
    <link rel="stylesheet" href="/css/style.css">
</head>
<body>
<#include 'common/header.ftl'/>
<div>
    <input type="text" id="name" name="name" value="${model.user.name}"/>
    <input type="text" id="surname" name="surname" value="${model.user.surname}"/>
    <button onclick="sendNewNameOrSurName(
        document.getElementById('name').value,
        document.getElementById('surname').value)">Отправить</button>
</div>
</body>
</html>
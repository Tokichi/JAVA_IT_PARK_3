<#ftl encoding='UTF-8'>
<#import 'spring.ftl' as spring>
<@spring.bind "model"/>
<html>
<head>
    <title>Просмотр группы</title>
</head>
<body>
<#include 'common/header.ftl'/>
<div align="center">
    <b>
        <br>
        <h1>Редактирование группы</h1>
        <br>
        <br>
    <form method="post" action="/groups/${model.group.id}">
        <br>
        <text>ИМЯ ГРУППЫ</text>
        <br>
        <input type="text" name="name" value="${model.group.name}">
        <br>
        <br>
        <input type="submit">
    </form>
        </b>
</div>
</body>
</html>
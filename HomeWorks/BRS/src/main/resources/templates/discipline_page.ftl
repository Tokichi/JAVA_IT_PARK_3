<#ftl encoding='UTF-8'>
<#import 'spring.ftl' as spring>
<@spring.bind "model"/>
<html>
<head>
    <title>Просмотр дисциплины</title>
</head>
<body>
<#include 'common/header.ftl'/>
<div align="center">
    <b>
    <br>
    <h1>Редактирование дисциплины</h1>
    <br>
    <br>
    <form method="post" action="/disciplines/${model.discipline.id}">
        <br>
        <text>НАЗВАНИЕ ДИСЦИПЛИНЫ</text>
        <input type="text" name="name" value="${model.discipline.name}">
        <br>
        <br>
        <input type="submit">
    </form>
        </b>
</div>
</body>
</html>
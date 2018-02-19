<#ftl encoding='UTF-8'>
<#import 'spring.ftl' as spring>
<@spring.bind "model"/>
<html>
<head>
    <title>Добавление дисциплины</title>
    <link rel="stylesheet" href="/css/style.css">
</head>
<body>
<#include 'common/header.ftl'/>
<br>
<br>
<div align="center">
    <h1>    Добавление дисциплины</h1>
    <br>
</div>
<div align="center">
    <form method="post" action="/addDiscipline">
        <br>
        <input type="text" name="name" placeholder="Имя">
        <br>
        <br>
        <input type="submit">
    </form>
</div>
</body>
</html>
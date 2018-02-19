<#ftl encoding='UTF-8'>
<#import 'spring.ftl' as spring>
<@spring.bind "model"/>
<!doctype html>
<html lang="en">
<head>
    <title>Главная страница</title>
</head>
<body>
<#include 'common/header.ftl'/>
<div align="center">
    <h1 style="color:#ff0000">Вы не заполнили все необходимые поля формы!</h1>
    <br>
    <input type="button" value="Назад" onclick="javascript:window.location='/addStudent'"/>
</div>
</body>
</html>

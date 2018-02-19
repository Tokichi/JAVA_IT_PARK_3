<#ftl encoding='UTF-8'>
<#import 'spring.ftl' as spring>
<@spring.bind "model"/>
<html>
<head>
    <title>Просмотр пользователя</title>
</head>
<body>
<#include 'common/header.ftl'/>
<div align="center">
    <b>
        <br>
        <h1>Редактирование студента</h1>
        <br>
        <br>
        <form method="post" action="/students/${model.user.id}">
            <br>
            <text>ИМЯ</text>
            <br>
            <input type="text" name="name" value="${model.user.name}">
            <br>
            <br>
            <text>ФАМИЛИЯ</text>
            <br>
            <input type="text" name="surname" value="${model.user.surname}">
            <br>
            <br>
            <text>ОТЧЕСТВО</text>
            <br>
            <input type="text" name="patronymic" value="${model.user.patronymic}">
            <br>
            <br>
            <text>EMAIL</text>
            <br>
            <input type="text" name="email" value="${model.user.email}">
            <br>
            <br>
            <text>ПАРОЛЬ</text>
            <br>
            <input type="password" name="hashPassword" value="">
            <br>
            <br>
            <input type="submit">
        </form>
    </b>
</div>
</body>
</html>
<#ftl encoding='UTF-8'>
<#import 'spring.ftl' as spring>
<@spring.bind "model"/>
<html>
<head>
    <title>BRS - Вход</title>
    <link rel="stylesheet" href="/css/style.css">
</head>
<body>
<#if model.error == true>
<h1>Неверно введено имя пользователя или пароль</h1>
</#if>

<div align="center">
    <img src="/images/BRS_logo.png">
    <br>
    <br>
    <br>
    <br>
    <b>
    <h1>АВТОРИЗАЦИЯ</h1>
<form class="form-style-4" title="Регистрация"
      name="registrationForm"
      method="post"
      action="/login">
    <br>
    <br>
    <text>ВВЕДИТЕ ЛОГИН ИЛИ EMAIL:</text>
    <br>
    <input type="text" name="email" placeholder="EMAIL"/>
    <br>
    <br>
    <text>ВВЕДИТЕ ПАРОЛЬ:</text>
    <br>
    <input type="password" name="password" placeholder="Пароль"/>
    <br>
    <br>
    <input type="checkbox" name="remember-me">Запомнить
    <br>
    <br>
    <input type="submit">
</form>
    </b>
</div>
</body>
</html>
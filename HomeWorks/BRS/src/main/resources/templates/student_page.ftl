<#ftl encoding='UTF-8'>
<#import 'spring.ftl' as spring>
<@spring.bind "model"/>
<html>
<head>
    <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <title>Просмотр пользователя</title>
</head>
<body>
<#include 'common/header.ftl'/>
<script>
    <#--Функция принимает на вход два параметра - имя и фамилию -->
    function sendNewNameOrSurName(name, surname, patronymic, email) {
        // Оотправляем ajax-запорс на сервер
        $.ajax({
            type: "POST",
            url: "/students/${model.user.id}",
            data: {
                "name": name,
                "surname": surname,
                "patronymic": patronymic,
                "email": email
            },
            error: function (data) {
                alert(data.status)
            },
            success: function (data) {
                alert("Wow!" + data.status)
            }
        });
    }
</script>
<div align="center">
    <input type="text" id="name" name="name" value="${model.user.name}"/>
    <input type="text" id="surname" name="surname" value="${model.user.surname}"/>
    <input type="text" id="patronymic" name="patronymic" value="${model.user.patronymic}"/>
    <input type="text" id="email" name="email" value="${model.user.email}"/>
    <button onclick="sendNewNameOrSurName(
        document.getElementById('name').value,
        document.getElementById('surname').value),
        document.getElementById('patronymic').value),
        document.getElementById('email').value)">Отправить
    </button>
</div>
</body>
</html>
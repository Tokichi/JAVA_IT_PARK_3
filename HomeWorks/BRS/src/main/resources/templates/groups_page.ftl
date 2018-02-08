<#ftl encoding='UTF-8'>
<#import 'spring.ftl' as spring>
<@spring.bind "model"/>
<html>
<head>
    <title>Список групп</title>
    <link rel="stylesheet" href="/css/style.css">
</head>
<body>
<#include 'common/header.ftl'/>
<ul class="menu-main">
    <li><a href="">Добавить новую группу</a></li>
</ul>
<div align="center">
    <h1>Список групп</h1>
    <table>
        <tr>
            <th>Имя группы</th>
        </tr>
<#list model.users as user>
    <tr>
        <td>${user.name}</td>
        <td>${user.surname}</td>
        <td>${user.patronymic}</td>
        <td>${user.email}</td>
        <td>
            <div align="center">
                <form method="POST" action="/groups">
                    <input type="hidden" name="product_id" value="<?php echo $row->product_id; ?>"/>
                    <input type="submit" value="Редактировать"/>
                </form>
            </div>
        </td>
    </tr>
</#list>
    </table>
</div>
</body>
</html>
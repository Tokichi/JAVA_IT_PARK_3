<#ftl encoding='UTF-8'>
<#import 'spring.ftl' as spring>
<@spring.bind "model"/>
<html>
<head>
    <title>Список студентов</title>
    <link rel="stylesheet" href="/css/style.css">
</head>
<body>
<#include 'common/header.ftl'/>
<ul class="menu-main">
    <li><a href="/addGroup">Добавить новую группу</a></li>
</ul>
<div align="center">
    <h1>Список групп</h1>
    <table class="table_blur">
        <tr>
            <th>Имя</th>
            <th>Редактировать</th>
            <th>Удалить</th>
        </tr>
<#list model.groups as group>
    <tr>
        <td>${group.name}</td>
        <td>
            <div align="center">
                <form method="GET" action="/groups/${group.id}">
                    <input type="hidden" name="group" value=""/>
                    <input type="submit" value="Редактировать"/>
                </form>
            </div>
        </td>
        <td>
            <div align="center">
                <form method="GET" action="/groups/delete/${group.id}">
                    <input type="hidden" name="group" value=""/>
                    <input type="submit" value="Удалить"/>
                </form>
            </div>
        </td>
    </tr>
</#list>
    </table>
</div>
</body>
</html>
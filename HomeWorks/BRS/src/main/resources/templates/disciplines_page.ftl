<#ftl encoding='UTF-8'>
<#import 'spring.ftl' as spring>
<@spring.bind "model"/>
<html>
<head>
    <title>Список дисциплин</title>
    <link rel="stylesheet" href="/css/style.css">
</head>
<body>
<#include 'common/header.ftl'/>
<ul class="menu-main">
    <li><a href="/addDiscipline">Добавить новую дисциплину</a></li>
</ul>
<div align="center">
    <h1>Список дисциплин</h1>
    <table class="table_blur">
        <tr>
            <th>Название</th>
            <th>Редактировать</th>
            <th>Удалить</th>
        </tr>
    <#list model.discipline as discipline>
        <tr>
            <td>${discipline.name}</td>
            <td>
                <div align="center">
                    <form method="GET" action="/disciplines/${discipline.id}">
                        <input type="hidden" name="discipline" value=""/>
                        <input type="submit" value="Редактировать"/>
                    </form>
                </div>
            </td>
            <td>
                <div align="center">
                    <form method="GET" action="/disciplines/delete/${discipline.id}">
                        <input type="hidden" name="discipline" value=""/>
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
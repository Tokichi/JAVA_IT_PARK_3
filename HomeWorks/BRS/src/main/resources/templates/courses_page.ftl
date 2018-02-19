<#ftl encoding='UTF-8'>
<#import 'spring.ftl' as spring>
<@spring.bind "model"/>
<html>
<head>
    <title>Список курсов</title>
    <link rel="stylesheet" href="/css/style.css">
</head>
<body>
<#include 'common/header.ftl'/>
<ul class="menu-main">
    <li><a href="/addCourse">Добавить новый курс</a></li>
</ul>
<div align="center">
    <h1>Список курсов</h1>
    <table class="table_blur">
        <tr>
            <th>Группа</th>
            <th>Дисциплина</th>
            <th>Преподаватель</th>
            <th>Редактировать</th>
            <th>Удалить</th>
        </tr>
    <#list model.courses as course>
        <tr>
            <td>${course.groupName}</td>
            <td>${course.disciplineName}</td>
            <td>${course.teacherName}</td>
            <td>
                <div align="center">
                    <form method="GET" action="/courses/${course.id}">
                        <input type="hidden" name="course" value=""/>
                        <input type="submit" value="Редактировать"/>
                    </form>
                </div>
            </td>
            <td>
                <div align="center">
                    <form method="GET" action="/courses/delete/${course.id}">
                        <input type="hidden" name="course" value=""/>
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
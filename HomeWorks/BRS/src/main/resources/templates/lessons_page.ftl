<#ftl encoding='UTF-8'>
<#import 'spring.ftl' as spring>
<@spring.bind "model"/>
<html>
<head>
    <title>Список занятий</title>
    <link rel="stylesheet" href="/css/style.css">
</head>
<body>
<#include 'common/header.ftl'/>
<ul class="menu-main">
    <li><a href="/addLesson">Добавить новое занятие</a></li>
</ul>
<div align="center">
    <h1>Список занятий</h1>
    <table class="table_blur">
        <tr>
            <th>Дата занятия</th>
            <th>Время занятия</th>
            <th>Курс</th>
            <th>Выставить оценки</th>
            <th>Удалить</th>
        </tr>
    <#list model.lessons as lesson>
        <tr>
            <td>${lesson.lessonDay}</td>
            <td>${lesson.lessonTime}</td>
            <td>${lesson.nameCourse}</td>
            <td>
                <div align="center">
                    <form method="GET" action="/lessonScore/${lesson.id}">
                        <input type="hidden" name="lesson" value=""/>
                        <input type="submit" value="Выставить оценки"/>
                    </form>
                </div>
            </td>
            <td>
                <div align="center">
                    <form method="GET" action="/lessons/delete/${lesson.id}">
                        <input type="hidden" name="lesson" value=""/>
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
<link rel="stylesheet" href="/css/style.css">
<div align="center">
    <img src="/images/BRS_logo.png">
</div>
<#if model.currentUser??>
<div>
    <b>
    <text>Вы вошли как</text>
    ${model.currentUser.name}
    ${model.currentUser.surname}
</div>
<#else>
<div>
    <a href="/login">Войти</a>
</div>
</#if>
<a href="/logout">Выход</a>
</b>
<ul class="menu-main">
    <li><a href="/students">Студенты</a></li>
    <li><a href="/teachers">Преподаватели</a></li>
    <li><a href="/groups">Группы</a></li>
    <li><a href="/disciplines">Дисциплины</a></li>
    <li><a href="/courses">Курсы</a></li>
    <li><a href="/lessons">Занятия</a></li>
</ul>
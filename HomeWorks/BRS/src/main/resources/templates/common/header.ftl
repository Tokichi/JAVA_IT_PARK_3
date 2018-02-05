<link rel="stylesheet" href="/css/style.css">
<div align="center">
<h1>Балльно-рейтинговая система какого-то учебного заведения</h1>
</div>
<#if model.user??>
<div>
    ${model.user.id}
    <br>
    ${model.user.name}
</div>
<#else>
<div>
    <a href="/login">Войти</a>
</div>
</#if>
<a href="/logout">Выход</a>
<ul class="menu-main">
    <li><a href="/students">Студенты</a></li>
    <li><a href="">Преподаватели</a></li>
    <li><a href="">Дисциплины</a></li>
    <li><a href="">Занятия</a></li>
</ul>
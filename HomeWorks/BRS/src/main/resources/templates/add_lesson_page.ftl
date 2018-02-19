<#ftl encoding='UTF-8'>
<#import 'spring.ftl' as spring>
<@spring.bind "model"/>
<html>
<head>
    <title>Добавление занятия</title>
    <link rel="stylesheet" href="/css/style.css">
</head>
<body>
<#include 'common/header.ftl'/>
<br>
<br>
<div align="center">
    <h1> Добавление занятия</h1>
    <br>
</div>
<div align="center">
    <b>
    </form>
    <form method="post" action="/addLesson">
        <br>
        <br>
        <text>Год</text>
        <select name="year">
            <option value="2017">2017</option>
            <option value="2018">2018</option>
            <option value="2019">2019</option>
            <option value="2020">2020</option>
            <option value="2021">2021</option>
            <option value="2022">2022</option>
        </select>
        <text>Месяц</text>
        <select name="month">
            <option value="01">Январь</option>
            <option value="02">Фвраль</option>
            <option value="03">Март</option>
            <option value="04">Апрель</option>
            <option value="05">Май</option>
            <option value="06">Июнь</option>
            <option value="07">Июль</option>
            <option value="08">Август</option>
            <option value="09">Сентябрь</option>
            <option value="10">Октябрь</option>
            <option value="11">Ноябрь</option>
            <option value="12">Декабрь</option>
        </select>
        <text>День</text>
        <select name="day">
            <option value="01">1</option>
            <option value="02">2</option>
            <option value="03">3</option>
            <option value="04">4</option>
            <option value="05">5</option>
            <option value="06">6</option>
            <option value="07">7</option>
            <option value="08">8</option>
            <option value="09">9</option>
            <option value="10">10</option>
            <option value="11">11</option>
            <option value="12">12</option>
            <option value="13">13</option>
            <option value="14">14</option>
            <option value="15">15</option>
            <option value="16">16</option>
            <option value="17">17</option>
            <option value="18">18</option>
            <option value="19">19</option>
            <option value="20">20</option>
            <option value="21">21</option>
            <option value="22">22</option>
            <option value="23">23</option>
            <option value="24">24</option>
            <option value="25">26</option>
            <option value="27">28</option>
            <option value="28">29</option>
            <option value="30">30</option>
            <option value="31">31</option>
        </select>
        <br>
        <br>
        <text>Время начала и конца анятия</text>
        <select name="time">
            <option value="08:00 - 09:30">08:00 - 09:30</option>
            <option value="09:45 - 11:15">09:45 - 11:15</option>
            <option value="12:00 - 13:30">12:00 - 13:30</option>
            <option value="13:45 - 15:15">13:45 - 15:15</option>
            <option value="15:30 - 17:00">15:30 - 17:00</option>
            <option value="17:15 - 18:45">17:15 - 18:45</option>
        </select>
        <br>
        <br>
        <text>Выберите курс</text>
        <select name="course">
        <#list model.courses as course>
            <option value="${course.id}">${course.courseName}</option>
        </#list>
        </select>
        <br>
        <br>
        <input type="submit">
    </form>
        </b>
</div>
</body>
</html>

<!DOCTYPE html>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <@title></@title>
    <style>
        .lgn {
            position: absolute;
            top: 35%;
            left: 50%;
            margin-right: -50%;
            transform: translate(-50%, -50%)
        }
    </style>
</head>
<body>

<nav class="navbar navbar-expand-lg navbar-light bg-light navbar-expand-sm">
    <ul class="navbar-nav mr-auto">
        <li class="nav-item mr-auto">
            <a class="nav-link" href="/homepage">Главная</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="#">Скидки</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="/aboutaspage">О нас</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="#">Отзывы</a>
        </li>
    </ul>
    <#if user?has_content>
        <ul class="navbar-nav ml-auto">
            <li class="nav-item">
                <a href="/profilepage" class="nav-link "><strong>${user.username}</strong></a>
            </li>
        </ul>
        <ul class="navbar-nav">
            <li class="nav-item">
                <a href="/homeworkpage" class="nav-link ">Домашка</a>
            </li>
        </ul>
    <#else>
        <ul class="navbar-nav ml-auto">
            <li class="nav-item">
                <a href="/login" class="nav-link "><strong>Войти</strong></a>
            </li>
        </ul>
    </#if>

</nav>

<@content></@content>

</body>
</html>
<!DOCTYPE html>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <script src="https://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.5.1.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/jquery-validation@1.19.3/dist/jquery.validate.js"></script>

    <script>
        $(document).ready(function () {
            $("#loginForm").validate({
                rules: {
                    username: {
                        required: true,
                        minlength: 4,
                        maxlength: 16,
                    },

                    password: {
                        required: true,
                        minlength: 4,
                        maxlength: 16,
                    },
                },
                messages: {
                    username: {
                        required: "Обязательно для ввода",
                        minlength: "Должно быть больше 4 символов",
                        maxlength: "Должно быть меньше 16 символов",
                    },

                    password: {
                        required: "Обязательно для ввода",
                        minlength: "Должно быть больше 4 символов",
                        maxlength: "Должно быть меньше 16 символов",
                    },
                },
            });
        });
    </script>
    <script>
        $(document).ready(function () {
            $("#regForm").validate({
                rules: {
                    first_name: {
                        required: true,
                        minlength: 2,
                        maxlength: 16,
                    },

                    last_name: {
                        required: true,
                        minlength: 2,
                        maxlength: 16,
                    },
                    username: {
                        required: true,
                        minlength: 4,
                        maxlength: 16,
                    },

                    password: {
                        required: true,
                        minlength: 4,
                        maxlength: 16,
                    },
                },
                messages: {
                    first_name: {
                        required: "Обязательно для ввода",
                        minlength: "Должно быть больше 2 символов",
                        maxlength: "Должно быть меньше 16 символов",
                    },

                    last_name: {
                        required: "Обязательно для ввода",
                        minlength: "Должно быть больше 2 символов",
                        maxlength: "Должно быть меньше 16 символов",
                    },

                    username: {
                        required: "Обязательно для ввода",
                        minlength: "Должно быть больше 4 символов",
                        maxlength: "Должно быть меньше 16 символов",
                    },

                    password: {
                        required: "Обязательно для ввода",
                        minlength: "Должно быть больше 4 символов",
                        maxlength: "Должно быть меньше 16 символов",
                    },
                },
            });
        });
    </script>
    <@title></@title>
    <style>
        .lgn {
            position: absolute;
            top: 100px;
            left: 600px;
        }

        .btn {
            padding: 10px 105px;
        }

        .regbtn {
            padding: 10px 55px;
        }

        .error {
            color: red;
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
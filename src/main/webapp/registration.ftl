<#include 'base.ftl'>
<#macro title>
    <title>Страница регистрации</title>
</#macro>
<#macro content>
    <form method="post" action="/reg" id="regForm">
        <div class="lgn">
            <h1>Регистрация</h1>
            <p class="lead">
                <label>
                    <input type="text" name="first_name" placeholder="Имя">
                </label>
            </p>
            <p class="lead">
                <label>
                    <input type="text" name="last_name" placeholder="Фамилия">
                </label>
            </p>
            <p class="lead">
                <label>
                    <input type="text" name="username" placeholder="Логин">
                </label>
            </p>
            <p class="lead">
                <label>
                    <input type="password" name="password" placeholder="Пароль">
                </label>
            </p>
            <p class="lead">
                <button type="submit" class=" btn regbtn btn-outline-dark btn-sm">Зарегистрироваться</button>
            </p>
            <p class="lead">
                <a href="/login">У меня есть аккаунт</a>
            </p>
        </div>
    </form>
</#macro>

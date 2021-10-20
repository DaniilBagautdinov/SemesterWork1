<#include 'base.ftl'>
<#macro title>
    <title>Страница входа</title>
</#macro>
<#macro content>
    <div class="lgn">
        <h1>Авторизация</h1>
        <form method="post" action="/login">
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
                <label>
                    <input type="checkbox" value="check"> Запомнить меня?
                </label>
            </p>
            <p class="lead">
                <button
                        type="submit" class="btn">Войти
                </button>
            </p>
            <p class="lead">
                <a
                        href="/reg">Зарегистрироваться
                </a>
            </p>
        </form>
    </div>
</#macro>

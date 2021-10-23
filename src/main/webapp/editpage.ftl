<#include 'base.ftl'>

<#macro title>
    <title>Страница изменения данных о пользователе</title>
</#macro>

<#macro content>
    <div class="position-absolute">
        <h1>Изменение данных</h1>
        <form method="post" action="/editpage">
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
                    <input type="password" name="password" placeholder="Пароль">
                </label>
            </p>
            <p class="lead">
                <button type="submit" class="btn btn-outline-dark btn-sm btn-block">Сохранить</button>
            </p>
        </form>
    </div>
</#macro>
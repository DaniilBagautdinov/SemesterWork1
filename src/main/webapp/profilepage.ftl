<#include 'base.ftl'>
<#macro title>
    <title>Страница пользователя</title>
</#macro>

<#macro content>
    <div class="position-absolute">
        <h1>Профиль пользователя</h1>
        <p class="lead">
            Имя: ${user.firstName}
        </p>
        <p class="lead">
            Фамилия: ${user.lastName}
        </p>
        <p class="lead">
            Логин: ${user.username}
        </p>
        <p class="lead">
            <a href="/editpage" class="btn btn-outline-dark btn-sm btn-block">Изменить профиль</a>
        </p>
    </div>
</#macro>
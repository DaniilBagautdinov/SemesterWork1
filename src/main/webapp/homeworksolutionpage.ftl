<#include 'base.ftl'>

<#macro title>
    <title>Страница решения домашки</title>
</#macro>

<#macro content>
    <#if homeworkNow?has_content>
        <h1>${homeworkNow.title}</h1>
        <h4>${homeworkNow.article}</h4>
        <p class="lead">
            <a
                    href="/homeworkpage">Вернуться назад
            </a>
        </p>
    </#if>
</#macro>
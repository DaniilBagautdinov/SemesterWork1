<#include 'base.ftl'>

<#macro title>
    <title>Страница урока</title>
</#macro>

<#macro content>
    <#if lessonNow?has_content>
        <h1>${lessonNow.title}</h1>
        <h4>${lessonNow.article}</h4>
        <p class="lead">
            <a
                    href="${lessonNow.link}">Ссылка на урок
            </a>
        </p>
    </#if>
</#macro>
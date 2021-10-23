<#include 'base.ftl'>

<#macro title>
    <title>Страница домашней работы</title>
</#macro>

<#macro content>
    <h1>Домашки</h1>
    <div class="card-columns m-md-auto w-auto ">
        <#if homeworks??>
            <#if homeworks?has_content>
                <#list homeworks as homework>
                    <div class="card w-auto">
                        <div class="card-body ">
                            <h5 class="card-title">${homework.title}</h5>
                            <a href="/homeworksolutionpage?id=${homework.id}" class="btn btn-dark">Посмотреть</a>
                        </div>
                    </div>
                </#list>
            </#if>
        </#if>

    </div>

</#macro>
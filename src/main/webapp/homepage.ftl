<#include 'base.ftl'>

<#macro title>
    <title>Главная страница</title>
</#macro>

<#macro content>
    <div class="carousel-inner w-100 m-auto ml-2 mr-2">
        <div class="carousel-item active">
            <img class="d-block w-100 rounded" src="images/homePageImages/ЕГЭKarlan.png" alt="Баннер"
                 data-holder-rendered="true">
        </div>
    </div>

    <div class="card-columns m-md-auto w-100">
        <#if lessons??>
            <#if lessons?has_content>
                <#list lessons as lesson>
                    <div class="card w-auto ">
                        <img class="card-img-top m-auto" src="/images/homePageImages/${lesson.photoTitle}" alt="Кейс 1">
                        <div class="card-body">
                            <h5 class="card-title">${lesson.title}</h5>
                            <p class="card-text">${lesson.description}</p>
                            <#if user?has_content>
                                <a href="/lessonpage?id=${lesson.id}" class="btn btn-dark">Посмотреть</a>
                            <#else>
                                <a href="/warningpage" class="btn btn-dark">Посмотреть</a>
                            </#if>
                        </div>
                    </div>
                </#list>
            </#if>
        </#if>
    </div>
</#macro>

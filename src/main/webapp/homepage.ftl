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
        <div class="card w-auto ">
            <img class="card-img-top m-auto" src="/images/homePageImages/Dol.jpg" alt="Кейс 1">
            <div class="card-body">
                <h5 class="card-title">ЕГЭ - русский язык</h5>
                <p class="card-text">Александр Долгих - научит вас писать и разговаривать</p>
                <h5 class="card-title">1000р</h5>
                <a href="/gamepage?id=1" class="btn btn-dark">Купить</a>
            </div>
        </div>
        <div class="card w-auto">
            <img class="card-img-top m-auto" src="/images/homePageImages/Shar.jpg" alt="Кейс 1">
            <div class="card-body">
                <h5 class="card-title">ЕГЭ - математика</h5>
                <p class="card-text">Артур Шарафиев - жесткий математик</p>
                <h5 class="card-title">1000р</h5>
                <a href="/gamepage?id=1" class="btn btn-dark">Купить</a>
            </div>
        </div>

        <div class="card">
            <img class="card-img-top m-auto" src="/images/homePageImages/Lan.jpg" alt="Кейс 2">
            <div class="card-body">
                <h5 class="card-title">ЕГЭ - информатика</h5>
                <p class="card-text">Виктория Ланская - изи инфа</p>
                <h5 class="card-title">1000р</h5>
                <a href="/gamepage?id=2" class="btn btn-dark">Купить</a>
            </div>
        </div>
    </div>
</#macro>

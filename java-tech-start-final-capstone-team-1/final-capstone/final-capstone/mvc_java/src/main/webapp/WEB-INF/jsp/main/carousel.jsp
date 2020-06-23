<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<section id="main-page-carousel">
    <div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
        <ol class="carousel-indicators">
            <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
            <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
            <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
        </ol>
        <div class="carousel-inner">
            <div class="carousel-item active">
                <img class="d-block w-100"
                     src="https://upload.wikimedia.org/wikipedia/commons/e/e9/Soy-whey-protein-diet.jpg"
                     alt="First slide">
            </div>
            <div class="carousel-item">
                <img class="d-block w-100"
                     src="https://upload.wikimedia.org/wikipedia/commons/1/1f/Creamy_roasted_sprouts_and_pasta_%288200316502%29.jpg"
                     alt="Second slide">
            </div>
            <div class="carousel-item">
                <img class="d-block w-100" src="https://upload.wikimedia.org/wikipedia/commons/0/0d/Keto_meal.jpg"
                     alt="Third slide">

            </div>
        </div>


        <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
            <span class="sr-only">Previous</span>
        </a>
        <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
            <span class="carousel-control-next-icon" aria-hidden="true"></span>
            <span class="sr-only">Next</span>
        </a>
    </div>
</section>
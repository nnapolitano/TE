<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<c:import url="/WEB-INF/jsp/main/header.jsp">
    <c:param name="pageTitle" value="Product Details"/>
</c:import>

<div class="container">


    <div class="row justify-content-center">

        <div class="col-xl-10 col-lg-12 col-md-9">

            <div class="card o-hidden border-0 shadow-lg my-5">
                <div class="card-body p-0">

                    <section>

                        <title>The Meal Planner - Home</title>

                        <!-- Page Content -->


                        <h1 class="my-4">Save Time. Save Money. Eat Healthy.</h1>

                        <c:import url="/WEB-INF/jsp/main/carousel.jsp"/>


                        <br>

                        <!-- Marketing Icons Section -->
                        <div class="row">
                            <div class="col-lg-4 mb-4">
                                <div class="card h-100">
                                    <h4 class="card-header">What's a Vegetarian?</h4>
                                    <a href="https://en.wikipedia.org/wiki/Vegetarianism"><img class="card-img-top"
                                                                                               src="https://upload.wikimedia.org/wikipedia/commons/e/e9/Soy-whey-protein-diet.jpg"
                                                                                               alt="Vegetarian image"></a>
                                    <div class="card-body">
                                        <p class="card-text"></p>
                                    </div>
                                    <div class="card-footer">
                                        <a href="https://en.wikipedia.org/wiki/Vegetarianism" class="btn btn-primary">Learn
                                            More</a>
                                    </div>
                                </div>
                            </div>
                            <div class="col-lg-4 mb-4">
                                <div class="card h-100">
                                    <h4 class="card-header">What's a Vegan Diet?</h4>
                                    <a href="https://en.wikipedia.org/wiki/Veganism"><img class="card-img-top"
                                                                                          src="https://upload.wikimedia.org/wikipedia/commons/1/1f/Creamy_roasted_sprouts_and_pasta_%288200316502%29.jpg"
                                                                                          alt="Vegan image"></a>
                                    <div class="card-body">
                                        <p class="card-text"></p>
                                    </div>
                                    <div class="card-footer">
                                        <a href="https://en.wikipedia.org/wiki/Veganism" class="btn btn-primary">Learn
                                            More</a>
                                    </div>
                                </div>
                            </div>
                            <div class="col-lg-4 mb-4">
                                <div class="card h-100">
                                    <h4 class="card-header">What's a Keto Diet?</h4>
                                    <a href="https://en.wikipedia.org/wiki/Ketogenic_diet"><img class="card-img-top"
                                                                                                src="https://upload.wikimedia.org/wikipedia/commons/0/0d/Keto_meal.jpg"
                                                                                                alt="keto image"></a>
                                    <div class="card-body">
                                        <p class="card-text"></p>
                                    </div>
                                    <div class="card-footer">
                                        <a href="https://en.wikipedia.org/wiki/Ketogenic_diet" class="btn btn-primary">Learn
                                            More</a>
                                    </div>
                                </div>

                            </div>
                            <!-- /.row -->

                            <!-- link Section -->

                            <h1 class="my-4">\ Food Groups</h1>

                            <div class="row">
                                <div class="col-lg-4 col-sm-6 link-item">
                                    <div class="card h-100">
                                        <a href="https://en.wikipedia.org/wiki/Vegetable"><img class="card-img-top"
                                                                                               src="https://upload.wikimedia.org/wikipedia/commons/2/24/Marketvegetables.jpg"
                                                                                               alt="Vegetable picture"></a>
                                        <div class="card-body">
                                            <h4 class="card-title">
                                                <a href="https://en.wikipedia.org/wiki/Vegetable">Veggies are good for
                                                    you!</a>
                                            </h4>
                                            <p class="card-text">Learn More Today!</p>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-lg-4 col-sm-6 link-item">
                                    <div class="card h-100">
                                        <a href="https://en.wikipedia.org/wiki/Fruit"><img class="card-img-top"
                                                                                           src="https://upload.wikimedia.org/wikipedia/commons/2/2f/Culinary_fruits_front_view.jpg"
                                                                                           alt="fruit picture"></a>
                                        <div class="card-body">
                                            <h4 class="card-title">
                                                <a href="https://en.wikipedia.org/wiki/Fruit">Fruits are a great way to
                                                    enjoy a sweet treat!</a>
                                            </h4>
                                            <p class="card-text">Learn More Today!</p>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-lg-4 col-sm-6 link-item">
                                    <div class="card h-100">
                                        <a href="https://en.wikipedia.org/wiki/Bread"><img class="card-img-top"
                                                                                           src="https://upload.wikimedia.org/wikipedia/commons/c/c7/Korb_mit_Br%C3%B6tchen.JPG"
                                                                                           alt="Bread Picture"></a>
                                        <div class="card-body">
                                            <h4 class="card-title">
                                                <a href="https://en.wikipedia.org/wiki/Bread">Although yummy, breads
                                                    should not be a significant part of your diet</a>
                                            </h4>
                                            <p class="card-text">Learn More</p>
                                        </div>
                                    </div>
                                </div>

                               <div class="col-lg-4 col-sm-6 link-item">
                                    <div class="card h-100">
                                        <a href="https://en.wikipedia.org/wiki/Coffee"><img class="card-img-top"
                                                                                            src="https://upload.wikimedia.org/wikipedia/commons/4/45/A_small_cup_of_coffee.JPG"
                                                                                            alt="coffee picture"></a>
                                        <div class="card-body">
                                            <h4 class="card-title">
                                                <a href="https://en.wikipedia.org/wiki/Coffee">Plain black coffee is
                                                    naturally very low in calories!</a>
                                            </h4>
                                            <p class="card-text">And it helps you wake up!</p>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-lg-4 col-sm-6 link-item">
                                    <div class="card h-100">
                                        <a href="https://en.wikipedia.org/wiki/Doughnut"><img class="card-img-top"
                                                                                              src="https://upload.wikimedia.org/wikipedia/commons/5/5d/Jack%27s_Donuts.jpg"
                                                                                              alt=""></a>
                                        <div class="card-body">
                                            <h4 class="card-title">
                                                <a href="https://en.wikipedia.org/wiki/Doughnut">Doughnuts should not be
                                                    your breakfast</a>
                                            </h4>
                                            <p class="card-text">Ever wonder why?</p>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-lg-4 col-sm-6 link-item">
                                    <div class="card h-100">
                                        <a href="https://en.wikipedia.org/wiki/Pizza"><img class="card-img-top"
                                                                                           src="https://upload.wikimedia.org/wikipedia/commons/9/91/Pizza-3007395.jpg"
                                                                                           alt="Pizza Picture"></a>
                                        <div class="card-body">
                                            <h4 class="card-title">
                                                <a href="https://en.wikipedia.org/wiki/Pizza">Pizza can be made any way
                                                    you like!</a>
                                            </h4>
                                            <p class="card-text">Just go easy on the cheese and bread!</p>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <br>
                    </section>
                </div>
            </div>
        </div>
    </div>
</div>


<c:import url="/WEB-INF/jsp/main/footer.jsp"/>
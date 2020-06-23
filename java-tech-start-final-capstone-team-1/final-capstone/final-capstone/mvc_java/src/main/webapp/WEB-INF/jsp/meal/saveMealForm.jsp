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


                        ${RecipeType}


                        <html>
                        <head>
                            <title>Add a Meal</title>
                        </head>
                        <div class="container">

                            <h1> Create a New Meal Here!</h1>
                            <body>


                            <script type="text/javascript">
                                $(document).ready(function () {

                                    $("form").validate({

                                        rules: {
                                            mealTypeId: {
                                                required: true
                                            },
                                            mealTitle: {
                                                required: true
                                            },
                                            ingredients: {
                                                required: true
                                            },
                                            prepTime: {
                                                required: true
                                            },
                                            cookTime: {
                                                required: true
                                            },
                                            instructions: {
                                                required: true
                                            }


                                        },
                                        messages: {
                                            password: {
                                                minlength: "Password too short, make it at least 15 characters",
                                                capitals: "Field must contain a capital letter",
                                            },
                                            confirmPassword: {
                                                equalTo: "Passwords do not match"
                                            }
                                        },
                                        errorClass: "error"
                                    });
                                });
                            </script>

                            <c:url var="formAction" value="/saveMeal"/>
                            <form method="POST" action="${formAction}">
                                <input type="hidden" name="CSRF_TOKEN" value="${CSRF_TOKEN}"/>
                                <br>
                                <div style="text-align: center;">Select the Meal Plan you would like to add your meal:
                                    <br>
                                    <select id="mealPlanId" name="mealPlanId">
                                        <option value="0">Select a Meal Plan</option>
                                        <c:forEach items="${mealPlans}" var="mealPlan">
                                            <option value="${mealPlan.mealPlanId}">${mealPlan.mealPlanDescription}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                                <br>
                                <div class="row">
                                    <div class="col-sm-4"></div>
                                    <div class="col-sm-4">
                                        <div class="form-group">
                                            <div class="form-group">
                                                <label for="MealName"> Enter Meal Name: </label>
                                                <input type="text" id="MealName" name="MealName" placeHolder="MealName"
                                                       class="form-control"/>
                                            </div>
                                            <div class="form-group">
                                                <label for="mealDescription">Enter a Description: </label>
                                                <input type="text" id="mealDescription" name="mealDescription"
                                                       placeHolder="mealDescription"
                                                       class="form-control"/>
                                            </div>

                                            <button type="submit" class="btn btn-primary">Save Meal</button>
                                            <input type="reset" class="btn btn-primary">
                                        </div>
                                        <div class="col-sm-4"></div>
                                    </div>
                                </div>
                            </form>


                            </body>

                        </div>

                        <script type="text/javascript">
                            $(document).ready(function () {
                                $('#sendMailBtn').click(function () {
                                    $.ajax({
                                        type: "post",
                                        url: "/path",
                                        data: "mealTypeId=" + $('#mealTypeId').val() + "&mealTitle=" + $('#mealTitle').val() + "&ingredients=" + $('#ingredients').val() + "&prepTime=" + $('#prepTime').val() + "&cookTime=" + $('#cookTime').val() + "&instructions=" + $('#instructions').val(),
                                        success: function (msg) {
                                            //
                                        }
                                    });
                                })})


                        </script>

                        </html>
                    </section>
                </div>
            </div>
        </div>
    </div>
</div>

<c:import url="/WEB-INF/jsp/main/footer.jsp"/>
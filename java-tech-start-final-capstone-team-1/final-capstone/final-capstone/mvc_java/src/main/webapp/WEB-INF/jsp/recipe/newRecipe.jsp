<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="/WEB-INF/jsp/main/header.jsp"/>
<%@ page import="com.techelevator.model.RecipeType" language="java" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

${RecipeType}


<head>
    <title>Add A Recipe</title>

    <script type="text/javascript">
        function validate() {

            $("form").validate({

                rules: {
                    recipeType: {
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
                errorClass: "error"
            });
        }

    </script>
</head>

<body>
<div class="container">


    <div class="row justify-content-center">

        <div class="col-xl-10 col-lg-12 col-md-9">

            <div class="card o-hidden border-0 shadow-lg my-5">
                <div class="card-body p-0">


                    <section>

                        <h1> Create a New Recipe Here!</h1>

                        <c:url var="formAction" value="/newRecipe"/>
                        <form method="POST" action="${formAction}">
                            <div class="row">
                                <div class="col-sm-4">
                                    <div class="form-group">
                                        <label for="recipeType">Recipe Types: </label>

                                        <c:set var="enumValues"
                                               value="<%=RecipeType.values()%>"/>

                                        <table>

                                            <tr>
                                                <th>Recipe Type:</th>
                                                <th></th>
                                            </tr>

                                            <c:forEach var="enumValue" items="${enumValues}">
                                                <tr>
                                                    <td><input type="checkbox" id="recipeType" name="recipeType"
                                                               value="${enumValue}" class="form-control"/></td>
                                                    <td><label for="recipeType">${enumValue.description}</label></td>
                                                </tr>
                                            </c:forEach>

                                        </table>

                                    </div>
                                    <div class="form-group">
                                        <label for="mealTitle">Title: </label>
                                        <input type="text" id="mealTitle" name="mealTitle" placeHolder="Title"
                                               class="form-control"/>
                                    </div>
                                    <div class="form-group">
                                        <input type="hidden" name="recipeId" value="${recipeId}"/>

                                        <label for="ingredients">Ingredients: </label>
                                        <input type="text" id="ingredients" name="ingredients"
                                               placeHolder="Select Ingredients"
                                               class="form-control"/>
                                    </div>
                                    <div class="form-group">
                                        <label for="prepTime"> Prep Time: </label>
                                        <input type="number" min=0 step=1 id="prepTime" name="prepTime"
                                               placeHolder="Prep Time:"
                                               class="form-control"/>
                                    </div>
                                    <div class="form-group">
                                        <label for="cookTime"> Cook Time: </label>
                                        <input type="number" min=0 step=1 id="cookTime" name="cookTime"
                                               placeHolder="Cook Time:"
                                               class="form-control"/>
                                    </div>
                                    <div class="form-group">
                                        <label for="instructions">Instructions: </label>
                                        <input type="text" id="instructions" name="instructions"
                                               placeHolder="instructions"
                                               class="form-control"/>
                                    </div>

                                    <button type="submit" class="btn btn-primary">Create Recipe</button>
                                    <input type="reset" class="btn btn-primary">
                                </div>

                            </div>
                        </form>


                    </section>
                </div>
            </div>
        </div>
    </div>
</div>


</body>
<script type="text/javascript">
    $(document).ready(function () {
        $('#sendMailBtn').click(function () {
            $.ajax({
                type: "post",
                url: "/newRecipe",
                data: "recipeType=" + $('#recipeType').val() + "&mealTitle=" + $('#mealTitle').val() + "&ingredients=" + $('#ingredients').val() + "&prepTime=" + $('#prepTime').val() + "&cookTime=" + $('#cookTime').val() + "&instructions=" + $('#instructions').val(),
                success: function (msg) {
                }
            });
        })
    });


</script>


<c:import url="/WEB-INF/jsp/main/footer.jsp"/>
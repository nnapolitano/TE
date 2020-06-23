<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:import url="/WEB-INF/jsp/main/header.jsp">
    <c:param name="pageTitle" value="Product Details"/>
</c:import>

<!-- Begin Page Content -->
<div class="container">

    <!-- Outer Row -->
    <div class="row justify-content-center">

        <div class="col-xl-10 col-lg-12 col-md-9">

            <div class="card o-hidden border-0 shadow-lg my-5">
                <div class="card-body p-0">

                    <section>

                        <!-- DataTales Example -->
                        <div class="card shadow mb-4">
                            <div class="card-header py-3">
                                <h6 class="m-0 font-weight-bold text-primary">All Recipes</h6>
                            </div>
                            <div class="card-body">
                                <div class="table-responsive">
                                    <table class="table table-bordered" id="dataTable" width="95%" cellspacing="0">
                                        <p id="recipe-text">

                                            <thead>
                                            <tr>
                                                <th>Name</th>
                                                <th>Ingredients</th>
                                                <th>Prep Time</th>
                                                <th>Cook Time</th>
                                                <th>Instructions</th>
                                                <th></th>
                                            </tr>
                                            </thead>

                                            <tfoot>
                                            <tr>
                                                <th>Name</th>
                                                <th>Ingredients</th>
                                                <th>Prep Time</th>
                                                <th>Cook Time</th>
                                                <th>Instructions</th>
                                                <th></th>
                                            </tr>
                                            </tfoot>
                                            <tbody>
                                            <c:forEach items="${recipes}" var="recipeMod">

                                                <tr>

                                                    <td><c:out value="${recipeMod.mealTitle}"/></td>
                                                    <td>
                                                        <ul>
                                                            <c:forEach items="${recipeMod.ingredients}"
                                                                       var="ingredients">
                                                                <li><c:out value="${ingredients}"/></li>
                                                            </c:forEach>
                                                        </ul>
                                                    </td>
                                                    <td><c:out value="${recipeMod.prepTime}  ${' Minutes'}"/></td>
                                                    <td><c:out value="${recipeMod.cookTime}  ${' Minutes'}"/></td>
                                                    <td>
                                                        <ol>
                                                            <c:forEach items="${recipeMod.instructions}"
                                                                       var="instructions">
                                                                <li><c:out value="${instructions}"/></li>
                                                            </c:forEach>
                                                        </ol>
                                                    </td>

                                                    <td>

                                                        <form action="modifyRecipe" method="GET" name="recipeId"
                                                              id="recipeId">
                                                            <button type="Submit" form="recipeId" name="recipeId"
                                                                    value="${recipeMod.recipeId}"/>
                                                            EDIT
                                                        </form>

<%--                                                        <form action="addRecipeToMeal" method="GET" name="recipeId"--%>
<%--                                                              id="recipeToMealId">--%>
<%--                                                            <button type="Submit" form="recipeToMealId" name="recipeId"--%>
<%--                                                                    value="${recipeMod.recipeId}"/>--%>
<%--                                                            Add To Meal--%>
<%--                                                        </form>--%>
                                                    </td>
                                                </tr>


                                            </c:forEach>

                                            </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>

                    </section>
                </div>
            </div>
        </div>
    </div>
</div>


<!-- Page level plugins -->
<script src="https://code.jquery.com/jquery-3.3.1.js"></script>
<script src="https://cdn.datatables.net/1.10.20/js/jquery.dataTables.min.js"></script>
<script src="/js/basictable.js"></script>

<c:import url="/WEB-INF/jsp/main/footer.jsp"/>
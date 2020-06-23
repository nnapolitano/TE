<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
                                <h6 class="m-0 font-weight-bold text-primary">All Meals</h6>
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
                                            <c:forEach items="${meals}" var="meals">

                                                <tr>

                                                    <td><c:out value="${meals.mealDescription}"/></td>


                                                    <td>

                                                            <%--                                                        <form action="modifyMeal" method="GET" name="mealId" id="mealId">--%>
                                                            <%--                                                            <button type="Submit" form="mealId" name="mealId"--%>
                                                            <%--                                                                    value="${meal.mealId}"/>EDIT</form>--%>

                                                        <form action="addMealToMealPlan" method="GET" name="mealId"
                                                              id="mealToMealPlanId">
                                                            <button type="Submit" form="mealToMealPlanId" name="mealId"
                                                                    value="${meal.mealId}"/>
                                                            Add To Meal Plan
                                                        </form>

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
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<c:import url="/WEB-INF/jsp/main/header.jsp"/>


<div class="container">


    <div class="row justify-content-center">

        <div class="col-xl-10 col-lg-12 col-md-9">

            <div class="card o-hidden border-0 shadow-lg my-5">
                <div class="card-body p-0">

                    <section>

                        <div class="main-box">
                            <h2>Create a Meal Plan</h2>
                            <p class="lead">Please use the form below to create a new meal
                                plan. You can always update your plan</p>

                            <c:url value="/newMealPlan" var="formAction"/>
                            <form id="mealPlanForm" method="POST" action="${formAction}">
                                <div>
                                    <%--<div>
                                        <label for="userId">User Id:</label><br>
                                        <input type="text" id="userId"
                                               name="userId" placeholder="user Id"/>
                                            <div>--%>
                                    <label for="mealPlanDescription">Meal Plan Description:</label><br>
                                    <input type="text" id="mealPlanDescription"
                                           name="mealPlanDescription" placeholder="Meal Plan Description"/>
                                </div>
                                <div>
                                    <label for="date">Date:</label><br>
                                    <input type="text" id="date"
                                           name="date" placeholder="Date"/>
                                </div>


                                <button style="" id="submitMealPlan" class="btn btn-primary">Submit</button>
                            </form>

                    </section>
                </div>
            </div>
        </div>
    </div>
</div>


<c:import url="/WEB-INF/jsp/main/footer.jsp"/>
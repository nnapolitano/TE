<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<%--           Drop down menus --%>
<button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse"
        data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false"
        aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
</button>
<div class="collapse navbar-collapse" id="navbarResponsive">
    <ul class="navbar-nav ml-auto">


        <%--                   recipes drop down --%>

        <li class="nav-item dropdown">
            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownlink" data-toggle="dropdown"
               aria-haspopup="true" aria-expanded="false">
                Recipes
            </a>
            <div class="dropdown-menu dropdown-menu-right" aria-labelledby="navbarDropdownlink">
                <a class="dropdown-item" href="newRecipe">New Recipe</a>
                <a class="dropdown-item" href="viewRecipe">View All Recipes</a>
                <a class="dropdown-item" href="viewUserRecipes">View My Recipes</a>
            </div>
        </li>

        <%--                    Meals Drop Down--%>

        <li class="nav-item dropdown">
            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownlink" data-toggle="dropdown"
               aria-haspopup="true" aria-expanded="false">
                Meals
            </a>
            <div class="dropdown-menu dropdown-menu-right" aria-labelledby="navbarDropdownlink">
                <a class="dropdown-item" href="saveMeal">New Meal</a>
                <a class="dropdown-item" href="viewAllMealsFromHome">View All Meals</a>
                <a class="dropdown-item" href="viewUserMeals">View My Meals</a>
            </div>
        </li>


        <%--                    Meal Plan Drop Down--%>

        <li class="nav-item dropdown">
            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownlink" data-toggle="dropdown"
               aria-haspopup="true" aria-expanded="false">
                Meal Plan
            </a>
            <div class="dropdown-menu dropdown-menu-right" aria-labelledby="navbarDropdownlink">
                <a class="dropdown-item" href="newMealPlan">New Meal Plan</a>
                <a class="dropdown-item" href="viewAllPlans">View All Meal Plans</a>
                <a class="dropdown-item" href="viewMyMealPlans">View My Meal Plans</a>

            </div>
        </li>


        <!-- Nav Item - User Information -->
        <li class="nav-item dropdown">

            <!-- Dropdown - User Information -->

            <a class="nav-link dropdown-toggle" href="#" id="userDropdown" role="button"
               data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                <span>      Welcome, <c:out value="${theUser.getGetUserName()}"/></span>
            </a>
            <div class="dropdown-menu dropdown-menu-right shadow animated--grow-in"
                 aria-labelledby="userDropdown">


                <a class="dropdown-item" href="groceryList">Grocery List</a>
                <a class="dropdown-item" href="#" data-toggle="modal" data-target="#logoutModal">
                    Logout
                </a>
                <br/>
                Logged in

            </div>

        </li>


    </ul>
</div>
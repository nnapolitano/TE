<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>

<html>
<head>
    <meta name="viewport" content="width=device-width" />
    <title>Recipe List View</title>
    <link rel="stylesheet" href="css/site.css" />
</head>
<body>
    <header>
        <h1>MVC Exercises - Views Part 2: Models</h1>        
    </header>
    <nav>
        <ul>
            <li><a href="recipeTiles">Tile Layout</a></li>
            <li><a href="recipeTable">Table Layout</a></li>
        </ul>
        
    </nav>
    <section id="main-content">
       <!-- Use the request attribute "recipes" (List<Recipe>) -->
        <div class="tile  ">
            <!-- Link to the Detail page using the product id (e.g. products/detail?id=1) -->
            <a class="recipeTiles" href="#">
                <a class="recipeTable" href="#">
                    <img src="<c:url value="/img/recipe0.jpg" />" />
                </a>
            </a>
            <div class="details">
                <p class="name">
                    <a href="#">Grey Sofa</a>
                </p>

                <!-- .filled will make the star solid -->
                <div class="rating">
                    <span class="filled">&#9734;</span>
                    <span>&#9734;</span>
                    <span>&#9734;</span>
                    <span>&#9734;</span>
                    <span>&#9734;</span>
                </div>

                <p class="price">$939.00</p>
            </div>
        </div>







        <table>
            <tr>Name</tr>
            <tr>Type</tr>
            <tr>Cook Time</tr>
            <tr>Rating</tr>

            <c:forEach var="recipe" items="${recipeTiles}">
                <tr>
                    <td>${recipe.getName}</td>
                    <td>${recipe.getRecipeType}</td>
                    <td>${recipe.getCookTimeInMinutes}</td>
                    <td>${recipe.adult}</td>
                </tr>
            </c:forEach>
        </table>

    </section>
</body>
</html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:import url="/WEB-INF/jsp/main/header.jsp">
    <c:param name="pageTitle" value="Modify Recipe"/>
</c:import>

<!-- Begin Page Content -->
<div class="container">

    <!-- Outer Row -->
    <div class="row justify-content-center">

        <div class="col-xl-10 col-lg-12 col-md-9">

            <%--            <select id="rec" name="recipes">--%>
            <%--                <c:forEach items="${recipes}" var="recipe">--%>
            <%--                    <option value=${recipe.recipeId}>${recipe.mealTitle}</option>--%>
            <%--                </c:forEach>--%>
            <%--            </select>--%>
            <form target="modifyRecipe" method="POST">
                <div class="card mb-4">
                    <div class="card-header">
                        Recipe
                    </div>
                    <div class="card-body p-0">

                        <section>

                            <p id="recipe-text">
                                <p1><c:out value="${'Title:'} ${recipe.mealTitle}"/><br></p1>
                            <ul>
                                <%-- Output ingredients list to a textbox for editing --%>
                                <p1><c:out value="${'Ingredients:'} "/><br></p1>
                                <textarea id="ingredients" name="ingredients" rows="4" cols="50"><c:out
                                        value="${ingredients}"/></textarea>
                            </ul>
                            <p3><c:out value="${'Prep Time: '} ${recipe.prepTime}"/><br></p3>
                            <p4><c:out value="${'Cook Time: '} ${recipe.cookTime}"/><br></p4>
                            <ol>
                                <%-- Output instructions list to a textbox for editing --%>
                                <p1><c:out value="${'Instructions:'} "/><br></p1>
                                <textarea id="instructions" name="instructions" rows="4" cols="50"><c:out
                                        value="${instructions}"/></textarea>
                            </ol>

                        </section>

                    </div>
                    <input type="hidden" id="recipeId" name="recipeId" value="${recipe.recipeId}">
                    <input type="submit" value="Modify Recipe">
                </div>
            </form>
        </div>
    </div>
</div>

<c:import url="/WEB-INF/jsp/main/footer.jsp"/>
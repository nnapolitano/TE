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
                        <!-- DO NOT CHANGE ANYTHING ABOVE THIS LINE-->


                        <c:forEach items="${recipes}" var="recipeMod">


                            <p id="recipe-text">
                                <p1><c:out value="${'Title:'} ${recipeMod.mealTitle}"/><br></p1>
                            <ol>
                                <p1><c:out value="${'Ingredients:'} "/><br></p1>
                                <c:forEach items="${recipeMod.ingredients}" var="ingredients">
                                    <li><c:out value="${ingredients}"/><br></li>
                                </c:forEach>
                            </ol>
                            <p3><c:out value="${'Prep Time:'}${recipeMod.prepTime}"/><br></p3>
                            <p4><c:out value="${'Cook Time:'} ${recipeMod.cookTime}"/><br></p4>
                            <ol>
                                <p1><c:out value="${'Instructions:'} "/><br></p1>
                                <c:forEach items="${recipeMod.instructions}" var="instructions">
                                    <li><c:out value="${instructions}"/><br></li>
                                </c:forEach>
                            </ol>

                        </c:forEach>

                        <!-- DO NOT CHANGE ANYTHING BELOW THIS LINE-->
                    </section>
                </div>
            </div>
        </div>
    </div>
</div>
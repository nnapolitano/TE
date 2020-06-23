<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<c:import url="/WEB-INF/jsp/main/header.jsp">
    <c:param name="pageTitle" value="Grocery List"/>
</c:import>

<div class="container">


    <div class="row justify-content-center">

        <div class="col-xl-10 col-lg-12 col-md-9">

            <div class="card o-hidden border-0 shadow-lg my-5">
                <div class="card-body p-0">

                    <section>

                        <div class="main-box">
                            <h2>My Grocery List</h2>

                            <div class="row">
                                <div class="col-sm-4"></div>
                                <div class="col-sm-4">
                                    <div class="form-group">


                                        <div class="table-responsive">
                                            <table class="table table-bordered" id="dataTable" width="95%"
                                                   cellspacing="0">
                                                <p id="recipe-text">


                                                    <c:choose>
                                                    <c:when test="${groceries != null}">
                                                    <thead>
                                                    <tr>
                                                        <th>Groceries Needed:</th>
                                                    </tr>
                                                    </thead>

                                                    </c:when>
                                                    <c:otherwise>
                                                    <thead>
                                                    <tr>
                                                        <th>Hmmm.. looks like you dont have any mealplans with
                                                            ingredients.
                                                        </th>
                                                    </tr>
                                                    </thead>
                                                    </c:otherwise>

                                                    </c:choose>

                                                    <tbody>


                                                    <c:forEach items="${groceries}" var="groceries">
                                                        <tr>
                                                            <td><c:out value="${groceries}"/></td>
                                                        </tr>
                                                    </c:forEach>

                                                    </tbody>
                                            </table>
                                        </div>


                                    </div>

                                </div>
                            </div>
                        </div>


                    </section>
                </div>
            </div>
        </div>
    </div>
</div>

<c:import url="/WEB-INF/jsp/main/footer.jsp"/>
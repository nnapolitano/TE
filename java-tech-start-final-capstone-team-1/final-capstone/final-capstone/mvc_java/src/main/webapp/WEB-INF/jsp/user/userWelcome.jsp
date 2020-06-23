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


                        hello ${userName}

                        <!-- DO NOT CHANGE ANYTHING BELOW THIS LINE-->
                    </section>
                </div>
            </div>
        </div>
    </div>
</div>

<c:import url="/WEB-INF/jsp/main/footer.jsp"/>
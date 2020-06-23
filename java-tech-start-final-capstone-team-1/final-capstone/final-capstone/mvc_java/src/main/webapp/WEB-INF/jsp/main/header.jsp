<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="Team Capstone Columbus Tech Start">


    <!-- Custom fonts for this template-->
    <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css"/>
    <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
          rel="stylesheet">

    <!-- Custom styles for this template-->
    <link href="css/sb-admin-2.min.css" rel="stylesheet"/>
    <link href="https://cdn.datatables.net/1.10.20/css/jquery.dataTables.min.css" rel="stylesheet"/>

    <!-- Custom styles for this project-->
    <link href="css/site.css" rel="stylesheet"/>
    <link href="css/modern-business.css" rel="stylesheet">

</head>

<body id="page-top">

<%--<!-- Page Wrapper -->--%>
<div id="wrapper">

    <!-- Navigation Bar -->
    <nav class="navbar fixed-top navbar-expand-lg navbar-dark bg-dark fixed-top">
        <div class="container">
            <a class="navbar-brand" href="index">The Meal Planner</a>

            <%--this will select a different header depending on if youre logged in or a guest--%>
            <c:choose>
                <c:when test="${theUser.getGetUserName() == null}">
                    <c:import url="/WEB-INF/jsp/main/headerGuest.jsp"/>
                </c:when>
                <c:otherwise>
                    <c:import url="/WEB-INF/jsp/main/headerLoggedIn.jsp"/>
                </c:otherwise>
            </c:choose>
        </div>

    </nav>
</div>
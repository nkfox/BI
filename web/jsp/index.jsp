<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>BI</title>
    <link rel="stylesheet" type="text/css" href="../css/template.css"/>
    <script src="../js/action.js"></script>
</head>
<body>
    <div>
        <%@include file="layout/header.jsp" %>

        <div id_members = "carousel">
            <img src="../img/bui.jpg" class="sliders">
            <img src="../img/warwick.jpg" class="sliders">
            <img src="../img/nat.jpg" class="sliders">
        </div>

        <div id_members = "event">
            <h3>The nearest events</h3><br>
            <hr>
            <c:forEach var="event" items="${mainEvents}">
                <div class="events events1">
                    <img src="../img/event4.jpg">
                    <span class="data">${event.startDate} - ${event.endDate}</span><br>
                    <span class="event-name"><strong>${event.title}</strong></span>
                    <div class="description description1">${event.description}</div>
                </div>
            </c:forEach>
            <div class="seeall"><a href="">See all</a></div>
        </div>

        <div id_members = "project">
            <h3>The latest projects</h3><br>
            <hr>
            <c:forEach var="project" items="${mainProjects}">
                <div class="projects projects2">
                    <img src="../img/project2.jpg">
                    <span class="data">${project.startDate} - ${project.endDate}</span><br>
                    <span class="project-name"><strong>${project.name}</strong></span>
                    <div class="description description2">${project.description}</div>
                </div>
            </c:forEach>
            <div class="seeall seeall2"><a href="">See all</a></div>
        </div>

        <%@include file="layout/footer.jsp" %>
    </div>
</body>
</html>
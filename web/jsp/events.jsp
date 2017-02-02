<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="../css/templateevent.css">
</head>
<body>
<div id_members = "wrapper">
    <%@include file="layout/header.jsp" %>

    <div id_members = "event">
        <h3>The nearest events</h3>
        <a href="">
            <div id_members="createEvent">
                Create new
            </div>
        </a>
        <br>
        <hr>

        <div id_members="register_Form">
            <form action="handler" method="post">

                <label><span>Name:</span></label>
                <input id_members="name" type="text" name="title"  required placeholder="Name of event"><br>
                <label><span>Place:</span></label>
                <input type="text" id_members="place" name="place" required placeholder="Expo Plaza"><br>
                <label><span>Members:</span></label>
                <input type="text" id_members="members" name="participants" required placeholder="Jonhathan"><br>

                <label><span>Date Start:</span></label>
                <input type=date name="startDate" id=today>
                <script>
                    document.getElementById('today').value = new Date().toISOString().substring(0, 10);
                </script>
                <label><span>Date End:</span></label>
                <input type=date name="endDate" id=today2>
                <script>
                    document.getElementById('today2').value = new Date().toISOString().substring(0, 10);
                </script>

                <label><span>Organisator:</span></label>
                <input type="text" id_members="organisator" name="organizer" required placeholder="David"><br>
                <label><span>Description:</span></label>
                <input type="text" id_members="description" name="description" required placeholder="About event"><br>

                <input type="hidden" name="act" value="addEvent"/>
                <input class = "submit" type="submit" value="Create new" id_members="btn">
            </form>
        </div>

        <c:forEach var="event" items="${events}">
            <div class="events events1">
                <img src="../img/event4.jpg">
                <span class="data">${event.startDate} - ${event.endDate}</span><br>
                <span class="event-name"><strong>${event.title}</strong></span>
                <div class="description description1">${event.description}</div>
            </div>
        </c:forEach>

        <div class="seeall"><a href="">See all</a></div>
    </div>

    <%@include file="layout/footer.jsp" %>
</div>
</body>
</html>
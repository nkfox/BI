<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Projects</title>
    <link rel="stylesheet" href="../css/templateproject.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
    <script src="http://code.jquery.com/ui/1.9.2/jquery-ui.js"></script>
    <script src="../action.js"></script>
</head>
<body>
<div id_members = "wrapper">
    <%@include file="layout/header.jsp" %>

    <div id_members="registerProject">
        <form action="#">
            Name: <input type="text" name="ProjectName" value="Project_number"><br>
            <input type="submit" value="Submit">
        </form>
    </div>

    <div id_members = "project">
        <h3>The latest projects</h3>
        <a href="">
            <div id_members="createProject">
                Create new
            </div>
        </a>
        <br>
        <hr>
        <div id_members="addProject">
            <div id_members="register_Form">
                <form action="handler" method="post">

                    <label><span>Name:</span></label>
                    <input id_members="name" type="text" name="name" required placeholder="Name of event"><br>
                    <label><span>Category:</span></label>
                    <input type="text" id_members="category" name="category" required placeholder="Med"><br>

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

                    <input type="hidden" name="act" value="addProject"/>
                    <input class = "submit" type="submit" value="Create new" id_members="btn">
                </form>
            </div>

            <c:forEach var="project" items="${projects}">
                <div class="projects projects2">
                    <img src="../img/project2.jpg">
                    <span class="data">${project.startDate} - ${project.endDate}</span><br>
                    <span class="project-name"><strong>${project.name}</strong></span>
                    <div class="description description2">${project.description}</div>
                </div>
            </c:forEach>

        </div>
        <div class="seeall seeall2"><a href="">See all</a></div>
    </div>

    <%@include file="layout/footer.jsp" %>
</div>
</body>
</html>

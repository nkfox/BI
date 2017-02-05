<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 04/02/2017
  Time: 22:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Member</title>
    <link rel="stylesheet" href="../../css/template.css">
    <link rel="stylesheet" href="../../css/templatemembers.css">
</head>
<body>
<div id_members = "wrapper">
    <%@include file="../layout/header.jsp" %>

    <div id_members="registerMem">
        <form action="handler" method="post">
            <label><span>Name:</span></label>
            <input type="text" name="name" placeholder="Your name"><br>
            <label><span>Country:</span></label>
            <input type="text" name="country" placeholder="Ukraine"><br>
            <label><span>Email:</span></label>
            <input type="text" name="email" pattern="^[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}$" required placeholder="Your email"><br>
            <label><span>Info:</span></label>
            <input type="text" name="info" placeholder="Info"><br>
            <label><span>Picture:</span></label>
            <input type="text" name="picture" placeholder="Picture"><br>
            <label><span>Birth Date:</span></label>
            <input type=date name="birthDate" id=today>
            <script>
                document.getElementById('today').value = new Date().toISOString().substring(0, 10);
            </script>
            <label><span>Post:</span></label>
            <input type="text" name="post" placeholder="Post"><br>
            <label><span>Degree:</span></label>
            <input type="text" name="degree" placeholder="Degree"><br>
            <input type="hidden" name="act" value="addMember"/>
            <input class = "submit" type="submit" value="Create new" id_members="btn">
        </form>
    </div>

    <div class="members">
        <h3>Our members : </h3>
        <a href="">
            <div id_members="createMember">
                Create new
            </div>
        </a>

        <c:forEach var="teacher" items="${teachers}">
            <div class="member-picture">
                <img src=${teacher.picture}>
            </div>
            Email: ${teacher.email}<br>
            Name: ${teacher.name}<br>
            Country: ${teacher.country}<br>
            Post: ${teacher.post}<br>
            Degree: ${teacher.degree}<br>
            Info: ${teacher.info}<br><br>
        </c:forEach>

    </div>

    <%@include file="../layout/footer.jsp" %>
</div>
</body>
</html>
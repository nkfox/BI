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
            <label><span>City:</span></label>
            <input type="text" name="city" placeholder="City"><br>
            <input type="hidden" name="act" value="addUniversity"/>
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

        <c:forEach var="university" items="${universities}">
            <div class="member-picture">
                <img src=${university.picture}>
            </div>
            Email: ${university.email}<br>
            Name: ${university.name}<br>
            Country: ${university.country}<br>
            City: ${university.city}<br>
            Info: ${university.info}<br><br>
            <form action="handler" method="post">
                <input type="hidden" name="universityEmail" value="${university.email}"/>
                <input type="hidden" name="act" value="showUniversity"/>
                <input class = "submit" type="submit" value="Show more">
            </form>
            <br><br>
        </c:forEach>

    </div>

    <%@include file="../layout/footer.jsp" %>
</div>
</body>
</html>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 05/02/2017
  Time: 10:19
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

    <div class="member-picture">
        <img src=${university.picture}>
    </div>
    Email: ${university.email}<br>
    Name: ${university.name}<br>
    Country: ${university.country}<br>
    City: ${university.city}<br>
    Info: ${university.info}<br><br>

    <div>Teachers:
        <br>
        <c:forEach var="teacher" items="${univTeachers}">
            <div class="member-picture">
                <img src=${teacher.picture}>
            </div>
            Email: ${teacher.email}<br>
            Name: ${teacher.name}<br>
            Country: ${teacher.country}<br>
            Birth Date: ${teacher.birthDate}<br>
            Post: ${teacher.post}<br>
            Degree: ${teacher.degree}<br>
            Info: ${teacher.info}<br><br>
            <form action="handler" method="post">
                <input type="hidden" name="teacherEmail" value=${teacher.email}/>
                <input type="hidden" name="act" value="showTeacher"/>
                <input class = "submit" type="submit" value="Show more" id_members="btn">
            </form>
            <br><br>
        </c:forEach>
    </div>

    <br><br>

    <div>Students:
        <br>
        <c:forEach var="student" items="${univStudents}">
            <div class="member-picture">
                <img src=${student.picture}>
            </div>
            Email: ${student.email}<br>
            Name: ${student.name}<br>
            Country: ${student.country}<br>
            Country: ${student.birthDate}<br>
            Faculty: ${student.faculty}<br>
            Speciality: ${student.speciality}<br>
            Year: ${student.year}<br>
            Info: ${student.info}<br><br>
            <form action="handler" method="post">
                <input type="hidden" name="studentEmail" value=${student.email}/>
                <input type="hidden" name="act" value="showStudent"/>
                <input class = "submit" type="submit" value="Show more" id_members="btn">
            </form>
            <br><br>
        </c:forEach>
    </div>

    <%@include file="../layout/footer.jsp" %>
</div>
</body>
</html>
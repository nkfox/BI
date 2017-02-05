<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 05/02/2017
  Time: 12:05
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
<div id_members="wrapper">
    <%@include file="../layout/header.jsp" %>

    <div class="member-picture">
        <img src=${teacher.picture}>
    </div>
    Email: ${teacher.email}<br>
    Name: ${teacher.name}<br>
    Country: ${teacher.country}<br>
    Post: ${teacher.post}<br>
    Degree: ${teacher.degree}<br>
    Info: ${teacher.info}<br><br>

    <%@include file="../layout/footer.jsp" %>
</div>
</body>
</html>
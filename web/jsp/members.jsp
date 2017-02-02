<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Member</title>
    <link rel="stylesheet" href="../css/template.css">
    <link rel="stylesheet" href="../css/templatemembers.css">
</head>
<body>
<div id_members = "wrapper">
    <%@include file="layout/header.jsp" %>

    <div id_members="registerMem">
        <form action="handler" method="post">
            <label for = "FirstName"><span>Name:</span></label>
            <input id_members="FirstName" type="text" name="name" placeholder="Your name"><br>
            <label for = "country"><span>Country:</span></label>
            <input type="text" id_members="country" name="country" placeholder="Ukraine"><br>
            <label for = "email"><span>Email:</span></label>
            <input type="text" id_members="email" name="email" pattern="^[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}$" required placeholder="Ваш email"><br>
            <label for = "phone"><span>Phone:</span></label>
            <input type="text" id_members="phone" name="phone" pattern="+380[0-9]{9}" required placeholder="+380"><br>
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
        <table border="1">
            <thead>
            <th>Email</th>
            <th>Name</th>
            <th>Country</th>
            <th>Phone</th>
            </thead>
            <c:forEach var="member" items="${members}">
                <tr>
                    <td>
                            ${member.email}
                    </td>
                    <td>
                            ${member.name}
                    </td>
                    <td>
                            ${member.country}
                    </td>
                    <td>
                            ${member.phone}
                    </td>
                    <!--<td>-->
                    <!--    <img class="mems-img" src="../img/mem2.png">-->
                    <!--</td>-->
                </tr>
            </c:forEach>

        </table>
    </div>

    <%@include file="layout/footer.jsp" %>
</div>
</body>
</html>
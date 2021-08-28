<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 8/23/2021
  Time: 7:15 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>New Table</h1>
<form action="saveTable" method="post" modelAttribute="table">
    <input type="hidden" name="tableId" value="0">
    Table Type
    <select name="tableType" >
       <option >2 person</option>
        <option >5 person</option>
        <option >8 person</option>
    </select><br><br>
    Table Place
    <input type="radio" value="indoor" name="tablePlace" checked>Indoor
    <input type="radio" value="outdoor" name="tablePlace" >Outdoor
    <br><br>
    <input type="submit" value="submit">
</form>

<br><br>

<h1>Table List</h1>
<table border="1">
    <tr>
        <th>Table Id</th>
        <th>Table Type</th>
        <th>Table location</th>
        <th>Delete</th>
    </tr>
    <c:forEach items="${tableList}" var="p">
        <tr>
            <td>${p.tableId}</td>
            <td>${p.tableType}</td>
            <td>${p.tablePlace}</td>
            <td><a href="deleteTable/${p.tableId}"><img style="width: 20px;height: 20px;" src="../../img/delete.png"></a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 8/19/2021
  Time: 9:34 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Restaurant Management</title>
</head>
<body>
<h1>Invoice</h1>
<table>
    <tr>
        <th>Food Id</th>
        <th>Food Name</th>
        <th>Quantity</th>
        <th>Unit Price</th>
        <th>Total</th>
    </tr>
    <tbody>
    <c:forEach items="${listCounterOrderDetails}" var="f">
    <tr>
    <td>${f.foodId}</td>
        <td>${f.name}</td>
        <td>${f.qty}</td>
        <td>${f.unitPrice}</td>
        <td>${f.qty * f.unitPrice}</td>
    </tr>
        <script>
            var aa = aa
            document.getElementById("demo").innerHTML = 11;
        </script>
    </c:forEach>
    </tbody>
</table>
</body>
</html>

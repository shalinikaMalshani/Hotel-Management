<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 8/8/2021
  Time: 10:41 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Restaurant</title>
</head>
<body>
<div>
<form action="saveFood" method="post" modelAttribute="foodItems">

    <h1>Food Item Form</h1>
    <input type="hidden" name="foodId" value="0">
 Food Name
    <input type="test" name="name"><br><br>
    Food Price
    <input type="text" name="unitPrice"><br><br>
    <input type="submit" value="Add">
</form>
</div>
</body>
</html>

























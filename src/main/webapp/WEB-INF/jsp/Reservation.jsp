<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 8/22/2021
  Time: 7:41 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Restaurant Management System</title>
</head>
<body>
<h1></h1>
<h1>Add Reservation</h1>
<form method="post" action="saveReservation" name="reservation">
  <input type="hidden" value="0" name="counterTableReserveId">
  Table Type
  <select name="type">
    <c:forEach items="${tableList2}" var="tt">
      <option value="${tt.tableId}">
      ${tt.tableType}${tt.tablePlace}
      </option>
    </c:forEach>
  </select><br><br>
  Place
  <input type="radio" value="indoor" name="place" checked>indoor
  <input type="radio" value="outdoor" name="place">outdoor<br><br>

  Date
  <input type="date" name="date"><br><br>
  <input type="submit" value="Add">

</form>
</body>
</html>

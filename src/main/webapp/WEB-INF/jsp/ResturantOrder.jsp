<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>


<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 8/8/2021
  Time: 12:10 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

        <script>

            //adding form data into table
        function addRow()
        {
            // get input values
            var fid = document.getElementById('fid').value;
            var fname = document.getElementById('fname').value;
            var fprice = document.getElementById('fprice').value;
            var fqty = document.getElementById('fqty').value;
            var total= fprice*fqty;
            var pic=document.createElement("img");
            pic.setAttribute("src","../../img/delete.png");
            pic.setAttribute("width", "15");
            pic.setAttribute("height", "15");
            pic.setAttribute("align","center");

            // get the html table
            // 0 = the first table
            var table = document.getElementById('tableList');

            // add new empty row to the table
            // 0 = in the top
            // table.rows.length = the end
            // table.rows.length/2+1 = the center
            var newRow = table.insertRow();

            // add cells to the row
            var cel1 = newRow.insertCell(0);
            var cel2 = newRow.insertCell(1);
            var cel3 = newRow.insertCell(2);
            var cel4 = newRow.insertCell(3);
            var cel5 = newRow.insertCell(4);
            var cel6 = newRow.insertCell(5);

            // add values to the cells
            cel1.innerHTML = fid;
            cel2.innerHTML = fname;
            cel3.innerHTML = fprice;
            cel4.innerHTML = fqty;
            cel5.innerHTML = total;
            cel6.appendChild(pic);
        }

    </script>


    <title>Restaurant</title>
</head>
<body>
<script src="../../js/restaurant.js"></script>
<h1>List Of Food Items</h1>
<table border="1" id="table">
    <tr>
        <th>Food Id</th>
    <th>Food Name</th>
    <th>Food Price</th>
</tr>
   <c:forEach items="${foodItemList}" var="f">
<tr>
    <td>${f.foodId}</td>
    <td>${f.name}</td>
    <td>${f.unitPrice}</td>
</tr>
   </c:forEach>
</table>
<h1>Food Order Form</h1>
<form>
    Food Id
    <input type="text" name="foodId" id="fid"><br><br>
    Food Name
    <input type="text" name="foodName" id="fname"><br><br>
    Food Price
    <input type="text" name="unitPrice" id="fprice"><br><br>
    Quantity
    <input type="number" name="qty" id="fqty"><br><br>

    <input  type="hidden" class="form-control"
            name="customerId" value="0"
            id="customerId" placeholder="Customer ID"/>

    <button type='button' id="btnAdd"
            value="Register">
        Add
    </button>

    <input type="reset" value="Reset">
</form>

<%--<script>--%>
<%--    var table=document.getElementById('table');--%>

<%--    for(i=1;i<table.rows.length;i++){--%>
<%--       table.rows[i].onclick=function ()--%>
<%--       {--%>
<%--           document.getElementById('fid').value=this.cells[0].innerHTML;--%>
<%--           document.getElementById('fname').value=this.cells[1].innerHTML;--%>
<%--           document.getElementById('fprice').value=this.cells[2].innerHTML;--%>
<%--       }--%>
<%--    }--%>
<%--</script>--%>
<h1>Order Table</h1>
<form method="POST" action="invoice"  name="restaurantCounterOrderDTO">
    <input style="display: none" type="text" id="itemPay" name="dataValue">
    <input style="display: none" type="text" id="cId" value="0"  name="customerId">
    <button type="submit" value="Register" onclick="getValue()" >Pay</button>
</form>
<table border="1">
<thead>
<tr>
    <th>Food Id</th>
    <th>Food name</th>
    <th>Unit Price</th>
    <th>Quantity</th>
    <th>Total</th>
    <th>Delete</th>
</tr>
</thead>
    <tbody id="tblOrder">

    </tbody>
</table>

















<script>
    var selectedRow = null;
    $("#dataTablesButton1 tbody").on('click', 'tr', function () {
        var date = new Date();
        var date2 = new Date();
        var today = date.getDate() + ":" + (date.getMonth()) + ":" + date.getFullYear();
        selectedRow = $(this);
        $("#fname").val($(this).find("td:nth-child(1)").text());
        $("#fid").val($(this).find("td:nth-child(2)").text());
        $("#fprice").val($(this).find("td:nth-child(3)").text());
        $("#date").val(today);
        $("#dataTablesButton1 tbody tr").removeClass('row-selected');
        selectedRow.addClass('row-selected');
    });
</script>

<script> $(document).ready(function () {
    $("#btn_enable").click(function () {
        $("#name").prop("disabled", false);
    });
});
</script>


</body>
</html>

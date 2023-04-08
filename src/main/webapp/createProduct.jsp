<%--
  Created by IntelliJ IDEA.
  User: HP-PC
  Date: 3/29/2023
  Time: 12:51 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create Coupon</title>
</head>
<body>
<h2>Coupon And Product App</h2>
<form action="ProductController" method="post">
    <pre>
        Product Name: <input type="text" name="productName"/><br/>
        Description: <input type="text" name="description"/><br/>
        Price: <input type="text" name="price"/><br/>
        Coupon Code <input type="text" name="couponCode"/><br/>
        <input type="submit" value="Create"/>
    </pre>
</form>
</body>
</html>

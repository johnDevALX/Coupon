<%--
  Created by IntelliJ IDEA.
  User: HP-PC
  Date: 3/29/2023
  Time: 2:16 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Find Coupon</title>
</head>
<body>
<h2>Find Coupon</h2>
<form action="CouponController" method="post">
    <pre>
        Coupon Code: <input type="text" name="couponCode"/><br/>
        <input type="hidden" name="action" value="find" /><br/>
        <input type="submit" value="Find"/>
    </pre>
</form>
</body>
</html>

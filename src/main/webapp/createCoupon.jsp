<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create Coupon</title>
</head>
<body>
<h2>Create Coupon</h2>
<form action="CouponController" method="post">
    <pre>
        Coupon Code: <input type="text" name="couponCode"/><br/>
        Discount: <input type="text" name="discount"/><br/>
        Expiry Date: <input type="text" name="expiryDate"/><br/>
        <input type="hidden" name="action" value="create" /><br/>
        <input type="submit" value="Save"/>
    </pre>
</form>
</body>
</html>
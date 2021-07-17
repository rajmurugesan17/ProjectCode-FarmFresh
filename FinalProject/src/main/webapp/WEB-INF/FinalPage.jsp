<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="${pageContext.request.contextPath}/resources/style/header.css"
    rel="stylesheet">
<title>FARM FRESH</title>
<style>
h4{
		position: absolute;
		margin-top:100px;
		margin-left:150px;
		font-size: 30px;
		font-family: monospace;
	}
	input[type=submit] {
  width: 100%;
  background-color: #2bab0d;
  color: white;
  padding: 7px 20px;
  margin: 3px 0;
  border: none;
  border-radius: 4px;
  cursor: pointer;	
  }
 input[type=submit]:hover {
  background-color: green;
}
#sub{
	position:absolute;
	margin-top:190px;
	margin-left:400px;
}
</style>
</head>
<body>

	<div class="headstyle"><i>Farm Fresh</i></div>
	<div class="menu-bar">
	<div class="logo"><img src="${pageContext.request.contextPath}/resources/images/logo.jpg" width="150px" height="115px"></div>
	<ul>
		<li class="home"><a href="onemoreorder">Home</a></li>
		<li style="color:white;">Hi.,${name.name}</li>
		
		
		<li><a href="myorderscus">My Orders</a></li>
		<li><a href="displaycuscartdetails">Cart</a></li>
		<li><a href="logoutcustomer">LogOut</a></li>
	</ul>
		</div>
		<div class="bg">
	<h2>The Amount of total Rs:${totalamount} has to be paid for the delivery..,</h2>
	<form action="payment" id="sub">
		<input type="submit" value="CONFIRM ORDER">
	</form>
	</div>
</body>
</html>
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
		<<li><a href="displaycuscartdetails">Cart</a></li>
		<li><a href="logoutcustomer">LogOut</a></li>
	</ul>
		</div>
		<div class="bg">
	<h2>No Records Found..,Category is Empty</h2></div>
</body>
</html>
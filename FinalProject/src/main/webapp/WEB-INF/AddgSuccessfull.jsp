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
#fd{
	color:white;}
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
		<li class="home"><a href="successfull">Home</a></li>
		<li id="fd">Hi.,${name.name}</li>
		
		
		<li><a href="farmerfullorders">Orders</a></li>
		<li><a href="goodsdetails">MyGoods</a></li>
		<li><a href="logout">LogOut</a></li>
	</ul>
		</div>
		<div class="bg">
	<h2>Your goods have been added successfully to the cart..,</h2>
	</div>
</body>
</html>
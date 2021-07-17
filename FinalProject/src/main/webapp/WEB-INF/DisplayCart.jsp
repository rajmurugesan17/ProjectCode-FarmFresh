<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="${pageContext.request.contextPath}/resources/style/header.css"
    rel="stylesheet">
<title>FARM FRESH</title>
<style>
<style>
#fd{
	color:red;}
	#tab{
		font-family:"Trebuchet MS",Arial,Helvetica, sans-serif;
		margin-left: auto;
		margin-right: auto;
		margin-top:70px;
		border-collapse: collapse;
		width:10%;
		box-shadow: 10px 10px 10px;
	}
	#tab td,#tab th{
	border:1px solid #ddd;
	padding: 8px;
	background-color: #f2f2f2;
	}
	#tab th{
	padding-top: 12px;
	padding-bottom: 12px;
	text-align: center;
	background-color:green;
	color:white;
	}
	caption{
		color:red;
		text-align: center;
		margin-bottom: 10px;
		
		font-size: 100%;
		padding:5px;
		
		font-weight: bold;
		}
	h3{
		position:absolute;		
		margin-top:70px;
		margin-left:550px;
	}
	input[type=text], select {
  	
  	padding: 12px 20px;
  	margin: 8px 0;
  	display: inline-block;
  	border: 1px solid #ccc;
 	 border-radius: 4px;
 	 box-sizing: border-box;
	}
	input[type=submit] {
  width: 100%;
  background-color: #4CAF50;
  color: white;
  padding: 7px 20px;
  margin: 3px 0;
  border: none;
  border-radius: 4px;
  cursor: pointer;	
  }
 input[type=submit]:hover {
  background-color: #2bab0d;
}
#colo{
color: red;
}
</style>
</head>
<body class="bg1">

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
	<table id="tab">
		<caption>Your CART </caption>
		<tr>
			<th>Category</th>
			<th>GoodsName</th>
			<th>OrderQuantity(Kg)</th>
			<th>Price(per Kg)</th>
			<th>Total Price</th>
			<th>Action</th>
		</tr>
		<c:forEach var="u" items="${cartdetails}">
		<tr>
			<td>${u.category}</td>
			<td>${u.goodsName}</td>
			<td>${u.orderQty}</td>
			<td>${u.price}</td>
			<td>${u.totalPrice}</td>
			<td><a href="deletecartdetails?fid=${u.fid}&gname=${u.goodsName}&price=${u.price}&qty=${u.orderQty}" style="color:red;">DELETE</a></td>
		</tr>
		</c:forEach>
		<tr>
			<form action="checkout">
				<td colspan="6"><input type="submit" value="CheckOut"></td>
			</form>
		</tr>
		</table>
</body>
</html>
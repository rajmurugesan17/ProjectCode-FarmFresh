<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ page import="java.util.*,com.rajkumar.model.CusCategoryDetails" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="${pageContext.request.contextPath}/resources/style/header.css"
    rel="stylesheet">
<title>FARM FRESH</title>
<style>
#tab{
		font-family:"Trebuchet MS",Arial,Helvetica, sans-serif;
		margin-left: auto;
		margin-right: auto;
		margin-top:50px;
		border-collapse: collapse;
		width:50%;
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
	background-color: green;
	color:white;
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
  padding: 14px 20px;
  margin: 8px 0;
  border: none;
  border-radius: 4px;
  cursor: pointer;	
  }
 input[type=submit]:hover {
  background-color: #45a049;
}
#fd{
color:white;}
	
</style>
</head>
<body class="bg1">

	<div class="headstyle"><i>Farm Fresh</i></div>
<div class="menu-bar">
<div class="logo"><img src="${pageContext.request.contextPath}/resources/images/logo.jpg" width="150px" height="115px"></div>
	<ul>
		<li class="home"><a href="onemoreorder">Home</a></li>
		<li id="fd">Hi.,${name.name}</li>
		
		<li><a href="myorderscus">My Orders</a></li>
		<li><a href="displaycuscartdetails">Cart</a></li>
		<li><a href="logoutcustomer">LogOut</a></li>
	</ul>
		</div>
	
	<table id="tab">
		<tr>
			<th>${categoryname} Name</th>
			<th>Quantity(Kg)</th>
			<th>Price(Rs/Kg)</th>
			<th>Action</th>
		</tr>
		<c:forEach var="u" items="${cuscategorydetails}">
		<tr>
			<td>${u.goodsName}</td>
			<td>${u.qty}</td>
			<td>${u.price}</td>
			<td><a href="customerselectedgoods?fid=${u.fid}&goodsname=${u.goodsName}&goodsprice=${u.price}"style="color:green;width=100%;">Click to ORDER</a></td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>
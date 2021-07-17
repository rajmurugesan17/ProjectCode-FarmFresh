<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
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
	font-family: serif;
	color:white;
	background-color: green;
	}
	caption{
		color:red;
		text-align: center;
		margin-bottom: 10px;
		
		font-size: 120%;
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
  background-color: #45a049;
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
		<li class="home"><a href="successfull">Home</a></li>
		<li style="color:white;">Hi.,${name.name}</li>
		
		
		<li><a href="farmerfullorders">Orders</a></li>
		<li><a href="goodsdetails">MyGoods</a></li>
		<li><a href="logout">LogOut</a></li>
	</ul>
		</div>
	
	<table id="tab">
		<caption>Goods Order Details</caption>
		<tr>
			<th>Customer Name</th>
			<th>Customer Phone Number</th>
			<th>Customer Location</th>
			<th>Category Name</th>
			<th>Goods Name</th>
			<th>Quantity</th>
			<!-- <th>Option</th> -->
		</tr>
		<c:forEach var="u" items="${farmfulldetails}">
		<tr>
			<td>${u.name}</td>
			<td>${u.number}</td>
			<td>${u.location}</td>
			<td>${u.category}</td>
			<td>${u.goodsName}</td>
			<td>${u.qty}</td>
			<%--<td ><a href="deletegoods?pname=${u.goodsName}" style="color:red;">DELETE</a></td> --%> 
		</tr>
		</c:forEach>
	</table>
</body>
</html>
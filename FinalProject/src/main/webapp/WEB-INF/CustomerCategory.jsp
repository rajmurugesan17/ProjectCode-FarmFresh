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
	#fd{
	color:white;}
	#tab{
		font-family:"Trebuchet MS",Arial,Helvetica, sans-serif;
		margin-left: auto;
		margin-right: auto;
		margin-top:100px;
		border-collapse: collapse;
		width:10%;
		border:1px solid #ddd;
		box-shadow: 10px 10px 10px;
	}
	#tab td,#tab th{
	border:0px solid #ddd;
	padding: 8px;
	background-color: #f2f2f2;
	}
	#tab th{
	padding-top: 12px;
	padding-bottom: 12px;
	text-align: left;
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
	 select {  	
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
  background-color:#2bab0d;
}
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
	<h3></h3>
	<table id="tab">
	<caption>Select the Category..,</caption>
	<form action="selectedCustomerCategory">
	
		<tr>
		<th>Category</th>
		<th><input list="category" name="category">
		<datalist id="category">
		<c:forEach var="u" items="${categoryDetails}">
		<option value="${u}"><c:out value="${u}"/></option>
		</c:forEach>
		</datalist>
		<tr>
		<td colspan="2"><input type="submit" value="Search"/></td>
	</tr>
	</form>
	</table>
</body>
</html>
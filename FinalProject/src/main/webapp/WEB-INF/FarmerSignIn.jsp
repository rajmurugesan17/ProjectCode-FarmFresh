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
	#tab th,#tab td{
	padding-top: 10px;
	padding-bottom: 5px;
	text-align: left;
	}
	caption{
		color:red;
		text-align: left;
		margin-bottom: 10px;
		
		font-size: 130%;
		padding:5px;
		text-shadow:.5px .5px black;
		font-weight: bold;
		}
		
	input[type=text], select {
   	padding: 12px 20px;
  	margin: 8px 0;
  	display: inline-block;
  	border: 1px solid #ccc;
 	 border-radius: 4px;
 	 box-sizing: border-box;
	}
	input[type=password] {
  	
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
.logo{
	position:absolute;
	margin-left:70px;
	margin-top:-60px;
}


</style>
</head>
<body class="bg1">

	<div class="headstyle"><i>Farm Fresh</i></div>
<div class="menu-bar">
<div class="logo"><img src="${pageContext.request.contextPath}/resources/images/logo.jpg" width="150px" height="115px"></div>
	<ul>
		<li class="home"><a href="home">Home</a></li>
		<li id="fd">Farmer</li>
		<li><a href="aboutusf">About us</a></li>
		<li><a href="contactusf">Contact us</a></li>
	</ul>
		</div>
		
	<table id="tab">
	<caption>Enter the Credintials..,</caption>
	<form action="fLogin">
	<tr>
		<th>UserName:</th><td><input type="text" placeholder="UserName" name="uname" required="required"></td>
	</tr>
	<tr>
		<th>Password:</th><td><input type="password" placeholder="Password" name="password" required="required"></td>
	</tr>
	<tr>
		<th  colspan="2"><input type="submit" value="Login"></th>
		
	</tr>
	</form>
	
	</table>
	
</body>
</html>
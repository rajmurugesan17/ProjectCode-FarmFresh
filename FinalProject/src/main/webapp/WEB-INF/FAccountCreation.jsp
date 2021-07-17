<%@page import="org.springframework.web.bind.annotation.RequestParam"%>
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
#tab{
		font-family:"Trebuchet MS",Arial,Helvetica, sans-serif;
		margin-left: auto;
		margin-right: auto;
		margin-top:50px;
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
	caption{
		color:red;
		text-align: left;
		margin-bottom: 10px;
		
		font-size: 120%;
		padding:5px;
		
		font-weight: bold;
		}
	#tab th{
	padding-top: 12px;
	padding-bottom: 12px;
	text-align: left;
	font-family: serif;
	font-size: 17px;
	}
	
	input[type=text], select {
  	
  	padding: 12px 20px;
  	margin: 8px 0;
  	display: inline-block;
  	border: 1px solid #ccc;
 	 border-radius: 4px;
 	 box-sizing: border-box;
	}
	input[type=number] {
  	
  	padding: 12px 20px;
  	margin: 8px 0;
  	display: inline-block;
  	border: 1px solid #ccc;
 	 border-radius: 4px;
 	 box-sizing: border-box;
	}
	input[type=email] {
  	
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
  background-color: #2bab0d;
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
		<li class="home"><a href="home">Home</a></li>
		<li id="fd">Farmer</li>
		<li><a href="aboutusf">About us</a></li>
		<li><a href="contactusf">Contact us</a></li>
	</ul>
		</div>
	
	<table id="tab">
	
	<c:set var="u" value="${count}"/>
	<c:if test="${u==1}">
	<caption><h4>UserName Already Exists..,</h4></caption>
	</c:if>
	<c:if test="${u==0}">
	<caption><h4>Enter the Details..,</h4></caption>
	</c:if>	
	<c:if test="${u==-1}">
	<caption><h4>UserName and Password Should not be same..,</h4></caption>
	</c:if>	
	<form:form action="FarmerDetails" modelAttribute="accDetails">
	<tr>
		<th>Name</th><td><form:input path="name" type="text" placeholder="Enter Your Name.." pattern="[A-za-z ]{1,}" title="Name should contain A-Z or a-z and space" required="required"/></td>
	</tr>
	<tr>
		<th>Age</th><td><form:input path="age" type="number" placeholder="Enter the Age.." min="1"  title="Age should not be Zero or Negative" required="required"/></td>
	</tr>
	<tr>
		<th>Location</th><td><form:input path="location" placeholder="Enter the Location.." type="text" pattern="[A-za-z ]{1,}" title="Location should contain A-z or a-z and space" required="required"/></td>
	</tr>
	<tr>
		<th>PhoneNumber</th><td><form:input path="phoneNumber" type="text" pattern="[6789]{1}[0-9]{9}" placeholder="Enter the Phone Number.." title="Phone no length should be 10 and it should start with the number 6 or 7 or 8 or 9" required="required"/></td>
	</tr>
	<tr>
		<th>EmailId</th><td><form:input path="emailId" type="email" placeholder="Enter the Email.." pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,}$" title="Eg:abc@gmail.com"  required="required"/></td>
	</tr>
	<tr>
		<th>UserName</th><td><form:input path="userName" placeholder="Enter the UserName.." pattern="(?=.*[a-z])(?=.*[A-Z]).{8,}" title="Must contain at least one uppercase and lowercase letter and at least 8 or more characters" required="required"/></td>
	</tr>
	<tr>
		<th>Password</th><td><form:input path="password" type="password" placeholder="Enter the passWord.." pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" title="Must contain at least one number and one uppercase and lowercase letter, and at least 8 or more characters" required="required"/></td>
	</tr>
	<tr>
		<th colspan="2"><input type="submit" value="Save" /></th>
	</tr>
	</form:form>
	</table>
</body>
</html>
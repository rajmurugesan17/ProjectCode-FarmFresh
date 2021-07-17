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
	}
	#tab td,#tab th{
	border:0px solid #ddd;
	padding: 8px;
	}
	#tab th{
	padding-top: 12px;
	padding-bottom: 12px;
	text-align: left;
	}
	h3{
		position:absolute;		
		margin-top:70px;
		margin-left:550px;
	}
	list {  	
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
</style>

</head>
<body>

	<div class="headstyle"><i>Farm Fresh</i></div>
	<div class="menu-bar">
<div class="logo"><img src="${pageContext.request.contextPath}/resources/images/logo.jpg" width="150px" height="115px"></div>
	<ul>
		<c:set var="u" value="${pos}"/>
		<c:if test="${u==0}">
		<li class="home"><a href="home">Home</a></li>
		<li><a href="#">Our Login</a>
				<div class="submenu1">
						<ul>
								<li class="hoverme"><a href="#">Farmer</a>
									<div class="submenu2">
										<ul>
											<li><a href="FarmerSignin">SignIn</a></li>
											<li><a href="FarmerNewAccount">SignUp</a></li>
										</ul>						
									</div>
								
								</li>	
								<li class="hoverme"><a href="#">Customer</a>
								<div class="submenu2">
										<ul>
											<li><a href="CustomerSignin">SignIn</a></li>
											<li><a href="CustomerNewAccount">SignUp</a></li>
										</ul>						
									</div>
								</li>
						</ul>		
				</div>
		</li>
		
	
		<li><a href="aboutusc">About us</a></li>
		<li><a href="contactusc">Contact us</a></li>
		</c:if>
		<c:if test="${u==1}">
		<li class="home"><a href="onemoreorder">Home</a></li>
		
		
		<li id="fd">Hi.,${name.name}</li>
		
	
		
		<li><a href="myorderscus">My Orders</a></li>
		<li><a href="displaycuscartdetails">Cart</a></li>
		<li><a href="logoutcustomer">LogOut</a></li>
		</c:if>
	</ul>
		</div>
	<h1>hii</h1>
</body>
</html>
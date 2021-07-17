<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="${pageContext.request.contextPath}/resources/style/header.css"
    rel="stylesheet">
<title>Insert title here</title>
</head>
<body>
<div class="headstyle"><i>Farm Fresh</i></div>
<div class="menu-bar">
<div class="logo"><img src="${pageContext.request.contextPath}/resources/images/logo.jpg" width="150px" height="115px"></div>
	<ul>
		<li class="home"><a href="home">Home</a></li>
		<li><a href="#">Our Login</a>
				<div class="submenu1">
						<ul>
								<li class="hoverme"><a href="#">Farmer</a>
									<div class="submenu2">
										<ul>
											<li><a href="FarmerSignin"><i>SignIn</i></a></li>
											<li><a href="FarmerNewAccount"><i>SignUp</i></a></li>
										</ul>						
									</div>
								
								</li>	
								<li class="hoverme"><a href="#">Customer</a>
								<div class="submenu2">
										<ul>
											<li><a href="CustomerSignin"><i>SignIn</i></a></li>
											<li><a href="CustomerNewAccount"><i>SignUp</i></a></li>
										</ul>						
									</div>
								</li>
						</ul>		
				</div>
		</li>
		<li><a href="aboutusf">About us</a></li>
		<li><a href="contactusf">Contact us</a></li>
	</ul>
		</div>
    <div class="col">
    	
	<h2>The Place where you find the Right Quality of Products...,<br>Affordable rate for your Products</h2>
	<h1>Grab it By Login Now!!!</h1>
	
	</div>
</body>
</html>
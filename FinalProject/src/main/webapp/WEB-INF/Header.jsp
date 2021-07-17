<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
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
		<li><a href="">Our Login</a>
				<div class="submenu1">
						<ul>
								<li class="hoverme"><a href="">Farmer</a>
									<div class="submenu2">
										<ul>
											<li><a href="FarmerSignin">SignIn</a></li>
											<li><a href="FarmerNewAccount">SignUp</a></li>
										</ul>						
									</div>
								
								</li>	
								<li class="hoverme"><a href="customer">Customer</a>
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
		<li><a href="aboutusf">About us</a></li>
		<li><a href="/contactpage">Contact us</a></li>
	</ul>
		</div>

</body>
</html>


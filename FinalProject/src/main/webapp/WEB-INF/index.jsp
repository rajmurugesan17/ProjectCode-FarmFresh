<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>FARM FRESH</title>
<style>
	h1{
	text-align:center;
	color:red;
	}
	h2{
	text-align: center;
	}
</style>
</head>
<body>
	<h1>Farm Fresh</h1>
	<h2>Farm Fresh Welcomes You </h2>
	<br>
	<center>
	<table id="option">
	<tr>
		<td><form action="farmer" id="s1">
		<input type="submit" value="Farmer">
		</form>
		</td>
		<td>
		<form action="customer" id="s2">
		<input type="submit" value="Customer">
		</form>
		</td>
	</tr>
	</table></center>
</body>
</html>
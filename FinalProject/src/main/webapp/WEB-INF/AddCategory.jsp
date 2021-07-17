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
	div{
	background-color:blue;
	}
	h2{
	text-align: center;
	}
</style>
</head>
<body>
	<h1>Farm Fresh</h1>
	<div>
	<table>
	<form action="logout">
	<tr>
		<td><input type="submit" value="LogOut"></td>
	</tr>
	</form>
	</table>
	</div>
	<table>
	<form action="addCategory">
	<tr>
		<td>Name of Category</td><td><input type="text" name="cate"></td><td><input type="submit" value="Add"></td>
	</tr>
	</form>
	</table>
</body>
</html>
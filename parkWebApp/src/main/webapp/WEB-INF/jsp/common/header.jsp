<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>
	<meta charset="ISO-8859-1">
		<link rel="stylesheet"
			href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
			integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
			crossorigin="anonymous">
		<c:url value="/css/site.css" var="cssURL" />
	<link rel="stylesheet" type="text/css" href="${cssURL }">
	
	<title>Park Detail</title>

</head>

<body>

	<%--for some reason can't get this to load out in the background, come back to this --%>
	 <div>
		<c:url value= "img/nationalPark.png" var = "nationalParkService"/>
		<img class="nationalParkLogo" id = "background-logo" src = "${nationalParkService}"></img>
	</div>
	
	<div class="logo">
		<c:url value="img/logo.png" var="parkLogo" />
		<img id="site-logo" src="${parkLogo}"></img>
	</div>

		<div class = "navigationBar">
			<nav class="navbar navbar-expand-lg navbar-light" style="background-color:#F5D60F;" >
				<a class="navbar-brand" href="home">Home</a>
				<button class="navbar-toggler" type="button" data-toggle="collapse"
					data-target="#navbarNavAltMarkup"
					aria-controls="navbarNavAltMarkup" aria-expanded="false"
					aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>
				<div class="collapse navbar-collapse" id="navbarNavAltMarkup">
					<div class="navbar-nav">

					<a class="nav-item nav-link" href="survey">Survey</a>

					</div>
				</div>
			</nav>
		</div>
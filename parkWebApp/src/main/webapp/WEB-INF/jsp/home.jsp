<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<c:import url="/WEB-INF/jsp/common/header.jsp" />



	<h1>Home Page</h1>
	

	<div class = "header">
		<h3>Descriptions</h3>
	</div>
			
	<div class="parkList">

			<c:forEach items="${parks}" var="park">
				<div class="park">
					<div class="card" style="width: 18rem;">
				 	<div class="card-body">
				  	<div class = "parkImage">
						<a href="detail?parkcode=${park.parkcode}">
						<c:url value="/img/parks/${(park.parkCodeToLowerCase)}.jpg" var="parkImage"/>
						<img class="img-style" src="${parkImage}" /></a>
						</div>
					    <h5 class="card-title">${park.parkname}</h5>
					    <h6 class="card-subtitle mb-2 text-muted">${park.state}</h6>
					    <p class="card-text">${park.parkDescription}</p>
					   <%--  <a href="#" class="card-link">Card link</a>
					    <a href="#" class="card-link">Another link</a>--%>
				  	</div>
					</div>
					</div>
			</c:forEach>
	</div>

	

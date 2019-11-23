<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<c:import url="/WEB-INF/jsp/common/header.jsp" />

<title>Insert title here</title>
<c:url value ="/survey" var ="favoriteURL"/>
<%-- <<<<<<< Updated upstream--%>
<%-- <form:form id="survey" method="post" action="${favoriteURL}" modelAttribute="survey">
	 <div>
		<label for="parkname">Park Name</label>
	<form:input id="parkname" type="text" path ="parkname" name="parkname" required ="required"/>
	
	</div> 

	 <div>
	<label for="emailAddress">Email Address</label>
	<form:input id="emailAddress" name="emailAddress" type="email" path="emailAddress" required ="required"/>
	<form:errors path="emailAddress" class="error"/>
	</div>
	
	<div>
	<label for="state">State of Residence</label>
	<form:input id="state" name="state" type="text" path="state" required ="required"/>
	<form:errors path="state" class="error"/>
	</div>
	
	<div>

		<label for="inactive">Inactive</label>
		<input type="radio" value="inactive" name= "activityLevel"/>
		<label for="sedentary">Sedentary</label>
		<input type="radio" value="sedentary" name= "activityLevel"/>
		<label for="active">active</label>
		<input type="radio" value="active" name= "activityLevel"/>
		<label for="extremelyActive">Extremely Active</label>
		<input type="radio" value="extremelyActive" name= "activitylevel" />
	
	<form:errors path="activityLevel" class="error"/>
	</div>
	<input type="submit" value = "submit"/>--%>
=======

<div class ="card">
<div class = "survey">
<form:form id="survey" method="post" action="${favoriteURL}" modelAttribute="survey">
     <div>
        <label for="parkname">Park Name</label>
    <form:input id="parkname" type="text" path ="parkname" name="parkname"/>
    <form:errors path="parkname" class="error"/>
    </div> 

     <div class>
    <label for="emailAddress">Email Address</label>
    <form:input id="emailAddress" name="emailAddress" type="email" path="emailAddress"/>
    <form:errors path="emailAddress" class="error"/>
    </div>
    
    <div class = " state-residence">
    <label for="state">State of Residence</label>
    <form:input id="state" name="state" type="text" path="state"/>
    <form:errors path="state" class="error"/>
    </div>
    
    <div>
<%-- >>>>>>> Stashed changes--%>

        <label for="inactive">Inactive</label>
        <input type="radio" value="inactive" name= "activityLevel"/>
        <label for="sedentary">Sedentary</label>
        <input type="radio" value="sedentary" name= "activityLevel"/>
        <label for ="active">Active</label>
        <input type="radio" value="active" name= "activityLevel"/>
        <label for="extremelyActive">Extremely Active</label>
        <input type="radio" value="extremelyActive" name= "activitylevel" />
    
    <form:errors path="activityLevel" class="error"/>
    </div>
    <input type="submit" value = "submit"/>

<<<<<<< Updated upstream
=======
</form:form>
</div>
</div>
<%-- >>>>>>> Stashed changes--%>
<c:import url="/WEB-INF/jsp/common/footer.jsp" />"
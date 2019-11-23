
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<c:import url="/WEB-INF/jsp/common/header.jsp" />

	<div class="detail-card-description">
		<h2>Fabulous Facts!</h2>
		</div>
		<div class="card" >
			<div class="card-body-detail" id = "details-card">
				<div class ="detailsForPark">
					<div class = "parkImage">
						<a href="detail?parkcode=${detailPark.parkcode}"> <c:url
									value="/img/parks/${(detailPark.parkCodeToLowerCase)}.jpg"
									var="parkImage" /> <img class = "detail-park-image" src="${parkImage}" />
						</a>
					</div>
				
				
					<h5 class="card-title">${detailPark.parkname }</h5>
			
		
					<div><img src="${imageSourceURL}" /></div>
			
					<h6 class="card-subtitle mb-2 text-muted">${detailPark.state}</h6>
				
					<p class="description">${detailPark.parkDescription}</p>
		
					<div class="inspirational">"${detailPark.inspirationalQuote}" <span
						class="quoteSource"> - ${detailPark.inspirationalQuoteSource}</span></div>
				
				<div class = "detail-stats">
					<table >
						<tr>
							<td class="table-content acreage">${detailPark.acreage} acres.</td>
						
							<td class="table-content climate">${detailPark.climate} Climate.</td>
						
							<td class="table-content elevation">${detailPark.elevationInFeet} ft above Sea Level.</td>
						
							<td class="table-content entry-fee">$ ${detailPark.entryFee}.00</td>
					
							<td class="table-content miles">${detailPark.milesOfTrail } miles of trail.</td>
					
							<td class="table-content animal-species">${detailPark.numberOfAnimalSpecies } different types of animal species.</td>
					
							<td class="table-content campsites">${detailPark.numberOfCampsites} camp sites.</td>
						
							<td class="table-content visitors">${detailPark.annualVisitorCount} annual visitors a year.</td>
						</tr>
					</table>
				</div>
			</div>
		</div>
	</div>


<%-- <form action= "<c:url value = "/detail"/>" method = "post" class ="temperature">

	<input type ="hidden" id="${detailPark.parkcode}" name = "parkcode" value = "${detailPark.parkcode}">
	<button type ="submit" id="buttonTemp" name = "temperature" value ="celsius">Celsius</button>
	<button type ="submit" id="buttonTemp" name = "temperature" value ="fahrenheit">Fahrenheit</button>

</form>


	<div class="table">
	
	
	<div>
		
			<c:forEach items="${weatherMap}" var="weatherDay">

				<div><c:url
						 value="/img/weather/${weatherDay.forecastImageString}.png"
						var="weatherImage" /> <img  src="${weatherImage}"
					alt="${weatherImage}" /></div>
					
				<c:choose>
					<c:when test = "${scale.equals(\"celsius\")}" >
					<c:url
						value="${weatherDay.highCelsius}"
						var="highCelsius" />
						<div>${weatherDay.highCelsius}&#x2103</div>
						<c:url
						value="${weatherDay.lowCelsius}"
						var="lowCelsius" />
						<div>${weatherDay.lowCelsius}&#x2103</div>
					</c:when>
					<c:otherwise>
						<div>${weatherDay.high}&#x2109</div>
						<div>${weatherDay.low}&#x2109</div>
					</c:otherwise>
				</c:choose>	
				<div><c:url value="${weatherDay.forecastMessage}" var="message" />
					${message}</div>
			</c:forEach>
	</div>--%>


<form class = "degreeToggle" action= "<c:url value = "/detail"/>" method = "post" class ="temperature">

	<input type ="hidden" id="${detailPark.parkcode}" name = "parkcode" value = "${detailPark.parkcode}">
		<button type ="submit" id="buttonTemp" name = "temperature" value ="celsius">Celsius</button>
		<button type ="submit" id="buttonTemp" name = "temperature" value ="fahrenheit">Fahrenheit</button>
</form>




	<div class="table">
    
    
    <div class ="card-group">
            <c:forEach items="${weatherMap}" var="weatherDay">
			<div class = "weather-card ${weatherDay.fiveDayForecastValue }" >
                <div class ="weather-image"><c:url
                        value="/img/weather/${weatherDay.forecastImageString}.png"
                        var="weatherImage" /> <img class = "card-image-top" src="${weatherImage}"
                    alt="${weatherImage }" /></div>
                    
                <c:choose>
                    
                    <c:when test = "${scale.equals(\"celsius\")}" >
                        <div class = "temp"> <b>High</b> ${weatherDay.highCelsius}&#x2103</div>
                        <div class = "temp"><b>Low</b> ${weatherDay.lowCelsius}&#x2103</div>
                    </c:when>
                    <c:otherwise>
                        <div class= "temp"> <b>High</b> ${weatherDay.high}&#x2109 </div>
                        <div class= "temp"> <b>Low</b> ${weatherDay.low}&#x2109 </div>
                    </c:otherwise>
                </c:choose> 
                <div class = "temp"><c:url value="${weatherDay.forecastMessage}" var="message" />
                 ${message}</div>
            </div>
            </c:forEach>
    </div>

</div>
<c:import url="/WEB-INF/jsp/common/footer.jsp" />






<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="com.flight.entities.Flight"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h1>Booking Details</h1>

	<c:choose>
		<c:when test="${not empty msg}">
			<p>${msg}</p>
		</c:when>
		<c:otherwise>
			<c:if test="${not empty reservation}">
				<table border="1">
					<tr>
						<th>Reservation ID</th>
						<th>Passenger Name</th>
						<th>Flight Number</th>
						<th>OperatingAirline</th>
						<th>DepartureCity</th>
						<th>ArrivalCity</th>
						<th>DateOfDeparture</th>
						<th>EstimatedDepartureTime</th>
					</tr>
					<tr>
						<td>${reservation.id}</td>
						<td>${reservation.passenger.firstName}</td>
						<td>${reservation.flight.flightNumber}</td>
						<td>${reservation.flight.operatingAirlines}</td>
						<td>${reservation.flight.departureCity}</td>
						<td>${reservation.flight.arrivalCity}</td>
						<td>${reservation.flight.dateOfDeparture}</td>
						<td>${reservation.flight.estimatedDepartureTime}</td>
					</tr>
				</table>
			</c:if>
		</c:otherwise>
	</c:choose>
</body>
</html>
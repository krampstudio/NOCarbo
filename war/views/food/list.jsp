<%@ page import="com.krampstudio.nopas.model.entities.FoodCategory"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div data-role="collapsible-set">
	
	<c:set var="categories" value="<%=FoodCategory.values()%>"/>
	
	<c:forEach var="category" items="${categories}">
		<div data-role="collapsible" data-collapsed="true" data-theme="d">
			<h3><c:out value="${category.description}" /></h3>
			<ul id="food-list-${category.id}" class="food-list" class data-role="listview" data-inset="true" data-theme="c"></ul>
		</div>
	</c:forEach>

</div>
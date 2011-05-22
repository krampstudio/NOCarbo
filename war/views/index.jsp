<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" 
 "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
<head>
	<title>No PAS</title>
	
	<link rel="stylesheet" type="text/css" href="/www/styles/jquery-ui/start/jquery-ui.custom.css" />
	<link rel="stylesheet" type="text/css" href="/www/styles/jquery.mobile/jquery.mobile.min.css" />
	<link rel="stylesheet" type="text/css" href="/www/styles/style.css" />
	
	<script type="text/javascript" src="/www/scripts/jquery.min.js"></script>
	<script type="text/javascript" src="/www/scripts/jquery-ui/jquery-ui.custom.min.js"></script>
	<script type="text/javascript" src="/www/scripts/controls.js"></script>
	<script type="text/javascript" src="/www/scripts/jquery.mobile/jquery.mobile.min.js"></script>
	
</head>
<body>
	
	<form id="token-form" name="token-form" style="display:none;">
		<input type="hidden" id="token" name="token" value="${sessionScope.token}" />
	</form>
	
	<!-- Add PAS page -->
	<div id="add-pas" data-role="page" data-theme="b">
		<%@ include file="header.jsp" %>
		<div  data-role="content">
			
		</div> 
		<%@ include file="footer.jsp" %>
	</div> 

	<!-- Add food page -->
	<div id="add-food" data-role="page" data-theme="b">
		<%@ include file="header.jsp" %>
		<div  data-role="content" data-theme="d">
			<form id="search-form">
				<div data-role="fieldcontain">
					<label for="search-food">Search for existing food</label>
					<input id="search-food" name="search-food" type="text" data-inline="true"  data-type="search" data-inline="true"/>
				</div>
			</form>
			<hr />
			<form id="food-form">
				
				<div data-role="fieldcontain">
					<label for="food-name">Name</label>
					<input id="food-name" name="food-name" type="text" />
				</div>
				<div data-role="fieldcontain">
					<label for="food-description">Description</label>
					<textarea id="food-description" name="food-description"></textarea>
				</div>
				<div data-role="fieldcontain">
					<label for="food-brand">Brand</label>
					<input id="food-brand" name="food-brand" type="text" />
				</div>
				<div data-role="fieldcontain">
					<label for="food-menu">Add to today's menu</label>
					<select name="food-menu" id="food-menu" data-role="slider">
						<option value="no">No</option>
						<option value="yes">Yes</option>
					</select> 
				</div>
				<div data-role="fieldcontain" >
					<button id="food-save" rel="external" name="food-save" data-inline="true" data-theme="b">save</button>
					<button id="food-remove" name="food-remove" disabled="true" data-inline="true">Remove</button>
				</div>
			</form>
		</div> 
		
		<%@ include file="footer.jsp" %>
	</div> 
	
</body>
</html>
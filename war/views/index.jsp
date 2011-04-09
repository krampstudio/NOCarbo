<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" 
 "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
<head>
	<title>No PAS</title>
	
	<link rel="stylesheet" type="text/css" href="www/scripts/jquery.mobile/jquery.mobile.min.css" />
	<link rel="stylesheet" type="text/css" href="www/styles/style.css" />
	
	<script type="text/javascript" src="www/scripts/jquery.min.js"></script>
	<script type="text/javascript" src="www/scripts/jquery.mobile/jquery.mobile.min.js"></script>
	
</head>
<body>
	
	<!-- Add PAS page -->
	<div id="add-pas" data-role="page" data-theme="b">
		<%@ include file="header.jsp" %>
		<div  data-role="content">
			
			PAS
			
		</div> 
		<%@ include file="footer.jsp" %>
	</div> 

	<!-- Add food page -->
	<div id="add-food" data-role="page" data-theme="b">
		<%@ include file="header.jsp" %>
		<div  data-role="content">
			
			FOOD
			
		</div> 
		<%@ include file="footer.jsp" %>
	</div> 
	
</body>
</html>
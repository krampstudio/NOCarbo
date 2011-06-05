<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" 
 "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
<head>
	<title>No PAS</title>
	
	<link rel="stylesheet" type="text/css" href="/www/styles/jquery-ui/start/jquery-ui.custom.css" />
	<link rel="stylesheet" type="text/css" href="/www/styles/jquery.mobile/jquery.mobile.min.css" />
	<link rel="stylesheet" type="text/css" href="/www/styles/style.css" />
	
	<script type="text/javascript" src="/www/scripts/lib/jquery.min.js"></script>
	<script type="text/javascript" src="/www/scripts/lib/jquery.tmpl.min.js"></script>
	<script type="text/javascript" src="/www/scripts/lib/jquery-ui.custom.min.js"></script>
	<script type="text/javascript" src="/www/scripts/controls.js"></script>
	<script type="text/javascript" src="/www/scripts/lib/jquery.mobile.min.js"></script>
</head>
<body>
	<form id="token-form" style="display:none;">
		<div>
			<input type="hidden" id="token" name="token" value="${sessionScope.token}" />
		</div>
	</form>
	
	<!-- Add PAS page -->
	<div id="add-pas" data-role="page" data-theme="b">
		<%@ include file="header.jsp" %>
		<div  data-role="content">
			
		</div> 
		<%@ include file="footer.jsp" %>
	</div> 
	
		<!-- List food page -->
	<div id="list-food" data-role="page" data-theme="b">
		
		<%@ include file="header.jsp" %>
		
		<%@ include file="food/menu.jsp" %>
		
		<%@ include file="message.jsp" %>
		
		<div  data-role="content" data-theme="d">
			<%@ include file="food/list.jsp" %>
		</div> 
		
		<%@ include file="footer.jsp" %>
	</div> 
	
		<!-- Search food page -->
	<div id="search-food" data-role="page" data-theme="b">
		
		<%@ include file="header.jsp" %>
		
		<%@ include file="food/menu.jsp" %>
		
		<%@ include file="message.jsp" %>
		
		<div  data-role="content" data-theme="d">
			<%@ include file="food/search.jsp" %>
			
			<div id="search-form-container" style="display:none;">
				<%@ include file="food/form.jsp" %>
			</div>
		</div> 
		
		<%@ include file="footer.jsp" %>
	</div> 

	
	<!-- Add/Edit food page -->
	<div id="save-food" data-role="page" data-theme="b">
		
		<%@ include file="header.jsp" %>
		
		<%@ include file="food/menu.jsp" %>
		
		<%@ include file="message.jsp" %>
		
		<div  data-role="content" data-theme="d">
			<%@ include file="food/form.jsp" %>
		</div> 
		
		<%@ include file="footer.jsp" %>
	</div> 
	

	
</body>
</html>
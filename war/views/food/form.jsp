<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<form class="food-form">
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
		<input type="hidden" id="food-id" name="food-id" />
		<button id="food-save" name="food-save" data-inline="true" data-theme="b">save</button>
		<button id="food-remove" name="food-remove" disabled="disabled" data-inline="true">Remove</button>
	</div>
</form>

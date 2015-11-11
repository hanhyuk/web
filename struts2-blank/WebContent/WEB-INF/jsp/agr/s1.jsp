<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html ng-app>
	<body>
	
	<div>
      <label>Name:</label>
      <input type="text" ng-model="yourName" placeholder="Enter a name here">
      <hr>
      <h1>Hello {{yourName}}!</h1>
    </div>
    
	<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.7/angular.js"></script>
	<script type="text/javascript"></script>
	</body>
</html>

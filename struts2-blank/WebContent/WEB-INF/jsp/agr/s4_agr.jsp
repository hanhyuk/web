<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!-----------------------------------------------------------------------------

	$scope.myVar 의 값이 변경 될 경우 alert 메세지를 띄우는 예제
	
------------------------------------------------------------------------------>
<html ng-app="myApp" ng-controller='myWatch'>
<body>
	{{myVar}}
	<button type='button' ng-click='myClick()'>click!</button>
	
<%--     <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script> --%>
	<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.7/angular.js"></script>
	<script src="/assets/js/cmn.js"></script>
	<script type="text/javascript">
	var myApp = angular.module('myApp', []);
	myApp.controller('myWatch', function($scope) {
		$scope.myVar = 1;
		
// 		$scope.$watch("myVar", function(){
// 			alert('changed!');
// 		});
		
		$scope.$watch(function() {
			//return $scope.myVar;	//변수 자체를 넘겨도 된다.
			return "myVar";			//변수명을 넘겨도 된다.
		}, function(newVal, oldVal, scope){
			//newVal 변경 값, oldVal 이전 값, scope 컨트롤러의 scope
			console.log('changed!', 'newVal=', newVal, 'oldVal=', oldVal, 'scope.myVar=', scope.myVar);
		});
		
		$scope.myClick = function() {
			$scope.myVar = 2;
		};
	});
	</script>
	
</body></html>

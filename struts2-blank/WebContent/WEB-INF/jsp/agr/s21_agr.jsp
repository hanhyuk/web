<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!-----------------------------------------------------------------------------

	페이지가 뜰때 리스트를 조회해서 화면에 뿌리는 예제 - angularJS 버전
	
	- s2_agr.jsp 샘플에서 tr 내용이 깜빡이는 문제가 있었는데 이걸 개선한 버전이다.
	$compile을 사용해서 html 을 처리한다.
	참고자료 : http://odetocode.com/blogs/scott/archive/2014/05/07/using-compile-in-angular.aspx
	
------------------------------------------------------------------------------>
<html ng-app='myApp' ng-controller="list"><body>

	<table border=1>
		<thead>
			<tr>
				<td>no</td><td>name</td><td>address</td>
			</tr>
		</thead>
		<!-- directive 사용시 네이밍은 snake-name 형식으로 사용 -->
		<tbody data-my-content></tbody>
	</table>    
    
<%--     <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script> --%>
	<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.7/angular.js"></script>
	<script src="/assets/js/cmn.js"></script>
	<script type="text/javascript">
		var myApp = angular.module('myApp', []);
		myApp.controller('list', function($scope, $http) {
			
			$http({
				method : 'post',
				url : '/agr/getList'
			}).then(function success(result){
				//console.log(result.data); console.log(result.status); console.log(result.headers); console.log(result.config); console.log(result.statusText);
				//원래는 JSON.parse(result.data) 처리를 해야 하는데 알아서 object 로 변환처리해 준다.
				$scope.jo = result.data;
			}, function error(result) {
				
			});
		});
	
		//javascript에서 directive 사용시 camel-name 형식으로 사용
		myApp.directive("myContent", function($compile) {
			return {
				link : function(scope, element, attrs) {
					var tplHtml = "";
					
					//tplHtml 내용에 angularJS의 요소가 포함될 경우 $compile을 호출해서 인식 될수 있도록 처리한다.
					tplHtml += "<tr ng-repeat='row in jo'>"
							 + "<td>{{row.no}}</td><td>{{row.name}}</td><td>{{row.address}}</td>"
							 + "</tr>";
							 
					element.append($compile(tplHtml)(scope));
				}
			};
		});
	</script>
	
</body></html>

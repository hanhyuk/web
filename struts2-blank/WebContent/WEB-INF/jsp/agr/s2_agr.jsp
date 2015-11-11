<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!-----------------------------------------------------------------------------

	페이지가 뜰때 리스트를 조회해서 화면에 뿌리는 예제 - angularJS 버전
	
------------------------------------------------------------------------------>
<html ng-app='myApp' ng-controller="list"><body>

	<table border=1>
		<thead>
			<tr>
				<td>no</td><td>name</td><td>address</td>
			</tr>
		</thead>
		<tbody>
			<!-- 
				아래 tr 내용이 잠깐 나타난다.(깜빡임) 이거 어떻게 안나타나게 하는방법 없을까?
				- 페이지 로드가 끝나고 나서 angular 라이브러리 로딩 사이의 딜레이 때문인듯 하다. -  
			-->
			<tr ng-repeat="row in jo">
				<td>{{row.no}}</td><td>{{row.name}}</td><td>{{row.address}}</td>
			</tr>
		</tbody>
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
	
	
// 		window.onload = function() {
// 			var pm = {};
			
// 			Cmn.ajax('/agr/getList', pm, function(result) {
// 				var jo = JSON.parse(result);
// 				var joLen = jo.length;
// 				var tplHtml = "<tr><td>_no_</td><td>_name_</td><td>_address_</td></tr>";
// 				var innerHtml = "";
				
// 				for( var i=0; i<joLen; i++ ) {
// 					innerHtml += tplHtml.replace('_no_', jo[i].no).replace('_name_', jo[i].name).replace('_address_', jo[i].address)
// 				}
// 				$('#list').html(innerHtml);
// 			}, function(xhr, status, exception) {
// 				alert('error');
// 			});
// 		};
	</script>
	
</body></html>

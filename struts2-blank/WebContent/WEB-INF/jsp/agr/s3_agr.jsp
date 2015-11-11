<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!-----------------------------------------------------------------------------

	기본 tree view + node 클릭시 node에 지정된 URL 로 이동하는 예제
	
------------------------------------------------------------------------------>
<html ng-app="myApp"><body>

	<div
	  data-angular-treeview
	  data-tree-model="treedata"		<%// $scope.treedata %>	
	  data-node-id="id"
	  data-node-label="label"
	  data-node-children="children" >
	</div>    
<%--     <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script> --%>
	<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.7/angular.js"></script>
	<script src="/assets/js/cmn.js"></script>
	<script type="text/javascript">
	
	//angularJS application에 내가 만든 모듈이 주입되도록 할때 사용한다. 	
	(function(angular) {
		// 기능작성
	})(angular);
	
	(function(angular) {
		
	})(angular);
	
	</script>
	
</body></html>

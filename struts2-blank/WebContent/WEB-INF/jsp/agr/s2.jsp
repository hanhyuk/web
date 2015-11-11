<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!-----------------------------------------------------------------------------

	페이지가 뜰때 리스트를 조회해서 화면에 뿌리는 예제
	
------------------------------------------------------------------------------>
<html><body>
	
	<table border=1>
		<thead>
			<tr>
				<td>no</td><td>name</td><td>address</td>
			</tr>
		</thead>
		<tbody id="list"></tbody>
	</table>    
	
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.7/angular.js"></script>
	<script src="/assets/js/cmn.js"></script>
	<script type="text/javascript">
	
		window.onload = function() {
			var pm = {};
			
			Cmn.ajax('/agr/getList', pm, function(result) {
				var jo = JSON.parse(result);
				var joLen = jo.length;
				var tplHtml = "<tr><td>_no_</td><td>_name_</td><td>_address_</td></tr>";
				var innerHtml = "";
				
				for( var i=0; i<joLen; i++ ) {
					innerHtml += tplHtml.replace('_no_', jo[i].no).replace('_name_', jo[i].name).replace('_address_', jo[i].address)
				}
				$('#list').html(innerHtml);
			}, function(xhr, status, exception) {
				alert('error');
			});
		};
	</script>
	
</body></html>

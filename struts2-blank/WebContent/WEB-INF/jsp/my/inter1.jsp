<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
	<head><title>inter1</title></head>
	<body>
	<form action="inter2">
		
		SampleInterceptor에서 추가한 세션 값을 출력 -> ${session.sesVal1} <br/>
		<input type="text" name="param1"/>
		<input type="submit" value="값넘기기"/>
	</form>
	</body>
</html>

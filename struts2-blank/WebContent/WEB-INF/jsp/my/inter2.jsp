<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
	<head><title>inter1</title></head>
	<body>
	inter1 페이지에서 넘긴값 -> ${param1}<br/>
	sampleInterceptor2 에서 액션 호출전에 셋팅한값 -> ${before}<br/>
	inter2 액센에서 셋팅한값 -> ${setValue}<br/>
	sampleInterceptor2 에서 액션 호출후에 셋팅한값 -> ${after}<br/>
	--> ${respVal}
	</body>
</html>

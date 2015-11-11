<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
	<head><title>sample1</title></head>
	<body>
		현재 locale : ${myLocale}<br/>
		
		<s:text name="HelloWorld.message"/><br/>
		
		<s:url id="url" action="sample1"/>
        <s:a class="test" href="%{url}">locale 값을 한글로 변경</s:a><br/>
        
		<s:url id="url" action="sample2"/>
        <s:a class="test" href="%{url}">locale 값을 영어로 변경</s:a>
	</body>
</html>

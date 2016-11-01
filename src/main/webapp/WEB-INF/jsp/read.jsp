<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<html>
<body>
	<h1>Read Value</h1>
	
	<br>
	${key}
	<br>
	${value}

	<br>
    <a href="/webproject"><spring:message code="app.goHome"/></a>
</body>
</html>
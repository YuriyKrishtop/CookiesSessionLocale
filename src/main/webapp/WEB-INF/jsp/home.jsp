<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<html>
<head>
</head>
<body>
    <h1><spring:message code="app.welcome"/></h1>
    <span style="margin-left:1px">
        <a href="?lang=en">en</a>
        |
        <a href="?lang=de">de</a>
        |
        <a href="?lang=ru">ru</a>
    </span>
    <p></p>
    <br>
    <a href="writeCookie">Write Cookie Value</a>
	<br>
	<a href="readCookie">Read Cookie Value</a>
	<br>
    <a href="writeSession">Write Session Value</a>
	<br>
    <a href="readSession">Read Session Value</a>
</body>
</html>
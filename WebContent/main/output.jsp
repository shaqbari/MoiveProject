<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	
	
</head>
<body>
	<%
		// ?name=홍길동
		//	==== ==== Map
		String name=request.getParameter("name");
	%>
	<%=name %>
</body>
</html>
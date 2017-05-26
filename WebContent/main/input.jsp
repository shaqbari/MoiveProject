<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	
	<!--
		페이지 변경
		1) HTML
			<a> : GET ==> URL?
			<form> => action => GET/POST
		2) Java
			sendRedirect() ==>GET
			forward() ==>GET
		3) JavaScript 
			location.href="" ==>GET
	
		URL?id=aaa&pwd=1234//보안이 요구되기 때문에 post를 써야 한다.
		//보내는 양이 많을경우도 post를 쓴다.
		
		==> 한글
		GET ==> server.xml
			<Connector URIEncoding="UTF-8"> 이나
			<Connector URIEncoding="EUC-KR"> 이나
		POST ==> 받을때마다 setCharacterEncoding("UTF-8")
		
		==>브라우저 : ASC(8bit)
					Unicode : 16bit
	
	  -->
</head>
<body>
	<a href="output.jsp?name=홍길동">Click</a><!-- 인터넷 익스플로러는 한글주소 인식을 못한다. -->
</body>
</html>
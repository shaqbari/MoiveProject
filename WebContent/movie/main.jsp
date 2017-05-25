<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%/* <!-- 
	1) JSP (JAVA SERVER Page)
	=지시자
		1. page : jsp에 대한 정보
			contentType : text/html, text/xml
			import : 자바라이브러리 읽기
			errorPage 
				= 404 : 파일이 없는경우	
				= 500 : 소스번역에 에러
				= 401 : 인증에러
				= 415 : 변환코드 에러 => EUC-KR > ECU-KR
				= 200 : 정상수행
				
		2. taglib : 자바문법(제어문) => 태그형으로 제작
			core ==> 제어문, URL
				<c:forEach>, <c:if>, <c:redirect>
			format ==> 날짜변환
				<fmt:formatDate> SimpleDateFormat
			sql => DAO쓰기 때문에 잘 안쓴다.
			xml => JAXP, JAXB(*****)(binding을 쓰기 때문에 해석하기 좋다)
			fn => function(String, List) java코드에서 쓰는게 더 좋다
		
		3. include
			<%@ include> VS <jsp:include>
		
			<%@ include>정적! 고정된 파일 넣을때 사용한다. 컴파일하기 전에  java 소스(.jsp)가 합쳐진다. 스태틱변수로 사용된다.(같은변수 쓸때 사용된다.)
			 주메뉴, footer 등에 자주 쓰인다.
			
			<jsp:include>동적! 고정이 안되는 파일 넣을대 쓴다. 컴파일 한 후  html 소스가 합쳐진다. 다른변수를 쓸때 사용된다.
			이게 더 많이 쓰인다. 부메뉴, 로그인등에 자주 쓰인다. 
			
	=스크립트	
		<%  % >스크립틀릿(일반 자바)
		<%! % >선언문
		<%= % >표현문(브라우저 출력)
		HTML + JAVA
		
		a.jsp
		<html>
		<body>
			<%! int a=0; % >
			<% ="Hello Java"	% >
		</body>
		</html>
		
		==> a_jsp.java
		public class a_jsp extends HttpServlet{
			
			int i=10;
			public void service(HttpServletRequest request, HttpServletResponse response){//메소드 영역이라는 것을 잘 알아두자
				out.println("<html>");
				out.println("<body>);
				out.println("Hello Java");
				out.println("</body>);
				out.println("</html>);
			}
			
		}
		
	= jsp action tag
			<jsp:useBean id="mem" class="Member">
			==> Member mem=new Member();
			<jsp:setProperty><jsp:getProperty>
			================================================
			
			<jsp:include>
			<jsp:forward> ==>jsp 흐름
		
	= 내장 객체
		http://localhost:8080/MovieProject/movie/main.jsp        :    URL
		=====================
							 =====================	:    URI
		====   ========= ==== 서버정보
		프로토콜     서버주소    포트   
		                      ============
		                      ContextPath
		
	    ***** request : HttpServletRequest
			=>서버 정보
				getServerInfo()
				getPort()
			=>클라이언트 정보
				getRequestURI()
				getRequestURL()
				getContextPath()
				getRemoteAddress() : ip정보얻어 저장했다가 너무 자주 접근하면 접속차단(403에러 뜨게) 
			=>요청 정보
				(String)getParameter()
				(String[])getParameterValues()
				문자열만 넘어간다는 것을 기억하자!
					
					==>스프링에서 public void insert(MemverVO vo)를 이용하면 그냥 들어간다. 
					
			=>추가 정보
				setAttribute()
				getAttribute()
				
		***** response : HttpServletResponse
		***** session : HttpSession
		out	: JspWriter
		***** application : ServletContext
		exception : Exception
		config : ServletConfig => web.xml
		page : Object
		***** pageContext : PageContext

		
		<table border=1 width=800>
		<tr>
			<td>1</td>
			<td>2</td>
			<td>3</td>
			<td>4</td>
			<td>5</td>
			<td>6</td>
		</tr>
		<tr>
		<% 
			for(int i=1; i<=9; i++){
				out.print("<tr>");
				for(int j=1; j<=6; j++){
					out.print("<td></td>");
					
				}
				out.print("</tr>");
			}
			
		% >
		
		아래가 더 보기 쉽다.
		<c:forEach var="i" begin="1" end="9">
			<tr>
			<c:forEach var="j" begin="1" end="6">
				<td></td>
			</c:forEach>
			</tr>
		</c:forEach>
		
--> */
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%! int i=0; %>
<body>
	<%="Hello JAVA!!" %>
</body>
</html>
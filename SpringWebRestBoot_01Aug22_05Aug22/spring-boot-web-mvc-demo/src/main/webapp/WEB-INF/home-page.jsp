<%@page import="java.time.LocalDate"%>
<html>
	<head>
		<title>My Spring App</title>
	</head>	
	<body>
		<jsp:include page="/header" />
		<section>
			<h4>Home Page</h4>
			<p>This is really exciting to see my first web page on spring web mvc on spring boot.</p>
			<p> Today it is <%=LocalDate.now() %> </p>
		</section>
	</body>
</html>
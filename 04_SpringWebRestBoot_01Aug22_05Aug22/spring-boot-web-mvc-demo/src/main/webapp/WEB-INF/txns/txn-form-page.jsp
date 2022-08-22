<%@page import="com.cts.sbwrd.entity.TxnType"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
	<head>
		<title>My Spring App</title>
		
		<style>
			section{
				border:1px solid #000000;
				margin:auto;
				margin-top:5px;
				width:40%;
				padding:2%;
			}
			
			label{
				display:inline-block;
				width:30%;
				margin:2px;
				text-align:right;
				font-weight:bolder;
			}
			input,select {
				display:inline-block;
				width:60%;
				margin:2px;
			}
		</style>
	</head>	
	<body>
		<jsp:include page="/header" />
		<section>
			<h3>Transaction Form</h3>
			
			<form:form method="POST" modelAttribute="txn">
				<div>
					<form:label path="txnId">Transaction#</form:label>
					<form:input path="txnId" readonly="true" />
				</div>
				<div>
					<form:label path="desp">Description</form:label>
					<form:input path="desp" />
					<form:errors path="desp"></form:errors>
				</div>
				<div>
					<form:label path="txndate">Transaction Date </form:label>
					<form:input path="txndate" type="date" />
					<form:errors path="txndate"></form:errors>
				</div>
				<div>
					<form:label path="amount">Amount </form:label>
					<form:input path="amount" type="number" />
					<form:errors path="amount"></form:errors>
				</div>
				<div>
					<form:label path="type">Transaction Type</form:label>
					<form:select path="type" items="${TxnType.values() }" />
					<form:errors path="type" ></form:errors>
				</div>
				<div style="text-align:right;margin:4px;">
					<button>SAVE</button>
				</div>
			</form:form>
		</section>
	</body>
</html>
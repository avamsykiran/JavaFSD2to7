<%@page import="com.cts.sbwmd.entity.TxnType"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<html>
	<head>
		<title>My Spring App</title>
	</head>	
	<body>
		<jsp:include page="/header" />
		<section>
			<h3>Income Statement</h3>
			
			<c:choose>
				<c:when test="${txns.isEmpty() }">
					<p><strong>No records to display</strong>
				</c:when>
				<c:otherwise>
					<table style="border:1px solid #000000; width:95%;margin:auto;">
						<thead>
							<tr>
								<th>Txn#</th>
								<th>Date</th>
								<th>Header</th>
								<th>Credit</th>
								<th>Debit</th>
								<th></th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="t" items="${txns }">
								<tr>
							                                                                                                                                                                                                                             		<td style="text-align:right">${t.txnId}</td>
									<td style="text-align:center">${t.txndate }</td>
									<td style="text-align:left">${t.desp }</td>
									<td style="text-align:right">${t.type==TxnType.CREDIT?String.valueOf(t.amount):"" }</td>
									<td style="text-align:right">${t.type==TxnType.DEBIT?String.valueOf(t.amount):"" }</td>
									<td style="text-align:center">
										<a 
										style="display:inline-block;margin:2px;padding:5px;text-decoration:none;border:1px solid #000000" 
										href="/txns/delete?id=${t.txnId }">delete</a>
											<a 
										style="display:inline-block;margin:2px;padding:5px;text-decoration:none;border:1px solid #000000" 
										href="/txns/edit?id=${t.txnId }">edit</a>
									</td>
								</tr>
							</c:forEach>
						</tbody>
						<tfoot>
							<tr>
								<th style="text-align:right" colspan="3"> Total</th>
								<th style="text-align:right" > ${totalCredit }</th>
								<th style="text-align:right" > ${totalDebit }</th>
								<th></th>
							</tr>
							<tr>
								<th style="text-align:right" colspan="4"> Balance</th>
								<th style="text-align:right" > ${balance }</th>
								<th></th>
							</tr>
						</tfoot>
					</table>
				</c:otherwise>
			</c:choose>
		</section>
	</body>
</html>
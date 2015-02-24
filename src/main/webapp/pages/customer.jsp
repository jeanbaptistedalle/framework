<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
</head>

<body>
	<h1>Struts 2 + Spring + Hibernate</h1>

	<h2>All Customers</h2>

	<s:if test="customerList != null && customerList.size() > 0">
		<table>
			<tr>
				<th>Customer Id</th>
				<th>Name</th>
				<th>Address</th>
				<th>Created Date</th>
				<th></th>
				<th></th>
			</tr>
			<s:iterator value="customerList" var="customer"
				status="userStatus">
				<tr>
					<td>${customer.customerId}</td>
					<td>${customer.name}</td>
					<td>${customer.address}</td>
					<td>${customer.formatCreatedDate}</td>
					<td><s:url id="deleteAction" action="deleteCustomerAction">
							<s:param name="customerId" value="customerId" />
						</s:url> <s:a href="%{deleteAction}">delete</s:a></td>
					<td><s:url id="editAction" action="editCustomerAction">
							<s:param name="customerId" value="customerId" />
						</s:url> <s:a href="%{editAction}">edit</s:a></td>
				</tr>
			</s:iterator>
		</table>
	</s:if>

	<s:url id="createAction" action="editCustomerAction" />
	<s:a href="%{createAction}">create customer</s:a>
</body>
</html>
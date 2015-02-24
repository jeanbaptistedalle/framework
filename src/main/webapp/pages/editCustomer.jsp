<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
</head>

<body>
	<h1>Struts 2 + Spring + Hibernate</h1>

	<h2>Add Customer</h2>
	<s:form action="saveCustomerAction">
		<s:textfield name="customer.name" label="Name" />
		<s:textarea name="customer.address" label="Address" cols="50" rows="5" />
		<s:submit />
	</s:form>

	<s:url id="listAction" action="listCustomerAction" />
	<s:a href="%{listAction}">back</s:a>
</body>
</html>
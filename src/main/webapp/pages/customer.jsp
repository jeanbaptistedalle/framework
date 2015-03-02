<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
</head>

<body>
	<h1>Struts 2 + Spring + Hibernate</h1>

	<h2>All Customers with their orders</h2>

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
			<!-- Grâce à s.iterator, on peut iterer sur une liste se situant dans le code java. 
				Ici, on itère donc sur customerList, qui se trouve dans la classe ListCustomerAction
				et on stocke l'utilisateur actuel dans la variable customer -->
			<s:iterator value="customerList" var="customer" status="userStatus">
				<tr>
					<!-- On utilise ici une notation EL pour accéder aux attributs de customer-->
					<td>${customer.customerId}</td>
					<!-- customer.customerId appelle en fait customer.getCustomerId(), il faut donc 
					respecter rigouresement la syntaxe des getters/setters 
					(à savoir minuscule pour le premier mot, majuscule pour les suivants) -->
					<td>${customer.name}</td>
					<td>${customer.address}</td>
					<td>${customer.formatCreatedDate}</td>

					<!-- On définit ici une url qui référence une action, puis on l'affecte à un lien -->
					<td><s:url id="deleteAction" action="deleteCustomerAction">
							<s:param name="customerId" value="customerId" />
						</s:url> <s:a href="%{deleteAction}">delete</s:a></td>

					<td><s:url id="editAction" action="editCustomerAction">
							<s:param name="customerId" value="customerId" />
						</s:url> <s:a href="%{editAction}">edit</s:a></td>
					<td><s:url id="addOrder" action="addOrderAction">
							<s:param name="customerId" value="customerId" />
						</s:url> <s:a href="%{addOrder}">new order</s:a></td>
				</tr>
				<!-- ici, orderCustomers fait appel à la méthode getOrderCustomers()
				 qui renvoie la liste contenue dans le client courant de la boucle -->
				<s:if test="orderCustomers != null && orderCustomers.size() > 0">
					<s:iterator value="orderCustomers" var="orderCustomer"
						status="orderStatus">
						<tr>
							<td />
							<td>Commande N°</td>
							<td>${orderCustomer.orderCustomerId}</td>
							<td>réalisée le</td>
							<td>${orderCustomer.orderDate}</td>
					<td><s:url id="deleteOrder" action="deleteOrderAction">
							<s:param name="orderCustomerId" value="orderCustomerId" />
						</s:url> <s:a href="%{deleteOrder}">delete</s:a></td>
						</tr>
					</s:iterator>
				</s:if>
			</s:iterator>
		</table>
	</s:if>

	<s:url id="createAction" action="editCustomerAction" />
	<s:a href="%{createAction}">create customer</s:a>
</body>
</html>
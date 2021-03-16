
<%@ include file="common/navigation.jspf" %>
<%@ include file="common/header.jspf" %>

<div class = "container">
	<table class="table table-striped">
		<caption>Hi ${name},Your Todos are</caption>
		<thead>
			<tr>
				<th>Description</th>
				<th>Target Date</th>
				<th>Done?</th>
				<th></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${todos}" var= "todo">
				<tr>
					<td>${todo.desc}</td>
					<td><fmt:formatDate pattern="dd/MM/yyyy" value="${todo.targetDate}" /></td>
					<td>${todo.done}</td> 
					<td>
						<a href ="/update-todo?id=${todo.id}" class="btn btn-info">Update todo</a>
						<a href ="/delete-todo?id=${todo.id}" class="btn btn-danger">Delete todo</a>
					</td>
				</tr>
				
			</c:forEach>
		</tbody>
	</table>
	
	
	<div>
	<a class ="btn btn-success" href="/add-todo">Add</a>
	</div>
	
	
</div>
<<script type="text/javascript">

</script>
<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</body>
</html>
 
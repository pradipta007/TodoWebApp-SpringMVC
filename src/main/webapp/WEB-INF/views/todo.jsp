<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
	rel="stylesheet">
<title>Add todo</title>
</head>
<body>
	<div class="container">	
		<form:form method="post" commandName="todo">
				<form:hidden path="id"/>
				<h1>Add a todo</h1>
				<fieldset class="form-group">
					<form:label path="desc">Description</form:label> 
					<form:input path="desc" type="text" class="form-control" required="required"></form:input>
				</fieldset>
				<fieldset class="form-group">
					<form:label path="targetDate">Target Date</form:label> 
					<form:input path="targetDate" type="text" class="form-control" required="required"></form:input>
				</fieldset>
				<input type="submit" value="Submit" class="btn btn-success">
		</form:form>
	</div>
	<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
	<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
	 <script>
       
    </script>
</body>
</html>

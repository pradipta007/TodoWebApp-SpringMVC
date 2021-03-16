<%@ include file="common/navigation.jspf" %>
<%@ include file="common/header.jspf" %>

<div class="container">
	
	<label>Welcome ${name} <br>
	<p>
		Manage your todos <a href="/list-todos">click here</a>
	</p>

</div>


<<script type="text/javascript">
$(document).ready(function(){
	   $(".active").removeClass("active");
	   $("#home").addClass("active");
	});
</script>

<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>

</body>
</html>
 
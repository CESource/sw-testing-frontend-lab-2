<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE HTML>
<html lang="en">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
	<meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
	<meta http-equiv="X-UA-Compatible" content="ie=edge">
	<title>SampleForm</title>

	<link rel="stylesheet" href="//cdnjs.cloudflare.com/ajax/libs/foundation/6.4.3/css/foundation.min.css" type="text/css"/>
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.css">

	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/foundation/6.4.3/js/foundation.min.js"></script>
</head>

<body>

<% if (request.getParameter("student") != null) { %>
<div class="row column large-4 small-centered">
	<div class="callout success autoclose">
		<p class="text-center">Congratulations, Students receive a 50% discount!</p>
	</div>
</div>
<% } %>
<% if (request.getParameter("student") == null) { %>
<div class="row column large-4 small-centered">
	<div class="callout success autoclose">
		<p class="text-center">Congratulations, you were successfully registered!</p>
	</div>
</div>
<% } %>

<div class="callout" style="width: 600px; margin: 80px auto;">
	<div class="grid-x">
		<h4 class="cell text-center">You entered</h4>
		<div class="cell a_name">
			Name: <span><%= request.getParameter("firstname") %> <%= request.getParameter("lastname") %></span>
		</div>

		<div class="cell a_birthday">
			Birthday: <span><%= request.getParameter("birthday") %></span>
		</div>

		<div class="cell a_gender">
			Gender: <span><%= request.getParameter("gender") %></span>
		</div>

		<div class="cell a_uni">
			University: <span><%= request.getParameter("uni") %></span>
		</div>

		<div class="cell a_acknowledgements">
			Acknowledgements:
			<span><%= request.getParameter("student") != null ? "student" : "non-student" %></span>
		</div>
		<div class="cell a_button">
			<a href="index.html">Back</a>
		</div>
	</div>
</div>

<script>
	$(document).ready(function () {
		$(document).foundation();
		$('.callout.autoclose').delay(1500).slideUp(200);
	});
</script>

</body>
</html>

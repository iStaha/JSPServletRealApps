<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<html>
<head>
<title>Ajax</title>
<script
  src="https://code.jquery.com/jquery-3.4.1.min.js"
  integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo="
  crossorigin="anonymous"></script>
<script type="text/javascript">
	$(document).ready(function() {

		$('#buttonDisplay').click(function() {
			$.ajax({
				type : 'GET',
				headers : {
					Accept : "application/json; charset=utf-8",
					"Content-Type" : "application/json; charset=utf-8"
				},
				url : '${pageContext.request.contextPath }/ajax',
				success : function(result) {
					var product = $.parseJSON(result);
					var s = 'Id: ' + product.id + '<br>';
					s += 'Name: ' + product.name + '<br>';
					s += 'Price: ' + product.price;
					$('#result').html(s);
				}
			});
		});

	});
</script>
</head>
<body>

	<h3>Return Object in Ajax</h3>
	<form>
		<input type="button" value="Dislay" id="buttonDisplay">
		<br>
		<span id="result"></span>
	</form>

</body>
</html>
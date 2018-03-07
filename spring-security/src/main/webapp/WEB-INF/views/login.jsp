<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <meta charset="UTF-8"/>
  <title>Log in</title>
</head>
<body>
	<p><font color="red">${errorMessage}</font></p>
	<form action="/login" method="post">
		Name: <input type="text" name="username"/>
		Password: <input type="password" name="password"/>
		<input type="submit"/>
	</form>
</body>
</html>
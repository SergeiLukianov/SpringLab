<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
  <meta charset="UTF-8"/>
  <title>Welcome!</title>
</head>
<body>
	<h1>Welcome on board, ${person.username}</h1>
	<p>Username :: ${person.username}</p>
	<p>Email :: ${person.email}</p>
	<p>Password :: ${person.password}</p>
</body>
</html>
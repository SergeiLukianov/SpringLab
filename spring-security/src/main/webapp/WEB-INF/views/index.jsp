<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
<head>
</head>
<body>
    <div>
        <div class="container">
            <h1>This is secured!</h1>
            <p>Hello<b><c:out value="${pageContext.request.remoteUser}"/></b></p>
        </div>
    </div>
</body>
</html>
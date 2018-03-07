<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
<h1>Registration form</h1>
<form action="/registernewuser" method="post">
    <div>
        <label>Name:</label>
        <input type="text"/>
    </div>
    <div>
        <label>Password:</label>
        <input type="password"/>
    </div>
    <div>
        <label>Confirm password</label>
        <input type="password"/>
    </div>
    <button type="submit">submit</button>
</form>
</body>
</html>
<%@ page language="java" %>
<html>
<head><title>Add User</title></head>
<body>
<h1>Add User</h1>
<form action="UserServlet" method="post">
    <input type="hidden" name="action" value="add" />
    <label>Name:</label><input type="text" name="name" /><br/>
    <label>Email:</label><input type="text" name="email" /><br/>
    <button type="submit">Submit</button>
</form>
</body>
</html>

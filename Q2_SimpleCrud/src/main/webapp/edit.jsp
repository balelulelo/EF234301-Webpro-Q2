<%@ page language="java" %>
<html>
<head><title>Edit User</title></head>
<body>
<h1>Edit User</h1>
<form action="UserServlet" method="post">
    <input type="hidden" name="action" value="edit" />
    <input type="hidden" name="id" value="<%= ((User) request.getAttribute("user")).getId() %>" />
    <label>Name:</label><input type="text" name="name" value="<%= ((User) request.getAttribute("user")).getName() %>" /><br/>
    <label>Email:</label><input type="text" name="email" value="<%= ((User) request.getAttribute("user")).getEmail() %>" /><br/>
    <button type="submit">Submit</button>
</form>
</body>
</html>

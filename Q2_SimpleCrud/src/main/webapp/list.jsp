<%@ page language="java" %>
<html>
<head><title>User List</title></head>
<body>
<h1>Users</h1>
<a href="UserServlet?action=add">Add User</a>
<table border="1">
    <tr><th>ID</th><th>Name</th><th>Email</th><th>Actions</th></tr>
    <%
        java.util.List<User> users = (java.util.List<User>) request.getAttribute("users");
        for (User user : users) {
    %>
    <tr>
        <td><%= user.getId() %></td>
        <td><%= user.getName() %></td>
        <td><%= user.getEmail() %></td>
        <td>
            <a href="UserServlet?action=edit&id=<%= user.getId() %>">Edit</a>
            <a href="UserServlet?action=delete&id=<%= user.getId() %>">Delete</a>
        </td>
    </tr>
    <% } %>
</table>
</body>
</html>

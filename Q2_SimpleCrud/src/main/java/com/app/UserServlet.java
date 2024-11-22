import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;

@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
    private UserDAO userDAO = new UserDAO();

    // Corrected method signature with IOException and ServletException
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) action = "list";

        try {
            switch (action) {
                case "add":
                    request.getRequestDispatcher("add.jsp").forward(request, response);
                    break;
                case "edit":
                    int id = Integer.parseInt(request.getParameter("id"));
                    User user = userDAO.getUserById(id);
                    request.setAttribute("user", user);
                    request.getRequestDispatcher("edit.jsp").forward(request, response);
                    break;
                case "delete":
                    id = Integer.parseInt(request.getParameter("id"));
                    userDAO.deleteUser(id);
                    response.sendRedirect("UserServlet");
                    break;
                default:
                    request.setAttribute("users", userDAO.getAllUsers());
                    request.getRequestDispatcher("list.jsp").forward(request, response);
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Corrected method signature with IOException and ServletException
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) action = "add";

        try {
            if (action.equals("add")) {
                String name = request.getParameter("name");
                String email = request.getParameter("email");
                userDAO.addUser(name, email);
            } else if (action.equals("edit")) {
                int id = Integer.parseInt(request.getParameter("id"));
                String name = request.getParameter("name");
                String email = request.getParameter("email");
                userDAO.updateUser(id, name, email);
            }
            response.sendRedirect("UserServlet");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

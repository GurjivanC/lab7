package ca.sait.jdbc.servlets;

import ca.sait.jdbc.models.Role;
import ca.sait.jdbc.models.User;
import ca.sait.jdbc.services.RoleService;
import ca.sait.jdbc.services.UserService;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author 744941
 */
public class UserServlet extends HttpServlet {

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        UserService service = new UserService();
        try {
            List<User> users = service.getAll();

            request.setAttribute("users", users);

            this.getServletContext().getRequestDispatcher("/WEB-INF/users.jsp").forward(request, response);
        } catch (Exception ex) {
            Logger.getLogger(UserServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        UserService user = new UserService();
        Role role = new Role();
        String action = request.getParameter("action");
        String email = request.getParameter("email");
        String firstName = request.getParameter("firtsName");
        String lastName = request.getParameter("lastName");
        String password = request.getParameter("password");
        String active = (request.getParameter("active") == null) ? "Y" : "N";
        if (action.equals("add") && action != null) {
            try {
                user.insert(email, Boolean.parseBoolean(active), firstName, lastName, password, role);
            } catch (Exception ex) {
                Logger.getLogger(UserServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (action.equals("edit") && action != null) {
            try {
                user.update(email, Boolean.parseBoolean(active), firstName, lastName, password, role);
            } catch (Exception ex) {
                Logger.getLogger(UserServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else if (action.equals("delete") && action != null) {
            try {
                user.delete(email);
            } catch (Exception ex) {
                Logger.getLogger(UserServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

}

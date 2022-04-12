package club.admin;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Jisung Kim
 */
public class BDJKNMMemberAdminController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url = "/BDJKNMDisplayMembers.jsp";
        
        String action = request.getParameter("action");
        if (action == null) {
            action = "displayMembers";
        }
        
        if (action.equals("displayMembers")) {
            url = "/BDJKNMDisplayMembers.jsp";
        } else if (action.equals("addMember")) {
            
        } else if (action.equals("editMember")) {
            
        } else if (action.equals("deleteMember")) {
            
        }
        
        getServletContext()
                .getRequestDispatcher(url)
                .forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
}

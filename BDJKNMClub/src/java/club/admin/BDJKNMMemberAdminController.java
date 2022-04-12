package club.admin;

import club.business.BDJKNMMember;
import club.data.MemberDB;
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
        System.out.println("servlet: " + request.getParameter("action"));

        String url = "";

        String action = request.getParameter("action");
        if (action == null) {
            action = "displayMembers";
        }

        if (action.equals("displayMembers")) {
            url = "/BDJKNMDisplayMembers.jsp";
        } else if (action.equals("addMember")) {
            url = "/BDJKNMAddMember.jsp";
        } else if (action.equals("saveMember")) {
            url = saveMember(request, response);
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

    private String saveMember(HttpServletRequest request, HttpServletResponse response) {
        String email = request.getParameter("email");
        String fullName = request.getParameter("fullName");
        String phone = request.getParameter("phone");
        String program = request.getParameter("program");
        String year = request.getParameter("year");

        BDJKNMMember member = new BDJKNMMember(fullName, email);

        String message = "";
        String url = "";
        int i = 0;

        if (!member.isValid()) {
            message = "Cannot insert a new record. Please provide a valid name and/or email.";
            url = "/BDJKNMAddMember.jsp";
        } else {
            message = "";
            url = "/BDJKNMDisplayMembers.jsp";

            member.setPhoneNumber(phone);
            member.setProgramName(program);
            member.setYearLevel(Integer.parseInt(year));

            if (MemberDB.emailExists(email)) {
                i = MemberDB.update(member);
            } else {
                i = MemberDB.insert(member);
            }

            request.setAttribute("member", member);
            request.setAttribute("records", i);
        }

        request.setAttribute("message", message);

        return url;

    }
}

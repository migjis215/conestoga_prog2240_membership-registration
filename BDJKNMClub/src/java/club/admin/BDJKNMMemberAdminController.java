package club.admin;

import club.business.BDJKNMMember;
import club.data.MemberDB;
import java.io.IOException;
import java.util.ArrayList;
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

        String[] programs = {"CPA", "CP", "CAS", "SQATE", "ITID", "CAD", "ITSS"};
        request.setAttribute("programs", programs);

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
        } else {
            BDJKNMMember member = MemberDB.selectMember(request.getParameter("email"));
            request.setAttribute("member", member);

            if (action.equals("editMember")) {
                url = "/BDJKNMEditMember.jsp";
            } else if (action.equals("removeMember")) {
                url = "/BDJKNMRemoveMember.jsp";
            } else if (action.equals("deleteMember")) {
                int i = MemberDB.delete(member);
                request.setAttribute("records", i);
                url = "/BDJKNMDisplayMembers.jsp";
            } 
        }

        ArrayList<BDJKNMMember> members = MemberDB.selectMembers();
            request.setAttribute("members", members);
        
        getServletContext()
                .getRequestDispatcher(url)
                .forward(request, response);
    }

    private String saveMember(HttpServletRequest request, HttpServletResponse response) {
        String message = "";
        String url = "";
        int i = 0;

        String db_operation = request.getParameter("db_operation");
        if (db_operation == null) {
            db_operation = "insert";
        }

        String email = request.getParameter("email");
        String fullName = request.getParameter("fullName");
        String phone = request.getParameter("phone");
        String program = request.getParameter("program");
        String year = request.getParameter("year");

        if (email == null || email.isEmpty()) {
            email = "";
        }

        if (fullName == null || fullName.isEmpty()) {
            fullName = "";
        }

        BDJKNMMember member = new BDJKNMMember(fullName, email);

        member.setPhoneNumber(phone);
        member.setProgramName(program);
        member.setYearLevel(Integer.parseInt(year));

        if (!member.isValid()) {
            if (db_operation.equals("update")) {
                message = "Cannot update the record. Please provide a valid name.";
                url = "/BDJKNMEditMember.jsp";
            } else if (db_operation.equals("insert")) {
                message = "Cannot insert a new record. Please provide a valid name and/or email.";
                url = "/BDJKNMAddMember.jsp";
            }
        } else {
            message = "";
            url = "/BDJKNMDisplayMembers.jsp";

            if (MemberDB.emailExists(email)) {
                i = MemberDB.update(member);
            } else {
                i = MemberDB.insert(member);
            }
        }

        request.setAttribute("message", message);
        request.setAttribute("member", member);
        request.setAttribute("records", i);

        return url;
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

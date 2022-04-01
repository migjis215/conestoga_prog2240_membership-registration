package club.cart;

import club.business.Book;
import club.business.ECart;
import club.business.ELoan;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Jisung Kim
 */
public class BDJKNMCartServlet extends HttpServlet {
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ServletContext context = getServletContext();
        ArrayList<Book> loanItems = (ArrayList<Book>)context.getAttribute("loanitems");
        
        HttpSession mySession = request.getSession();
        ECart myCart = (ECart)mySession.getAttribute("myCart");
        
        if (myCart == null) {
            myCart = new ECart();
        }
        
        String reserve = request.getParameter("action");
        String reserveCode = (String)request.getParameter("code");
        
        if (reserve != null && (reserveCode != "" && reserveCode != null)) {
            Book tempBook = ELoan.findItem(loanItems, reserveCode);
            myCart.addItem(tempBook);
            ELoan.subtractFromQOH(loanItems, reserveCode, 1);
            mySession.setAttribute("myCart", myCart);
        }
        
        RequestDispatcher dispatcher = getServletContext()
            .getRequestDispatcher("/BDJKNMECart.jsp");
        dispatcher.forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
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
        processRequest(request, response);
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
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

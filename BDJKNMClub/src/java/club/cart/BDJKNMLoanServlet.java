package club.cart;

import club.business.Book;
import club.business.ELoan;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Jisung Kim
 */

public class BDJKNMLoanServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        ServletContext context = getServletContext();
        String path = context.getRealPath("/WEB-INF/books.txt");
        ArrayList<Book> loanItems = (ArrayList<Book>)context.getAttribute("loanitems");
        
        if (loanItems == null) {
            loanItems = ELoan.loadItems(path);
            context.setAttribute("loanitems", loanItems);
        }                
        
        RequestDispatcher dispatcher = getServletContext()
            .getRequestDispatcher("/BDJKNMELoan.jsp");
        dispatcher.forward(request, response);
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

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
public class BDJKNMClearCartServlet extends HttpServlet {
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ServletContext context = getServletContext();
        ArrayList<Book> loanItems = (ArrayList<Book>)context.getAttribute("loanitems");
        
        ECart deleteCart;
        HttpSession mySession = request.getSession();
        
        if (mySession.getAttribute("myCart") != null) {
            deleteCart = (ECart)mySession.getAttribute("myCart");
            
            for (Book item : deleteCart.getItems()) {
                ELoan.addToQOH(loanItems, item.getCode(), item.getQuantity());
            }
            
            deleteCart = new ECart();
            mySession.setAttribute("myCart", deleteCart);
        }
        
        RequestDispatcher dispatcher = getServletContext()
            .getRequestDispatcher("/BDJKNMECart.jsp");
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

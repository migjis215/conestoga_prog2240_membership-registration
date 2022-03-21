package club.admin;

import club.business.Book;
import club.data.BookIO;
import java.io.IOException;
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
public class BDJKNMAddBookServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        ServletContext context = getServletContext();
        
        String path = context.getRealPath("/WEB-INF/books.txt");
        String bookCode = request.getParameter("code");
        String bookDescription = request.getParameter("description");
        String quantityStr = request.getParameter("quantity");
        
        if (quantityStr == null || quantityStr.isEmpty()) {
            quantityStr = "0";
        }
        
        int bookQuantity = Integer.parseInt(quantityStr);
        
        // store data in User object
        Book newBook = new Book(bookCode, bookDescription, bookQuantity);
        request.setAttribute("book", newBook);
        
        // validate the inputs
        String message = "";
        String url = "";
        
        if (bookCode == null || bookCode == "")
        {
            message += "Book code is required. <br />";
        }
        if (bookDescription == null || bookDescription == "" || bookDescription.length() < 3)
        {
            message += "Description must have at least 3 characters. <br />";
        }
        if (bookQuantity <= 0)
        {
            message += "uantity must be a positive number. <br />";
        }
        
        if (message == "") {
            // Call the insert() method of BookIO class.
            BookIO.insert(newBook, path);
            url = "/BDJKNMDisplayBooks";
        } else {
            request.setAttribute("message", message);
            url = "/BDJKNMAddBook.jsp";
        }
        
        RequestDispatcher dispatcher = getServletContext()
        .getRequestDispatcher(url);
        dispatcher.forward(request,response);
    }
}

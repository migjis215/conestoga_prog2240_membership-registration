/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package club.admin;

import club.business.Book;
import club.data.BookIO;
import java.io.IOException;
import java.io.PrintWriter;
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

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
//        response.setContentType("text/html;charset=UTF-8");
//        try ( PrintWriter out = response.getWriter()) {
//            /* TODO output your page here. You may use following sample code. */
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet BDJKNMAddBookServlet</title>");            
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet BDJKNMAddBookServlet at " + request.getContextPath() + "</h1>");
//            out.println("</body>");
//            out.println("</html>");
//        }
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
        doPost(request, response);
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

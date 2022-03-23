/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package vn.aptech.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import vn.aptech.dto.Product;


/**
 *
 * @author Administrator
 */
@WebServlet(name = "ProductServlet", urlPatterns = {"/Product"})
public class ProductServlet extends HttpServlet {
    
    public static List<Product> products = new ArrayList<>();
    
    static {
        Product p1 = new Product (1,"Product 1",10);
        products.add(p1);
         Product p2 = new Product (2,"Product 2",11);
        products.add(p2);
         Product p3 = new Product (3,"Product 3",13);
        products.add(p3);
         Product p4 = new Product (4,"Product 4",17);
        products.add(p4);
    }
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
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ProductServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Product List</h1>");
            out.println("<table>");
            out.println("<tr>");
              out.println("<th>Id</th>");
              out.println("<th>Name</th>");
              out.println("<th>Price</th>");
              out.println("<th>Add Card</th>");
            out.println("</tr>");
            for(Product p : products){
                out.println("<td>"+p.getId()+"</td>");
                out.println("<td>"+p.getName()+"</td>");
                out.println("<td>"+p.getPrice()+"</td>");
                out.println("<td><a href='#'>Add Card</a></td>");
                out.println("</tr>");
            }
            out.println("</table>");
            out.println("</body>");
            out.println("</html>");
        }
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

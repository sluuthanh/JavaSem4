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
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import vn.aptech.dto.Cart;
import vn.aptech.dto.CartItem;
import vn.aptech.dto.Product;
import static vn.aptech.servlet.ProductServlet.products;


/**
 *
 * @author Administrator
 */
@WebServlet(name = "ViewCartServLet", urlPatterns = {"/ViewCart"})
public class ViewCartServLet extends HttpServlet {

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
            out.println("<title>Servlet ViewCartServLet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>ViewCart</h1>");
            
            out.println("<table>");
            out.println("<tr>");
              out.println("<th>Product Id</th>");
              out.println("<th>Name</th>");
              out.println("<th>Price</th>");
              out.println("<th>Quantity</th>");
            out.println("</tr>");
           
            HttpSession session = request.getSession();
            if(session.getAttribute("cart")!=null){
                Cart cart = (Cart) session.getAttribute("cart");
                for (CartItem item  : cart.getCarts()) {
                    out.println("<tr>");
                    out.println("<td>"+ item.getProduct().getId()+ "</td>");
                    out.println("<td>"+ item.getProduct().getName()+ "</td>");
                    out.println("<td>"+ item.getProduct().getPrice()+ "</td>");
                    out.println("<td>"+ item.getQuantity()+ "</td>");
                    out.println("</tr>");
                }
            }else{
                // truong hop chua co cart 
                out.println("<tr>");
                out.println("<td colspan='4'>Cart Empty</td>");
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
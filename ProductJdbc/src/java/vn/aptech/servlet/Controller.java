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
import vn.aptech.dal.ProductDal;
import vn.aptech.entity.Product;


/**
 *
 * @author Administrator
 */
@WebServlet(name = "Controller", urlPatterns = {"/Controller"})
public class Controller extends HttpServlet {
    ProductDal dal = new ProductDal();
   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            String a = request.getParameter("action");
            if(null==a){
                request.setAttribute("products", dal.findAll());
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }else switch (a) {
                case "CreateProduct":
                {
                    Product p = (Product) request.getAttribute("product");
                    dal.create(p);
                    response.sendRedirect("Controller");
                    break;
                }
                case "Search":
                {
                    String name = request.getParameter("name");
                    request.setAttribute("products", dal.findByName(name));
                    request.getRequestDispatcher("index.jsp").forward(request, response);
                    break;
                }
                case "ShowUpdate":
                {
                    String id = request.getParameter("id");
                    request.setAttribute("p",dal.findById(Integer.parseInt(id)));
                    request.getRequestDispatcher("update.jsp").forward(request, response);
                    break;
                }
                case "Update":
                {
                    int id = Integer.parseInt(request.getParameter("id"));
                    String name =request.getParameter("name");
                    int price = Integer.parseInt(request.getParameter("price"));
                    Product p = new Product();
                    p.setId(id);
                    p.setName(name);
                    p.setPrice(price);
                    dal.update(p);
                    response.sendRedirect("Controller");
                    break;
                }
                default:
                    break;
            }
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

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
import vn.aptech.dal.StudentDal;
import vn.aptech.entity.Student;


/**
 *
 * @author Administrator
 */
@WebServlet(name = "Controller", urlPatterns = {"/Controller"})
public class Controller extends HttpServlet {
    StudentDal dal = new StudentDal();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            String a = request.getParameter("action");
            if(null==a){
                request.setAttribute("students", dal.findAll());
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }else switch (a) {
                case "Create":
                    {
                        String name = request.getParameter("name");
                        String email = request.getParameter("email");
                        boolean gender = Boolean.parseBoolean(request.getParameter("gender"));
                        Student stu = new Student();
                        stu.setName(name);
                        stu.setEmail(email);
                        stu.setGender(gender);
                        dal.create(stu);
                        response.sendRedirect("Controller");
                        break;
                    }
                case "DisplayUpdate":
                    {
                        String id = request.getParameter("id");
                        request.setAttribute("student", dal.findById(Integer.parseInt(id)));
                        request.getRequestDispatcher("update.jsp").forward(request, response);
                        break;
                    }
                case "Update":
                    {
                        int id = Integer.parseInt(request.getParameter("id"));
                        String name = request.getParameter("name");
                        String email = request.getParameter("email");
                        boolean gender = Boolean.parseBoolean(request.getParameter("gender"));
                        Student stu = new Student();
                        stu.setId(id);
                        stu.setName(name);
                        stu.setEmail(email);
                        stu.setGender(gender);
                        dal.update(stu);
                        // chuyen ve index.jsp
                        response.sendRedirect("Controller");
                        break;
                    }
                case "Delete":
                    {
                        int id = Integer.parseInt(request.getParameter("id"));
                        dal.delete(id);
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

package vn.aptech.servlet;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import vn.aptech.dal.GlassDal;
import vn.aptech.entity.Glass;

/**
 *
 * @author Administrator
 */

@MultipartConfig(
        fileSizeThreshold = 10 * 1024 * 1024,
        maxFileSize = 50 * 1024 * 1024,
        maxRequestSize = 100 * 1024 * 1024
)
@WebServlet(name = "ProcessServlet", urlPatterns = {"/admin/ProcessServlet"})
public class ProcessServlet extends HttpServlet {

    GlassDal dal = new GlassDal();
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            int id = Integer.parseInt(request.getParameter("id"));
            String name = request.getParameter("name");
            int price = Integer.parseInt(request.getParameter("price"));
            String image = processUpload(request);
            Glass g = new Glass(id, name, price, image);
            
            if(dal.create(g)){
                response.sendRedirect("create.jsp");
            }else{
                response.sendRedirect("error.jsp");
            }
        }
    }

    private String getFilename(Part part) {
        String result = null;
        String partHeader = part.getHeader("content-disposition");
        System.out.println("---------- Part Header: " + partHeader);
        // trong phần part header này sẽ có nhiều trường, phân biệt bằng dấu ;
        for (String content: partHeader.split(";")) {
            if (content.trim().startsWith("filename")) {
                content = content.trim();
                result = content.substring(content.indexOf("=")+1).replace("\"", "");
                break;
            }
        }
        return result;
    }
    private String processUpload(HttpServletRequest request) {
        String filename = "";
        try {
            Part filePart = request.getPart("image");
            filename = getFilename(filePart);
            // đường dẫn đến thư mục root (/) tại thời điểm runtime
            String root = getServletContext().getRealPath("");
            String imgFolder = root + File.separator + "images" + File.separator;
            // kiểm tra xem thư mục images này đã tồn tại hay chưa?
            File imgFile = new File(imgFolder);
            if (!imgFile.exists()) {
                imgFile.mkdir();    // tạo thư mục (tương tự lệnh mkdir của console)
            }

            InputStream in = filePart.getInputStream();
            OutputStream out = new FileOutputStream(new File(imgFolder + filename));
            int read = 0;
            byte[] buf = new byte[1024];
            while ((read = in.read(buf)) != -1) {
                out.write(buf, 0, read);
            }
            in.close();
            out.close();
        } catch (Exception e) {
            filename = "";
        }
        return filename;
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

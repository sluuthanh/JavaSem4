/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vn.aptech.dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import vn.aptech.entity.Book;

/**
 *
 * @author Administrator
 */
public class BookDal {
    private Connection connectDb() throws ClassNotFoundException, SQLException{
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String url = "jdbc:sqlserver://localhost\\SQLEXPRESS:1500;databaseName=T12009A0_Sem4_Java";
        return DriverManager.getConnection(url,"sa","1");
    }
    
    public boolean create(Book book){
        boolean result = false;
        try {
            Connection con = connectDb();
            String query = "Insert into book values (?,?,?,?)";
            PreparedStatement stm = con.prepareStatement(query);
            stm.setString(1, book.getCode());
            stm.setString(2, book.getTitle());
            stm.setInt(3, book.getPrice());
            stm.setString(4, book.getPublisher());
            result = stm.executeUpdate()>0;
            stm.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
    
     public List<Book> findAll(){
        List<Book> result = new ArrayList<>();
        try {
            Connection con = connectDb();
            String query = "Select * from Book";
            PreparedStatement stm = con.prepareStatement(query);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {                
                Book b = new Book(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getString(4));
                result.add(b);
            }
            rs.close();
            stm.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}

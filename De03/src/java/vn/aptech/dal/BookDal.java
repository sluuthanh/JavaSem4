/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
 * @author namng
 */
public class BookDal {
     private Connection connectDb() throws ClassNotFoundException, SQLException{
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String url = "jdbc:sqlserver://localhost\\SQLEXPRESS:1500;databaseName=T12009A0_Sem4_Java";
        return DriverManager.getConnection(url,"sa","1");
    }
     
     public List<Book> getAll() throws ClassNotFoundException, SQLException{
         List<Book> books=new ArrayList<>();
         try{
             Connection con=connectDb();
             String query="SELECT * FROM Book ";
             ResultSet rs=con.prepareStatement(query).executeQuery();
             while(rs.next()){
             String bookCode=rs.getString(1);
             String title=rs.getString(2);
             int price=rs.getInt(3);
             String publisher=rs.getString(4);
             Book b=new Book(bookCode,title,price,publisher);
             books.add(b);
         }
         }catch(Exception ex){
             ex.printStackTrace();
         }
         return books;
     }
     
     public Book getByBookCode(String bookCode){
         Book b=null;
         try{
             Connection con=connectDb();
             String query="SELECT * FROM Book WHERE bookCode=?";
             PreparedStatement stm=con.prepareStatement(query);
             stm.setString(1, bookCode);
             ResultSet rs=stm.executeQuery();
             while(rs.next()){
                 b=new Book(rs.getString(1),rs.getString(2),rs.getInt(3),rs.getString(4));
             }
         }catch(Exception ex){
             ex.printStackTrace();
         }         
          return b;
     }

    public boolean create(Book b) {
       try{
            Connection con=connectDb();
            String query="INSERT INTO Book VALUES (?,?,?,?) ";
            PreparedStatement stm=con.prepareStatement(query);
            stm.setString(1, b.getBookCode());
            stm.setString(2, b.getTitle());
            stm.setInt(3, b.getPrice());
            stm.setString(4, b.getPublisher());
            return stm.executeUpdate()>0;
       }catch(Exception ex){
           ex.printStackTrace();
       }
       return false;
    }
     
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bookdb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Administrator
 */
public class BookDal {
    private Connection connectDb() throws ClassNotFoundException, SQLException{
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String url = "jdbc:sqlserver://localhost\\SQLEXPRESS:1500;databaseName=T12009A0_Sem4_Java";
        return DriverManager.getConnection(url, "sa", "1");
    }
    
    public List<BookEntity> findAll(){
        List<BookEntity> result = new ArrayList<>();
        try {
            Connection con = connectDb();
            String query = "Select id,title,price from book";
            PreparedStatement stm = con.prepareStatement(query);
            ResultSet rs = stm.executeQuery();
            while(rs.next()){
                BookEntity b = new BookEntity(rs.getInt(1),rs.getString(2),rs.getInt(3));
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
    public List<BookEntity> findByName(String title){
        List<BookEntity> result = new ArrayList<>();
        try {
            Connection con = connectDb();
            String query = "Select id,title,price from book where title like ?";
            PreparedStatement stm = con.prepareStatement(query);
            stm.setString(1,"%"+title+"%");
            ResultSet rs = stm.executeQuery();
            while(rs.next()){
                BookEntity b = new BookEntity(rs.getInt(1),rs.getString(2),rs.getInt(3));
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
    
     public BookEntity findById(int id){
        BookEntity result = null;
        try {
            Connection con = connectDb();
            String query = "Select id,title,price from book where id = ?";
            PreparedStatement stm = con.prepareStatement(query);
            stm.setInt(1,id);
            ResultSet rs = stm.executeQuery();
            if(rs.next()){
                BookEntity b = new BookEntity(rs.getInt(1),rs.getString(2),rs.getInt(3));
                result = b;            }
            rs.close();
            stm.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
     
    public boolean create(BookEntity b){
        boolean result = false;
        try {
            Connection con = connectDb();
            String query = "Insert into book (title,price) values(?,?)";
            PreparedStatement stm = con.prepareStatement(query);
            stm.setString(1, b.getTitle());
            stm.setInt(2, b.getPrice());
            result = stm.executeUpdate()>0;
            stm.close();
            con.close();
        } catch (Exception e) {
        }
        return result;
    }
    
    public boolean update(BookEntity b){
        boolean result = false;
        try {
            Connection con = connectDb();
            String query = "Update book Set title = ?, price = ? where id = ?";
            PreparedStatement stm = con.prepareStatement(query);
            stm.setString(1, b.getTitle());
            stm.setInt(2, b.getPrice());
            stm.setInt(3, b.getId());
            result = stm.executeUpdate()>0;
            stm.close();
            con.close();
        } catch (Exception e) {
        }
        return result;
    }
    
    
    public boolean delete(BookEntity b){
        boolean result = false;
        try {
            Connection con = connectDb();
            String query = "Delete from book where id = ?";
            PreparedStatement stm = con.prepareStatement(query);
            stm.setInt(1, b.getId());
            result = stm.executeUpdate()>0;
            stm.close();
            con.close();
        } catch (Exception e) {
        }
        return result;
    }
}

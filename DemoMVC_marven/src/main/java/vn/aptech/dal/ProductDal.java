/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vn.aptech.dal;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import vn.aptech.entity.Product;

/**
 *
 * @author Administrator
 */
public class ProductDal {
    private Connection connectDb() throws ClassNotFoundException, SQLException{
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String url = "jdbc:sqlserver://localhost\\SQLEXPRESS:1500;databaseName=T12009A0_Sem4_Java";
        return DriverManager.getConnection(url,"sa","1");
    }
    
    public List<Product> findAll(){
        List<Product> result = new ArrayList<>();
        try {
            Connection con = connectDb();
            String query = "SELECT * FROM product";
            PreparedStatement stm = con.prepareStatement(query);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {                
                Product p = new Product(rs.getInt(1), rs.getString(2), rs.getInt(3));
                result.add(p);
            }
            rs.close();
            stm.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public boolean create(Product p) {
        boolean result = false;
        try {
            Connection con = connectDb();
            String query = "INSERT INTO product VALUES (?,?)";
            PreparedStatement stm = con.prepareStatement(query);
            stm.setString(1, p.getName());
            stm.setInt(2, p.getPrice());
            stm.executeUpdate();
            stm.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}

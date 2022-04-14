/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vn.aptech.dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import vn.aptech.entity.Glass;

/**
 *
 * @author Administrator
 */
public class GlassDal {
    private Connection connectDb() throws ClassNotFoundException, SQLException{
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String url = "jdbc:sqlserver://localhost\\SQLEXPRESS:1500;databaseName=T12009A0_Sem4_Java";
        return DriverManager.getConnection(url,"sa","1");
    } 
    
    public boolean create(Glass g){
        boolean result = false;
        try {
            Connection con = connectDb();
            String query = "Insert into glass values (?,?,?,?)";
            PreparedStatement stm = con.prepareStatement(query);
            stm.setInt(1, g.getId());
            stm.setString(2, g.getName());
            stm.setInt(3, g.getPrice());
            stm.setString(4, g.getImage());
            result =stm.executeUpdate()>0;
            stm.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}

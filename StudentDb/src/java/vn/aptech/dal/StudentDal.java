/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vn.aptech.dal;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import vn.aptech.entity.Student;


/**
 *
 * @author Administrator
 */
public class StudentDal {
    private Connection connectDb() throws ClassNotFoundException, SQLException{
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String url = "jdbc:sqlserver://localhost\\SQLEXPRESS:1500;databaseName=T12009A0_Sem4_Java";
        return DriverManager.getConnection(url,"sa","1");
    }
    
    public List<Student> findAll(){
        List<Student> result = new ArrayList<>();
        try {
            Connection con = connectDb();
            String query = "Select id,name,email,gender from student";
            PreparedStatement stm = con.prepareStatement(query);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {                
                Student stu = new Student(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getBoolean(4));
                result.add(stu);
            }
            rs.close();
            stm.close();
            con.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
    
    public boolean create(Student stu){
        boolean result = false;
        try {
            Connection con = connectDb();
            String query = "Insert into student(name,email,gender) values (?,?,?)";
            PreparedStatement stm = con.prepareStatement(query);
            stm.setString(1, stu.getName());
            stm.setString(2, stu.getEmail());
            stm.setBoolean(3, stu.isGender());
            stm.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Responsitory_IPL;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author phamt
 */
public class DBContext {

    public static String USER = "sa";
    public static String PASSWORD = "123456";
    public static String URL = "jdbc:sqlserver://localhost:1433;databaseName=DuAn1;encrypt=true;trustServerCertificate=true;";

    static {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static Connection getConnection(){
       Connection con=null;
        try {
            con = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException ex) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
       return con;
    
    } 
    public static void main(String[] args) {
            Connection con=getConnection();
            if(con!=null){
            System.out.println("ket noi thanh cong");
        }
        else{
            System.out.println("ket noi that bai");
        }
    }
}


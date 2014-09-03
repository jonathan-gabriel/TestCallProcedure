/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package callstoreprocedure;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author User
 */
public class CallProcThread extends Thread {
    @Override
    public void run() {
        Connection mysqlConn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver"); //.newInstance
            String _url = "jdbc:mysql://" + "72.167.141.193" + ":" + "3306" + "/" + "sequence" + "?user=" + "root" + "&password=" + "mysql";
//            String _url = "jdbc:mysql://" + "localhost" + ":" + "3306" + "/" + "web" + "?user=" + "root" + "&password=" + "mysql";
            mysqlConn = DriverManager.getConnection(_url,"root","mysql");
            
            String sql = "call sequence.sp_getSequence('Submission'); ";
            
            Statement ps = mysqlConn.createStatement();
            ResultSet rs = ps.executeQuery(sql);
            
            rs.next();
            BigDecimal id = rs.getBigDecimal(1);
            
            System.out.println("Thread: " + this.getId() + " seq: " + id);
           
            rs.close();
            
            
            
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace(System.out);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        finally {
            try {
                mysqlConn.close(); // System.out.println("close");
            } catch (SQLException ex) {
                
            }
        }
    }
}

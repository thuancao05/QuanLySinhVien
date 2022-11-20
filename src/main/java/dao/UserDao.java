/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.User;
/**
 *
 * @author Thuan
 */
public class UserDao {
    public User checkLogin(String username, String password){
        Connection connection = JDBCConnection.getJDBCConnection();
        String sql = "select username, password, role from [User] "
                    +" where username = ? and password = ?";
        
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                User user = new User();
                
                user.setUsername(rs.getString("username"));
                user.setRole(rs.getString("role"));
                
                return user;
            }
        
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
   }
}

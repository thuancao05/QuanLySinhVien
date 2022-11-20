/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.MonHoc;

/**
 *
 * @author Thuan
 */
public class MonHocDao {

    public boolean insert(MonHoc monHoc) throws SQLException{
        Connection connection = JDBCConnection.getJDBCConnection();
        String sql = "INSERT INTO [dbo].[MonHoc](MaMon,TenMon,SoTinChi) "
                    +" values(?,?,?)";
        
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, monHoc.getMaMon());
            preparedStatement.setString(2, monHoc.getTenMon());
            preparedStatement.setInt(3, monHoc.getSoTinChi());
                                    
        return preparedStatement.executeUpdate() > 0;
   }
   public boolean update(MonHoc mh) throws SQLException{
        Connection connection = JDBCConnection.getJDBCConnection();
        String sql = "UPDATE [dbo].[MonHoc] SET "
                + "[TenMon] = ?,[SoTinChi] = ?"
                + " WHERE [MaMon] = ?";
             
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            
            preparedStatement.setString(1, mh.getTenMon());
            preparedStatement.setInt(2, mh.getSoTinChi());
            preparedStatement.setString(3, mh.getMaMon());

                        
        return preparedStatement.executeUpdate() > 0;
   }    

    public boolean delete(MonHoc monHoc) throws SQLException{
        Connection connection = JDBCConnection.getJDBCConnection();
        String sql = "DELETE FROM [dbo].[MonHoc] "
                + " WHERE MaMon = ?";
        
        
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            
            preparedStatement.setString(1, monHoc.getMaMon());
                        
        return preparedStatement.executeUpdate() > 0;
   }
    public MonHoc findByMaMon(String maMon) throws SQLException{
        Connection connection = JDBCConnection.getJDBCConnection();
        String sql = "select * FROM [dbo].[MonHoc] "
                + " WHERE MaMon = ?";
        
        
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
            
        preparedStatement.setString(1, maMon);           
        ResultSet rs = preparedStatement.executeQuery();
        if(rs.next()){
               MonHoc monHoc = createMonHoc(rs);
               
               return monHoc;
        }
            return null;
    }   
    public List<MonHoc> findAll() throws SQLException{
        Connection connection = JDBCConnection.getJDBCConnection();
        String sql = "select * FROM [dbo].[MonHoc] ";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
                                  
        ResultSet rs = preparedStatement.executeQuery();
        List<MonHoc> list = new ArrayList<>();
        while(rs.next()){
               MonHoc monHoc = createMonHoc(rs);
               list.add(monHoc);
        }
        return list;
    } 

    private MonHoc createMonHoc(ResultSet rs) throws SQLException {
        MonHoc monHoc = new MonHoc();
        monHoc.setMaMon(rs.getString("MaMon"));
        monHoc.setTenMon(rs.getString("TenMon"));
        monHoc.setSoTinChi(rs.getInt("SoTinChi"));

        return monHoc;
    }    
}


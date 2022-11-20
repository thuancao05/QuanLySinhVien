/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.SinhVien;

/**
 *
 * @author Thuan
 */
public class SinhVienDao {
    public boolean insert(SinhVien sv) throws SQLException{
        Connection connection = JDBCConnection.getJDBCConnection();
        String sql = "INSERT INTO [dbo].[SinhVien]([MaSinhVien],[HoTen],[Email],[DiaChi],[SoDienThoai],[GioiTinh],[Hinh]) "
                    +" values(?,?,?,?,?,?,?)";
        
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, sv.getMaSinhVien());
            preparedStatement.setString(2, sv.getHoTen());
            preparedStatement.setString(3, sv.getEmail());
            preparedStatement.setString(4, sv.getDiaChi());
            preparedStatement.setString(5, sv.getSoDienThoai());
            preparedStatement.setInt(6, sv.getGioiTinh());
            if(sv.getHinh() != null){
                byte[] avatar = sv.getHinh();
                preparedStatement.setBytes(7, avatar);
            }else{
                byte[] avatar = null;
                preparedStatement.setBytes(7, avatar);
            }
                        
        return preparedStatement.executeUpdate() > 0;
   }    
    public boolean update(SinhVien sv) throws SQLException{
        Connection connection = JDBCConnection.getJDBCConnection();
        String sql = "UPDATE [dbo].[SinhVien] SET "
                + "[HoTen] = ?,[Email] = ?,[SoDienThoai] = ?,[GioiTinh] = ?,[DiaChi] = ?,"
                + "[Hinh] = ? WHERE [MaSinhVien] = ?";
             
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            
            preparedStatement.setString(1, sv.getHoTen());
            preparedStatement.setString(2, sv.getEmail());
            preparedStatement.setString(3, sv.getSoDienThoai());
            preparedStatement.setInt(4, sv.getGioiTinh());
            preparedStatement.setString(5, sv.getDiaChi());
            if(sv.getHinh() != null){
                byte[] avatar = sv.getHinh();
                preparedStatement.setBytes(6, avatar);
            }else{
                byte[] avatar = null;
                preparedStatement.setBytes(6, avatar);
            }
            preparedStatement.setString(7, sv.getMaSinhVien());
                        
        return preparedStatement.executeUpdate() > 0;
   }

    public boolean delete(SinhVien sv) throws SQLException{
        Connection connection = JDBCConnection.getJDBCConnection();
        String sql = "DELETE FROM [dbo].[SinhVien] "
                + " WHERE [MaSinhVien] = ?";
        
        
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            
            preparedStatement.setString(1, sv.getMaSinhVien());
                        
        return preparedStatement.executeUpdate() > 0;
   }
    public SinhVien findByID(String SinhVienID) throws SQLException{
        Connection connection = JDBCConnection.getJDBCConnection();
        String sql = "select * FROM [dbo].[SinhVien] "
                + " WHERE [MaSinhVien] = ?";
        
        
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
            
        preparedStatement.setString(1, SinhVienID);           
        ResultSet rs = preparedStatement.executeQuery();
        if(rs.next()){
               SinhVien sv = createSinhVien(rs);
               
               return sv;
        }
            return null;
    }   
    public List<SinhVien> findAll() throws SQLException{
        Connection connection = JDBCConnection.getJDBCConnection();
        String sql = "select * FROM [dbo].[SinhVien] ";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
                                  
        ResultSet rs = preparedStatement.executeQuery();
        List<SinhVien> list = new ArrayList<>();
        while(rs.next()){
               SinhVien sv = createSinhVien(rs);
               list.add(sv);
        }
        return list;
    } 

    private SinhVien createSinhVien(ResultSet rs) throws SQLException {
        SinhVien sv = new SinhVien();
        sv.setMaSinhVien(rs.getString("MaSinhVien"));
        sv.setHoTen(rs.getString("HoTen"));
        sv.setEmail(rs.getString("Email"));
        sv.setSoDienThoai(rs.getString("SoDienThoai"));
        sv.setGioiTinh(rs.getInt("GioiTinh"));
        sv.setDiaChi(rs.getString("DiaChi"));
        Blob avatar = rs.getBlob("Hinh");
        if(avatar != null){
            sv.setHinh(avatar.getBytes(1, (int)avatar.length()));
        
        }
        return sv;
    }    
}

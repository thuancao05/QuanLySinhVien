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
import model.KQMonHoc;
import model.MonHoc;
import model.SinhVien;

/**
 *
 * @author Thuan
 */
public class KQMonHocDao {
    public boolean insert (KQMonHoc kqMonHoc ) throws SQLException{
        Connection connection = JDBCConnection.getJDBCConnection();
        String sql = "INSERT INTO [dbo].[KetQuaMonHoc]([MaSinhVien],[MaMon],[DiemSo],[DiemChu],[NamHoc],[HocKy]) "
                + " VALUES(?,?,?,?,?,?)";

        
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
            
        preparedStatement.setString(1, kqMonHoc.getMaSinhVien());
        preparedStatement.setString(2, kqMonHoc.getMaMon());
        preparedStatement.setFloat(3, kqMonHoc.getDiemSo());
        preparedStatement.setString(4, kqMonHoc.getDiemChu());
        preparedStatement.setString(5, kqMonHoc.getNamHoc());
        preparedStatement.setInt(6, kqMonHoc.getHocKy());
        
                                    
        return preparedStatement.executeUpdate() > 0;
   }    
    public boolean update (KQMonHoc kqMonHoc, int maKQ ) throws SQLException{
        Connection connection = JDBCConnection.getJDBCConnection();
        String sql = "UPDATE [dbo].[KetQuaMonHoc] SET [DiemSo] = ? ,[DiemChu] = ? "
                + " WHERE [MaKQ] = ?";

        
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
            
        
        preparedStatement.setFloat(1, kqMonHoc.getDiemSo());
        preparedStatement.setString(2, kqMonHoc.getDiemChu());
        preparedStatement.setInt(3, maKQ);
                
                                    
        return preparedStatement.executeUpdate() > 0;
   }

    public boolean delete(KQMonHoc kqMonHoc) throws SQLException{
        Connection connection = JDBCConnection.getJDBCConnection();
        String sql = "DELETE FROM [dbo].[KetQuaMonHoc] "
                + " WHERE [MaKQ] = ?";
        
        
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            
            preparedStatement.setInt(1, kqMonHoc.getMaKQ());
                        
        return preparedStatement.executeUpdate() > 0;
   }    
    
    public KQMonHoc find (String maSinhVien, String maMon, String namHoc, int hocKy ) throws SQLException{
        Connection connection = JDBCConnection.getJDBCConnection();
        String sql = "select * FROM [dbo].[KetQuaMonHoc] "
                + " WHERE [MaSinhVien] = ? AND [MaMon] = ? AND [NamHoc] = ? AND [HocKy] = ?";
        
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
            
        preparedStatement.setString(1, maSinhVien);
        preparedStatement.setString(2, maMon);
        preparedStatement.setString(3, namHoc);
        preparedStatement.setInt(4, hocKy);
                                    
        try (ResultSet rs = preparedStatement.executeQuery();) {
            if(rs.next()){
                KQMonHoc result = createKQMonHoc(rs);            
                
                return result;
            }
            return null;
        } 
   }
    
    public List<KQMonHoc> findAllKQMonHoc (String maSinhVien, String namHoc, int hocKy ) throws SQLException{
        Connection connection = JDBCConnection.getJDBCConnection();
        String sql = "select * FROM [dbo].[KetQuaMonHoc] "
                + " WHERE [MaSinhVien] = ?  AND [NamHoc] = ? AND [HocKy] = ?";
        
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
            
        preparedStatement.setString(1, maSinhVien);
        preparedStatement.setString(2, namHoc);
        preparedStatement.setInt(3, hocKy);
                                    
        try (ResultSet rs = preparedStatement.executeQuery();) {
            List<KQMonHoc> list = new ArrayList<>();
            while(rs.next()){
                KQMonHoc result = createKQMonHoc(rs);            
                list.add(result);
                
            }
            return list;
        } 
   }    
    
    private KQMonHoc createKQMonHoc(final ResultSet rs) throws SQLException {
        KQMonHoc result = new KQMonHoc();
        result.setMaKQ(rs.getInt("MaKQ"));
        result.setMaMon(rs.getString("MaMon"));
        result.setMaSinhVien(rs.getString("MaSinhVien"));
        result.setDiemChu(rs.getString("DiemChu"));
        result.setDiemSo(rs.getFloat("DiemSo"));
        result.setNamHoc(rs.getString("NamHoc"));
        result.setHocKy(rs.getInt("HocKy"));
        return result;
    }
}

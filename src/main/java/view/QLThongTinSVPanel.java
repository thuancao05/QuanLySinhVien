/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view;

import dao.SinhVienDao;
import helper.DataValidator;
import helper.ImageHelper;
import helper.MessageDialogHelper;
import helper.ShareData;
import java.awt.Image;
import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.rmi.server.LoaderHandler;
import java.sql.SQLException;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.SinhVien;
import model.User;

/**
 *
 * @author Thuan
 */
public class QLThongTinSVPanel extends javax.swing.JPanel {
    
    private MainFrame parentFrame;
    private DefaultTableModel defaultTableModel;
    private byte [] personalImage;
    /**
     * Creates new form QLThongTinSVPanel
     */
    public QLThongTinSVPanel() throws SQLException, IOException {
        initComponents();
        if(ShareData.userLogin.getRole().equals("Giáo Viên")){
            btnBrowse.setVisible(false);
            btnDelete.setVisible(false);
            btnNew.setVisible(false);
            btnSave.setVisible(false);
            btnUpdate.setVisible(false);
            
        }
        initTable();
        loadDataToTable();
        if(ShareData.userLogin.getRole().equals("Sinh Viên"))
             roleSV(ShareData.userLogin);
    }
    
    private void initTable(){
        defaultTableModel = new DefaultTableModel();
        defaultTableModel.setColumnIdentifiers(new String[]{"Mã sinh viên", "Họ và tên", "Email", "Số điện thoại", "Giới tính", "Địa chỉ"});
        tblSinhVien.setModel(defaultTableModel);
    }
    private void loadDataToTable() throws SQLException{
        try{
            SinhVienDao svDao = new SinhVienDao();
            List<SinhVien> list = svDao.findAll();
            defaultTableModel.setRowCount(0);
            for(SinhVien sv : list){
                defaultTableModel.addRow(new Object[]{
                        sv.getMaSinhVien(),sv.getHoTen(),sv.getSoDienThoai()
                        , sv.getEmail(), sv.getGioiTinh()== 1 ? "Nam" : "Nữ", sv.getDiaChi()
                });
            }
            defaultTableModel.fireTableDataChanged();
        }
        catch(Exception e){
            e.printStackTrace();
            MessageDialogHelper.showMessageDialog(parentFrame, e.getMessage(), "Error");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblSinhVien = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txaDiaChi = new javax.swing.JTextArea();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        rdbNam = new javax.swing.JRadioButton();
        jLabel7 = new javax.swing.JLabel();
        rdbNu = new javax.swing.JRadioButton();
        txtMaSinhVien = new javax.swing.JTextField();
        btnUpdate = new javax.swing.JButton();
        txtHoTen = new javax.swing.JTextField();
        btnDelete = new javax.swing.JButton();
        txtEmail = new javax.swing.JTextField();
        btnNew = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtSDT = new javax.swing.JTextField();
        btnSave = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel1 = new javax.swing.JPanel();
        lblImage = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnBrowse = new javax.swing.JButton();
        jSeparator4 = new javax.swing.JSeparator();

        tblSinhVien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblSinhVien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSinhVienMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblSinhVien);

        jLabel3.setText("Họ và tên");

        jSeparator2.setForeground(new java.awt.Color(255, 102, 0));

        jLabel4.setText("Email");

        txaDiaChi.setColumns(20);
        txaDiaChi.setRows(5);
        jScrollPane1.setViewportView(txaDiaChi);

        jSeparator3.setForeground(new java.awt.Color(255, 102, 0));

        jLabel5.setText("Số điện thoại");

        jLabel6.setText("Giới tính");

        buttonGroup1.add(rdbNam);
        rdbNam.setSelected(true);
        rdbNam.setText("Nam");

        jLabel7.setText("Địa chỉ");

        buttonGroup1.add(rdbNu);
        rdbNu.setText("Nữ");

        btnUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Actions-document-edit-icon-16.png"))); // NOI18N
        btnUpdate.setText("Cập nhật");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        txtHoTen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtHoTenActionPerformed(evt);
            }
        });

        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Button-Close-icon-16.png"))); // NOI18N
        btnDelete.setText("Xóa");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnNew.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/new-icon-16.png"))); // NOI18N
        btnNew.setText("Làm mới");
        btnNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewActionPerformed(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("QUẢN LÝ SINH VIÊN");

        txtSDT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSDTActionPerformed(evt);
            }
        });

        btnSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Save-icon.png"))); // NOI18N
        btnSave.setText("Lưu");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        jSeparator1.setForeground(new java.awt.Color(255, 102, 0));

        lblImage.setForeground(new java.awt.Color(255, 255, 255));
        lblImage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/10207-man-student-light-skin-tone-icon-64.png"))); // NOI18N
        lblImage.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblImage, javax.swing.GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblImage, javax.swing.GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel2.setText("Mã Sinh Viên");

        btnBrowse.setText("Chọn hình");
        btnBrowse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBrowseActionPerformed(evt);
            }
        });

        jSeparator4.setForeground(new java.awt.Color(255, 102, 0));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator2)
                    .addComponent(jScrollPane2)
                    .addComponent(jSeparator1)
                    .addComponent(jSeparator3)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 462, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnNew)
                                .addGap(32, 32, 32)
                                .addComponent(btnSave)
                                .addGap(36, 36, 36)
                                .addComponent(btnUpdate)
                                .addGap(43, 43, 43)
                                .addComponent(btnDelete))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel6)
                                            .addComponent(jLabel7))
                                        .addGap(30, 30, 30)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel5)
                                            .addComponent(jLabel4))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(17, 17, 17)
                                                .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addComponent(rdbNam)
                                                        .addGap(32, 32, 32)
                                                        .addComponent(rdbNu))
                                                    .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel2)
                                            .addComponent(jLabel3))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtMaSinhVien, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jSeparator4)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(66, 66, 66)
                                        .addComponent(btnBrowse)))))
                        .addGap(0, 34, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnBrowse))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtMaSinhVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(7, 7, 7)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(7, 7, 7)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rdbNam)
                            .addComponent(jLabel6)
                            .addComponent(rdbNu))
                        .addGap(14, 14, 14)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(36, 36, 36)
                                .addComponent(jLabel7))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 21, Short.MAX_VALUE)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNew)
                    .addComponent(btnSave)
                    .addComponent(btnUpdate)
                    .addComponent(btnDelete))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tblSinhVienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSinhVienMouseClicked
        try {
            int row = tblSinhVien.getSelectedRow();
            if(row >= 0 ){
                String id = (String) tblSinhVien.getValueAt(row, 0);
                SinhVienDao svDao = new SinhVienDao();
                SinhVien sv = svDao.findByID(id);
                loadSV(sv);

            }

        } catch (Exception e) {
            e.printStackTrace();
            MessageDialogHelper.showErrorDialog(parentFrame, e.getMessage(), "Error");

        }
    }//GEN-LAST:event_tblSinhVienMouseClicked

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        StringBuilder sb = new StringBuilder();
        DataValidator.validateEmpty(txtMaSinhVien, sb, "Phải nhập mã sinh viên");
        DataValidator.validateEmpty(txtHoTen, sb, "Phải nhập họ và tên");
        DataValidator.validateNumber(txtSDT, sb, "Số điện thoại sai");
        if (sb.length() > 0) {
            MessageDialogHelper.showErrorDialog(parentFrame, sb.toString(), "Error");
            return;
        }

        try {
            SinhVien sv = new SinhVien();
            sv.setMaSinhVien(txtMaSinhVien.getText());
            sv.setHoTen(txtHoTen.getText());
            sv.setEmail(txtEmail.getText());
            sv.setSoDienThoai(txtSDT.getText());
            sv.setDiaChi(txaDiaChi.getText());
            sv.setGioiTinh(rdbNam.isSelected() ? 1 : 0);
            sv.setHinh(personalImage);

            SinhVienDao svDao = new SinhVienDao();
            if (svDao.update(sv)) {
                MessageDialogHelper.showMessageDialog(parentFrame, "Sinh viên đã được cập nhật", "Thành công");
                loadDataToTable();
            } else {
                MessageDialogHelper.showErrorDialog(parentFrame, "Sinh viên chưa được cập nhật", "Thất bại");
            }

        } catch (Exception e) {
            e.printStackTrace();
            MessageDialogHelper.showErrorDialog(parentFrame, e.getMessage(), "Error");
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void txtHoTenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtHoTenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtHoTenActionPerformed

    private void btnNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewActionPerformed
        txtEmail.setText("");
        txtHoTen.setText("");
        txtSDT.setText("");
        txtMaSinhVien.setText("");
        txaDiaChi.setText("");
        personalImage = null;                                 
        ImageIcon icon = new ImageIcon(getClass().getResource("/icons/10207-man-student-light-skin-tone-icon-64.png"));
        lblImage.setIcon(icon);
    }//GEN-LAST:event_btnNewActionPerformed

    private void txtSDTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSDTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSDTActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        StringBuilder sb = new StringBuilder();
        DataValidator.validateEmpty(txtMaSinhVien, sb, "Phải nhập mã sinh viên");
        DataValidator.validateEmpty(txtHoTen, sb, "Phải nhập họ và tên");
        DataValidator.validateNumber(txtSDT, sb, "Số điện thoại sai");
        if (sb.length() > 0) {
            MessageDialogHelper.showErrorDialog(parentFrame, sb.toString(), "Error");
            return;
        }

        try {
            SinhVien sv = new SinhVien();
            sv.setMaSinhVien(txtMaSinhVien.getText());
            sv.setHoTen(txtHoTen.getText());
            sv.setEmail(txtEmail.getText());
            sv.setSoDienThoai(txtSDT.getText());
            sv.setDiaChi(txaDiaChi.getText());
            sv.setGioiTinh(rdbNam.isSelected() ? 1 : 0);
            sv.setHinh(personalImage);

            SinhVienDao svDao = new SinhVienDao();
            if (svDao.insert(sv)) {
                MessageDialogHelper.showMessageDialog(parentFrame, "Sinh viên đã được thêm", "Thành công");
                loadDataToTable();
            } else {
                MessageDialogHelper.showErrorDialog(parentFrame, "Sinh viên chưa được thêm", "Thất bại");
            }

        } catch (Exception e) {
            e.printStackTrace();
            MessageDialogHelper.showErrorDialog(parentFrame, e.getMessage(), "Error");
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void roleSV(User user) throws SQLException, IOException{
        txtMaSinhVien.setText( user.getUsername());
        txtMaSinhVien.setEnabled(false);
        tblSinhVien.setVisible(false);
        btnNew.setVisible(false);
        btnDelete.setVisible(false);
        btnSave.setVisible(false);
        
        SinhVienDao svDao = new SinhVienDao();
        SinhVien sv = svDao.findByID(user.getUsername());

        loadSV(sv);
    }
    
    private void loadSV(SinhVien sv) throws IOException{
        if (sv != null) {
            txtMaSinhVien.setText(sv.getMaSinhVien());
            txtHoTen.setText(sv.getHoTen());
            txtSDT.setText(sv.getSoDienThoai());
            txtEmail.setText(sv.getEmail());
            txaDiaChi.setText(sv.getDiaChi());
            rdbNam.setSelected(sv.getGioiTinh() == 1 ? true : false);
            if (sv.getHinh() != null) {
                Image image = ImageHelper.createImageFromByteArray(sv.getHinh(), "jpg");
                personalImage = sv.getHinh();
                lblImage.setIcon(new ImageIcon(image));
            } else {
                personalImage = sv.getHinh();
                ImageIcon icon = new ImageIcon(getClass().getResource("/icons/10207-man-student-light-skin-tone-icon-64.png"));
                lblImage.setIcon(icon);
            }
        }     
    }
    private void btnBrowseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBrowseActionPerformed
        JFileChooser chooser = new JFileChooser();
        chooser.setFileFilter(new javax.swing.filechooser.FileFilter() {
            @Override
            public boolean accept(File f) {
                if(f.isDirectory()){
                    return true;
                }else{
                    return f.getName().toLowerCase().endsWith(".jpg");
                }
            }

            @Override
            public String getDescription() {
                return "Image File (*.jpg)";
            
            }
        });
        if(chooser.showOpenDialog(parentFrame) == JFileChooser.CANCEL_OPTION)
                return;
        
        File file = chooser.getSelectedFile();
        try{
            ImageIcon icon = new ImageIcon(file.getPath());
            Image img = ImageHelper.resize(icon.getImage(), 140,160 );
            ImageIcon resizeIcon = new ImageIcon(img);
            lblImage.setIcon(resizeIcon);
            personalImage = ImageHelper.toByteArray(img, "jpg");
        }catch(Exception e){
            e.printStackTrace();
            MessageDialogHelper.showErrorDialog(parentFrame, e.getMessage(), "Error");
                   
        }
    }//GEN-LAST:event_btnBrowseActionPerformed

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
                                                     
                                    

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        StringBuilder sb = new StringBuilder();
        DataValidator.validateEmpty(txtMaSinhVien, sb, "Phải nhập mã sinh viên");
        DataValidator.validateEmpty(txtHoTen, sb, "Phải nhập họ và tên");
        if (sb.length() > 0) {
            MessageDialogHelper.showErrorDialog(parentFrame, sb.toString(), "Error");
            return;
        }

        try {
            if (MessageDialogHelper.showConfirmDialog(parentFrame, "Có chắc muốn xóa " + txtMaSinhVien.getText(), " Chú ý !! ") == JOptionPane.NO_OPTION) {
                return;
            }

            SinhVien student = new SinhVien();
            student.setMaSinhVien(txtMaSinhVien.getText());

            SinhVienDao studentDao = new SinhVienDao();
            if (studentDao.delete(student)) {
                MessageDialogHelper.showMessageDialog(parentFrame, "Sinh viên đã được xóa", "Thành công");
                btnNewActionPerformed(evt);
                loadDataToTable();
            } else {
                MessageDialogHelper.showErrorDialog(parentFrame, "Sinh viên chưa được xóa", "Thất bại");
            }

        } catch (Exception e) {
            e.printStackTrace();
            MessageDialogHelper.showErrorDialog(parentFrame, e.getMessage(), "Error");
        }
    }//GEN-LAST:event_btnDeleteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBrowse;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnNew;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnUpdate;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JLabel lblImage;
    private javax.swing.JRadioButton rdbNam;
    private javax.swing.JRadioButton rdbNu;
    private javax.swing.JTable tblSinhVien;
    private javax.swing.JTextArea txaDiaChi;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtHoTen;
    private javax.swing.JTextField txtMaSinhVien;
    private javax.swing.JTextField txtSDT;
    // End of variables declaration//GEN-END:variables
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package helper;

import java.awt.Color;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author Thuan
 */
public class DataValidator {
    public static void validateEmpty(JTextField field, StringBuilder sb, String erromessage){
        if(field.getText().equals("")){
            sb.append(erromessage).append("\n");
            field.setBackground(Color.red);
            field.requestFocus();
        }else{
            field.setBackground(Color.white);
        }
    }
    
    public static void validateEmpty(JPasswordField field, StringBuilder sb, String erromessage){
        String password = new String(field.getPassword());
        if(password.equals("")){
            sb.append(erromessage).append("\n");
            field.setBackground(Color.red);
            field.requestFocus();
        }else{
            field.setBackground(Color.white);
        }
    }
    public static void validateNumber(JTextField field, StringBuilder sb, String erromessage){
        if(!field.getText().matches("\\d+")){
            sb.append(erromessage).append("\n");
            field.setBackground(Color.red);
            field.requestFocus();
        }else{
            field.setBackground(Color.white);
        }
    }
    public static void validateScore(JTextField field, StringBuilder sb, String erromessage){
        try {
            float score = Float.parseFloat(field.getText());
            if(score < 0 || score > 10){
                sb.append(erromessage).append("\n");
                field.setBackground(Color.red);
                field.requestFocus();
            }else{
                field.setBackground(Color.white);
            }         
            
        } catch (Exception e) {
            sb.append(erromessage).append("\n");
            field.setBackground(Color.red);
            field.requestFocus();
        }
        
 
    }
}

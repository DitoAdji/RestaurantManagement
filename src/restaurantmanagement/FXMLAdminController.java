/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurantmanagement;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.Scanner;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author DITO
 */
public class FXMLAdminController implements Initializable {

    @FXML
    private JFXButton ctkstruk;
    @FXML
    private JFXButton exit;
    @FXML
    private JFXTextField nomermeja;
    @FXML
    private JFXTextArea area;
    private ResultSet rs;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void prosesstruk(ActionEvent event) {
    Connection connection;
    PreparedStatement pst;
    String sql="SELECT * FROM `order2` WHERE no_meja=?";
    try{
    connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/restaurant","root","");
    pst=connection.prepareStatement(sql);
    pst.setString(1,nomermeja.getText());
    rs=pst.executeQuery();
    if(rs.next()){
        
    Scanner masukan = new Scanner(System.in);
        int harga1=55000;
        int harga2=45000;
        int harga3=63500;
        int harga4=67500;
        int harga5=120000;
        int harga6=136900;
        int harga7=23000;
        int harga8=25000;
        int harga9=30000;
        int harga10=30000;
        int harga11=33000;
        int harga12=35000;
        int total;
        
         String add1 = "0";
        String add2 = "0";
        String add3 = "0";
        String add4 ="0";
        String add5 ="0";
        String add6 ="0";
        String add7 ="0";
        String add8 ="0";
        String add9 ="0";
        String add10 ="0";
        String add11 ="0";
        String add12 ="0";
        
        int total1=Integer.parseInt(add1);
        int total2=Integer.parseInt(add2);
        int total3=Integer.parseInt(add3);
        int total4=Integer.parseInt(add4);
        int total5=Integer.parseInt(add5);
        int total6=Integer.parseInt(add6);
        int total7=Integer.parseInt(add7);
        int total8=Integer.parseInt(add8);
        int total9=Integer.parseInt(add9);
        int total10=Integer.parseInt(add10);
        int total11=Integer.parseInt(add11);
        int total12=Integer.parseInt(add12);

total = (harga1*total1)+(harga2*total2)+
                 (harga3*total3)+(harga4*total4)+
                 (harga5*total5)+(harga6*total6)+
                 (harga7*total7)+(harga8*total8)+(harga9*total9)
                 +(harga10*total10)+(harga11*total11)+(harga12*total12);
        
        add1 = rs.getString("ma1");
        add2 = rs.getString("ma2");
        add3 = rs.getString("ma3");
        add4 = rs.getString("ma4");
        add5 = rs.getString("ma5");
        add6 = rs.getString("ma6");
        add7 = rs.getString("mi1");
        add8 = rs.getString("mi2");
        add9 = rs.getString("mi3");
        add10 = rs.getString("mi4");
        add11 = rs.getString("mi5");
        add12 = rs.getString("mi6");

        area.setText("Makanan 1 : " + add1
                + "\n Harga : " + harga1
                + "\n\nMakanan 2 : " + add2
                + "\n Harga : " + harga2
                + "\n\nMakanan 3 : " + add3
                + "\n Harga : " + harga3
                + "\n\nMakanan 4 : " + add4
                + "\n Harga : " + harga4
                + "\n\nMakanan 5 : " + add5
                + "\n Harga : " + harga5
                + "\n\nMakanan 6 : " + add6
                + "\n Harga : " + harga6
                + "\n\nMinuman 1 : " + add7
                + "\n Harga : " + harga7
                + "\n\nMinuman 2 : " + add8
                + "\n Harga : " + harga8
                + "\n\nMinuman 3 : " + add9
                + "\n Harga : " + harga9
                + "\n\nMinuman 4 : " + add10
                + "\n Harga : " + harga10
                + "\n\nMinuman 5 : " + add11
                + "\n Harga : " + harga11
                + "\n\nMinuman 6 : " + add12
                + "\n Harga : " + harga12
                + "\n\n\nHARGA TOTAL : "+total);


        
    }else{
    JOptionPane.showMessageDialog(null,"Nomor Meja tidak ditemukan!");
    }
    }catch(SQLException e){
    JOptionPane.showMessageDialog(null,e);
    }
    }

    @FXML
    private void prosesexit(ActionEvent event) {
    System.exit(0);
    }

    
    
}

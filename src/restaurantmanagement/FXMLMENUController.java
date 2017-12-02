/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurantmanagement;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;
import java.sql.*;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author DITO
 */
public class FXMLMENUController implements Initializable {

    @FXML
    private JFXTextField ma1;

    @FXML
    private JFXTextField ma2;

    @FXML
    private JFXTextField ma3;

    @FXML
    private JFXTextField ma4;

    @FXML
    private JFXTextField ma5;

    @FXML
    private JFXTextField ma6;

    @FXML
    private JFXTextField mi1;

    @FXML
    private JFXTextField mi2;

    @FXML
    private JFXTextField mi3;

    @FXML
    private JFXTextField mi4;

    @FXML
    private JFXTextField mi5;

    @FXML
    private JFXTextField mi6;
    @FXML
    private JFXButton orderbutton;
    @FXML
    private JFXTextField meja;
    public static String mak1;
    public static String mak2;
    public static String mak3;
    public static String mak4;
    public static String mak5;
    public static String mak6;
    public static String min1;
    public static String min2;
    public static String min3;
    public static String min4;
    public static String min5;
    public static String min6;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void prosesorder(ActionEvent event) throws IOException, SQLException {

        Connection connection;
        PreparedStatement st;
        try {
            if (meja.getText().length() == 0) {
                JOptionPane.showMessageDialog(null, "Mohon Isi Nomer Meja");
            } else if (ma1.getText().length() != 0 || ma2.getText().length() != 0 || ma3.getText().length() != 0 || ma4.getText().length() != 0
                    || ma5.getText().length() != 0 || ma6.getText().length() != 0 || mi1.getText().length() != 0 || mi2.getText().length() != 0
                    || mi3.getText().length() != 0 || mi4.getText().length() != 0 || mi5.getText().length() != 0
                    || mi6.getText().length() != 0) {
                connection = DriverManager.getConnection("jdbc:mysql://localhost/restaurant?zeroDate TimeBehavior=convertToNull", "root", "");
                st = connection.prepareStatement("INSERT INTO `order2`(`no_meja`, `ma1`, `ma2`, `ma3`, `ma4`, `ma5`, `ma6`, `mi1`, `mi2`, `mi3`, `mi4`, `mi5`, `mi6`) values(?,?,?,?,?,?,?,?,?,?,?,?,?)");
                st.setString(1, meja.getText());
                st.setString(2, ma1.getText());
                st.setString(3, ma2.getText());
                st.setString(4, ma3.getText());
                st.setString(5, ma4.getText());
                st.setString(6, ma5.getText());
                st.setString(7, ma6.getText());
                st.setString(8, mi1.getText());
                st.setString(9, mi2.getText());
                st.setString(10, mi3.getText());
                st.setString(11, mi4.getText());
                st.setString(12, mi5.getText());
                st.setString(13, mi6.getText());

                st.execute();
                JOptionPane.showMessageDialog(null, "Terima Kasih Sudah Memesan");
                ((Node) (event.getSource())).getScene().getWindow().hide();
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("FXMLAdmin.fxml"));
                Scene scene = new Scene(fxmlLoader.load(), 830, 450);
                Stage stage = new Stage();
                stage.setScene(scene);
                stage.setTitle("MenuAwal");
                stage.show();
            } else if (ma1.getText().length() == 0 || ma2.getText().length() == 0 || ma3.getText().length() == 0 || ma4.getText().length() == 0
                    || ma5.getText().length() == 0 || ma6.getText().length() == 0 || mi1.getText().length() == 0 || mi2.getText().length() == 0
                    || mi3.getText().length() == 0 || mi4.getText().length() == 0 || mi5.getText().length() == 0
                    || mi6.getText().length() == 0) {
                JOptionPane.showMessageDialog(null, "Mohon Pilih Makanan atau Minuman Yang Anda Order");
            }

            meja.setText("");
            ma1.setText("");
            ma2.setText("");
            ma3.setText("");
            ma4.setText("");
            ma5.setText("");
            ma6.setText("");
            mi1.setText("");
            mi2.setText("");
            mi3.setText("");
            mi4.setText("");
            mi5.setText("");
            mi6.setText("");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
}

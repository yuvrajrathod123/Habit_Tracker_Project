package habitude.habitude1;

import javafx.scene.Node;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.event.ActionEvent;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;

import static habitude.habitude1.databaseController.getconnection;

public  class Logincontroller extends NullPointerException {
    @FXML
    private Label message;
    @FXML
    private TextField username;
    @FXML
    private PasswordField password;
    @FXML
    public void login(ActionEvent e) {

        if (!username.getText().isBlank() && !password.getText().isBlank() ){
            validatelogin(e);

        } else {
            message.setText("Both Username & Password Needed");
        }
    }
    public static String user ,pass;
    @FXML



    
    public void signup (ActionEvent e) {

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("signup.fxml"));
            ((Node)(e.getSource())).getScene().getWindow().hide();
            Parent root1 = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.show();
        } catch (Exception ep) {
            ep.printStackTrace();
        }
    }
    @FXML
    public void cancel(ActionEvent e) {

        try {

            ((Node)(e.getSource())).getScene().getWindow().hide();

        } catch (Exception ep) {
            ep.printStackTrace();
        }
    }

    public void validatelogin(ActionEvent e) {
        databaseController databaseController = new databaseController();
        Object connectnow = null;
        Connection connectdb;
        connectdb = getconnection();
        String verifylogin = "select count(1) from login where username='" + username.getText() + "' and Password='" + password.getText() + "'";
        try {
            Statement statement = connectdb.createStatement();
            ResultSet queryResult = statement.executeQuery(verifylogin);
            while (queryResult.next()) {
                if (queryResult.getInt(1) == 1) {
                    try {
                        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("dashboard.fxml"));
                        ((Node)(e.getSource())).getScene().getWindow().hide();
                        Parent root1 = fxmlLoader.load();
                        Stage stage = new Stage();
                        stage.setScene(new Scene(root1));
                        stage.show();
                    } catch (Exception ep)
                    {
                        ep.printStackTrace();
                    }
                } else {
                    message.setText("Wrong username or password");
                }
            }
        } catch (Exception ep) {
            ep.printStackTrace();
        }

    }

}




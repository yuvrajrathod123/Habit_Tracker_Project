package habitude.habitude1;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import java.sql.*;
public  class SignupController extends NullPointerException {

    @FXML
    private Label message;
    @FXML
    private TextField tf_username;
    @FXML
    private TextField tf_lastname;
    @FXML
    private TextField tf_firstname;
    @FXML
    private TextField tf_email;
    @FXML
    private PasswordField tf_password;
    @FXML
    private PasswordField tf_confirmpassword;

    @FXML
    protected void submit(ActionEvent e) {

        String Firstname = tf_firstname.getText();
        String Lastname = tf_lastname.getText();
        String username = tf_username.getText();
        String email = tf_email.getText();
        String Password = tf_password.getText();
        String Confirmpassword = tf_confirmpassword.getText();

        databaseController connectnow = new databaseController();
        Connection connectdb = connectnow.getconnection();
        PreparedStatement psinsert = null;
        PreparedStatement pscheck = null;
        ResultSet resultSet = null;
        if (!tf_firstname.getText().isBlank() && !tf_lastname.getText().isBlank() && !tf_username.getText().isBlank() && !tf_email.getText().isBlank() && !tf_password.getText().isBlank() && !tf_confirmpassword.getText().isBlank()) {
            try {
                pscheck = connectdb.prepareStatement("select * from login where username= ?");
                pscheck.setString(1, String.valueOf(username));
                resultSet = pscheck.executeQuery();
                if (resultSet.isBeforeFirst()) {

                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setContentText("YOU CAN NOT USE THIS USERNAME.");
                    alert.show();
                } else {

                    psinsert = connectdb.prepareStatement("insert into login VALUES (?,?,?,?,?,?)");
                    psinsert.setString(1, String.valueOf(username));
                    psinsert.setString(2, Firstname);
                    psinsert.setString(3, Lastname);
                    psinsert.setString(4, email);
                    psinsert.setString(5, Password);
                    psinsert.setString(6, Confirmpassword);
                    psinsert.executeUpdate();
                    message.setText("Registered Successfully!!");
                }
            } catch (SQLException ep) {
                ep.printStackTrace();
            }
        } else {
            message.setText("All Fields Are compulsory...");

        }

    }

    @FXML
    protected void login(ActionEvent e) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("login.fxml"));
            ((Node) (e.getSource())).getScene().getWindow().hide();
            Parent root1 = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.show();
        } catch (Exception ep) {
            ep.printStackTrace();
        }
    }

     @FXML
    protected void back(ActionEvent e) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("login.fxml"));
            ((Node) (e.getSource())).getScene().getWindow().hide();
            Parent root1 = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.show();
        } catch (Exception ep) {
            ep.printStackTrace();
        }
    }
}


















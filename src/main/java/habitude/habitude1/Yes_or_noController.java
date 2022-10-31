package habitude.habitude1;

//import javafx.event.ActionEvent;
//import javafx.fxml.FXML;
//import javafx.fxml.FXMLLoader;
//import javafx.scene.Node;
//import javafx.scene.Parent;
//import javafx.scene.Scene;
//import javafx.scene.control.TextField;
//import javafx.stage.Stage;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//
//public class YesornoController extends NullPointerException{
//
//
//
//
//
//
//    @FXML
//    public void Measurable(ActionEvent e) {
//
//        try {
//            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Measurable.fxml"));
//            ((Node)(e.getSource())).getScene().getWindow().hide();
//            Parent root1 = fxmlLoader.load();
//            Stage stage = new Stage();
//            stage.setScene(new Scene(root1));
//            stage.show();
//        } catch (Exception ep) {
//            ep.printStackTrace();
//        }
//    }
//
//    @FXML
//    public void yesorno(ActionEvent e) {
//        try {
//            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("yesorno.fxml"));
//            ((Node)(e.getSource())).getScene().getWindow().hide();
//            Parent root1 = fxmlLoader.load();
//            Stage stage = new Stage();
//            stage.setScene(new Scene(root1));
//            stage.show();
//        }catch (Exception ep)
//        {
//            ep.printStackTrace();
//        }
//    }
//
//    @FXML
//    public void logout (ActionEvent e) {
//
//        try {
//            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("login.fxml"));
//            ((Node)(e.getSource())).getScene().getWindow().hide();
//            Parent root1 = fxmlLoader.load();
//            Stage stage = new Stage();
//            stage.setScene(new Scene(root1));
//            stage.show();
//        } catch (Exception ep) {
//            ep.printStackTrace();
//        }
//    }
//
//    @FXML
//    public void score (ActionEvent e) {
//
//        try {
//            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("score.fxml"));
//            ((Node)(e.getSource())).getScene().getWindow().hide();
//            Parent root1 = fxmlLoader.load();
//            Stage stage = new Stage();
//            stage.setScene(new Scene(root1));
//            stage.show();
//        } catch (Exception ep) {
//            ep.printStackTrace();
//        }
//    }
//}





import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.EventObject;

public class Yes_or_noController {

    @FXML
    private Label message;
    @FXML
    private Button Measurable;


    @FXML
    private TextField frequency;

    @FXML
    private TextField habitname;

    @FXML
    private Button logout;

    @FXML
    private TextField question;
//    @FXML
//    private TextField target;

//    @FXML
//    private Button score;

    @FXML
    private Button yesorno;


    @FXML
    public void save(ActionEvent e){
        String Habit_name = habitname.getText();
        String Frequency = frequency.getText();
        String Question = question.getText();
//

        databaseController connectnow = new databaseController();
        Connection connectdb = connectnow.getconnection();
        PreparedStatement psinsert = null;
        PreparedStatement pscheck = null;
        ResultSet resultSet = null;
        if (!habitname.getText().isBlank() && !frequency.getText().isBlank() && !question.getText().isBlank()) {
            try {
                pscheck = connectdb.prepareStatement("select * from y_or_n where Habit_name= ?");
               // boolean username = false;
                pscheck.setString(1, String.valueOf(Habit_name));
                resultSet = pscheck.executeQuery();
                if (resultSet.isBeforeFirst()) {

                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setContentText("YOU CAN NOT USE THIS USERNAME.");
                    alert.show();
                } else {

                    psinsert = connectdb.prepareStatement("insert into y_or_n (Habit_name,Frequency,Question) VALUES (?,?,?)");
                    psinsert.setString(1, String.valueOf(Habit_name));
                    psinsert.setString(2,String.valueOf( Frequency));
                    psinsert.setString(3, String.valueOf(Question));
//
                    psinsert.executeUpdate();
                    message.setText("Habit Saved!!");
                }
            } catch (SQLException ep) {
                ep.printStackTrace();
            }
       }
         else {
            message.setText("All Fields Are compulsory...");

        }

    }




    @FXML
    public void Measurable(ActionEvent e) {

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Measurable.fxml"));
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
    public void yesorno(ActionEvent e) {

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("yesorno.fxml"));
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
    public void logout(ActionEvent e) {

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
    public void home(ActionEvent e) {

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("dashboard.fxml"));
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
    public void score(ActionEvent e) {

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("score.fxml"));
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

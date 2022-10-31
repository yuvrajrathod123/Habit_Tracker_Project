package habitude.habitude1;



//import javafx.event.ActionEvent;
//import javafx.fxml.FXML;
//import javafx.fxml.FXMLLoader;
//import javafx.scene.Node;
//import javafx.scene.Parent;
//import javafx.scene.Scene;
//import javafx.scene.control.Alert;
//import javafx.scene.control.Label;
//import javafx.scene.control.TextField;
//import javafx.stage.Stage;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//
//public class MeasurableController extends NullPointerException {
//
//    @FXML
//    private Label message;
//    @FXML
//    private TextField habitname;
//
//    @FXML
//    private TextField question;
//
//    @FXML
//    private TextField target;
//    @FXML
//    private TextField unit;
//    @FXML
//    private TextField frequency;
//
//    public MeasurableController() {
//    }
//
//
//    @FXML
//    protected void save(ActionEvent e) {
//
//        String Habitname = habitname.getText();
//        String Question = question.getText();
//        String Target = target.getText();
//        String Unit = unit.getText();
//
//
//        int m_id = 1;
//
//        String Frequency = frequency.getText();
//
//        databaseController connectnow = new databaseController();
//        Connection connectdb = connectnow.getconnection();
//        PreparedStatement psinsert = null;
//        PreparedStatement pscheck = null;
//        ResultSet resultSet = null;
//        if (!habitname.getText().isBlank() && !question.getText().isBlank() && !target.getText().isBlank() && !unit.getText().isBlank() && !frequency.getText().isBlank()) {
//            try {
//                pscheck = connectdb.prepareStatement("select * from habit where m_id= ?");
//                pscheck.setString(1, String.valueOf(m_id));
//                resultSet = pscheck.executeQuery();
//
//                if (resultSet.isBeforeFirst()) {
//
//                    Alert alert = new Alert(Alert.AlertType.ERROR);
//                    alert.setContentText("YOU CAN NOT USE THIS USERNAME.");
//                    alert.show();
//                } else {
//
//                    psinsert = connectdb.prepareStatement("insert into habit VALUES (?,?,?,?,?,?)");
//                    psinsert.setInt(1, Integer.parseInt(String.valueOf(m_id)));
//                    psinsert.setString(2, String.valueOf(Habitname));
//                    // psinsert.setString(2, String.valueOf(colour));
//                    psinsert.setString(3, String.valueOf(Question));
//                    psinsert.setString(4, String.valueOf(Target));
//                    psinsert.setString(5, String.valueOf(Unit));
//                    psinsert.setString(6, String.valueOf(Frequency));
//
//                    psinsert.executeUpdate();
//                    message.setText("Habit Saved!!");
//                    m_id++;
//                }
//            } catch (SQLException ep) {
//                ep.printStackTrace();
//            }
//        } else {
//            message.setText("All Fields Are compulsory...");
//
//        }
//
//    }
//
//
//    @FXML
//    public void Measurable(ActionEvent e) {
//
//        try {
//            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Measurable.fxml"));
//            ((Node) (e.getSource())).getScene().getWindow().hide();
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
//
//        try {
//            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("yesorno.fxml"));
//            ((Node) (e.getSource())).getScene().getWindow().hide();
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
//    public void logout(ActionEvent e) {
//
//        try {
//            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("login.fxml"));
//            ((Node) (e.getSource())).getScene().getWindow().hide();
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
//    public void score(ActionEvent e) {
//
//        try {
//            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("score.fxml"));
//            ((Node) (e.getSource())).getScene().getWindow().hide();
//            Parent root1 = fxmlLoader.load();
//            Stage stage = new Stage();
//            stage.setScene(new Scene(root1));
//            stage.show();
//        } catch (Exception ep) {
//            ep.printStackTrace();
//        }
//    }
//
//}




import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import habitude.habitude1.Logincontroller;

public class MeasurableController extends NullPointerException {

    @FXML
    private Label message;
    @FXML
    private TextField habitname;

    @FXML
    private TextField question;

    @FXML
    private TextField target;
    @FXML
    private TextField unit;
    @FXML
    private TextField frequency;

    public MeasurableController() {
    }


    @FXML
    protected void save(ActionEvent e) {

        String Habitname = habitname.getText();
        String Question = question.getText();
        String Target = target.getText();
        String Unit = unit.getText();
        String username = Logincontroller.user;

        System.out.println("reached here" + username);

      //  int m_id = 1;

        String Frequency = frequency.getText();

        databaseController connectnow = new databaseController();
        Connection connectdb = connectnow.getconnection();
        PreparedStatement psinsert = null;
        PreparedStatement pscheck = null;
        ResultSet resultSet = null;
        if (!habitname.getText().isBlank() && !question.getText().isBlank() && !target.getText().isBlank() && !unit.getText().isBlank() && !frequency.getText().isBlank()) {
            try {
                pscheck = connectdb.prepareStatement("select * from habit where habitname= ?");
                pscheck.setString(1, String.valueOf(habitname));
                resultSet = pscheck.executeQuery();

                if (resultSet.isBeforeFirst()) {

                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setContentText("YOU CAN NOT USE THIS USERNAME.");
                    alert.show();
                } else {

                    psinsert = connectdb.prepareStatement("insert into habit(Habitname,Question,Target,Unit,Frequency) VALUES (?,?,?,?,?)");
                  //  psinsert.setInt(1, Integer.parseInt(String.valueOf(m_id)));
                    psinsert.setString(1, String.valueOf(Habitname));
                    // psinsert.setString(2, String.valueOf(colour));
                    psinsert.setString(2, String.valueOf(Question));
                    psinsert.setString(3, String.valueOf(Target));
                    psinsert.setString(4, String.valueOf(Unit));
                    psinsert.setString(5, String.valueOf(Frequency));

                    psinsert.executeUpdate();
                    message.setText("Habit Saved!!");

                }
            } catch (SQLException ep) {
                ep.printStackTrace();
            }
        } else {
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

}
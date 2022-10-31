package habitude.habitude1;


import java.sql.Connection;
import java.sql.DriverManager;

//import static java.lang.Class.forName;

public class databaseController {

    public static void main(String[] args) {

        getconnection();

    }

    public static Connection getconnection() {
        try{
            String driver = "com.mysql.cj.jdbc.Driver";
            String databaseurl = "jdbc:mysql://localhost:3306/habitude";
            String username = "root";
            String password = "Yuvraj@5587";
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(databaseurl,username,password);
            System.out.println("database connected");
            return conn;
        }
        catch(Exception e){
            System.out.println(e);
        }


        return null;
    }
}

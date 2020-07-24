package pages;

import java.sql.*;

// i use this library in pom file for my framework
//<dependency>
//            <groupId>mysql</groupId>
//            <artifactId>mysql-connector-java</artifactId>
//            <version>8.0.19</version>
//</dependency>

public class QueryDB {

    //Probably its better to put it into class TestContext

    public void getDBQuery(){

        Connection conection = null;
        Statement statment = null;
        ResultSet result = null;

        String url = "jdbc:mysql://24.4.202.10:3307/Assessment controll/application";// I think problem is here
        String user = "testuser";
        String password = "password";
        try{
            conection = DriverManager.getConnection(url, user, password);
            statment = conection.createStatement();
            result = statment.executeQuery("SELECT * FROM users;");

//            if(result.next()){
//                System.out.println(result.getString(1));
//            }
            while(result.next())
            {
                System.out.println(result.getString("Colomn_Name"));//or getString(1) for coloumn 1 etc
            }

        }catch (SQLException ex){

//            Logger lgr = Logger.getLogger(Version.class.getName());
//            lgr.log(Level.SEVERE, ex.getMessage(), ex);

            System.out.println("An error Maybe username or password invalid");
            ex.printStackTrace();
        } finally {
            try {
                if (result != null) {
                    result.close();
                }
                if (statment != null) {
                    statment.close();
                }
                if (conection != null) {
                    conection.close();
                }
            } catch (SQLException ex) {
//                Logger lgr = Logger.getLogger(Version.class.getName());
//                lgr.log(Level.WARNING, ex.getMessage(), ex);

                System.out.println("An error - Still in prosess");
                ex.printStackTrace();
            }
        }

    }

}

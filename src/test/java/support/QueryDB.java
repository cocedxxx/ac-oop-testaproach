package support;

import java.sql.*;

import static support.TestContext.getConfig;

// i use this library in pom file for my framework
//<dependency>
//            <groupId>mysql</groupId>
//            <artifactId>mysql-connector-java</artifactId>
//            <version>8.0.19</version>
//</dependency>

public class QueryDB {

    public String getDBQuery(String querySelect, String fieldName){
        Connection conection = null;
        Statement statment = null;
        ResultSet result = null;

        String url = getConfig().dataBaseUrl;
        String user = getConfig().dataBaseUser;
        String password = getConfig().dataBasePass;
        try{
            conection = DriverManager.getConnection(url, user, password);
            statment = conection.createStatement();
            result = statment.executeQuery(querySelect);
            while(result.next()) {
                return result.getString(fieldName);
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
        return null;
    }
}

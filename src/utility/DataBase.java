package utility;

import java.sql.Connection;
import java.sql.DriverManager;

public class DataBase {

    static private Connection  connection;

    public static Connection getConnection() throws Exception{
        if(connection == null){
            //JDBC
        	Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/JD", "postgres",
					"ROOT123");
        }
        return connection;
    }

}





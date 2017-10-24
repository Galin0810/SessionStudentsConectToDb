package realizationsDAO;

import java.sql.*;
import java.util.List;

public class ConnectionFactory {
    public static Connection connection;
    private static final String URL = "jdbc:mysql://localhost:3306/session?useUnicode=true&useSSL=true&useJDBCCompliantTimezoneShift=true" +
            "&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASS = "root";
    
   
       public static Connection getConnection(){
           

        try {System.out.println("Connection to db");
             return DriverManager.getConnection(URL, USER, PASS);

        }catch (SQLException s){
           throw new RuntimeException("Error connecting to the database",s);
       
           
        }
    }


    public static void main(String[] args) {
        connection = ConnectionFactory.getConnection();
        System.out.println("MAIN");
        List <Students > sts = StudentsDAO.getUser(2);
        System.out.println(sts.get(1).name);

}}

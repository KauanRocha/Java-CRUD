package br.com.crud.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

        private static final String USERNAME = "root";
        private static final String PASSWORD = "";
        private static final String DATABASE = "jdbc:mysql://localhost:3306/crud";

        //conectando com o banco

        public static Connection createConnectionToMySQL() throws ClassNotFoundException, SQLException {

                    Class.forName("com.mysql.jdbc.Driver");
                    Connection connection = DriverManager.getConnection(DATABASE, USERNAME, PASSWORD);

                    return connection;
        }

        public static void main(String[] args) throws SQLException, ClassNotFoundException {
                Connection con = createConnectionToMySQL();

                if(con!=null){
                        System.out.println("Conexão obtida com sucesso!");
                        con.close();
                }
        }
}

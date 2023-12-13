package code;

import java.sql.*;

public class Conexao {
    // utilizando o JDBC postgresql
    // funcao para estabelecer a conexao com o banco de dados poo_Teste
    private final String url = "jdbc:postgresql://localhost:5432/poo_projeto";
    private final String user = "postgres";
    private final String password = "123";

    public Connection getConnection() {
        try {
            return DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            System.out.println("Erro ao conectar ao banco de dados");
            throw new RuntimeException(e);
        }
    }

    public void closeConnection(Connection con) {
        try {
            if (con != null) {
                System.out.println("Encerrando conexao com o banco de dados");
                con.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }



}
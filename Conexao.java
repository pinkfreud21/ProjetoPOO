import java.sql.*;

public class Conexao {
    // utilizando o JDBC postgresql
    // funcao para estabelecer a conexao com o banco de dados poo_Teste
    private final String url = "jdbc:postgresql://localhost:5432/poo_projeto";
    private final String user = "postgres";
    private final String password = "9200";

    public Connection getConnection() {
        try {
            System.out.println("Conectando ao banco de dados");
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

    public void Criar_tabela_Cliente() {
        // verificar se tabela cliente existe, se existir printar que existe e nao fazer nada
        // se nao existir, criar a tabela cliente
        Connection con = getConnection();
        try {
            Statement stmt = con.createStatement();
            String sql = "CREATE TABLE Cliente " + "(id SERIAL PRIMARY KEY," + " nome VARCHAR(255), "
                    + " usuario VARCHAR(255), " + " senha VARCHAR(255), " + " email VARCHAR(255), "
                    + " cpf VARCHAR(255), " + " saldo FLOAT)";
            stmt.executeUpdate(sql);
            stmt.close();
            System.out.println("Tabela Cliente criada com sucesso");
        } catch (SQLException e) {
            System.out.println("Tabela Cliente ja existe");

        }
    }

    public void Criar_tabela_Jogos(){
        Connection conGames = getConnection();
        try {
            Statement stmtGames = conGames.createStatement();
            String sqlGames = "CREATE TABLE Jogos " + "(id SERIAL PRIMARY KEY," + " nome VARCHAR(255), "
                    + " preco FLOAT, " + " genero VARCHAR(255), " + " desenvolvedora VARCHAR(255), "  + " descricao VARCHAR(255))";
            stmtGames.executeUpdate(sqlGames);
            stmtGames.close();
            System.out.println("Tabela Jogos criada com sucesso");
        } catch (SQLException e) {
            System.out.println("Tabela Jogos ja existe");
        }
    }


}
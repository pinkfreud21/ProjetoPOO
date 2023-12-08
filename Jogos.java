import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Jogos {
    private String nome;
    private float preco;
    private String genero;
    private String desenvolvedora;
    private String descricao;
    private int id;



    public Jogos(String nome, float preco, String genero, String desenvolvedora, String descricao){
        this.nome = nome;
        this.preco = preco;
        this.genero = genero;
        this.desenvolvedora = desenvolvedora;
        this.descricao = descricao;
    }

    public Jogos() {}

    public void jogos_banco(int numero) throws SQLException {
        if (numero == 0) {
            System.out.println("Voce precisa estar logado para comprar jogos");
            return;
        } else {
            System.out.println("id cliente menu logado: " + numero);
        }
        Conexao con = new Conexao();
        // percorrer as linhas da tabela jogos e mostrar os jogos disponiveis
        Statement stmt = con.getConnection().createStatement();
        String sql = "SELECT COUNT(*) FROM jogos;";
        ResultSet rs = stmt.executeQuery(sql);
        rs.next();
        int qtd_jogos = rs.getInt("count");
        ArrayList<Jogos> jogo = new ArrayList<Jogos>();
        for (int i = 1; i <= qtd_jogos; i++) {
            sql = "SELECT * FROM jogos WHERE id = " + i + ";";
            rs = stmt.executeQuery(sql);
            rs.next();


            System.out.println("ID: " + rs.getInt("id"));
            System.out.println("Nome: " + rs.getString("nome"));
            System.out.println("Preco: " + rs.getFloat("preco"));
            System.out.println("Genero: " + rs.getString("genero"));
            System.out.println("Desenvolvedora: " + rs.getString("desenvolvedora"));
            System.out.println("Descricao: " + rs.getString("descricao"));
            System.out.println("-------------------------------------------------");
            jogo.add(new Jogos(rs.getString("nome"), rs.getFloat("preco"), rs.getString("genero"), rs.getString("desenvolvedora"), rs.getString("descricao")));
        }
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o nome do jogo que deseja comprar: ");
        String nome_jogo = sc.nextLine();
        String sql2 = "SELECT nome, preco FROM jogos WHERE nome = '" + nome_jogo + "';";
        rs = stmt.executeQuery(sql2);
        rs.next();
        System.out.println("Nome: " + rs.getString("nome"));
        System.out.println("Preco: " + rs.getFloat("preco"));
        float preco_jogo = rs.getFloat("preco");

        System.out.println("Deseja comprar esse jogo? (S/N)");
        String op = sc.nextLine();
        op = op.toUpperCase();
        if (op.equals("S")) {
            // verificar se saldo cliente e o suficiente para comprar o jogo
            String sql3 = "SELECT * FROM cliente WHERE id = " + numero + ";";
            rs = stmt.executeQuery(sql3);
            rs.next();
            if (rs.getFloat("saldo") < preco_jogo) {
                System.out.println("Saldo insuficiente");
                return;
            }
            System.out.println("Compra efetuada com sucesso");
            // atualizar o saldo do cliente
            String sql4 = "UPDATE cliente SET saldo = saldo - " + preco_jogo + " WHERE id = " + numero + ";";
            stmt.executeUpdate(sql4);
            // pegar informacoes do jogo comprado e inserir no banco de dados historico
            String sql5 = "SELECT * FROM jogos WHERE nome = '" + nome_jogo + "';";
            rs = stmt.executeQuery(sql5);
            rs.next();
            String idjogo = rs.getString("id");
            String nomecompra = rs.getString("nome");
            String precojogo = rs.getString("preco");
            String descricao = rs.getString("descricao");
            String sql6 = "INSERT INTO historico (idcliente, idjogo, nomecompra, precojogo) VALUES (" + numero + ", " + idjogo + ", '" + nomecompra + "', " + precojogo + ");";
            stmt.executeUpdate(sql6);
            System.out.println("Jogo adicionado ao historico de compras");
            // Inserir o jogo na biblioteca
            String sql7 = "INSERT INTO biblioteca (idcliente, idjogo, nome, preco, descricao) VALUES (" + numero + ", " + idjogo + ", '" + nomecompra + "', '" + descricao + "');";
            stmt.executeUpdate(sql7);
            System.out.println("Jogo adicionado a sua biblioteca");
        } else {
            System.out.println("Compra cancelada");
        }

        }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getDesenvolvedora() {
        return desenvolvedora;
    }

    public void setDesenvolvedora(String desenvolvedora) {
        this.desenvolvedora = desenvolvedora;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}

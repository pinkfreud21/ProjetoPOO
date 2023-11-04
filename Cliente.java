import java.util.Scanner;
import java.sql.*;
public class Cliente extends Conexao implements Login, Cadastro{
    private String user;
    private String password;
    private String email;
    private String CPF;
    private float saldo;
    private String nome;
    private boolean logado;
    public int id;





    public Cliente(String user, String password, String email, String CPF, float saldo, String nome) {
        this.user = user;
        this.password = password;
        this.email = email;
        this.CPF = CPF;
        this.saldo = saldo;
        this.nome = nome;
    }

    public Cliente(){

    }


    public void login(){
        // se usuario digitar usuario e senha percorrer pelo banco de dados na tabela cliente e verificar se existe
        // se existir, efeturar o login e mudar o metodo isLogged para true
        // se nao existir, nao efetuar o login e manter o metodo isLogged como false
        Scanner sc = new Scanner(System.in);
        System.out.println("-------------Login----------------");
        System.out.println("Digite o usuario: ");
        String userAux = sc.nextLine();
        System.out.println("Digite a senha: ");
        String passwordAux = sc.nextLine();
        Conexao con = new Conexao();
        // verificar se existe no banco de dados se nao existir pedir novamente o usuario e senha
        try {
            Statement stmt = con.getConnection().createStatement();
            String sql = "SELECT * FROM Cliente WHERE usuario = '" + userAux + "' AND senha = '" + passwordAux + "';";
            ResultSet rs = stmt.executeQuery(sql);
            if(rs.next()){
                System.out.println("Login efetuado com sucesso");
                this.user = userAux;
                this.password = passwordAux;
                this.email = rs.getString("email");
                this.CPF = rs.getString("cpf");
                this.saldo = rs.getFloat("saldo");
                this.nome = rs.getString("nome");
                this.setLogado(true);
                // retorne o id do cliente logado do banco de dados
                this.id = rs.getInt("id");         // implementar logica de retornar id para esta variavel
                System.out.println("id do cliente logado: " + id);  // e utilizar ela para inserir no banco de dados.(feito)

                isLogged(true);
            }else{
                System.out.println("Usuario ou senha incorretos");
                isLogged(false);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public boolean isLogged(boolean x) {
        return x;
    }


    public void cadastrar() throws SQLException {
        System.out.println("------------Cadastro--------------");
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o nome: ");
        String nomeAux = sc.nextLine();
        System.out.println("Digite o CPF: ");
        String CPFAux = sc.nextLine();
        System.out.println("Digite o email: ");
        String emailAux = sc.nextLine();
        System.out.println("Digite o usuario: ");
        String userAux = sc.nextLine();
        System.out.println("Digite a senha: ");
        String passwordAux = sc.nextLine();

        // inserir no banco de dados na tabela cliente
        Connection con2 = getConnection();
        Statement stmt2 = con2.createStatement();
        String sql2 = "INSERT INTO Cliente(nome, cpf, email, usuario, senha, saldo) VALUES ('" + nomeAux + "', '" + CPFAux + "', '" + emailAux + "', '" + userAux + "', '" + passwordAux + "', 0);";
        stmt2.executeUpdate(sql2);
        System.out.println("Cliente cadastrado com sucesso");
    }



    public String toString(){
        return "Nome: " + this.nome + "\n" +
                "CPF: " + this.CPF + "\n" +
                "Email: " + this.email + "\n" +
                "Usuario: " + this.user + "\n" +
                "Senha: " + this.password + "\n" +
                "Saldo: " + this.saldo + "\n";
    }

    public int getId(){
        return this.id;
    }

    public void setId(int id){
        this.id = id;
    }
    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setLogado(boolean logado) {
        this.logado = logado;
    }

    public boolean getLogado(){
        return this.logado;
    }
}

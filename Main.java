// Version: 1.0
// Date: 02/04/2020
// Author: Gabriel Reis Macedo
// Description: Main class of the project.

//import java.sql.*;
import java.awt.GridBagLayout;
import javax.swing.*;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    private static int idClienteLogado;

    public void MenuLogado(){
        Scanner sc1 = new Scanner(System.in);
        System.out.println("--------------Sistema--------------");
        System.out.println("1 - Depositar");
        System.out.println("2 - Loja");
        System.out.println("3 - Minha Biblioteca");
        System.out.println("4 - Carrinho");
        System.out.println("5 - Historico de compras");
        System.out.println("6 - Sair");
        System.out.println("Digite a opcao desejada: ");
        int op = sc1.nextInt();
        while(op != 99){
            switch(op){
                case 1:
                    System.out.println("Formas de pagamentos disponiveis: PIX, Deposito ou Cartao");
                    System.out.println("Diga qual a forma de pagamento: ");
                    String pagamento = sc1.next();
                    pagamento = pagamento.toUpperCase();
                    if(pagamento.equals("PIX") || pagamento.equals("DEPOSITO") || pagamento.equals("CARTAO")){
                        float valor;
                        System.out.println("Digite o valor a ser depositado: ");
                        valor = sc1.nextFloat();
                        //System.out.println("id cliente menu logado: " + idClienteLogado);
                        // depositar o valor digitado no banco de dados
                        Conexao con3 = new Conexao();
                        try {
                            Statement stmt3 = con3.getConnection().createStatement();
                            String sql3 = "UPDATE Cliente SET saldo = saldo + " + valor + " WHERE id = " + idClienteLogado + ";";
                            stmt3.executeUpdate(sql3);
                            stmt3.close();
                            System.out.println("Deposito efetuado com sucesso");
                        } catch (SQLException e) {
                            throw new RuntimeException(e);
                        }
                    }else{
                        System.out.println("Forma de pagamento invalida");
                    }
                    break;

                case 6:
                    System.exit(0);
                    break;

                    // setar o saldo do cliente logado com o valor digitado no banco de dados
                default:
                    System.out.println("Opcao invalida");
                    break;

            }
            System.out.println("--------------Sistema--------------");
            System.out.println("1 - Depositar");
            System.out.println("2 - Loja");
            System.out.println("3 - Minha Biblioteca");
            System.out.println("4 - Carrinho");
            System.out.println("5 - Historico de compras");
            System.out.println("6 - Sair");
            System.out.println("Digite a opcao desejada: ");
            op = sc1.nextInt();
        }

    }

    public static void main(String[] args) throws SQLException {
        Conexao con = new Conexao();
        System.out.println("1 - Conectar ao banco de dados");
        System.out.println("2 - Criar tabela Cliente");
        System.out.println("3 - Login");
        System.out.println("4 - Cadastrar Cliente");
        System.out.println("5 - Desconectar do banco de dados");
        System.out.println("6 - Sair");
        System.out.println("Digite a opcao desejada: ");
        Scanner sc = new Scanner(System.in);
        int opcao = sc.nextInt();
        while(opcao != 99){
            switch(opcao){
                case 1:
                    con.getConnection();
                    break;
                case 2:
                    con.Criar_tabela_Cliente();
                    break;
                case 3:
                    Cliente cliente = new Cliente();
                    cliente.login();
                    idClienteLogado = cliente.getId();
                    System.out.println("id cliente main: " + cliente.getId());
                    if(cliente.getLogado()){
                        Main menu = new Main();
                        menu.MenuLogado();
                    }
                    break;
                case 4:
                    Cliente cliente2 = new Cliente();
                    cliente2.cadastrar();
                    break;
                case 5:
                    con.closeConnection(con.getConnection());
                    break;
                case 6:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opcao invalida");
                    break;
            }
            System.out.println("1 - Conectar ao banco de dados");
            System.out.println("2 - Criar tabela Cliente");
            System.out.println("3 - Login");
            System.out.println("4 - Cadastrar Cliente");
            System.out.println("5 - Desconectar do banco de dados");
            System.out.println("6 - Sair");
            System.out.println("Digite a opcao desejada: ");
            opcao = sc.nextInt();
        }


    }
}


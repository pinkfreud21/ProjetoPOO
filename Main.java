// Version: 1.0
// Date: 02/04/2020
// Author: Gabriel Reis Macedo
// Description: Main class of the project.

//import java.sql.*;
import java.awt.GridBagLayout;
import javax.swing.*;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {

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


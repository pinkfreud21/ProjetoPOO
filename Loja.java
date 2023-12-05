import java.lang.reflect.Array;
import java.sql.Connection;
import java.util.ArrayList;

public class Loja extends Jogos{

    private ArrayList<Jogos> jogos = new ArrayList<Jogos>();


    public Loja(String nome, float preco, String genero, String desenvolvedora, String descricao) {
        super(nome, preco, genero, desenvolvedora, descricao);


    }
    public Loja(){
        super();

    }

    public void addJogo(Jogos jogo){
        jogos.add(jogo);
    }

    public void removeJogo(Jogos jogo){
        jogos.remove(jogo);
    }

    public ArrayList<Jogos> getJogos(){
        return jogos;
    }

    public void setJogos(ArrayList<Jogos> jogos){
        this.jogos = jogos;
    }


}

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

    public Jogos() {

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

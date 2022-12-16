public class Vendedores {

    private String nome;
    private String sobrenome;
    private int vendas;
    private float bonificacao;

    public Vendedores(String nome, String sobrenome){
       this.nome = nome;
       this.sobrenome = sobrenome;
    }

    public Vendedores(String nome, String sobrenome, int valorVendas, int valorBonificacao){
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.vendas = valorVendas;
        this.bonificacao = valorBonificacao;
    }

    public void vender (int valor){
        vendas += valor;
    }

    public String toString(){
        return nome + " " + sobrenome;
    }

    public void setBonificacao(float valor){
        bonificacao = valor;
    }

    public int getVendas(){ return vendas; }

    public double getBonificacao(){ return bonificacao; }

    public String anunciar(){
        return nome + " " + sobrenome + " vendeu: " + getVendas();
    }

}

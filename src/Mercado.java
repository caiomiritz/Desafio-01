public class Mercado {

    private Vendedores[] vendedores;

    private int meta;
    private String nome;
    private String local;
    private int totalVendas;

    public Mercado(Vendedores[] vendedores, int meta, String nome){
        this.vendedores = vendedores;
        this.meta = meta;
        this.nome = nome;
    }

    public Vendedores[] getVendedores(){ return vendedores; }

    public int getTotalVendas() { return totalVendas; }

    public String getNome(){ return nome; }

    public String getLocal() { return local; }

    public int getMeta(){ return meta; }

    public void setTotal(int valor){
        totalVendas = valor;
    }
}

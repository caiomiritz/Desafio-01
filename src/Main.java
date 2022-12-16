import java.util.Random;

public class Main {

    private static final String[] nomes = new String[]{"Caio", "Marina", "Luca", "Rafa", "Paulo", "Bernardo", "José", "Rita", "Isadora", "Viviane"}; // [0,3]
    private static final String[] sobrenomes = new String[]{"Matias", "Fernandes", "Maia", "Rocha", "Medeiros", "Alves", "Raphaelli", "Marçal", "Goulart", "Ferreira"};

    private static Random random = new Random();


    public static void main(String[] args) {
        Vendedores[] vendedoresFrutas = new Vendedores[10];
        Vendedores[] vendedoresRoupas = new Vendedores[10];
        Vendedores[] vendedoresJoias = new Vendedores[10];
        newVendedores(nomes, sobrenomes, vendedoresRoupas, random);
        newVendedores(nomes, sobrenomes, vendedoresFrutas, random);
        newVendedores(nomes, sobrenomes, vendedoresJoias, random);

        Mercado mercadoFrutas = new Mercado(vendedoresFrutas, 450, "Frutas");
        Mercado mercadoRoupas = new Mercado(vendedoresRoupas, 680, "Roupas");
        Mercado mercadoJoias = new Mercado(vendedoresJoias, 800, "Joias");

        Comprador comprador = new Comprador();
        Regulador regulador = new Regulador();

        realizarVendas(mercadoFrutas, comprador);
        realizarVendas(mercadoRoupas, comprador);
        realizarVendas(mercadoJoias, comprador);

        regulador.aplicar(mercadoFrutas);
        regulador.aplicar(mercadoRoupas);
        regulador.aplicar(mercadoJoias);

        sumario(mercadoFrutas);
        sumario(mercadoRoupas);
        sumario(mercadoJoias);
    }

    private static void newVendedores(String[] nomes, String[] sobrenomes, Vendedores[] vendedorX, Random random){

        for(int i = 0; i < 10 ; i++){
            int iNome = random.nextInt(nomes.length);
            String nome = nomes[iNome];

            int iSobre = random.nextInt(sobrenomes.length);
            String sobrenome = sobrenomes[iSobre];

            vendedorX[i] = new Vendedores(nome, sobrenome);
        }
    }

    private static void realizarVendas(Mercado mercadoX, Comprador comprador){

        int totalVendas = 0;

        for(int i = 0; i < 10; i++){
            comprador.comprar(mercadoX.getVendedores()[i]);
            totalVendas += mercadoX.getVendedores()[i].getVendas();
        }

        mercadoX.setTotal(totalVendas);
    }

    private static void sumario(Mercado mercadoX){
        System.out.println(" ");
        System.out.printf("%%%%%%%%%%%%%%%%%%%%%% Um resumo detalhado do mercado de %s %%%%%%%%%%%%%%%%%%%%%%\n", mercadoX.getNome());
        System.out.println(" ");

        System.out.println("Meta de venda para cada vendedor do: " + mercadoX.getMeta());
        System.out.println("Total de vendas do mercado: " + mercadoX.getTotalVendas());
        System.out.println(" ");
        System.out.println("----Vendedores, suas vendas, e bonificação----");
        System.out.println(" ");

        for(int i = 0; i < 10; i++){
            Vendedores vendedor = mercadoX.getVendedores()[i];

            System.out.printf(vendedor.anunciar() + " bonificação: %.2f\n", vendedor.getBonificacao());
        }

        System.out.println(" ");
    }

}
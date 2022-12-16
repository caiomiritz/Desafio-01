import java.util.Random;

public class Comprador {

    private Random random = new Random();

    public void comprar(Vendedores vendedor){
        vendedor.vender(random.nextInt(100, 1000));
    }
}

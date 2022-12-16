public class Regulador {

    public void aplicar(Mercado mercadoX){

        for(int i = 0; i < 10; i++){
            Vendedores vendedor = mercadoX.getVendedores()[i];

            if(vendedor.getVendas() >= mercadoX.getMeta() ){
                vendedor.setBonificacao((vendedor.getVendas() * 0.10f));
            }
            else{
                vendedor.setBonificacao(0);
            }
        }
    }
}

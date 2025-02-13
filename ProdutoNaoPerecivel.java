public class ProdutoNaoPerecivel extends Produto{

    protected ProdutoNaoPerecivel(String desc, double precoCusto, double margemLucro) {
            super(desc, precoCusto, margemLucro); 
    }

    protected ProdutoNaoPerecivel(String desc, double precoCusto) {
        super(desc, precoCusto); 
    }
    
    @Override
    public double valorDeVenda() {
        return precoCusto * (1+margemLucro);
    }
    
}

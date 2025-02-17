package aeds2;

public class ProdutoNaoPerecivel extends Produto {

    public ProdutoNaoPerecivel(String descricao, double valor, double margem) {
        super(descricao, valor, margem);
    }

    public ProdutoNaoPerecivel(String desc, double precoCusto) {
        super(desc, precoCusto); 
    }
    
    @Override
    public double valorDeVenda() {
        return precoCusto * (1+margemLucro);
    }
    
}
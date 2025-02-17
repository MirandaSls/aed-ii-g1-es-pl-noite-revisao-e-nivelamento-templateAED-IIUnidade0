package aeds2;


import java.time.LocalDate;


public class ProdutoPerecivel extends Produto {
    private LocalDate dataDeVencimento;
    private static final double DESCONTO = 0.25;
    private static final int PRAZO_DESCONTO = 7;

    public ProdutoPerecivel(String desc, double precoCusto, double margemLucro, LocalDate dataDeValidade) {
        super(desc, precoCusto, margemLucro);
        this.dataDeVencimento = dataDeValidade;
    }
    
    @Override
    public double valorDeVenda() {
        LocalDate hoje = LocalDate.now();
        
        if (hoje.isAfter(dataDeVencimento)) {
            throw new IllegalStateException("Produto vencido não pode ser vendido");
        }

        double valorBase = precoCusto * (1 + margemLucro);
        
        if (hoje.plusDays(PRAZO_DESCONTO).isAfter(dataDeVencimento)) {
            return valorBase * (1 - DESCONTO);
        }

        return valorBase;
    }
    
    @Override
    public String toString(){
            return null;
    }
}
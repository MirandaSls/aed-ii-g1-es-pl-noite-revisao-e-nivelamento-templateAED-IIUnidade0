
import java.time.LocalDate;


public class ProdutoPerecivel extends Produto {
    private LocalDate dataDeVencimento;
    private static final double MARGEM_VENCIMENTO = 0.25;

    protected ProdutoPerecivel(String desc, double precoCusto, double margemLucro, LocalDate dataDeValidade) {
        super(desc, precoCusto, margemLucro);

    }

    protected ProdutoPerecivel(String desc, double precoCusto, LocalDate dataDeValidade) {
        super(desc, precoCusto);
    }
    
    

    @Override
    public double valorDeVenda() {
        return 0;
    }
    
    @Override
    public String toString(){
            return null;
    }
}

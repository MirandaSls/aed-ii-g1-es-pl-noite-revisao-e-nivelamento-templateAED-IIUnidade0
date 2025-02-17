import aeds2.ProdutoPerecivel;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class ProdutoPerecivelTest {

    static ProdutoPerecivel produto;
    static LocalDate dataValidade;
    
    @BeforeAll
    static public void prepare(){
        dataValidade = LocalDate.now().plusMonths(6); // validade de 6 meses
        produto = new ProdutoPerecivel("Produto teste", 100.0, 0.1, dataValidade);
    }
    
    @Test
    public void calculaPrecoCorretamente(){
        assertEquals(110.0, produto.valorDeVenda(), 0.01);
    }

    @Test
    public void stringComDescricaoValorEData(){
        String desc = produto.toString();
        assertTrue(desc.contains("Produto teste") && 
                  desc.contains("R$ 110,00") && 
                  desc.contains(dataValidade.toString()));
    }

    @Test
    public void naoCriaProdutoComPrecoNegativo(){
        Exception exception = assertThrows(IllegalArgumentException.class, 
            () -> new ProdutoPerecivel("teste", -5.0, 0.5, dataValidade));
        assertEquals("Preço de custo não pode ser negativo", exception.getMessage());
    }
    
    @Test
    public void naoCriaProdutoComMargemNegativa(){
        Exception exception = assertThrows(IllegalArgumentException.class, 
            () -> new ProdutoPerecivel("teste", 5.0, -1.0, dataValidade));
        assertEquals("Margem de lucro não pode ser negativa", exception.getMessage());
    }

    @Test
    public void naoCriaProdutoComDataVencida(){
        LocalDate dataPassada = LocalDate.now().minusDays(1);
        Exception exception = assertThrows(IllegalArgumentException.class, 
            () -> new ProdutoPerecivel("teste", 5.0, 0.1, dataPassada));
        assertEquals("Data de validade não pode ser no passado", exception.getMessage());
    }

    @Test
    public void aplicaDescontoQuandoProximoVencimento(){
        LocalDate dataProxima = LocalDate.now().plusDays(5);
        ProdutoPerecivel produtoQuaseVencido = new ProdutoPerecivel("teste", 100.0, 0.1, dataProxima);
        assertEquals(55.0, produtoQuaseVencido.valorDeVenda(), 0.01); // 50% de desconto
    }
} 
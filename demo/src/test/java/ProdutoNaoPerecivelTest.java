import aeds2.Produto;
import aeds2.ProdutoNaoPerecivel;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class ProdutoNaoPerecivelTest {

    static Produto produto;
        
    
    @BeforeAll
    static public void prepare(){
        produto = new ProdutoNaoPerecivel("Produto teste", 100.0, 0.1);
    }
    
    @Test
    public void calculaPrecoCorretamente(){
        assertEquals(110.0, produto.valorDeVenda(), 0.01);
    }

    @Test
    public void stringComDescricaoEValor(){
        String desc = produto.toString();
        assertTrue(desc.contains("Produto teste") && desc.contains("R$ 110,00"));
    }

    @Test
    public void naoCriaProdutoComPrecoNegativo(){
        Exception exception = assertThrows(IllegalArgumentException.class, 
            () -> new ProdutoNaoPerecivel("teste", -5.0, 0.5));
        assertEquals("Preço de custo não pode ser negativo", exception.getMessage());
    }
    
    @Test
    public void naoCriaProdutoComMargemNegativa(){
        Exception exception = assertThrows(IllegalArgumentException.class, 
            () -> new ProdutoNaoPerecivel("teste", 5.0, -1.0));
        assertEquals("Margem de lucro não pode ser negativa", exception.getMessage());
    }
}
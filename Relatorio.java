import java.io.IOException;
import produto.Produto;
import produto.ProdutoPadrao;
import static enumeradores.Enum_Algoritmos.*;
import static enumeradores.Enum_Criterios.*;
import static enumeradores.Enum_Filtros.*;
import static enumeradores.Enum_Formatos.*;
import formatacao.*;
import formatacao.cor.*;
import java.util.HashMap;

/**
 *
 * @author ferna
 */
public class Relatorio {
    public static Produto[] carregaProdutos() {

        return new Produto[]{
            new ProdutoPadrao(1, "O Hobbit", "Livros", 2, 34.90),
            new ProdutoPadrao(2, "Notebook Core i7", "Informatica", 5, 1999.90),
            new ProdutoPadrao(3, "Resident Evil 4", "Games", 7, 79.90),
            new ProdutoPadrao(4, "iPhone", "Telefonia", 8, 4999.90),
            new ProdutoPadrao(5, "Calculo I", "Livros", 20, 55.00),
            new ProdutoPadrao(6, "Power Glove", "Games", 3, 499.90),
            new ProdutoPadrao(7, "Microsoft HoloLens", "Informatica", 1, 19900.00),
            new ProdutoPadrao(8, "OpenGL Programming Guide", "Livros", 4, 89.90),
            new ProdutoPadrao(9, "Vectrex", "Games", 1, 799.90),
            new ProdutoPadrao(10, "Carregador iPhone", "Telefonia", 15, 499.90),
            new ProdutoPadrao(11, "Introduction to Algorithms", "Livros", 7, 315.00),
            new ProdutoPadrao(12, "Daytona USA (Arcade)", "Games", 1, 12000.00),
            new ProdutoPadrao(13, "Neuromancer", "Livros", 5, 45.00),
            new ProdutoPadrao(14, "Nokia 3100", "Telefonia", 4, 249.99),
            new ProdutoPadrao(15, "Oculus Rift", "Games", 1, 3600.00),
            new ProdutoPadrao(16, "Trackball Logitech", "Informatica", 1, 250.00),
            new ProdutoPadrao(17, "After Burner II (Arcade)", "Games", 2, 8900.0),
            new ProdutoPadrao(18, "Assembly for Dummies", "Livros", 30, 129.90),
            new ProdutoPadrao(19, "iPhone (usado)", "Telefonia", 3, 3999.90),
            new ProdutoPadrao(20, "Game Programming Patterns", "Livros", 1, 299.90),
            new ProdutoPadrao(21, "Playstation 2", "Games", 10, 499.90),
            new ProdutoPadrao(22, "Carregador Nokia", "Telefonia", 14, 89.00),
            new ProdutoPadrao(23, "Placa Aceleradora Voodoo 2", "Informatica", 4, 189.00),
            new ProdutoPadrao(24, "Stunts", "Games", 3, 19.90),
            new ProdutoPadrao(25, "Carregador Generico", "Telefonia", 9, 30.00),
            new ProdutoPadrao(26, "Monitor VGA 14 polegadas", "Informatica", 2, 199.90),
            new ProdutoPadrao(27, "Nokia N-Gage", "Telefonia", 9, 699.00),
            new ProdutoPadrao(28, "Disquetes Maxell 5.25 polegadas (caixa com 10 unidades)", "Informatica", 23, 49.00),
            new ProdutoPadrao(29, "Alone in The Dark", "Games", 11, 59.00),
            new ProdutoPadrao(30, "The Art of Computer Programming Vol. 1", "Livros", 3, 240.00),
            new ProdutoPadrao(31, "The Art of Computer Programming Vol. 2", "Livros", 2, 200.00),
            new ProdutoPadrao(32, "The Art of Computer Programming Vol. 3", "Livros", 4, 270.00)
        };
    }
    
    public static HashMap<Produto,Produto> personaliza(Produto[] produtos){
        HashMap<Produto,Produto> personalizados = new HashMap<>();
        personalizados.put(produtos[0], new Italico(new Negrito(new Roxo(produtos[0]))));
        personalizados.put(produtos[1], new Negrito(new Rosa(produtos[1])));
        personalizados.put(produtos[3], new Italico(new Preto(produtos[3])));
        personalizados.put(produtos[31], new Padrao(new Italico(new Vermelho(produtos[31]))));
        personalizados.put(produtos[30], new Padrao(new Italico(new Verde(produtos[30]))));
        personalizados.put(produtos[27], new Padrao(new Negrito(new Azul(produtos[27]))));
        return personalizados;
    }

    public static void main(String[] args) {

        Produto[] produtos = carregaProdutos();
        
        HashMap<Produto,Produto> personalizados = null;
        personalizados = personaliza(produtos);
        
        GeradorDeRelatorios gdr;

        gdr = new GeradorDeRelatorios(produtos, ALG_QUICKSORT, CRIT_PRECO_DECRE,
                FILTRO_INTERVALO_PRECO, "10.00; 500.00",personalizados);

        //gdr = new GeradorDeRelatorios(produtos, new InsertionSort(), new EstoqueCrescente(), new IntervaloDePrecos(), "10.00; 500.00", personalizar);
        //gdr = new GeradorDeRelatorios(produtos, new QuickSort(), new EstoqueDecrescente(), new Todos(), personalizar);
        try {
            gdr.geraRelatorio("saida.html");
        } catch (IOException e) {

            e.printStackTrace();
        }
    }
}

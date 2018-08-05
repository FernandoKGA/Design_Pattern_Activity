
import java.io.PrintWriter;
import java.io.IOException;

public class GeradorDeRelatorios {

    //Algoritmos
    public static final int ALG_INSERTIONSORT = 0;
    public static final int ALG_QUICKSORT = 1;

    //Criterio crescente
    public static final int CRIT_DESC_CRESC = 0;
    public static final int CRIT_PRECO_CRESC = 1;
    public static final int CRIT_ESTOQUE_CRESC = 2;

    //Criterio decrescente
    public static final int CRIT_DESC_DECRE = 3;
    public static final int CRIT_PRECO_DECRE = 4;
    public static final int CRIT_ESTOQUE_DECRE = 5;

    //Filtros
    public static final int FILTRO_TODOS = 0;
    public static final int FILTRO_ESTOQUE_MENOR_OU_IQUAL_A = 1;
    public static final int FILTRO_CATEGORIA_IGUAL_A = 2;

    // operador bit a bit "ou" pode ser usado para combinar mais de  
    // um estilo de formatacao simultaneamente (veja exemplo no main)
    public static final int FORMATO_PADRAO = 0b0000;
    public static final int FORMATO_NEGRITO = 0b0001;
    public static final int FORMATO_ITALICO = 0b0010;

    private Produto[] produtos;
    private int algoritmo;
    private int criterio;
    private int format_flags;
    private int filtro;
    private Object argFiltro;

    private final Filtro filtro_estoque = new Filtro_Estoque();
    private final Filtro filtro_categoria = new Filtro_Categoria();

    public GeradorDeRelatorios(Produto[] produtos, int algoritmo, int criterio, int format_flags, int filtro, Object argFiltro) {

        this.produtos = produtos;
        this.algoritmo = algoritmo;
        this.criterio = criterio;
        this.format_flags = format_flags;
        this.filtro = filtro;
        this.argFiltro = argFiltro;
    }

    private void ordena() {
        int ini = 0;
        int fim = produtos.length - 1;
        switch (algoritmo) {
            case ALG_INSERTIONSORT:
                Algoritmo insertion_sort = new InsertionSort(ini, fim, produtos, criterio);
                produtos = insertion_sort.ordena();
                break;
            case ALG_QUICKSORT:
                Algoritmo quick_sort = new QuickSort(ini, fim, produtos, criterio);
                produtos = quick_sort.ordena();
                break;
            default:
                throw new RuntimeException("Algoritmo invalido!");
        }
    }

    public void geraRelatorio(String arquivoSaida) throws IOException {

        ordena();

        PrintWriter out = new PrintWriter(arquivoSaida);

        out.println("<!DOCTYPE html><html>");
        out.println("<head><title>Relatorio de produtos</title></head>");
        out.println("<body> Relatorio de Produtos:<br>");
        out.println("<ul>");

        int count = 0;

        for (Produto p : produtos) {
            boolean selecionado = false;

            switch (filtro) {
                case FILTRO_TODOS:
                    selecionado = true;
                    break;
                case FILTRO_ESTOQUE_MENOR_OU_IQUAL_A:
                    if (filtro_estoque.compara(p, argFiltro)) {
                        selecionado = true;
                    }
                    break;
                case FILTRO_CATEGORIA_IGUAL_A:
                    if (filtro_categoria.compara(p, argFiltro)) {
                        selecionado = true;
                    }
                    break;
                default:
                    throw new RuntimeException("Filtro invalido!");
            }

            if (selecionado) {
                out.print("<li>");
                Produto produto_decorador = new ProdutoDecorator(p, format_flags);
                out.print(produto_decorador.formataParaImpressao());
                out.println("</li>");
                count++;
            }
        }

        out.println("</ul>");
        out.println(count + " produtos listados, de um total de " + produtos.length + ".<br>");
        out.println("</body>");
        out.println("</html>");

        out.close();
    }

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

    public static void main(String[] args) {

        Produto[] produtos = carregaProdutos();

        GeradorDeRelatorios gdr;

        gdr = new GeradorDeRelatorios(produtos, ALG_QUICKSORT, CRIT_PRECO_DECRE,
                FORMATO_PADRAO | FORMATO_NEGRITO | FORMATO_ITALICO,
                //FILTRO_ESTOQUE_MENOR_OU_IQUAL_A, 100);
                FILTRO_CATEGORIA_IGUAL_A, "Livros");

        try {
            gdr.geraRelatorio("saida.html");
        } catch (IOException e) {

            e.printStackTrace();
        }
    }
}

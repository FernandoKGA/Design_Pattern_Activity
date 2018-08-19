
import produto.*;
import filtro.*;
import algoritmo.*;
import criterio.*;
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
    private final int algoritmo;
    private Criterio criterio;
    private final int criterio_define;
    private final int format_flags;
    private final int filtro_define;
    private final Object argFiltro;
    private Filtro filtro;

    public GeradorDeRelatorios(Produto[] produtos, int algoritmo,
            int criterio_define, int format_flags, int filtro_define,
            Object argFiltro) {

        this.produtos = produtos;
        this.algoritmo = algoritmo;
        this.criterio_define = criterio_define;
        selecionaCriterio();
        this.format_flags = format_flags;
        this.filtro_define = filtro_define;
        this.argFiltro = argFiltro;
    }
    
    private void selecionaCriterio(){
        switch(criterio_define){
            case CRIT_DESC_CRESC:
                criterio = new Criterio_Desc_Crescente();
                break;
            case CRIT_PRECO_CRESC:
                criterio = new Criterio_Preco_Crescente();
                break;
            case CRIT_ESTOQUE_CRESC:
                criterio = new Criterio_Estq_Crescente();
                break;
            case CRIT_DESC_DECRE:
                criterio = new Criterio_Desc_Decrescente();
                break;
            case CRIT_PRECO_DECRE:
                criterio = new Criterio_Preco_Decrescente();
                break;
            case CRIT_ESTOQUE_DECRE:
                criterio = new Criterio_Estq_Decrescente();
                break;
                
            default:
                throw new RuntimeException("Criterio inválido!");
        }
    }

    private void ordena() {

        //Inicializacao de variaveis
        int ini = 0;
        int fim = produtos.length - 1;

        //Seleciona o algoritmo de acordo
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

        //Feita a atribuição do filtro
        if (filtro == null) {
            switch (filtro_define) {
                case FILTRO_TODOS:
                    filtro = new Filtro_Todos();
                    break;
                case FILTRO_ESTOQUE_MENOR_OU_IQUAL_A:
                    filtro = new Filtro_Estoque();
                    break;
                case FILTRO_CATEGORIA_IGUAL_A:
                    filtro = new Filtro_Categoria();
                    break;
                default:
                    throw new RuntimeException("Filtro inválido!");
            }
        }
        
        for (Produto p : produtos) {
            boolean selecionado = false;
            
            if(filtro.compara(p, argFiltro)){
                selecionado = true;
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
}

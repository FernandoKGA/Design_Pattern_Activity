import produto.*;
import filtro.*;
import algoritmo.*;
import criterio.*;
import enumeradores.*;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.HashMap;

public class GeradorDeRelatorios {

    private Produto[] produtos;
    private final Enum_Algoritmos algoritmo;
    private Criterio criterio;
    private final Enum_Criterios criterio_define;
    private final Enum_Filtros filtro_define;
    private Object argFiltro;
    private Filtro filtro;
    private final HashMap<Produto,Produto> formatacao;
    private Produto prod_formatado;

    public GeradorDeRelatorios(Produto[] produtos, Enum_Algoritmos algoritmo,
            Enum_Criterios criterio_define, Enum_Filtros filtro_define,
            Object argFiltro, HashMap<Produto,Produto> formatacao) {

        this.produtos = produtos;
        this.algoritmo = algoritmo;
        this.criterio_define = criterio_define;
        selecionaCriterio();
        this.filtro_define = filtro_define;
        this.argFiltro = argFiltro;
        this.formatacao = formatacao;
    }
    
    public GeradorDeRelatorios(Produto[] produtos, Enum_Algoritmos algoritmo,
            Enum_Criterios criterio_define, Enum_Filtros filtro_define,
            HashMap<Produto,Produto> formatacao) {

        this.produtos = produtos;
        this.algoritmo = algoritmo;
        this.criterio_define = criterio_define;
        selecionaCriterio();
        this.filtro_define = filtro_define;
        this.formatacao = formatacao;
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

    //Método que vai gerar o relatório
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
                case FILTRO_INTERVALO_PRECO:
                    filtro = new Filtro_IntervalorDePreco();
                    break;
                case FILTRO_SUBSTRING:
                    filtro = new Filtro_Substring();
                    break;
                    
                default:
                    throw new RuntimeException("Filtro inválido!");
            }
        }
        
        boolean selecionado;
        for (Produto p : produtos) {
            selecionado = filtro.compara(p, argFiltro);
            
            if (selecionado) {
                out.print("<li>");
                
                if(formatacao.containsKey(p)){
                    //Se encontra no HashMap
                    prod_formatado = formatacao.get(p);
                    out.print(prod_formatado.formataParaImpressao());
                } else{
                    out.print(p.formataParaImpressao());
                }
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

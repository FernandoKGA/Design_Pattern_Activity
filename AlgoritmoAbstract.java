/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ferna
 */
public abstract class AlgoritmoAbstract{
    
    public static final int CRIT_DESC_CRESC = 0;
    public static final int CRIT_PRECO_CRESC = 1;
    public static final int CRIT_ESTOQUE_CRESC = 2;
    
    public static final int CRIT_DESC_DECRE = 3;
    public static final int CRIT_PRECO_DECRE = 4;
    public static final int CRIT_ESTOQUE_DECRE = 5;
    
    protected final Criterio crit_descricao = new Criterio_Descricao();
    protected final Criterio crit_preco = new Criterio_Preco();
    protected final Criterio crit_estoque = new Criterio_Estoque();
    
    protected int inicio;
    protected int fim;
    protected Produto[] produtos;
    protected int criterio;

    public AlgoritmoAbstract(int inicio, int fim, Produto[] produtos, int criterio) {
        this.inicio = inicio;
        this.fim = fim;
        this.produtos = produtos;
        this.criterio = criterio;
    }

    private int getInicio() {
        return inicio;
    }

    protected void setInicio(int inicio) {
        this.inicio = inicio;
    }

    protected int getFim() {
        return fim;
    }

    protected void setFim(int fim) {
        this.fim = fim;
    }

    protected Produto[] getProdutos() {
        return produtos;
    }

    protected void setProdutos(Produto[] produtos) {
        this.produtos = produtos;
    }

    protected int getCriterio() {
        return criterio;
    }

    protected void setCriterio(int criterio) {
        this.criterio = criterio;
    }
    
}

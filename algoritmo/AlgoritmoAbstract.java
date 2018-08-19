package algoritmo;



import criterio.Criterio;


import produto.Produto;

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
    
    protected Criterio criterio = null;
    
    protected int inicio;
    protected int fim;
    protected Produto[] produtos;

    public AlgoritmoAbstract(int inicio, int fim, Produto[] produtos, Criterio criterio) {
        this.inicio = inicio;
        this.fim = fim;
        this.produtos = produtos;
        this.criterio = criterio;
        if(criterio == null){
            throw new RuntimeException("Critério Inválido!");
        }
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

    protected Criterio getCriterio() {
        return criterio;
    }

    protected void setCriterio(Criterio criterio) {
        this.criterio = criterio;
    }
    
}

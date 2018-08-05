/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ferna
 */
public class Criterio_Preco implements Criterio{
    /** Método que aplica o critério de Preço.
     * Verifica se o Produto k tem preço igual ou maior a do Produto x. Caso tenha,
     * retorna 1 como true, ou 0 como falso.
     * @param x
     * @param k
     * @return True caso seja igual ou maior, falso caso seja menor ou igual a 0.
     */
    @Override
    public boolean aplicaCriterioUm(Produto k, Produto x) {
        return (k.getPreco() > x.getPreco());
    }
    
    @Override
    public boolean aplicaCriterioDois(Produto k, Produto x){
        return (k.getPreco() < x.getPreco());
    }
    
}

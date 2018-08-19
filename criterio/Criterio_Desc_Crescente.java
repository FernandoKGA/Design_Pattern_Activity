package criterio;

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
public class Criterio_Desc_Crescente implements Criterio{
    /** Método que aplica o critério de Descrição.
     * Verifica se o Produto k tem a descrição igual ou maior a do Produto x. Caso tenha,
     * retorna 1 como true, ou 0 como falso.
     * @param x
     * @param k
     * @return True caso seja igual ou maior, falso caso seja menor ou igual a 0.
     */
    @Override
    public boolean aplicaCriterio(Produto k, Produto x) {
        return (k.getDescricao().compareToIgnoreCase(x.getDescricao()) > 0);
    }
}

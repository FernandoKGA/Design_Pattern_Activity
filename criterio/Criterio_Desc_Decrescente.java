/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package criterio;

import produto.Produto;

/**
 *
 * @author ferna
 */
public class Criterio_Desc_Decrescente implements Criterio{
    @Override
    public boolean aplicaCriterio(Produto k, Produto x){
        return (k.getDescricao().compareToIgnoreCase(x.getDescricao()) < 0);
    }
}

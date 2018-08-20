/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formatacao;

import produto.Produto;

/**
 *
 * @author ferna
 */
public abstract class Formatacao extends produto.ProdutoDecorator {

    public Formatacao(Produto produto) {
        super(produto);
    }

    @Override
    public abstract String formataParaImpressao();
    
}

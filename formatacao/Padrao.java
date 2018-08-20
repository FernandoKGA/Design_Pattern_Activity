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
public class Padrao extends Formatacao{

    public Padrao(Produto produto) {
        super(produto);
    }

    @Override
    public String formataParaImpressao() {
        return this.produto.formataParaImpressao();
    }
    
}

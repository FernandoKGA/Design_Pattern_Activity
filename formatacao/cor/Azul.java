/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formatacao.cor;

import formatacao.Formatacao;
import produto.Produto;

/**
 *
 * @author ferna
 */
public class Azul extends Formatacao{

    public Azul(Produto produto) {
        super(produto);
    }

    @Override
    public String formataParaImpressao() {
        String cor = "";
        cor += "<font color = blue>";
        cor += this.produto.formataParaImpressao();
        cor += "</font color = blue>";
        return cor;
    }
    
}

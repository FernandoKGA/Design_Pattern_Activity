/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formatacao;

import produto.Produto;

/**
 *
 * @author Fernando Karchiloff
 */
public class Negrito extends Formatacao{

    public Negrito(Produto produto) {
        super(produto);
    }

    @Override
    public String formataParaImpressao() {
        String formata = "";
        formata += "<b>";
        formata += this.produto.formataParaImpressao();
        formata += "</b>";
        return formata;
    }
    
}

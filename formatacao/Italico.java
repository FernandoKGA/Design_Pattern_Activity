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
public class Italico extends Formatacao{

    public Italico(Produto produto) {
        super(produto);
    }

    @Override
    public String formataParaImpressao() {
        String formata = "";
        formata += "<i>";
        formata += this.produto.formataParaImpressao();
        formata += "</i>";
        return formata;
    }
    
}

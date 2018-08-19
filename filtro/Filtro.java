package filtro;

import produto.Produto;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Fernando Karchiloff
 */
public interface Filtro {
    public boolean compara(Produto x, Object argFiltro);
}

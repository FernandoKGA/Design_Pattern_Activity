/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filtro;

import produto.Produto;

/**
 *
 * @author ferna
 */
public class Filtro_Todos implements Filtro{

    @Override
    public boolean compara(Produto x, Object argFiltro) {
        return true;
    }
    
}

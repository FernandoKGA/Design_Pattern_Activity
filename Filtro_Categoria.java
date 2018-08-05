/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ferna
 */
public class Filtro_Categoria implements Filtro{

    @Override
    public boolean compara(Produto x, Object argFiltro) {
        return (x.getCategoria().equalsIgnoreCase((String) argFiltro));
    }
}

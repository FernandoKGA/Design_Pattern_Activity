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
public class Filtro_IntervalorDePreco implements Filtro{

    private final int min = 0;
    private final int max = 1;
    
    @Override
    public boolean compara(Produto x, Object argFiltro) {
        String arg = (String) argFiltro;
        String[] intervalo = arg.split(";|;\\s");
        
        double valorMin = Double.parseDouble(intervalo[min]);
        double valorMax = Double.parseDouble(intervalo[max]);
        
        return ((x.getPreco() >= valorMin) && (x.getPreco() <= valorMax));
    }
    
}

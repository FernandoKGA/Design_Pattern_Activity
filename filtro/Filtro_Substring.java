/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filtro;

import java.util.regex.Pattern;
import produto.Produto;

/**
 *
 * @author ferna
 */
public class Filtro_Substring implements Filtro{

    @Override
    public boolean compara(Produto x, Object argFiltro) {
        String descricao = x.getDescricao();
        String subString = (String) argFiltro;
      
        return (Pattern.compile(Pattern.quote(subString), Pattern.CASE_INSENSITIVE).matcher(descricao).find());
    }
    
}

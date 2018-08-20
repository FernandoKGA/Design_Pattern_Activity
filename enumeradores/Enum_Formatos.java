/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enumeradores;

/**
 *
 * @author ferna
 */
public enum Enum_Formatos {
    
    // operador bit a bit "ou" pode ser usado para combinar mais de  
    // um estilo de formatacao simultaneamente (veja exemplo no main)
    
    FORMATO_PADRAO(0b0000), FORMATO_NEGRITO(0b0001), FORMATO_ITALICO(0b0010);

    private final int bit;

    Enum_Formatos(int bit){
        this.bit = bit;
    }
    
    public int getBit(){
        return bit;
    }
}

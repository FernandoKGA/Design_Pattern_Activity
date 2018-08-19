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
public enum Enum_Filtros {
    
    FILTRO_TODOS(0),
    FILTRO_ESTOQUE_MENOR_OU_IQUAL_A(1),
    FILTRO_CATEGORIA_IGUAL_A(2);
    
    private final int valor;
    
    Enum_Filtros(int valor){
        this.valor = valor;
    }
    
    public int getValor(){
        return valor;
    }
}

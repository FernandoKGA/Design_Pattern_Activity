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
public enum Enum_Criterios {
    //Criterios crescentes
    CRIT_DESC_CRESC(0), CRIT_PRECO_CRESC(1), CRIT_ESTOQUE_CRESC(2),
    
    //Criterio decrescente
    CRIT_DESC_DECRE(3), CRIT_PRECO_DECRE(4), CRIT_ESTOQUE_DECRE(5);
    
    private final int valor;
    
    Enum_Criterios(int valor){
        this.valor = valor;
    }
    
    public int getValor(){
        return valor;
    }
}

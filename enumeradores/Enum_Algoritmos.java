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
public enum Enum_Algoritmos {
    
    ALG_INSERTIONSORT(0),ALG_QUICKSORT(1);
    
    private final int alg;

    private Enum_Algoritmos(int alg){
        this.alg = alg;
    }
    
    public int getAlg(){
        return alg;
    }
}

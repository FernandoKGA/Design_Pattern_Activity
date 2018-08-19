package algoritmo;

import produto.Produto;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ferna
 */
public interface Algoritmo {
    public void ordenacao(int ini, int fim);
    public Produto[] ordena();
}

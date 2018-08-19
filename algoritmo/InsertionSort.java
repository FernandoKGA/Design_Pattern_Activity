package algoritmo;

import criterio.Criterio;
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
public class InsertionSort extends AlgoritmoAbstract implements Algoritmo {

    public InsertionSort(int inicio, int fim, Produto[] produtos, Criterio criterio) {
        super(inicio, fim, produtos, criterio);
    }

    @Override
    public void ordenacao(int ini, int fim) {

        for (int i = ini; i <= fim; i++) {

            Produto x = produtos[i];
            int j = (i - 1);
            boolean bro = false;
            
            while (j >= ini) {
                if (criterio != null) {
                    if (criterio.aplicaCriterio(x, produtos[j])) {
                        j = func(j);
                    }
                    else{
                        bro = true;
                    }
                } else {
                    throw new RuntimeException("Criterio invalido!");
                }
                if (bro) {
                    break;
                }
            }
            produtos[j + 1] = x;
        }
    }

    @Override
    public Produto[] ordena() {
        ordenacao(inicio, fim);
        return getProdutos();
    }

    private int func(int j) {
        produtos[j + 1] = produtos[j];
        j--;
        return j;
    }
}

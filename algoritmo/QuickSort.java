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
public class QuickSort extends AlgoritmoAbstract implements Algoritmo {

    public QuickSort(int inicio, int fim, Produto[] produtos, Criterio criterio) {
        super(inicio, fim, produtos, criterio);
    }

    @Override
    public Produto[] ordena() {
        ordenacao(inicio, fim);
        return getProdutos();
    }

    @Override
    public void ordenacao(int ini, int fim) {
        if (ini < fim) {

            int q = particionaUm(ini, fim);

            ordenacao(ini, q);
            ordenacao(q + 1, fim);
        }
    }

    //Funciona?
    private int particionaUm(int ini, int fim) {
        Produto x = produtos[ini];
        int i = (ini - 1), j = (fim + 1);

        while (true) {
            do {
                j--;
            } while (criterio.aplicaCriterio(x, produtos[j]));
            
            do {
                i++;
            } while (criterio.aplicaCriterio(produtos[i], x));

            if (i < j) {
                Produto temp = produtos[i];
                produtos[i] = produtos[j];
                produtos[j] = temp;
            } else {
                return j;
            }
        }
    }
}

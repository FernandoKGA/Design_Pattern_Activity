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

    public InsertionSort(int inicio, int fim, Produto[] produtos, int criterio) {
        super(inicio, fim, produtos, criterio);

    }

    @Override
    public void ordenacao(int ini, int fim) {

        for (int i = ini; i <= fim; i++) {

            Produto x = produtos[i];
            int j = (i - 1);
            boolean bro = false;
            while (j >= ini) {
                switch (criterio) {
                    case CRIT_DESC_CRESC:
                        if (crit_descricao.aplicaCriterioDois(x, produtos[j])) {
                            j = func(j);
                        } else {
                            bro = true;
                        }
                        break;
                        
                    case CRIT_PRECO_CRESC:
                        if (crit_preco.aplicaCriterioDois(x, produtos[j])) {
                            j = func(j);
                        } else {
                            bro = true;
                        }
                        break;
                        
                    case CRIT_ESTOQUE_CRESC:
                        if (crit_estoque.aplicaCriterioDois(x, produtos[j])) {
                            j = func(j);
                        } else {
                            bro = true;
                        }
                        break;
                        
                    case CRIT_DESC_DECRE:
                        if(crit_descricao.aplicaCriterioUm(x, produtos[j])){
                            j = func(j);
                        } else {
                            bro = true;
                        }
                        break;
                        
                    case CRIT_PRECO_DECRE:
                        if(crit_preco.aplicaCriterioUm(x, produtos[j])){
                            j = func(j);
                        } else {
                            bro = true;
                        }
                        break;
                        
                    case CRIT_ESTOQUE_DECRE:
                        if(crit_estoque.aplicaCriterioUm(x, produtos[j])){
                            j = func(j);
                        } else {
                            bro = true;
                        }
                        break;
                        
                    default:
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

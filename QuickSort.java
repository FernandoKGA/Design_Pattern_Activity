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

    public QuickSort(int inicio, int fim, Produto[] produtos, int criterio) {
        super(inicio, fim, produtos, criterio);
    }

    @Override
    public Produto[] ordena() {
        ordenacao(inicio, fim);
        return getProdutos();
    }

    @Override
    public void ordenacao(int ini, int fim) {
        if (criterio >= CRIT_DESC_CRESC && criterio <= CRIT_ESTOQUE_CRESC) {
            if (ini < fim) {

                int q = particionaUm(ini, fim);

                ordenacao(ini, q);
                ordenacao(q + 1, fim);
            }
            //ARRUMAR O DECRESCENTE!!!!!!!
        } else if (criterio >= CRIT_DESC_DECRE && criterio <= CRIT_ESTOQUE_DECRE) {
            System.out.println(criterio);
            if (ini > fim) {

                int q = particionaDois(ini, fim);

                ordenacao(ini, q);
                ordenacao(q + 1, fim);
            }
        } else {
            throw new RuntimeException("Critério Inválido!");
        }

    }

    //Funciona?
    private int particionaUm(int ini, int fim) {
        Produto x = produtos[ini];
        int i = (ini - 1), j = (fim + 1);

        while (true) {

            switch (criterio) {
                case CRIT_DESC_CRESC:
                    do {
                        j--;
                    } while (crit_descricao.aplicaCriterioUm(produtos[j], x));
                    //produtos[j].getDescricao().compareToIgnoreCase(x.getDescricao()) > 0

                    do {
                        i++;
                    } while (crit_descricao.aplicaCriterioDois(produtos[i], x));
                    //produtos[i].getDescricao().compareToIgnoreCase(x.getDescricao()) < 0

                    break;

                case CRIT_PRECO_CRESC:
                    do {
                        j--;
                    } while (crit_preco.aplicaCriterioUm(produtos[j], x));
                    //produtos[j].getPreco() > x.getPreco()

                    do {
                        i++;
                    } while (crit_preco.aplicaCriterioDois(produtos[i], x));
                    //produtos[i].getPreco() < x.getPreco()

                    break;

                case CRIT_ESTOQUE_CRESC:
                    do {
                        j--;
                    } while (crit_estoque.aplicaCriterioUm(produtos[j], x));
                    //produtos[j].getQtdEstoque() > x.getQtdEstoque()

                    do {
                        i++;
                    } while (crit_estoque.aplicaCriterioDois(produtos[i], x));
                    //produtos[i].getQtdEstoque() < x.getQtdEstoque()

                    break;

            }

            if (i < j) {
                Produto temp = produtos[i];
                produtos[i] = produtos[j];
                produtos[j] = temp;
            } else {
                return j;
            }
        }
    }

    //????
    private int particionaDois(int ini, int fim) {
        Produto x = produtos[ini];
        int i = (ini - 1), j = (fim + 1);

        while (true) {

            switch (criterio) {
                case CRIT_DESC_DECRE:
                    do {
                        j--;
                    } while (crit_descricao.aplicaCriterioDois(produtos[j], x));
                    //produtos[j].getDescricao().compareToIgnoreCase(x.getDescricao()) > 0

                    do {
                        i++;
                    } while (crit_descricao.aplicaCriterioUm(produtos[i], x));
                    //produtos[i].getDescricao().compareToIgnoreCase(x.getDescricao()) < 0

                    break;

                case CRIT_PRECO_DECRE:
                    do {
                        j--;
                    } while (crit_preco.aplicaCriterioDois(produtos[j], x));
                    //produtos[j].getPreco() > x.getPreco()

                    do {
                        i++;
                    } while (crit_preco.aplicaCriterioUm(produtos[i], x));
                    //produtos[i].getPreco() < x.getPreco()

                    break;

                case CRIT_ESTOQUE_DECRE:
                    do {
                        j--;
                    } while (crit_estoque.aplicaCriterioDois(produtos[j], x));
                    //produtos[j].getQtdEstoque() > x.getQtdEstoque()

                    do {
                        i++;
                    } while (crit_estoque.aplicaCriterioUm(produtos[i], x));
                    //produtos[i].getQtdEstoque() < x.getQtdEstoque()

                    break;
            }

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

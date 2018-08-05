/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ferna
 */
public interface Criterio {
    public boolean aplicaCriterioUm(Produto k, Produto x);
    public boolean aplicaCriterioDois(Produto k, Produto x);
}

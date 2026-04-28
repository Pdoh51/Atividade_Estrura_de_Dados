package controller;

import model.arvore.ArvoreBinaria;
import model.lista.ListaEncadeada;

public class ArvoreController {
    public ArvoreController() {
        super();
    }

    public String teste() throws Exception {
        ArvoreBinaria arvore = new ArvoreBinaria();

        arvore.add(30);
        arvore.add(25);
        arvore.add(40);
        arvore.add(23);
        arvore.add(28);
        arvore.add(35);
        arvore.add(45);
        arvore.add(22);
        arvore.add(24);
        arvore.add(27);
        arvore.add(29);
        arvore.add(31);
        arvore.add(36);
        arvore.add(41);
        arvore.add(46);

        ListaEncadeada ordem = arvore.ORDEM();
        ListaEncadeada preOrdem = arvore.PREordem();
        ListaEncadeada posOrdem = arvore.POSordem();

        return "ORDEM:   " + ordem.toString() + "\n" +
                "PREordem:  " + preOrdem.toString() + "\n" +
                "POSordem:  " + posOrdem.toString();
    }
}
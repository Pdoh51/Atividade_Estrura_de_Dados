package controller;

import model.estrutura.filaCircular;
import model.estrutura.tipos;

public class filaFifoCircularController {
    private filaCircular lista = new filaCircular();

    public void add(tipos elemento) {
        lista.append(elemento);
    }
    public String get() {
        return lista.remover();
    }
    public String show() {
        return lista.toString();
    }
}
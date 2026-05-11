package controller;

import model.GrafoMatriz;

public class GrafoController{
    public GrafoController(){
        super();
    }

    public String teste() throws Exception{
        String[] rotas = new String[] {"A", "B", "C", "D"};
        GrafoMatriz g = new GrafoMatriz(rotas);

        g.link("A", "B");
        g.link("A", "D");
        g.link("B", "C");
        g.link("C", "D");

        g.remove("A");

        return g.toString();
    }
}
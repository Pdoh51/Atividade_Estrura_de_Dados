package controller;

import model.GrafoLista;

public class GrafoController{
    public GrafoController(){
        super();
    }

    public String teste() throws Exception{
        GrafoLista<String> g = new GrafoLista<String>();

        g.add("A", "B");
        g.add("A", "D");
        g.add("B", "C");
        g.add("D", "G");
        g.add("D", "H");
        g.add("D", "I");
        g.add("E", "H");
        g.add("E", "J");
        g.add("F", "A");
        g.add("F", "K");
        g.add("F", "H");
        g.add("H", "O");
        g.add("I", "C");
        g.add("I", "J");
        g.add("J", "C");
        g.add("J", "N");
        g.add("K", "L");
        g.add("L", "G");
        g.add("L", "M");
        g.add("M", "N");
        g.add("N", "O");

        //g.remove(0, 1);

        return g.toString();
    }
}
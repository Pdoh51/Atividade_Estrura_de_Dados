package view;

import controller.filaFifoCircularController;
import model.estrutura.tipos;

public class filaFifoCircular {

    public static void main(String[] args) {
        filaFifoCircularController c = new filaFifoCircularController();

        c.add(new tipos("http","lista_encadeada"));
        c.add(new tipos("http","lista_dupla"));
        c.add(new tipos("pop","fatorial"));
        c.add(new tipos("smtp","quick_sort"));
        c.add(new tipos("http","lista_circular"));

        System.out.println(c.get());
        System.out.println(c.get());
        System.out.println(c.get());
        System.out.println(c.get());
        
        

        System.out.println(c.show());
    }

}
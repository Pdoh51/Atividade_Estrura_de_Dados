package controller;

import model.GrafoMatriz;
import java.util.*;

public class GrafoController {

    static String[] rotas = new String[] {"Belo Horizonte", "Governador Valadares", "Manhuaçu", "Uberaba", "Juiz de Fora", "Uberlândia", "Patos de Minas", "Colatina", "Vitória", "Rio de Janeiro", "Campos dos Goytacazes", "São José dos Campos", "São Paulo", "Campinas", "São Carlos", "Ribeirão Preto", "Franca", "São José do Rio Preto"};
    static Grafo g = new Grafo(rotas);

    public void carregaGrafo() {
        g.link("Belo Horizonte", "Governador Valadares", 313);
        g.link("Belo Horizonte", "Manhuaçu", 279);
        g.link("Belo Horizonte", "Uberaba", 476);
        g.link("Belo Horizonte", "Juiz de Fora", 260);
        g.link("Uberaba", "Uberlândia", 105);
        g.link("Uberlândia", "Patos de Minas", 222);
        g.link("Governador Valadares", "Colatina", 216);
        g.link("Manhuaçu", "Governador Valadares", 198);
        g.link("Manhuaçu", "Vitória", 233);
        g.link("Manhuaçu", "Juiz de Fora", 290);
        g.link("Juiz de Fora", "Rio de Janeiro", 181);
        g.link("Rio de Janeiro", "Campos dos Goytacazes", 277);
        g.link("Campos dos Goytacazes", "Vitória", 240);
        g.link("Rio de Janeiro", "São José dos Campos", 341);
        g.link("São José dos Campos", "São Paulo", 79);
        g.link("São Paulo", "Campinas", 111);
        g.link("Campinas", "São Carlos", 142);
        g.link("São Carlos", "Ribeirão Preto", 99);
        g.link("Ribeirão Preto", "Franca", 89);
        g.link("Ribeirão Preto", "Uberlândia", 278);
        g.link("Uberlândia", "São José do Rio Preto", 285);
        g.link("São José do Rio Preto", "São Carlos", 260);
    }


    public void teste(String cidade) {
        System.out.println("CAMINHO PARA FABRICA: ");
        //FABRICA
        g.menorCaminho(cidade,"Belo Horizonte",true);

        //CENTRO 1
        int c1 = g.menorCaminho(cidade,"Campos dos Goytacazes",false);
        // CENTRO 2
        int c2 = g.menorCaminho(cidade,"Campinas",false);

        System.out.println("CAMINHO PARA CENTRO: ");
        if(c1 < c2) {
            g.menorCaminho(cidade,"Campos dos Goytacazes",true);
        }else {
            g.menorCaminho(cidade,"Campinas",true);
        }
    }
}
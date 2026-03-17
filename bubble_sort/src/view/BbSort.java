package view;

import controller.BbSortController;

public class BbSort{
    public static void main (String [] args){
        int vetor[] = {1, 5, 3, 9, 4, 8};
        BbSortController Bb = new BbSortController();
        Bb.ordenar(vetor);
        for (int i = 0; i < vetor.length; i++)
            System.out.println(vetor[i]);
    }
}
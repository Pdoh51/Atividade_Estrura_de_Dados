package model;

import java.util.*;

public class GrafoMatriz <T>{
    private int[][] matriz;
    private String[] labels;

    public GrafoMatriz(String[] labels){
        this.labels = labels;
        this.matriz = new int [labels.length][labels.length];
    }

    public void link(String label1, String label2){
        int index_label1 = Arrays.asList (this.labels).indexOf(label1);
        int index_label2 = Arrays.asList (this.labels).indexOf(label2);
        this.matriz[index_label1] [index_label2] = 1;
        this.matriz[index_label2] [index_label1] = 1;
    }

    /* REMOVE */

    public void remove(T label1, T label2){
        int index_label1 = Arrays.asList (this.labels).indexOf(label1);
        int index_label2 = Arrays.asList (this.labels).indexOf(label2);
        this.matriz[index_label1] [index_label2] = 0;
        this.matriz[index_label2] [index_label1] = 0;
    }

    public void remove(String label) {
        int index = Arrays.asList(this.labels).indexOf(label);
        if (index == -1) return;

        int novoTamanho = this.labels.length - 1;

        String[] novasLabels = new String[novoTamanho];
        int[][] novaMatriz = new int[novoTamanho][novoTamanho];

        int ki = 0;
        for (int i = 0; i < this.labels.length; i++) {
            if (i == index) continue;
            novasLabels[ki++] = this.labels[i];
        }

        int ni = 0;
        for (int i = 0; i < this.labels.length; i++) {
            if (i == index) continue;
            int nj = 0;
            for (int j = 0; j < this.labels.length; j++) {
                if (j == index) continue;
                novaMatriz[ni][nj++] = this.matriz[i][j];
            }
            ni++;
        }

        this.labels = novasLabels;
        this.matriz = novaMatriz;
    }


    @Override
    public String toString(){
        StringBuilder builder = new StringBuilder();
        for(int i = 0; i < this.labels.length; i++){
            builder.append(this.labels[i] + ": ");
            for (int j = 0; j < this.labels.length; j++){
                if(this.matriz[i][j] == 1) {
                    builder.append(this.labels[j] + " ");
                }
            }
            builder.append("\r\n");
        }
        return (builder.toString());
    }
}
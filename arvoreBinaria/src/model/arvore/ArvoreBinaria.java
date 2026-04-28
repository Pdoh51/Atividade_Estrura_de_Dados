package model.arvore;

import model.arvore.No;
import model.lista.ListaEncadeada;

public class ArvoreBinaria<T extends Comparable<T>>{
    private No<T> raiz;
    private int tamanho = 0;

    public ArvoreBinaria(){
        this.raiz = null;
    }

    public void add (T valor){ // colocar algo
        No<T> novo = new No<T>(valor);
        tamanho++;
        if(raiz == null){ // se raiz estiver vazia ela vira o novo colocalo
            this.raiz = novo;
            return;
        } else {
            No<T> atual = this.raiz;
            while(true){
                if(novo.getValor().compareTo(atual.getValor()) == -1){ // compareTo compara o novo com -1 para ver se o novo é negativo ou não (Se o novo for 0 vai para o maior e se o novo for igual a algum já existente vai para o maior também)
                    if(atual.getMenor() != null){
                        atual = atual.getMenor();
                    } else {
                        atual.setMenor(novo);
                        break;
                    }
                } else {
                    if(atual.getMaior() != null){
                        atual = atual.getMaior();
                    } else {
                        atual.setMaior(novo);
                        break;
                    }
                }
            }
        }
    }

    // Base para mostrar as ordens
    public  ListaEncadeada ORDEM(){ // criar a base para ordem
        ListaEncadeada lista = new ListaEncadeada();
        No<T> atual = this.raiz;
        ORDEM(atual, lista);
        return lista;
    }
    public  ListaEncadeada PREordem(){ // criar a base para preordem
        ListaEncadeada lista = new ListaEncadeada();
        No<T> atual = this.raiz;
        PREordem(atual, lista);
        return lista;
    }
    public  ListaEncadeada POSordem(){ // criar a base para posordem
        ListaEncadeada lista = new ListaEncadeada();
        No<T> atual = this.raiz;
        POSordem(atual, lista);
        return lista;
    }


    // Seguencia interna de cada ordem
     private void ORDEM(No<T>  atual, ListaEncadeada lista){ // menor, raiz, maior
        if(atual != null){
            ORDEM(atual.getMenor(), lista);
            lista.append(atual.getValor());
            ORDEM(atual.getMaior(), lista);
        }
     }
    private void PREordem(No<T>  atual, ListaEncadeada lista){ // raiz, menor, maior
        if(atual != null){
            lista.append(atual.getValor());
            PREordem(atual.getMenor(), lista);
            PREordem(atual.getMaior(), lista);
        }
    }
    private void POSordem(No<T>  atual, ListaEncadeada lista){ // menor, maior, raiz
        if(atual != null){
            POSordem(atual.getMenor(), lista);
            POSordem(atual.getMaior(), lista);
            lista.append(atual.getValor());
        }
    }
}
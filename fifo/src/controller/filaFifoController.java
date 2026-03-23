package controller;

import model.estrutura.filaFifo;
import model.estrutura.No;

public class filaFifoController{
    public filaFifoController(){
        super();
    }
    
    public String teste() throws Exception{
        filaFifo fila = new filaFifo();

        fila.enqueue("1-Primeiro da fila.");
        fila.enqueue("2-Segundo da fila.");
        fila.enqueue("3-Terceiro da fila.");
        fila.dequeue();
        
        return fila.toString();
    }
}
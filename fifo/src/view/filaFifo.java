package view;

import controller.filaFifoController;

public class filaFifo{
    public static void main (String [] args){
        try{
            filaFifoController obj = new filaFifoController();
            System.out.println(obj.teste());
        } catch(Exception e){
            e.printStackTrace();
        }
    }
}
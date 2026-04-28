package view;

import controller.ArvoreController;

public class View{
    public static void main (String [] args){
        try{
            ArvoreController obj = new ArvoreController();
            System.out.println(obj.teste());
        } catch( Exception e){
            e.printStackTrace();
        }
    }
}
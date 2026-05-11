package view;

import controller.GrafoController;

public class View{
    public static void main (String [] args){
        try{
            GrafoController obj = new GrafoController();
            System.out.println(obj.teste());
        } catch(Exception e){
            e.printStackTrace();
        }
    }
}
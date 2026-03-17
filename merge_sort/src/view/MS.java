package view;

 import controller.MSController;

 public class MS{
     public static void main (String [] args) {
         int vetor[] = {1, 5, 3, 9, 4, 8};
         MSController merge = new MSController();
         merge.ordenar(vetor);
         for (int i = 0; i < vetor.length; i++)
             System.out.println(vetor[i]);
     }
 }
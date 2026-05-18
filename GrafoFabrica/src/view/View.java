package view;

import javax.swing.JOptionPane;

import controller.GrafoController;

public class View {
    public static void main(String[] args) {
        Controlador c = new Controlador();
        c.carregaGrafo();

        String opc = JOptionPane.showInputDialog("Digite o nome da cidade");
        c.teste(opc);
    }
}
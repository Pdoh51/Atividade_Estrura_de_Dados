package model;

import java.util.*;

public class GrafoMatriz <T>{
    private int[][] matriz;
    private String[] labels;

    public GrafoMatriz(String[] labels){
        this.labels = labels;
        this.matriz = new int [labels.length][labels.length];
    }

    public void link(String label1, String label2,int distancia){
        int index_label1 = Arrays.asList (this.labels).indexOf(label1);
        int index_label2 = Arrays.asList (this.labels).indexOf(label2);
        this.matriz[index_label1] [index_label2] = distancia;
        this.matriz[index_label2] [index_label1] = distancia;
    }

    public int menorCaminho(String partida, String destinoNome,boolean printar) {
        int origem = Arrays.asList(labels).indexOf(partida);
        int destino = Arrays.asList(labels).indexOf(destinoNome);

        if (origem == -1 || destino == -1) {
            System.out.println("Cidade não encontrada");
            return 0;
        }

        int n = matriz.length;

        int[] distancia = new int[n];
        boolean[] visitado = new boolean[n];
        int[] anterior = new int[n];

        Arrays.fill(distancia, Integer.MAX_VALUE);
        Arrays.fill(anterior, -1);

        distancia[origem] = 0;

        for (int c = 0; c < n; c++) {
            int atual = -1;
            int menorDistancia = Integer.MAX_VALUE;

            // pega o menor vértice ainda não visitado
            for (int i = 0; i < n; i++) {

                if (!visitado[i] && distancia[i] < menorDistancia) {

                    menorDistancia = distancia[i];
                    atual = i;
                }
            }

            // não há mais caminhos
            if (atual == -1) {
                break;
            }

            visitado[atual] = true;

            // percorre vizinhos
            for (int vizinho = 0; vizinho < n; vizinho++) {

                // existe aresta
                if (matriz[atual][vizinho] > 0) {

                    int novaDistancia = distancia[atual] + matriz[atual][vizinho];

                    // encontrou caminho melhor
                    if (novaDistancia < distancia[vizinho]) {

                        distancia[vizinho] = novaDistancia;
                        anterior[vizinho] = atual;
                    }
                }
            }
        }

        // Traçar a rota
        List<String> caminho = new ArrayList<>();

        for (int at = destino; at != -1; at = anterior[at]) {
            caminho.add(labels[at]);
        }

        Collections.reverse(caminho);

        if(printar) {
            //System.out.println("Menor custo : " + distancia[destino]+" KM");

            //System.out.println("Caminho:");
            StringBuilder str = new StringBuilder("");
            for (String cidade : caminho) {
                str.append(cidade);
                str.append(", ");
            }
            str.append(": ");
            str.append(distancia[destino]);
            str.append(" KM");
            System.out.println(str.toString());
        }
        return distancia[destino];
    }

    @Override
    public String toString(){
        StringBuilder builder = new StringBuilder();
        for(int i = 0; i < this.labels.length; i++){
            builder.append(this.labels[i] + ": ");
            for (int j = 0; j < this.labels.length; j++){
                if(this.matriz[i][j] >= 1) {
                    builder.append(this.labels[j] + " ");
                }
            }
            builder.append("\r\n");
        }
        return (builder.toString());
    }
}
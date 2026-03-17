package controller;

public class MSController{
    public MSController() {
        super();
    }

    public void ordenar (int[] vetor) {
        merge(vetor, 0, vetor.length - 1);
    }

    public void merge (int[] vetor, int inicio, int fim) {
        int meio;
        if( inicio < fim) {
            meio = (inicio + fim) / 2;
            merge(vetor, inicio, meio);
            merge(vetor, meio + 1, fim);
            intercala(vetor, inicio, fim, meio);
        }
    }

    public void intercala(int[] vetor, int inicio, int fim, int meio) {
        int poslivre, inicio_v, inicio_v2;
        int aux[] = new int [vetor.length];
        inicio_v = inicio;
        inicio_v2 = meio + 1;
        poslivre = inicio;

        while (inicio_v <= meio && inicio_v2 <= fim) {
            if (vetor[inicio_v] <= vetor[inicio_v2]) {
                aux[poslivre++] = vetor[inicio_v ++];
            } else {
                aux[poslivre++] = vetor[inicio_v2 ++];
            }
        }
        for (int i = inicio_v; i <= meio; i++)
            aux[poslivre++] = vetor[i];
        for (int i = inicio_v2; i <= fim; i++)
            aux[poslivre++] = vetor[i];
        for (int i = inicio; i <= fim; i++)
            vetor[i] = aux[i];
    }
}
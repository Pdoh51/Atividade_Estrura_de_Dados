package model.estrutura;

import model.estrutura.filaFifo.No;

public class filaCircular<T> {
    public class No {
        private filaFifo lista;
        private No proximo;
        private No anterior;
        public No(filaFifo lista) {
            this.lista = lista;
        }
        public filaFifo getLista() {
            return this.lista;
        }
        public void setFila(filaFifo lista) {
            this.lista = lista;
        }
        public No getProximo() {
            return this.proximo;
        }
        public void setProximo(No proximo) {
            this.proximo = proximo;
        }
        public No getAnterior() {
            return anterior;
        }
        public void setAnterior(No anterior) {
            this.anterior = anterior;
        }
        @Override
        public String toString() {
            return this.lista.toString();
        }
    }
    private No ultimo;
    private No ponteiro;
    public void append(tipos elemento) {
        if (this.ultimo == null) {
            filaFifo lista = new filaFifo();
            lista.enqueue(elemento);
            No novo = new No(lista);
            novo.setProximo(novo);
            novo.setAnterior(novo);
            this.ultimo = novo;
        } else {
            if (simTipo(elemento.getType()) != null) {
                No buffer = simTipo(elemento.getType());
                buffer.getLista().enqueue(elemento);
            } else {
                filaFifo lista = new filaFifo();
                lista.enqueue(elemento);
                No novo = new No(lista);
                novo.setProximo(this.ultimo.getProximo());
                novo.setAnterior(this.ultimo);
                this.ultimo.setProximo(novo);
                this.ultimo = novo;
            }
        }
    }
    public No simTipo(String tipo) {
        if (this.ultimo == null) {
            return null;
        }
        No buffer = this.ultimo;
        if (buffer.getLista().getType().equals(tipo)) {
            return buffer;
        }
        while (buffer.getProximo() != this.ultimo) {
            buffer = buffer.getProximo();
            if (buffer.getLista().getType().equals(tipo)) {
                return buffer;
            }
        }
        return null;
    }
    public String remover() {
        if (this.ponteiro == null) {
            this.ponteiro = this.ultimo;
        }
        String protocolo = this.ponteiro.getLista().getInicio().toString();
        this.ponteiro.getLista().dequeue();
        this.ponteiro = this.ponteiro.getProximo();
        No buffer = this.ponteiro;
        while (this.ponteiro.toString().equals("[]")) {
            this.ponteiro = this.ponteiro.getProximo();
            if (this.ponteiro == buffer) {
                break;
            }
        }
        return protocolo;
    }

    @Override
    public String toString() {
        String text = "[";
        No buffer = this.ultimo;
        text += buffer.getLista();
        while (buffer.getProximo() != this.ultimo) {
            text += ", ";
            buffer = buffer.getProximo();
            text += buffer.getLista();
        }
        text += "]";
        return text;
    }
}
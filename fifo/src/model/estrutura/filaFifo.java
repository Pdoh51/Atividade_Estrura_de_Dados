package model.estrutura;

import java.lang.Exception;
import model.estrutura.No;

public class filaFifo<T> {
    private No<T> inicio;
    public No<T> last() {
        No<T> buffer = this.inicio;
        while (buffer.getProximo() != null) {
            buffer = buffer.getProximo();
        }
        return buffer;
    }

    public void enqueue(T valor) {
        No<T> novo = new No<T>(valor);
        if (this.inicio == null) {
            this.inicio = novo;
        } else {
            this.last().setProximo(novo);
        }
    }

    public void dequeue() {
        if (this.inicio != null) {
            if (this.inicio.getProximo() != null) {
                this.inicio = this.inicio.getProximo();
            } else {
                this.inicio = null;
            }
        }
    }

    @Override
    public String toString(){
        if (this.inicio == null) {
            return "[]";
        }
        StringBuilder builder = new StringBuilder("[");
        No<T> buffer = this.inicio;
        builder.append(buffer.getValor());
        while(buffer.getProximo() != null){
            builder.append(",");
            buffer = buffer.getProximo();
            builder.append(buffer.getValor());
        }
        builder.append("]");
        return builder.toString();
    }
}

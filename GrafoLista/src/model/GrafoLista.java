package model;

import java.util.*;

public class GrafoLista <T>{
    private Map<T, List<T> > map = new HashMap<>();

    public void add(T source){
         map.put(source, new LinkedList<T>());
    }

    public void add(T source, T destino){
        if(!map.containsKey(source)){
            add(source);
        }
        if(!map.containsKey(destino)){
            add(destino);
        }
        map.get(source).add(destino);
        map.get(destino).add(source);
    }

    public boolean has (T s){ // para ver se existe(se existe chave)
        return map.containsKey(s);
    }

    public boolean has (T s, T d){ // para ver se tem coneção
        return map.get(s).contains(d);
    }

    public int size(){ // retorna quantidade de chaves 
        return map.keySet().size();
    }

    /* REMOVE */
    public void remove(T s, T d){
        // EX: A: [B] | Chave = A e Conexão = B
        if(has(s)){ // Se tem chave tira conexão
            map.get(s).remove(d);
        }
        if(has(d)){
            map.get(d).remove(s);
        }

        if(map.get(s).size() == 0){ // Se não tem nenhuma conexão tira a chave
            map.remove(s);
        }
        if(map.get(d).size() == 0){
            map.remove(d);
        }
    }
    
    @Override
    public String toString(){
        StringBuilder builder = new StringBuilder();
        for(T v: map.keySet()){
            builder.append(v.toString() + ": ");
            for (T w: map.get(v)){
                builder.append(w.toString()+ " ");
            }
            builder.append("\n");
        }
        return (builder.toString());
    }
}
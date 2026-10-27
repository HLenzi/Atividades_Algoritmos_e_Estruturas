/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */



/**
 *
 * @author Lenzi
 */
public class PilhaVetor<T> implements Pilha<T> {

    private T info[];
    private int limite;
    private int tamanho;

    public PilhaVetor(int limite) {
        this.limite = limite;
        info = (T[]) new Object[limite];
        this.tamanho = 0;
    }
    
    public int getTamanho(){
    return this.tamanho;
}

    @Override
    public void push(T valor) {
        if (tamanho == limite) {
            throw new PilhaVaziaException();
        }
        tamanho++;
        info[tamanho - 1] = valor;

    }

    @Override
    public T pop() {
        if (tamanho == 0) {
            throw new PilhaVaziaException();
        }
        T topo = peek();
        info[tamanho - 1] = null;
        tamanho--;
        return topo;
    }

    @Override
    public T peek() {
        if (tamanho == 0) {
            throw new PilhaVaziaException();
        }

        return info[tamanho - 1];
    }

    @Override
    public boolean estaVazia() {
        if (tamanho == 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void liberar() {
        T topo;
        while (tamanho != 0) {
            topo = pop();
        }
    }
    
    @Override
    public String toString(){
        String stg = "";
        for(int i = tamanho - 1; i >= 0; i--){
            stg += info[i];
            if(i != 0){
                stg += ", ";
            }
        }
        
        return stg;
    }

    
    public void concatenar(PilhaVetor pilha){
        if(this.tamanho + pilha.getTamanho() > limite){
            throw new IllegalArgumentException("Pilha fornecida é muito grande");
        }
        for(int i = 0; i < pilha.getTamanho(); i++){
            push((T) pilha.info[i]);
        }
        
    }
}

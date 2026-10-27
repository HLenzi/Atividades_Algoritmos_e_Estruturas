/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lista6;

/**
 *
 * @author Lenzi
 */
public class FilaVetor<T> implements Fila<T>{

    private T[] info;
    private int inicio;
    private int tamanho;
    private int limite;
    
    public FilaVetor(int limite) {
        this.limite = limite;
        this.info = (T[]) new Object[limite];
        this.inicio = 0;
        this.tamanho = 0;
    }
    
    @Override
    public void inserir(T valor) {
        if(tamanho == limite){
        throw new FilaCheiaException();
        }
        
        int posicaoInserir = (inicio + tamanho) % limite;
        info[posicaoInserir] = valor;
        tamanho++;
    }

    @Override
    public boolean estaVazia() {
        if(tamanho != 0){
            return false;
        } else {
            return true;
        }
    }

    @Override
    public T peek() {
        if(tamanho == 0){
            throw new FilaVaziaException();
        }
        return info[inicio];
    }

    @Override
    public T retirar() {
        T valor = peek();
        
        inicio = (inicio + 1) % limite;
        tamanho--;
        return valor;
    }

    @Override
    public void liberar() {
        Object[] novo = (T[]) new Object[limite];
        info = (T[]) novo;
        tamanho = 0;
        inicio = 0;
    }
    
    public FilaVetor criarFilaConcatenada(FilaVetor<T> f2){
        FilaVetor<T> novo = new FilaVetor<T>(this.limite + f2.limite);
        
        for(int i = 0; i < this.tamanho; i++){
            int posicao = (this.inicio + i) % this.limite;
            novo.inserir((T) this.info[posicao]);
        }
        
        for(int i = 0; i < f2.tamanho; i++){
            int posicao = (f2.inicio + i) % f2.limite;
            novo.inserir((T) f2.info[posicao]);
        }
        
        return novo;
    }
    
    public String toString(){
        String str = "";
        for( int i = 0; i < this.tamanho; i++){
            int posicao = (this.inicio + i) % limite;
            str += this.info[posicao];
            
            if (i < this.tamanho - 1){
                str += ",";
            }
        }
        return str;
    }
}

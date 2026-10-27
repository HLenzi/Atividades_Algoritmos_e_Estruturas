/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lista6;

/**
 *
 * @author Lenzi
 */
public class FilaLista<T> implements Fila<T> {

    private ListaEncadeada lista = new ListaEncadeada();
    
    @Override
    public void inserir(T valor) {
        lista.inserirNoFinal(valor);
    }

    @Override
    public boolean estaVazia() {
        if(lista.getPrimeiro() == null){
            return true;
        } else {
            return false;
        }
    }

    @Override
    public T peek() {
        if(this.estaVazia()){
            throw new FilaVaziaException();
        }
        return (T) lista.getPrimeiro().getInfo();
    }

    @Override
    public T retirar() {
        T valor = peek();
        
        lista.retirar(valor);
        
        return valor;
    }

    @Override
    public void liberar() {
        lista = new ListaEncadeada<>();
    }
    
    public String toString(){
        return lista.toString();
    }
}

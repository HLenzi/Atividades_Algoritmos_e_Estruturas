/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


/**
 *
 * @author Lenzi
 */
public class PilhaLista<T> implements Pilha<T> {
    
    private ListaEncadeada lista = new ListaEncadeada();
    
    @Override
    public void push(T valor) {
        lista.inserir(valor);
    }

    @Override
    public T pop() {
        T valor = peek();
        lista.retirar(valor);
        return valor;
    }

    @Override
    public T peek() {
        T valor = (T) lista.getPrimeiro().getInfo();
        return valor;
    }

    @Override
    public boolean estaVazia() {
        return lista.estaVazia();
    }

    @Override
    public void liberar() {
        lista.setPrimeiro(null);
    }
    
    public String toString(){
        return lista.toString();
    }
}

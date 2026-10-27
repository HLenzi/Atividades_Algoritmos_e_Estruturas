/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.lista2;

/**
 *
 * @author Lenzi
 */
public class ListaEstatica<G> {

    G[] info;
    int tamanho;

    public ListaEstatica(G[] info, int tamanho) {
        this.info = info;
        this.tamanho = tamanho;
    }

    private void redimencionar() {
        G[] novo = (G[]) new Object[info.length + 10];
        
        for (int i = 0; i < tamanho; i++) {
            novo[i] = info[i];
        }
        
        info = novo;
    }

    public void inserir(G valor) {
        if (tamanho >= this.getTamanho()) {
            this.redimencionar();
        }

        info[tamanho] = valor;
        tamanho++;
    }

    public void exibir() {
        for (int i = 0; i <= tamanho; i++) {
            System.out.println("Posicao " + i + ": " + info[i]);
        }
    }

    public int buscar(G valor) {
        int index = -1;

        for (int i = 0; i <= this.getTamanho(); i++) {
            if (info[i].equals(valor)) {
                index = i;
                return index;
            }
        }

        return index;
    }

    public void retirar(int valor) {
        for (int i = 0; i < this.getTamanho(); i++) {
            if (info[i].equals(valor)) {
                for (int x = i; x < this.getTamanho(); x++) {
                    info[x] = info[x + 1];
                }
                this.tamanho--;
            }

        }
    }

    public void liberar() {
        int[] info = new int[10];
        tamanho = 0;
    }

    public G obterElemento(int posicao) {
        if (posicao > this.getTamanho()) {
            throw new IndexOutOfBoundsException("Posição invalida!");
        } else {
            return info[posicao];
        }
    }

    public boolean estaVazia() {
        if (this.getTamanho() == 0) {
            return true;
        } else {
            return false;
        }
    }

    public int getTamanho() {
        return this.tamanho;
    }
    
    public String toString() {
        if (tamanho == 0) return "";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < tamanho; i++) {
            sb.append(info[i]);
            if (i < tamanho - 1) {
                sb.append(",");
            }
        }
        return sb.toString();
    }
    
    public void inverter() {
    for (int i = 0, j = tamanho - 1; i < j; i++, j--) {
        G temp = info[i];
        info[i] = info[j];
        info[j] = temp;
    }
}
}

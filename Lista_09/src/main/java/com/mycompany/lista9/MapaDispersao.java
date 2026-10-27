/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lista9;

/**
 *
 * @author Lenzi
 */
public class MapaDispersao<T> {

    private ListaEncadeada<NoMapa<T>>[] info;

    public MapaDispersao(int tamanho) {
        info = new ListaEncadeada[tamanho];
    }

    private int calcularHash(int chave) {
        int tamanho = info.length;
        return chave % tamanho;
    }

    public void inserir(int chave, T valor) {
        int idx = calcularHash(chave);

        if (info[idx] == null) {
            info[idx] = new ListaEncadeada<NoMapa<T>>();
        }

        NoMapa noMapa = new NoMapa();
        noMapa.setChave(chave);
        noMapa.setValor(valor);

        info[idx].inserir(noMapa);
    }

    public T buscar(int chave) {
        int idx = calcularHash(chave);

        if (info[idx] != null) {
            NoMapa noMapa = new NoMapa();
            noMapa.setChave(chave);
            
            NoLista<NoMapa<T>> no = info[idx].buscar(noMapa);
            
            if(no != null){
                return no.getInfo().getValor();
            }
        }
        return null;
    }
    
    public double calcularFatorCarga() {
    int total = 0;
    
    for (int i = 0; i < info.length; i++) {
        if (info[i] != null) {
            total += info[i].obterComprimento();
        }
    }
    
    return (double) total / info.length;
}
    
    public void remover(int chave) {
    int idx = calcularHash(chave);

    if (info[idx] != null) {
        NoMapa<T> noMapa = new NoMapa<>();
        noMapa.setChave(chave);
        
        info[idx].retirar(noMapa);
    }
}
}

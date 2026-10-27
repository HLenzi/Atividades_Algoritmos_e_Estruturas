/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lista11;

/**
 *
 * @author Lenzi
 */
public class BuscaLinearVetorOrdenado<T extends Comparable<T>> extends BuscaAbstract<T> {
    
    @Override
    public int buscar(T valor) {

        for (int i = 0; i < info.length; i++) {
            int comparacao = info[i].compareTo(valor);
            
            if (comparacao == 0) {
                return i;
            } else if (comparacao > 0) {
                return -1;
            }
        }
        
        return -1;
    }
}

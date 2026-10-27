/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lista11;

/**
 *
 * @author Lenzi
 */
public class BuscaLinear <T extends Comparable<T>> extends BuscaAbstract<T> {

    @Override
    public int buscar(T valor) {
       int n = info.length;
        for (int i = 0; i < info.length; i++) {
            if (info[i].compareTo(valor) == 0) {
                return i;
            }
        }
        return -1;
    }
    
}

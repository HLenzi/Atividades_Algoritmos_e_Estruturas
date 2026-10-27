/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lista11;

/**
 *
 * @author Lenzi
 */
public class BuscaBinaria<T extends Comparable<T>> extends BuscaAbstract<T> {
    
     @Override
    public int buscar(T valor) {
        int n = info.length;
        int inicio = 0;
        int fim = n - 1;
        
        while (inicio <= fim) {
            int meio = (inicio + fim) / 2;
            
            if (valor.compareTo(info[meio]) < 0) {
                fim = meio - 1; 
            } else if (valor.compareTo(info[meio]) > 0) {
                inicio = meio + 1; 
            } else {
                return meio;
            }
        }
        
        return -1; 
    }
  }

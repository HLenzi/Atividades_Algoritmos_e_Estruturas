/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.lista11;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Lenzi
 */
public class BuscaIT {
    
    public BuscaIT() {
    }

     private final Integer[] dados = {0, 10, 20, 30, 40, 50, 60, 70, 80, 90, 100};
    
    @Test
    public void testeBuscar20() {
        BuscaLinear<Integer> buscaLinear = new BuscaLinear<>();
        buscaLinear.setInfo(dados);
        
        int resultado = buscaLinear.buscar(20);
        assertEquals(2, resultado);
    }
    
    @Test
    public void testeBuscar40() {
        BuscaLinearVetorOrdenado<Integer> buscaLinearOrdenada = new BuscaLinearVetorOrdenado<>();
        buscaLinearOrdenada.setInfo(dados);
        
        int resultado = buscaLinearOrdenada.buscar(40);
        assertEquals(4, resultado);
    }
    
    @Test
    public void testeBuscar70() {
        BuscaBinaria<Integer> buscaBinaria = new BuscaBinaria<>();
        buscaBinaria.setInfo(dados);
        
        int resultado = buscaBinaria.buscar(70);
        assertEquals(7, resultado);
    }
    
    @Test
    public void testeBuscar75() {
        BuscaBinaria<Integer> buscaBinaria = new BuscaBinaria<>();
        buscaBinaria.setInfo(dados);
        
        int resultado = buscaBinaria.buscar(75);
        assertEquals(-1, resultado);
    }
    
}

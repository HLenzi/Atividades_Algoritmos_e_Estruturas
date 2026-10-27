/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.lista10;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Lenzi
 */
public class OrdenacaoTest {

    public OrdenacaoTest() {
    }

    public Integer[] vetorEntrada = {70, 2, 88, 15, 90, 30};
    public Integer[] resultado = {2, 15, 30, 70, 88, 90};

    @Test
    public void testBolha() {
        OrdenacaoBolha<Integer> ordenador = new OrdenacaoBolha<>();

        ordenador.setInfo(vetorEntrada);
        ordenador.ordenar();
        assertArrayEquals(ordenador.getInfo(), resultado);
    }

    @Test
    public void testBolhaOtimizada() {
        OrdenacaoBolhaOtimizada<Integer> ordenador = new OrdenacaoBolhaOtimizada<>();

        ordenador.setInfo(vetorEntrada);
        ordenador.ordenar();
        assertArrayEquals(ordenador.getInfo(), resultado);
    }

    @Test
    public void testQuickSort() {
        OrdenacaoQuickSort<Integer> ordenador = new OrdenacaoQuickSort<>();

        ordenador.setInfo(vetorEntrada);
        ordenador.ordenar();
        assertArrayEquals(ordenador.getInfo(), resultado);
    }

    @Test
    public void testMergeSort() {
        OrdenacaoMergeSort<Integer> ordenador = new OrdenacaoMergeSort<>();

        ordenador.setInfo(vetorEntrada);
        ordenador.ordenar();
        assertArrayEquals(ordenador.getInfo(), resultado);
    }
}

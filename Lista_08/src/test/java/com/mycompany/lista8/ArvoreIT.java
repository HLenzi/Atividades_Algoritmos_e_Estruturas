/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.lista8;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Lenzi
 */
public class ArvoreIT {
    
    public ArvoreIT() {
    }

    private Arvore<Integer> criarArvore() {
        Arvore<Integer> arvore = new Arvore<>();
        
        // Criar nós
        NoArvore<Integer> n1 = new NoArvore<>(1);
        NoArvore<Integer> n2 = new NoArvore<>(2);
        NoArvore<Integer> n3 = new NoArvore<>(3);
        NoArvore<Integer> n4 = new NoArvore<>(4);
        NoArvore<Integer> n5 = new NoArvore<>(5);
        NoArvore<Integer> n6 = new NoArvore<>(6);
        NoArvore<Integer> n7 = new NoArvore<>(7);
        NoArvore<Integer> n8 = new NoArvore<>(8);
        NoArvore<Integer> n9 = new NoArvore<>(9);
        NoArvore<Integer> n10 = new NoArvore<>(10);
        
        // Montar a estrutura da árvore conforme diagrama
        n1.inserirFilho(n4);
        n1.inserirFilho(n3);
        n1.inserirFilho(n2);
        
        n2.inserirFilho(n7);
        n2.inserirFilho(n6);
        n2.inserirFilho(n5);
        
        n3.inserirFilho(n8);
        
        n4.inserirFilho(n10);
        n4.inserirFilho(n9);
        
        arvore.setRaiz(n1);
        
        return arvore;
    }
    
    
    @Test
    public void testToString() {
        Arvore<Integer> arvore = criarArvore();

        assertEquals(arvore.toString(), "<1<2<5><6><7>><3<8>><4<9><10>>>");
    }
    
     @Test
    public void pertenceTrue() {
        Arvore<Integer> arvore = criarArvore();
        
        assertTrue(arvore.pertence(7));
    }
    
     @Test
    public void pertenceFalse() {
        Arvore<Integer> arvore = criarArvore();
        
        assertFalse(arvore.pertence(55));
    }
    
    @Test
    public void testContarNos() {
        Arvore<Integer> arvore = criarArvore();
       
        assertEquals(10, arvore.contarNos());
    }
}

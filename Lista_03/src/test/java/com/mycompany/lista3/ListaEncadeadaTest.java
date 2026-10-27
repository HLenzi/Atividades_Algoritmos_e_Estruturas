/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.lista3;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Lenzi
 */
public class ListaEncadeadaTest {

    public ListaEncadeadaTest() {
    }

    @Test
    public void listaVazia() {
        ListaEncadeada<String> lista = new ListaEncadeada<>();

        boolean resultado = lista.estaVazia();

        assertTrue(resultado);
    }

    @Test
    public void listaNaoVazia() {
        ListaEncadeada<Integer> lista = new ListaEncadeada<>();

        lista.inserir(5);

        boolean resultado = lista.estaVazia();

        assertFalse(resultado);
    }

    @Test
    public void inclusaoNumero() {
        ListaEncadeada<Integer> lista = new ListaEncadeada<>();
        lista.inserir(5);
        NoLista<Integer> primeiroNo = lista.getPrimeiro();

        assertNotNull(primeiroNo);
        assertEquals(5, primeiroNo.getInfo());
        assertNull(primeiroNo.getProximo());
    }

    @Test
    public void inclusaoNumeros() {
        ListaEncadeada<Integer> lista = new ListaEncadeada<>();

        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);

        NoLista<Integer> primeiro = lista.getPrimeiro();
        assertNotNull(primeiro);
        assertEquals(15, primeiro.getInfo());

        NoLista<Integer> segundo = primeiro.getProximo();
        assertNotNull(segundo);
        assertEquals(10, segundo.getInfo());

        NoLista<Integer> terceiro = segundo.getProximo();
        assertNotNull(terceiro);
        assertEquals(5, terceiro.getInfo());

        assertNull(terceiro.getProximo());

    }
    
    @Test
    public void busca() {
        ListaEncadeada<Integer> lista = new ListaEncadeada<>();
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);
        
        NoLista<Integer> no = lista.buscar(20);
        
        assertEquals(20, no.getInfo());
    }
    
    @Test
    public void buscaMeio() {
        ListaEncadeada<Integer> lista = new ListaEncadeada<>();
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);
        
        NoLista<Integer> no = lista.buscar(15);
        
        assertEquals(15, no.getInfo());
    }
    
    @Test
    public void buscaInesistente() {
        ListaEncadeada<Integer> lista = new ListaEncadeada<>();
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);
        
        NoLista<Integer> no = lista.buscar(50);
        
        assertNull(no);
    }
    
    @Test
    public void exclusao() {
        ListaEncadeada<Integer> lista = new ListaEncadeada<>();
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);
        
        lista.retirar(20);
        
        NoLista<Integer> primeiro = lista.getPrimeiro();
        assertNotNull(primeiro);
        assertEquals(15, primeiro.getInfo());

        NoLista<Integer> segundo = primeiro.getProximo();
        assertNotNull(segundo);
        assertEquals(10, segundo.getInfo());

        NoLista<Integer> terceiro = segundo.getProximo();
        assertNotNull(terceiro);
        assertEquals(5, terceiro.getInfo());

        assertNull(terceiro.getProximo());
    }
    
    @Test
    public void exclusaoMeio() {
        ListaEncadeada<Integer> lista = new ListaEncadeada<>();
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);
        
        lista.retirar(15);
        
        NoLista<Integer> primeiro = lista.getPrimeiro();
        assertNotNull(primeiro);
        assertEquals(20, primeiro.getInfo());

        NoLista<Integer> segundo = primeiro.getProximo();
        assertNotNull(segundo);
        assertEquals(10, segundo.getInfo());

        NoLista<Integer> terceiro = segundo.getProximo();
        assertNotNull(terceiro);
        assertEquals(5, terceiro.getInfo());

        assertNull(terceiro.getProximo());
    }
    
    @Test
    public void obterNo() {
        ListaEncadeada<Integer> lista = new ListaEncadeada<>();
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);
        
        NoLista<Integer> no = lista.obterNo(0);
        
        assertEquals(20, no.getInfo());
    }
    
    @Test
    public void obterNoUltimo() {
        ListaEncadeada<Integer> lista = new ListaEncadeada<>();
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);
        
        NoLista<Integer> no = lista.obterNo(3);
        
        assertEquals(5, no.getInfo());
    }
    
    @Test
    public void obterNoInvalido() {
        ListaEncadeada<Integer> lista = new ListaEncadeada<>();
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);
        
        assertThrows(IndexOutOfBoundsException.class, () -> lista.obterNo(10)); 
    }
    
    @Test
    public void obterComprimeito() {
        ListaEncadeada<Integer> lista = new ListaEncadeada<>();
        
        assertEquals(0, lista.obterComprimeto());
    }
    
    @Test
    public void obterComprimeito2() {
        ListaEncadeada<Integer> lista = new ListaEncadeada<>();
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);
        
        assertEquals(4, lista.obterComprimeto());
    }
    
    
}

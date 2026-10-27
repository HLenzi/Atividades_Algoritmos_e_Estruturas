/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.lista8;

/**
 *
 * @author Lenzi
 */
public class Arvore<T> {

    private NoArvore<T> raiz;

    public Arvore() {

    }

    public NoArvore<T> getRaiz() {
        return raiz;
    }

    public void setRaiz(NoArvore<T> raiz) {
        this.raiz = raiz;
    }

    public boolean pertence(T info) {
        if (this.raiz == null) {
            return false;
        }

        return pertence(raiz, info);
    }

    public boolean pertence(NoArvore no, T info) {

        if (no.getInfo() == info) {
            return true;
        }

        NoArvore p = no.getPrimeiro();
        while (p != null) {
            if (this.pertence(p, info)) {
                return true;
            }
            p = p.getProximo();
        }
        return false;
    }

    public String toString() {
        if (raiz == null) {
            return "";
        }

        return obterRepresentacaoTextual(raiz);
    }

    public String obterRepresentacaoTextual(NoArvore no) {
        String str = "<";
        str += no.getInfo();

        NoArvore p = no.getPrimeiro();

        while (p != null) {
            str += obterRepresentacaoTextual(p);
            p = p.getProximo();
        }

        str += ">";

        return str;
    }

    public int contarNos() {
        if (raiz == null) {
            return 0;
        }
        return contarNos(raiz);
    }

    public int contarNos(NoArvore no) {
        if (no == null) {
            return 0;
        }

        int x = 1;
        NoArvore p = no.getPrimeiro();

        while (p != null) {
            x += contarNos(p);
            p = p.getProximo();
        }

        return x;
    }
}
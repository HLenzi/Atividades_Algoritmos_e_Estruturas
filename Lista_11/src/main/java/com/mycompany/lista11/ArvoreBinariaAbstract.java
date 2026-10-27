/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.lista11;

/**
 *
 * @author Lenzi
 */

public abstract class ArvoreBinariaAbstract<T> {

    private NoArvoreBinaria<T> raiz;

    public ArvoreBinariaAbstract() {
    }

    public NoArvoreBinaria<T> getRaiz() {
        return raiz;
    }

    protected void setRaiz(NoArvoreBinaria<T> raiz) {
        this.raiz = raiz;
    }

    public abstract NoArvoreBinaria<T> buscar(T info);

    public boolean pertence(T info) {
        return buscar(info) != null;
    }

    @Override
    public String toString() {
        if (raiz == null) {
            return "<>";
        }
        return obterRepresentacaoTextual(raiz);
    }

    private String obterRepresentacaoTextual(NoArvoreBinaria<T> no) {
        if (no == null) {
            return "<>";
        }

        String texto = "<" + no.getInfo();

        texto += obterRepresentacaoTextual(no.getEsquerda());
        texto += obterRepresentacaoTextual(no.getDireita());

        texto += ">";

        return texto;
    }

    public int contarNos() {
        return contarNos(raiz);
    }

    private int contarNos(NoArvoreBinaria<T> no) {
        if (no == null) {
            return 0;
        }
        return 1 + contarNos(no.getEsquerda()) + contarNos(no.getDireita());
    }
}
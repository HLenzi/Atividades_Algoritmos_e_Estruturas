/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lista11;

/**
 *
 * @author Lenzi
 */
public class ArvoreBinariaBusca<T extends Comparable<T>> extends ArvoreBinariaAbstract<T> {

    @Override
    public NoArvoreBinaria<T> buscar(T info) {
        return null;
    }

    public void inserir(T valor) {

        NoArvoreBinaria<T> novo = new NoArvoreBinaria<>(valor);

        if (this.getRaiz() == null) {
            this.setRaiz(novo);
            return;
        }

        NoArvoreBinaria<T> p = this.getRaiz();
        NoArvoreBinaria<T> pai;

        while (true) {

            pai = p;

            if (valor.compareTo(p.getInfo()) < 0) {
                p = pai.getEsquerda();

                if (p == null) {
                    pai.setEsquerda(novo);
                    return;
                }

            } else {
                p = pai.getDireita();

                if (p == null) {
                    pai.setDireita(novo);
                    return;
                }
            }
        }
    }

    public void retirar(T valor) {

        NoArvoreBinaria<T> p = this.getRaiz();
        NoArvoreBinaria<T> pai = null;
        boolean filhoEsquerda = false;

        while (p != null && p.getInfo() != valor) {
            pai = p;

            if (valor.compareTo(p.getInfo()) < 0) {
                filhoEsquerda = true;
                p = p.getEsquerda();
            } else {
                filhoEsquerda = false;
                p = p.getDireita();
            }
        }

        if (p.getEsquerda() == null && p.getDireita() == null) {

            if (p == this.getRaiz()) {
                this.setRaiz(null);
            } else if (filhoEsquerda) {
                pai.setEsquerda(null);
            } else {
                pai.setDireita(null);
            }

        } else if (p.getDireita() == null) {

            if (p == getRaiz()) {
                setRaiz(p.getEsquerda());
            } else if (filhoEsquerda) {
                pai.setEsquerda(p.getEsquerda());
            } else {
                pai.setDireita(p.getEsquerda());
            }


        } else if (p.getEsquerda() == null) {

            if (p == getRaiz()) {
                setRaiz(p.getDireita());
            } else if (filhoEsquerda) {
                pai.setEsquerda(p.getDireita());
            } else {
                pai.setDireita(p.getDireita());
            }


        } else {

            NoArvoreBinaria<T> sucessor = extrairSucessor(p);

            if (p == getRaiz()) {
                setRaiz(sucessor);
            } else if (filhoEsquerda) {
                pai.setEsquerda(sucessor);
            } else {
                pai.setDireita(sucessor);
            }

            sucessor.setEsquerda(p.getEsquerda());
        }

    }

    private NoArvoreBinaria<T> extrairSucessor(NoArvoreBinaria<T> p) {

        NoArvoreBinaria<T> atual = p.getDireita();
        NoArvoreBinaria<T> paiSucessor = p;
        NoArvoreBinaria<T> sucessor = p;

        while (atual != null) {
            paiSucessor = sucessor;
            sucessor = atual;
            atual = atual.getEsquerda();
        }

        if (sucessor != p.getDireita()) {

            paiSucessor.setEsquerda(sucessor.getDireita());
            sucessor.setDireita(p.getDireita());
        }

        return sucessor;
    }
}

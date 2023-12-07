/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.listaduplamenteencadeada;

/**
 *
 * @author Usuario
 */
public class FuncLista {
    Celula primeira;
    Celula ultima;
    int qtdElementos = 0;
    
    void addInicio(Object num){
        if(this.qtdElementos == 0){
            Celula nova = new Celula(num);
            this.primeira = nova;
            this.ultima = nova;
            this.qtdElementos++;
        }else{
            Celula nova = new Celula(this.primeira, num);
             this.primeira.setAnterior(nova);
             this.primeira = nova;
             this.qtdElementos++;
        }
    }
    
    void addFinal(Object num){
        if(this.qtdElementos == 0){
            addInicio(num);
        }else{
            Celula nova = new Celula(num);
            
            this.ultima.setProxima(nova);
            nova.setAnterior(this.ultima);
            this.ultima = nova;
            this.qtdElementos++;
        }
    }
    
    void addMeio(Celula pos, Object num){
        Celula ant = pos;
        Celula prox = pos.getProxima();
            
        Celula nova = new Celula(ant.getProxima(),num);
        nova.setAnterior(ant);
        ant.setProxima(nova);
        prox.setAnterior(nova);
        this.qtdElementos++;
    }
    
    void removePrimosInicio(Celula pos){
        this.primeira.anterior = null;
        this.primeira = this.primeira.getProxima();
        
        this.qtdElementos--;
    }
    
    void removePrimosFinal(Celula pos){
        Celula penultima = this.ultima.getAnterior();
        penultima.setProxima(null);
        this.ultima = penultima;
        
        this.qtdElementos--;
    }
    
    void removePrimosMeio(Celula pos){
        Celula ant = pos.getAnterior();
        Celula prox = pos.getProxima();
        
        ant.setProxima(prox);
        prox.setAnterior(ant);
        
        this.qtdElementos--;
    }
        
    
    Celula buscaPosicao(Object num) {
        Celula atual = this.primeira;
        Celula prox = atual.getProxima();
        Celula posicao = null;

        while(posicao == null){
            Object validaAtual = atual.Numero;
            Object ValidaProx = prox.Numero;
            if (validaAtual instanceof Number && num instanceof Number && ValidaProx instanceof Number){
                Number numAtual = (Number) validaAtual;
                Number numVal = (Number) num;
                Number numprox = (Number) ValidaProx;
                
                if (numAtual.doubleValue() <= numVal.doubleValue() && numprox.doubleValue() >= numVal.doubleValue()) {
                    posicao = atual;
                }else{
                    atual = prox;
                    prox = prox.getProxima();
                }
            }
        }
        return(posicao);
    }
    
    int buscarValor(Celula pos){
        Celula atual = pos;
        int valor = 0;
        Object validaAtual = atual.Numero;
        if (validaAtual instanceof Integer) {
            valor = (int) validaAtual;
        }
        return(valor);
    }
    
    Boolean validarPrimos(int valor){
        
        for(int i = 2; i < valor; i++){
            if (valor % i == 0){
                return false;  }
        }
        return(true);
    }
    
    void ExcluirPrimos(){
        Celula atual = this.primeira;
        for(int i=0; i<this.qtdElementos; i++){
            int valor = buscarValor(atual);
            if(validarPrimos(valor)){
                System.out.println("Primo: "+atual.getNumero());
            }
            else{
                System.out.println("Não Primo: "+atual.getNumero());
            }
            atual = atual.getProxima();
        }
    }
    
    void imprimirLista(){
        System.out.print("Números = [");
        Celula atual = this.primeira;
        for(int i=0; i<this.qtdElementos; i++){
             if(i==0){
                 System.out.print(atual.getNumero());
             }
             else{
                 System.out.print(", "+atual.getNumero());
             }
             atual = atual.getProxima();
        }
        System.out.print("]");
    }
}

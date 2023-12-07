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
            Celula nova = new Celula(num); //cria uma nova célula e insere o dado na célula
                                                //como a célula será inserida ao final da lista, não há próximo elemento
            this.ultima.setProxima(nova);   //Configura o novo final da lista, o próximo a partir da referência ultimo para a nova célula
            nova.setAnterior(this.ultima);  //configura a referência anterior da nova célula para aonde ultima está apontando
            this.ultima = nova; //atualiza o final da lista, ultima passa a apontar para a nova célula
            this.qtdElementos++;
        }
    }
    
    void addMeio(int pos, Object num){
        if(pos==0){
            this.addInicio(num);
            
        }else if(pos==this.qtdElementos){
            this.addFinal(num);
            
        }else{
            Celula ant = this.buscaCelula(pos-1);
            Celula prox = ant.getProxima();
            
            Celula nova = new Celula(ant.getProxima(),num);
            nova.setAnterior(ant);
            ant.setProxima(nova);
            prox.setAnterior(nova);
            this.qtdElementos++;
        }
    }
    
    boolean contem(Object num){
        Celula atual = this.primeira;
        while(atual!=null){
            if(atual.getNumero().equals(num)){
                
                return(true);
            }
            atual = atual.getProxima();
        }
        return(false);
    }
    
    Celula buscaCelula(int pos){
        if(!this.posicaoOcupada(pos)){
           System.out.println("Erro: posição não existe");
           return null;
        }else{
            Celula atual = this.primeira;
            for(int i=0;i<pos;i++){
                atual = atual.getProxima();
            }
            return(atual);
        } 
        
    }
    
    Object busca(int pos){
        return(this.buscaCelula(pos).getNumero());
        
    }
    
    boolean posicaoOcupada(int pos){
        return((pos>=0)&&(pos<this.qtdElementos));
        
    }
}

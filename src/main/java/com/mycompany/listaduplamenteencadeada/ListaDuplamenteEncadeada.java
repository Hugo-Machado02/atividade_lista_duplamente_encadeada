/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.listaduplamenteencadeada;

/**
 *
 * @author Usuario
 */
public class ListaDuplamenteEncadeada {

    public static void main(String[] args) {
        FuncLista fl = new FuncLista();
        int numeros[] = new int[1000];
        int i, num_min = -9999, num_max = 9999;
        int num_maior = -9999, num_menor = 9999;
        
        for(i = 0; i< 1000; i++){
            numeros[i] = (int)(Math.random() * (num_max - num_min + 1) + num_min);
        }
        for(i = 0; i< 1000; i++){
            System.out.println("Números: "+numeros[i]);
        }
        for(i = 0; i< 1000; i++){
            if(num_maior <= numeros[i]){
                fl.addFinal(numeros[i]);
                num_maior = numeros[i];
            }
            
            else if(num_menor >= numeros[i]){
                fl.addInicio(numeros[i]);
                num_menor = numeros[i];
            }
            
            else{
                fl.addMeio(fl.buscaPosicao(numeros[i]), numeros[i]);
            }
        }
        fl.imprimirLista();
        System.out.println("============================= VALIDAR PRIMOS =============================");
    }
}

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
        int numeros[] = new int[20];
        int i, num_min = -9999, num_max = 9999;
        
        for(i = 0; i< 20; i++){
            numeros[i] = (int)(Math.random() * (num_max - num_min + 1) + num_min);
        }
        for(i = 0; i< 20; i++){
            System.out.println("Número["+i+"]: "+numeros[i]);
        }
    }
}

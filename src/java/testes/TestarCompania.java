/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package testes;

import modelo.Compania;

public class TestarCompania {
    
    public static void main(String[] args) {
        System.out.println("Teste de pessoa");
        Compania p = new Compania("12345678910", "João da Silva", 
                "josilva@gmail.com", "47 9 92332 3332");
        System.out.print(p);        
    }
}
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package testes;

import dao.CompaniaDAO;
import modelo.Compania;

/**
 *
 * @author friend
 */
public class TestarCompaniaDAO {

    CompaniaDAO pdao = new CompaniaDAO();
    
    public void listarCompanias(){
        System.out.println("Lista de pessoas:");
        for (Compania p : pdao.retornarCompanias(100, 1)){
            System.out.println(p);
        }        
        System.out.println("Fim da lista de pessoas");
    }
    public static void main(String[] args) {
        TestarCompaniaDAO teste = new TestarCompaniaDAO();
        
        System.out.println("* Listar pessoas");
        teste.listarCompanias();
        
        System.out.println("* Incluir pessoa");
        System.out.println(teste.pdao.incluirCompania(new Compania("12345678910", "João da Silva", 
                "josilva@gmail.com", "47 9 92332 3332")));
        teste.listarCompanias();
        
        System.out.println("* Alterar pessoa");
        Compania alguem = teste.pdao.buscarCompania(1234567910);
        alguem.setSite("alterado@gmail.com");
        System.out.println(teste.pdao.atualizarCompania(alguem));
        teste.listarCompanias();        
        
        System.out.println("* Remover pessoa");
        System.out.println(teste.pdao.removerCompania(1234567910));
        teste.listarCompanias();       
        
        System.out.println("FIM DOS TESTES");
    }
}

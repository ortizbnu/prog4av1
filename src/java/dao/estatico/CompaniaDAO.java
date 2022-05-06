package dao.estatico;

import dao.CompaniaDAOInterface;
import java.util.ArrayList;
import modelo.Compania;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

public class CompaniaDAO implements CompaniaDAOInterface{

    @Override
    public ArrayList<Compania> retornarCompanias(int tamanhoPagina, int pagina) {
        ArrayList<Compania> retorno = new ArrayList<Compania>();
        retorno.add(new Compania("12345678910", "João da Silva", 
                "josilva@gmail.com", "47 9 92332 3332"));
        return retorno;
    }

    @Override
    public boolean incluirCompania(Compania nova) {
        return true;
    }

    @Override
    public boolean removerCompania(int id) {
        return true;
    }
    
    @Override
    public Compania buscarCompania(int id) {
        return new Compania("12345678910", "João da Silva", 
                "josilva@gmail.com", "47 9 92332 3332");
    } 
    
    @Override
    public boolean atualizarCompania(Compania novosDados) {
        return true;
    }

    @Override
    public int retornarNumeroTotalCompanias() {
        return 0;
    }

}
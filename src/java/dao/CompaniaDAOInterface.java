/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao;

import java.util.ArrayList;
import modelo.Compania;

public interface CompaniaDAOInterface {    
    public ArrayList<Compania> retornarCompanias(int tamanhoPagina, int pagina);	
    public int retornarNumeroTotalCompanias();
    public boolean incluirCompania(Compania nova);	
    public boolean removerCompania(int id);	   
    public Compania buscarCompania(int id);
    public boolean atualizarCompania(Compania novosDados);
}

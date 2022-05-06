/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao.memoria;

/**
 *
 * @author friend
 */
import dao.CompaniaDAOInterface;
import java.util.ArrayList;
import modelo.Compania;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.HashSet;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CompaniaDAO implements CompaniaDAOInterface {

    //public static final String URL = "jdbc:sqlite:D:\\Trabalho\\IFC\\PROG4\\dw2ed\\bd\\java\\sqlite\\companies_1000.db";
    
    public static final String URL = "jdbc:sqlite:C:\\Users\\ortiz\\Downloads\\companies.db";
    private ArrayList<Compania> pessoas = new ArrayList();

    @Override
    public ArrayList<Compania> retornarCompanias(int tamanhoPagina, int pagina) {
        int registroPagina = 1;
        
        if (pagina > 1) registroPagina = (pagina-1) * tamanhoPagina;
        
        pessoas = new ArrayList<Compania>();
        Connection con;
        Statement st;
        ResultSet result;
        try {
            try {
                Class.forName("org.sqlite.JDBC");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(CompaniaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            con = DriverManager.getConnection(URL);
            st = con.createStatement();
            System.out.println("PAssou aqui conexao");
            result = st.executeQuery("select * from compania LIMIT " + tamanhoPagina + " OFFSET " + registroPagina);
            System.out.println("PAssou aqui query");
            while (result.next()) {
                System.out.println("Carregando lista");
                Compania novaCompania = new Compania();
                int j=1;
                novaCompania.setId(result.getInt(j++));
                novaCompania.setNome(result.getString(j++));
                novaCompania.setSite(result.getString(j++));
                novaCompania.setFundacao(result.getInt(j++));
                novaCompania.setRamo(result.getString(j++));
                novaCompania.setTamanhoEstimado(result.getString(j++));
                novaCompania.setEndereco(result.getString(j++));
                novaCompania.setPais(result.getString(j++));
                novaCompania.setLinkedin(result.getString(j++));
                novaCompania.setEmpregosDiretos(result.getInt(j++));
                novaCompania.setEmpregosIndiretos(result.getInt(j++));
                
                
                /*novaCompania.setNome(result.getString(j++));
                novaCompania.setTelefone(result.getString(j++));*/
                pessoas.add(novaCompania);
                /*for (int i = 1; i <= 11; i++) {
                    System.out.print(result.getString(i) + " | ");
                }
                System.out.println("");*/
            }
        } catch (SQLException ex) {
            System.out.print("Erro no SQL: " + ex.getMessage());
        }
        
        return pessoas;
    }
    
    
    @Override
    public int retornarNumeroTotalCompanias() {
        int retorno = 0;
        Connection con;
        Statement st;
        ResultSet result;
        try {
            try {
                Class.forName("org.sqlite.JDBC");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(CompaniaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            con = DriverManager.getConnection(URL);
            st = con.createStatement();
            result = st.executeQuery("select count(*) as total from compania");
            while (result.next()) {
                
                retorno = result.getInt(1);
            }
        } catch (SQLException ex) {
            System.out.print("Erro no SQL: " + ex.getMessage());
        }
        
        return retorno;
    }

    @Override
    public boolean incluirCompania(Compania nova) {
        try {
            pessoas.add(nova);
            return true;
        } catch (Exception e) {
            System.out.println("depuração: " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean removerCompania(int id) {
        Connection con;
        Statement st;
        try {
            try {
                Class.forName("org.sqlite.JDBC");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(CompaniaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            con = DriverManager.getConnection(URL);
            System.out.println("removendo entidade compania "+ id);
            
            PreparedStatement pstmt = con.prepareStatement("DELETE FROM compania WHERE id = ?");
            
            // set the corresponding param
            pstmt.setInt(1, id);
            // execute the delete statement
            pstmt.executeUpdate();

            System.out.println("Executou Comando exclusao compania =" + id);

            return true;
        } catch (SQLException ex) {
            
            System.out.print("Erro no SQL de DELETE: " + ex.getMessage());
            return false;
        }
            
    }

    @Override
    public Compania buscarCompania(int id) {
        try {
            for (int i = 0; i < pessoas.size(); i++) { // percorrer a lista 
                if (pessoas.get(i).getId()== id) { // achou?
                    return pessoas.get(i);
                }
            }
            return null;
        } catch (Exception e) {
            System.out.println("depuração: " + e.getMessage());
            return null;
        }
    }

    @Override
    public boolean atualizarCompania(Compania novosDados) {
        try {
            int encontrado = -1; // variável para sinalizar sucesso da busca
            for (int i = 0; i < pessoas.size(); i++) { // percorrer a lista 
                if (pessoas.get(i).getId() == novosDados.getId()) { // achou?
                    encontrado = i; // sinaliza a posição da pessoa encontrada
                    break; // interrompe a busca
                }
            }
            if (encontrado >= 0) { // se achou...
                pessoas.set(encontrado, novosDados); // atualiza a pessoa
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            System.out.println("depuração: " + e.getMessage());
            return false;
        }
    }
}

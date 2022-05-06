package modelo;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author friend
 */
public class Compania {
    

    
    
    private int id;
    private String nome;
    private String site;
    private int fundacao;
    private String ramo;
    private String tamanhoEstimado;
    private String endereco;
    private String pais;
    private String linkedin;
    private int empregosDiretos;
    private int empregosIndiretos;

    public Compania(String cpf, String nome, String email, String telefone) {
        this.ramo = cpf;
        this.nome = nome;
        this.site = email;
        this.tamanhoEstimado = telefone;
    }

    public Compania() {        
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String email) {
        this.site = email;
    }
    public int getFundacao() {
        return fundacao;
    }

    public void setFundacao(int fundacao) {
        this.fundacao = fundacao;
    }
    
    public String getRamo() {
        return ramo;
    }

    public void setRamo(String cpf) {
        this.ramo = cpf;
    }
    
    public String getTamanhoEstimado() {
        return tamanhoEstimado;
    }

    public void setTamanhoEstimado(String telefone) {
        this.tamanhoEstimado = telefone;
    }
    
    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    
    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }
    
    public String getLinkedin() {
        return linkedin;
    }

    public void setLinkedin(String linkedin) {
        this.linkedin = linkedin;
    }

    public int getEmpregosDiretos() {
        return empregosDiretos;
    }

    public void setEmpregosDiretos(int empregosDiretos) {
        this.empregosDiretos = empregosDiretos;
    }
    
    public int getEmpregosIndiretos() {
        return empregosIndiretos;
    }

    public void setEmpregosIndiretos(int empregosIndiretos) {
        this.empregosIndiretos  = empregosIndiretos;
    }

    @Override
    public String toString() {
        return "Compania{Id=" + id + ", nome=" + nome + 
                ", Ramo=" + ramo + ", site=" + site + ", tamanho=" + tamanhoEstimado + '}';
    }
    
    
    
}

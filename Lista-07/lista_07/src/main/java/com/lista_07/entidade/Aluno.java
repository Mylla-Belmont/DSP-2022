package com.lista_07.entidade;

public class Aluno {
    private int id;
    private String cpf;
    private String matricula;
    private String nome;
    private String email;
    private String telefone;

    public void setId(int id) {
        this.id = id;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public int getId() {
        return id;
    }

    public String getCpf() {
        return cpf;
    }

    public String getMatricula() {
        return matricula;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefone() {
        return telefone;
    }
   
    public String toString() {
        return "Aluno [id: " + id + ", cpf: " + cpf + ", matricula: " + matricula + ", nome: " + nome + ", email: " + email
                + ", telefone: " + telefone + "]";
    }
}
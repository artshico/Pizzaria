package Model;

import java.util.Date;

public class CadastroModel {

    private String NomeCompleto;
    private String Endereco;
    private double Telefone;
    private double CPF;

    public String getNomeCompleto() {
        return NomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        NomeCompleto = nomeCompleto;
    }

    public String getEndereco() {
        return Endereco;
    }

    public void setEndereco(String endereco) {
        Endereco = endereco;
    }

    public Double getTelefone() {
        return Telefone;
    }

    public void setTelefone(double telefone) {
        Telefone = telefone;
    }

    public Double getCPF() {
        return CPF;
    }

    public void setCPF(double CPF) {
        this.CPF = CPF;
    }
}

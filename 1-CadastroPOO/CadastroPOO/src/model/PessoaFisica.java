package model;

public class PessoaFisica extends Pessoa { 
    private String cpf;
    private int idade;

    public PessoaFisica() {
        super(0, "");
    }

    public PessoaFisica(int id, String nome, String cpf, int idade) {
        super(id, nome);
        this.cpf = cpf;
        this.idade = idade;
    }

    public String getCpf() {
        return cpf;
    }

    public int getIdade() {
        return idade;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Override
    public void exibir() {
        System.out.println("CPF: " + cpf);
        System.out.println("idade: " + idade);
    }
}

package model;
import java.io.Serializable;

/**
 *
 * @author fernando
 */
public class PessoaFisica extends Pessoa implements Serializable{

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
    
    public void setIdade(int idade) {
        this.idade = idade;
    }
    @Override
    public void exibir() {
        System.out.println("CPF: " + cpf);
        System.out.println("idade: " + idade);
    }
}

package cadastropoo;

import model.PessoaFisica;
import model.PessoaFisicaRepo;
import model.PessoaJuridica;
import model.PessoaJuridicaRepo;
import java.io.IOException;
import java.util.List;

public class CadastroPOO {

    public static void main(String[] args) {

        //PESSOA FISICA
        PessoaFisicaRepo repo1 = new PessoaFisicaRepo();
        PessoaFisica pessoa1 = new PessoaFisica(1, "Marcos", "25896314700", 21);
        PessoaFisica pessoa2 = new PessoaFisica(2, "Gustavo", "75395147050", 34);

        repo1.inserir(pessoa1);
        repo1.inserir(pessoa2);

        String pessoas_fisicas = "pessoas_fisicas.dat";
        try {
            repo1.persistir(pessoas_fisicas);
            System.out.println("Dados de Pessoa Fisica Armazenados!" + pessoas_fisicas);
        } catch (IOException e) {
            System.out.println("Erro ao armazenar os dados: " + e.getMessage());
        }

        PessoaFisicaRepo repo2 = new PessoaFisicaRepo();

        try {
            repo2.recuperar(pessoas_fisicas);
            System.out.println("Dados de Pessoa Fisica Recuperados!" + pessoas_fisicas);
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Erro ao recuperar os dados: " + e.getMessage());
        }

        List<PessoaFisica> cadastrosFis = repo2.obterTodos();
        for (PessoaFisica pessoaFis : cadastrosFis) {
            System.out.println("ID: " + pessoaFis.getId());
            System.out.println("Nome: " + pessoaFis.getNome());
            System.out.println("CPF: " + pessoaFis.getCpf());
            System.out.println("Idade: " + pessoaFis.getIdade());
            System.out.println();
        }

        //PESSOA JURIDICA
        PessoaJuridicaRepo repo3 = new PessoaJuridicaRepo();
        PessoaJuridica pessoajuridica1 = new PessoaJuridica(1, "Lavanderia Super", "258963147000188");
        PessoaJuridica pessoajuridica2 = new PessoaJuridica(2, "Padaria PaoBao", "7539514705000155");

        repo3.inserir(pessoajuridica1);
        repo3.inserir(pessoajuridica2);

        String pessoa_juridica = "pessoa_juridica.dat"; 
        try {
            repo3.persistir(pessoa_juridica);
            System.out.println("Dados de Pessoa Juridica Armazenados!" + pessoa_juridica);
        } catch (IOException e) {
            System.out.println("Erro ao armazenar os dados: " + e.getMessage());
        }

        PessoaJuridicaRepo repo4 = new PessoaJuridicaRepo();

        try {
            repo4.recuperar(pessoa_juridica);
            System.out.println("Dados de Pessoa Juridica Recuperados!" + pessoa_juridica);
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Erro ao recuperar os dados: " + e.getMessage());
        }

        List<PessoaJuridica> cadastrosJur = repo4.obterTodos();
        for (PessoaJuridica pessoaJur : cadastrosJur) {
            System.out.println("ID: " + pessoaJur.getId());
            System.out.println("Nome: " + pessoaJur.getNome());
            System.out.println("CNPJ: " + pessoaJur.getCnpj());
            System.out.println();
        }
    }
}
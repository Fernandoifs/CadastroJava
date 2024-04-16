package model;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class PessoaFisicaRepo {

    private List<PessoaFisica> listaPessoas;

    public PessoaFisicaRepo() {
        listaPessoas = new ArrayList<>();
    }

    public void inserir(PessoaFisica pessoa) {
        listaPessoas.add(pessoa);
    }

    public void alterar(int id, PessoaFisica pessoaAtualizada) {
        for (int i = 0; i < listaPessoas.size(); i++) {
            if (listaPessoas.get(i).getId() == id) {
                listaPessoas.set(i, pessoaAtualizada);
                break;
            }
        }
    }

    public void excluir(int id) {
        Iterator<PessoaFisica> iterator = listaPessoas.iterator();
        while (iterator.hasNext()) {
            PessoaFisica pessoa = iterator.next();
            if (pessoa.getId() == id) {
                iterator.remove();
                break;
            }
        }
    }

    public PessoaFisica obter(int id) {
        for (PessoaFisica pessoa : listaPessoas) {
            if (pessoa.getId() == id) {
                return pessoa;
            }
        }
        return null;
    }

    public List<PessoaFisica> obterTodos() {
        return new ArrayList<>(listaPessoas);
    }

    public void persistir(String arquivo) throws IOException {
        try (FileOutputStream fileOut = new FileOutputStream(arquivo);
                ObjectOutputStream objectOut = new ObjectOutputStream(fileOut)) {
            objectOut.writeObject(listaPessoas);

        } catch (IOException e) {
            throw e;
        }
    }

    public void recuperar(String arquivo) throws IOException, ClassNotFoundException {
        try (FileInputStream fileIn = new FileInputStream(arquivo);
                ObjectInputStream objectIn = new ObjectInputStream(fileIn)) {
            listaPessoas = (List<PessoaFisica>) objectIn.readObject();

        } catch (IOException | ClassNotFoundException e) {
            throw e;
        }
    }
}

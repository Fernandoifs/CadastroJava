package model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class PessoaJuridicaRepo {

    private List<PessoaJuridica> listaPessoaJuridica;

    public PessoaJuridicaRepo() {
        listaPessoaJuridica = new ArrayList<>();
    }

    public void inserir(PessoaJuridica pessoa) {
        listaPessoaJuridica.add(pessoa);
    }

    public void alterar(int id, PessoaJuridica pessoaJuridicaAtualizada) {
        for (int i = 0; i < listaPessoaJuridica.size(); i++) {
            if (listaPessoaJuridica.get(i).getId() == id) {
                listaPessoaJuridica.set(i, pessoaJuridicaAtualizada);
                break;
            }
        }
    }

    public void excluir(int id) {
        Iterator<PessoaJuridica> iterator = listaPessoaJuridica.iterator();
        while (iterator.hasNext()) {
            PessoaJuridica pessoa = iterator.next();
            if (pessoa.getId() == id) {
                iterator.remove();
                break;
            }
        }
    }

    public PessoaJuridica obter(int id) {
        for (PessoaJuridica pessoa : listaPessoaJuridica) {
            if (pessoa.getId() == id) {
                return pessoa;
            }
        }
        return null;
    }

    public List<PessoaJuridica> obterTodos() {
        return new ArrayList<>(listaPessoaJuridica);
    }

    public void persistir(String arquivo) throws IOException {
        try (FileOutputStream fileOut = new FileOutputStream(arquivo);
                ObjectOutputStream objectOut = new ObjectOutputStream(fileOut)) {
            objectOut.writeObject(listaPessoaJuridica);

        } catch (IOException e) {
            throw e;
        }
    }

    public void recuperar(String arquivo) throws IOException, ClassNotFoundException {
        try (FileInputStream fileIn = new FileInputStream(arquivo);
                ObjectInputStream objectIn = new ObjectInputStream(fileIn)) {
            listaPessoaJuridica = (List<PessoaJuridica>) objectIn.readObject();

        } catch (IOException | ClassNotFoundException e) {
            throw e;
        }
    }
}

package model;
import java.io.Serializable;
/**
 *
 * @author fernando
 */
public class Pessoa implements Serializable{
    private int id;
    private String nome;
    
    //construtor
    public Pessoa(int id, String nome){
    this.id = id;
    this.nome = nome;
}
    
    public void exibir() {
        System.out.println("ID: " + id);
        System.out.println("Nome: " + nome);             
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

}
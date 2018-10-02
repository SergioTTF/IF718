package models.controladores;

import models.entidades.Livro;
import models.repositorios.CadastroLivro;

import java.util.List;

public class ControladorLivro {
    private CadastroLivro cadastroLivro;

    public ControladorLivro() {
        cadastroLivro = new CadastroLivro();
    }

    public void incluirLivro(Livro livro) {
        cadastroLivro.inserir(livro);
    }

    public Livro buscarLivro(long id) {
        return cadastroLivro.getLivro(id);
    }

    public List<Livro> listLivros() {
        return cadastroLivro.getLivros();
    }
}

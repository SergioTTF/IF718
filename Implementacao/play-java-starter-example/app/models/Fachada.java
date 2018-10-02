package models;

import models.controladores.ControladorCarrinho;
import models.controladores.ControladorLivro;
import models.entidades.Livro;

import java.util.List;

public class Fachada {
    private ControladorLivro controladorLivro;
    private ControladorCarrinho controladorCarrinho;
    private static Fachada instancia;

    private Fachada() {
        controladorLivro = new ControladorLivro();
        controladorCarrinho = new ControladorCarrinho();
    }

    public static Fachada getInstance() {
        if(instancia == null) {
            instancia = new Fachada();
        }
        return instancia;
    }

    public void incluirLivro(Livro livro) {
        controladorLivro.incluirLivro(livro);
    }

    public Livro buscarLivro(long id) {
        return controladorLivro.buscarLivro(id);
    }

    public List<Livro> listLivros() {
        return controladorLivro.listLivros();
    }

    public void addLivroCarrinho(Livro livro) {
        controladorCarrinho.addLivroCarrinho(livro);
    }

    public float getValorCarrinho() {
        return controladorCarrinho.atualizarValorCarrinho();
    }
}

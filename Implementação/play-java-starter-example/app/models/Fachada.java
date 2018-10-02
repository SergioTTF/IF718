package models;

import models.controladores.ControladorLivro;
import models.entidades.Livro;

import java.util.List;

public class Fachada {
    private ControladorLivro controladorLivro;
    private static Fachada instancia;

    private Fachada() {
        controladorLivro = new ControladorLivro();
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
}

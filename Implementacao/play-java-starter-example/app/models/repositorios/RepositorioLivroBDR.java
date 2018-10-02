package models.repositorios;

import io.ebean.Finder;
import models.entidades.Livro;

import java.awt.*;
import java.util.List;

public class RepositorioLivroBDR implements IRepositorioLivro {

    public Finder<Long, Livro> livrosFinder;

    public RepositorioLivroBDR() {
        livrosFinder = new Finder<Long, Livro>(Livro.class);
    }
    @Override
    public List<Livro> livroList() {
        return livrosFinder.all();
    }

    @Override
    public void addLivro(Livro livro) {
        livro.save();
    }

    @Override
    public void removeLivro(long idLivro) {
        livrosFinder.ref(idLivro).delete();
    }

    @Override
    public Livro getLivro(long idLivro) {
        return livrosFinder.byId(idLivro);
    }
}

package models.repositorios;

import models.entidades.Livro;
import java.util.List;

public interface IRepositorioLivro {
    public List<Livro> livroList();
    public void addLivro(Livro livro);
    public void removeLivro(long idLivro);
    public Livro getLivro(long idLivro);
}
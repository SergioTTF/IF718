package models.entidades;

import java.util.Set;

public class Carrinho {
    private Set<Livro> livros;
    private Cupom cupom;

    public Carrinho(Set<Livro> livros, Cupom cupom) {
        this.livros = livros;
        this.cupom = cupom;
    }

    public float getValorTotal() {
        float value = 0;
        for(Livro l : this.livros) {
            value += l.getPreco();
        }
        return value;
    }

    public Set<Livro> getLivros() {
        return livros;
    }

    public void setLivros(Set<Livro> livros) {
        this.livros = livros;
    }

    public Cupom getCupom() {
        return cupom;
    }

    public void setCupom(Cupom cupom) {
        this.cupom = cupom;
    }
}
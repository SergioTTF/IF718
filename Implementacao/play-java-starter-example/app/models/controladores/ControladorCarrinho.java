package models.controladores;

import models.entidades.Carrinho;
import models.entidades.Livro;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class ControladorCarrinho {

    private Carrinho carrinho;

    public ControladorCarrinho() {
        this.carrinho = new Carrinho(new HashSet<>());
    }

    public void addLivroCarrinho(Livro livro) {
        this.carrinho.getLivros().add(livro);
    }

    public float atualizarValorCarrinho() {
        return carrinho.getValorTotal();
    }
}

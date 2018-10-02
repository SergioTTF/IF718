package models.repositorios;

import io.ebean.Finder;
import models.entidades.Livro;

import java.sql.*;
import java.util.List;


public class CadastroLivro {
//    private String url = "jdbc:postgresql:postgres";
//    private String user = "postgres";
//    private String password = "123456";
    public IRepositorioLivro repLivro;

    public CadastroLivro() {
        repLivro = new RepositorioLivroBDR();
    }

//    public static void main(String[] args){
//        new CadastroLivro().inserir(new Livro(1, "Harry Potter e a pedra do dale dale", "Eu", "Ela", "Facista", 35, "Dale que dale dale"));
//    }

    public void inserir(Livro livro){
        repLivro.addLivro(livro);
//        try {
//            Connection con = DriverManager.getConnection(url, user, password);
//            String sql = "INSERT INTO librarium.livro (titulo, autor, editora, genero, preco, descricao) VALUES (?,?,?,?,?,?)";
//            PreparedStatement ps = con.prepareStatement(sql);
//            ps.setString(1, livro.getTitulo());
//            ps.setString(2, livro.getAutor());
//            ps.setString(3, livro.getEditora());
//            ps.setString(4, livro.getGenero());
//            ps.setFloat(5, livro.getPreco());
//            ps.setString(6, livro.getDescricao());
//            ps.execute();
//            con.close();
//        } catch (Exception e){
//            e.printStackTrace();
//        }
    }

    public void alterar(){}

    public void remover(long id){
        if(repLivro.getLivro(id) != null)
            repLivro.removeLivro(id);
    }

    public List<Livro> getLivros() {
        return repLivro.livroList();
    }

    public Livro getLivro(long id) {
        return repLivro.getLivro(id);
    }

//    public String getUrl() {
//        return url;
//    }
//
//    public void setUrl(String url) {
//        this.url = url;
//    }
//
//    public String getUser() {
//        return user;
//    }
//
//    public void setUser(String user) {
//        this.user = user;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }

}

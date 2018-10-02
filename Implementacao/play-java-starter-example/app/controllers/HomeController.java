package controllers;

import models.Fachada;
import models.entidades.Carrinho;
import models.entidades.Livro;
import play.data.Form;
import play.data.FormFactory;
import play.mvc.*;

import views.html.*;

import java.util.List;
import java.util.Map;

/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
public class HomeController extends Controller {

    static Fachada fachada = Fachada.getInstance();
    private static long cont = 0;

    /**
     * An action that renders an HTML page with a welcome message.
     * The configuration in the <code>routes</code> file means that
     * this method will be called when the application receives a
     * <code>GET</code> request with a path of <code>/</code>.
     */
    public Result index() {
        List<Livro> livros = fachada.listLivros();
        return ok(index.render(livros, fachada.getValorCarrinho()));
    }
    public Result addLivroG() {
        return ok(livro.render("Cadastro de Livro"));
    }

    public Result addLivro() {
        final Map<String, String[]> values = request().body().asFormUrlEncoded();
        Livro livro = new Livro(values.get("titulo")[0], values.get("autor")[0],
                values.get("editora")[0], values.get("genero")[0], Float.parseFloat(values.get("preco")[0]), values.get("descricao")[0]);
        fachada.incluirLivro(livro);
        return redirect(routes.HomeController.index());
    }

}

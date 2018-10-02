package controllers;

import models.Fachada;
import models.entidades.Livro;
import play.mvc.*;

import views.html.*;

import java.util.Map;

/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
public class VitrineController extends Controller {
    static Fachada fachada = Fachada.getInstance();

    /**
     * An action that renders an HTML page with a welcome message.
     * The configuration in the <code>routes</code> file means that
     * this method will be called when the application receives a
     * <code>GET</code> request with a path of <code>/</code>.
     */

    public Result addLivro() {
        final Map<String, String[]> values = request().body().asFormUrlEncoded();
        fachada.addLivroCarrinho(fachada.buscarLivro(Long.parseLong( values.get("id_livro")[0])));
        return redirect(routes.HomeController.index());
    }

}

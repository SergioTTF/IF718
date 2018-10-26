
package views.html

import _root_.play.twirl.api.TwirlFeatureImports._
import _root_.play.twirl.api.TwirlHelperImports._
import _root_.play.twirl.api.Html
import _root_.play.twirl.api.JavaScript
import _root_.play.twirl.api.Txt
import _root_.play.twirl.api.Xml
import models._
import controllers._
import play.api.i18n._
import views.html._
import play.api.templates.PlayMagic._
import java.lang._
import java.util._
import scala.collection.JavaConverters._
import play.core.j.PlayMagicForJava._
import play.mvc._
import play.api.data.Field
import play.mvc.Http.Context.Implicit._
import play.data._
import play.core.j.PlayFormsMagicForJava._
/*1.2*/import helper._

object livro extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template1[String,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*2.2*/(title: String):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*2.17*/("""

"""),_display_(/*4.2*/form(CSRF(routes.HomeController.addLivro()))/*4.46*/ {_display_(Seq[Any](format.raw/*4.48*/("""
"""),format.raw/*5.1*/("""<!DOCTYPE html>
    <html>
        <head>
            <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
            <title>"""),_display_(/*9.21*/title),format.raw/*9.26*/("""</title>
        </head>
        <body>
            <div class="col-md-2 col-md-offset-5">
                <h2>Cadastrar Livro</h2>
                <form method="post" action="/addLivro">
                    <div class="form-group">
                        <label for="titulo">Título</label>
                        <input type="text" class="form-control" name="titulo">
                    </div>
                    <div class="form-group">
                        <label for="autor">Autor</label>
                        <input type="text" class="form-control" name="autor">
                    </div>
                    <div class="form-group">
                        <label for="genero">Gênero</label>
                        <input type="text" class="form-control" name="genero">
                    </div>
                    <div class="form-group">
                        <label for="preco">Preço</label>
                        <input type="text" class="form-control" name="preco">
                    </div>
                    <div class="form-group">
                        <label for="descricao">Descrição</label>
                        <input type="text" class="form-control" name="descricao">
                    </div>
                    <div class="form-group">
                        <label for="editora">Editora</label>
                        <input type="text" class="form-control" name="editora">
                    </div>
                    <button type="submit" class="btn btn-primary">Submeter</button>
                </form>
            </div>
        </body>
    </html>
""")))}))
      }
    }
  }

  def render(title:String): play.twirl.api.HtmlFormat.Appendable = apply(title)

  def f:((String) => play.twirl.api.HtmlFormat.Appendable) = (title) => apply(title)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Tue Oct 02 07:36:16 BRT 2018
                  SOURCE: /Users/SergioTorres/Documents/IF718/Implementacao/play-java-starter-example/app/views/livro.scala.html
                  HASH: 0f9960c67b5ba72be66e15f3f0d921c04c9d96a8
                  MATRIX: 651->1|971->19|1081->34|1111->39|1163->83|1202->85|1230->87|1546->377|1571->382
                  LINES: 24->1|29->2|34->2|36->4|36->4|36->4|37->5|41->9|41->9
                  -- GENERATED --
              */
          
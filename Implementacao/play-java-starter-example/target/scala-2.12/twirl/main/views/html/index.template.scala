
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
/*5.2*/import helper._

object index extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template2[List[models.entidades.Livro],Float,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*6.2*/(livros: List[models.entidades.Livro], valorCarrinho: Float):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*7.1*/("""
"""),format.raw/*8.1*/("""<!DOCTYPE html>
<html>
    <head>
        <style type="text/css">
		.tituloLivro: """),format.raw/*12.17*/("""{"""),format.raw/*12.18*/("""
            """),format.raw/*13.13*/("""margin-left: 40px
        """),format.raw/*14.9*/("""}"""),format.raw/*14.10*/(""",
        .livroContainer: """),format.raw/*15.26*/("""{"""),format.raw/*15.27*/("""
            """),format.raw/*16.13*/("""border: 2px solid red;
            border-radius: 5px;
            border-width: 5px;
        """),format.raw/*19.9*/("""}"""),format.raw/*19.10*/(""",
        .titleText: """),format.raw/*20.21*/("""{"""),format.raw/*20.22*/("""
            """),format.raw/*21.13*/("""margin-left: 30px;
            margin-bottom: 30px;
        """),format.raw/*23.9*/("""}"""),format.raw/*23.10*/(""",

	</style>

        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">


        <title>Vitrine</title>

    </head>
    <body>
        <div class="row" style="margin-left: 20px; margin-bottom: 30px; margin-top: 10px;">
            <a href="/addLivro">Adicionar Livro</a>
            <h3 class="col-xs-8" style="margin-right: 80px;">
			Vitrine! Escolhas seus livros:
            </h3>

            <i class="fa fa-shopping-cart" style="font-size: 2em; color: lightgreen; margin: 5px;"></i>
            <p style="color: lightgreen; font-size: 1.5em; margin: 5px;">

"""),_display_(/*44.2*/valorCarrinho),format.raw/*44.15*/("""
            """),format.raw/*45.13*/("""</p>
        </div>

        <hr>

        <div style="margin-left: 40px">

            """),_display_(/*52.14*/for(livro <- livros) yield /*52.34*/ {_display_(Seq[Any](format.raw/*52.36*/("""
                """),_display_(/*53.18*/form(CSRF(routes.VitrineController.addLivro()))/*53.65*/ {_display_(Seq[Any](format.raw/*53.67*/("""
                    """),format.raw/*54.21*/("""<form method="post" action="/addLivroCarrinho">
                        <div class="row" style="margin-left: 10px;">
                            <div class="col-xs-6">
                                """),_display_(/*57.34*/livro/*57.39*/.getTitulo()),format.raw/*57.51*/("""
                            """),format.raw/*58.29*/("""</div>

                            <div class="col-xs-6">
                                """),_display_(/*61.34*/livro/*61.39*/.getDescricao()),format.raw/*61.54*/("""
                            """),format.raw/*62.29*/("""</div>

                            <div class="col-xs-6">
                                Autor: """),_display_(/*65.41*/livro/*65.46*/.getAutor()),format.raw/*65.57*/("""
                            """),format.raw/*66.29*/("""</div>

                            <div class="col-xs-6">
                                Editora: """),_display_(/*69.43*/livro/*69.48*/.getEditora()),format.raw/*69.61*/("""
                            """),format.raw/*70.29*/("""</div>

                            <h4 style="color: lightgreen;
                                margin-left: 20px;">
                                R$ """),_display_(/*74.37*/livro/*74.42*/.getPreco()),format.raw/*74.53*/("""
                            """),format.raw/*75.29*/("""</h4>

                            <input type="hidden" name="id_livro" value=""""),_display_(/*77.74*/livro/*77.79*/.getId()),format.raw/*77.87*/("""">

                            <button class="col-xs-6" style="margin-left: 20px" type="submit">
                                Adicionar ao Carrinho!</button>
                        </div>

                        <hr>
                    </form>
                """)))}),format.raw/*85.18*/("""
            """)))}),format.raw/*86.14*/("""
        """),format.raw/*87.9*/("""</div>

    </body>
</html>
"""))
      }
    }
  }

  def render(livros:List[models.entidades.Livro],valorCarrinho:Float): play.twirl.api.HtmlFormat.Appendable = apply(livros,valorCarrinho)

  def f:((List[models.entidades.Livro],Float) => play.twirl.api.HtmlFormat.Appendable) = (livros,valorCarrinho) => apply(livros,valorCarrinho)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Tue Oct 02 06:54:03 BRT 2018
                  SOURCE: C:/Users/arthu/Desktop/play-java-starter-example/app/views/index.scala.html
                  HASH: 001cc428f6bc01ffd83aad9d2363df6f683001d8
                  MATRIX: 651->95|999->112|1153->173|1180->174|1290->256|1319->257|1360->270|1413->296|1442->297|1497->324|1526->325|1567->338|1688->432|1717->433|1767->455|1796->456|1837->469|1924->529|1953->530|2831->1382|2865->1395|2906->1408|3022->1497|3058->1517|3098->1519|3143->1537|3199->1584|3239->1586|3288->1607|3516->1808|3530->1813|3563->1825|3620->1854|3739->1946|3753->1951|3789->1966|3846->1995|3972->2094|3986->2099|4018->2110|4075->2139|4203->2240|4217->2245|4251->2258|4308->2287|4490->2442|4504->2447|4536->2458|4593->2487|4700->2567|4714->2572|4743->2580|5042->2848|5087->2862|5123->2871
                  LINES: 24->5|29->6|34->7|35->8|39->12|39->12|40->13|41->14|41->14|42->15|42->15|43->16|46->19|46->19|47->20|47->20|48->21|50->23|50->23|71->44|71->44|72->45|79->52|79->52|79->52|80->53|80->53|80->53|81->54|84->57|84->57|84->57|85->58|88->61|88->61|88->61|89->62|92->65|92->65|92->65|93->66|96->69|96->69|96->69|97->70|101->74|101->74|101->74|102->75|104->77|104->77|104->77|112->85|113->86|114->87
                  -- GENERATED --
              */
          
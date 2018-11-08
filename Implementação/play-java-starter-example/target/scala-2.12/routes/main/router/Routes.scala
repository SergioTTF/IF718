// @GENERATOR:play-routes-compiler
// @SOURCE:C:/Users/arthu/Desktop/play-java-starter-example/conf/routes
// @DATE:Tue Oct 02 03:26:05 BRT 2018

package router

import play.core.routing._
import play.core.routing.HandlerInvokerFactory._

import play.api.mvc._

import _root_.controllers.Assets.Asset
import _root_.play.libs.F

class Routes(
  override val errorHandler: play.api.http.HttpErrorHandler, 
  // @LINE:6
  HomeController_1: controllers.HomeController,
  // @LINE:10
  VitrineController_4: controllers.VitrineController,
  // @LINE:12
  CountController_0: controllers.CountController,
  // @LINE:14
  AsyncController_2: controllers.AsyncController,
  // @LINE:17
  Assets_3: controllers.Assets,
  val prefix: String
) extends GeneratedRouter {

   @javax.inject.Inject()
   def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:6
    HomeController_1: controllers.HomeController,
    // @LINE:10
    VitrineController_4: controllers.VitrineController,
    // @LINE:12
    CountController_0: controllers.CountController,
    // @LINE:14
    AsyncController_2: controllers.AsyncController,
    // @LINE:17
    Assets_3: controllers.Assets
  ) = this(errorHandler, HomeController_1, VitrineController_4, CountController_0, AsyncController_2, Assets_3, "/")

  def withPrefix(prefix: String): Routes = {
    router.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, HomeController_1, VitrineController_4, CountController_0, AsyncController_2, Assets_3, prefix)
  }

  private[this] val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation = List(
    ("""GET""", this.prefix, """controllers.HomeController.index"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """livros""", """controllers.HomeController.getLivros"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """addLivro""", """controllers.HomeController.addLivroG"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """addLivro""", """controllers.HomeController.addLivro"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """carrinho""", """controllers.VitrineController.viewCarrinho"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """count""", """controllers.CountController.count"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """message""", """controllers.AsyncController.message"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """assets/""" + "$" + """file<.+>""", """controllers.Assets.versioned(path:String = "/public", file:Asset)"""),
    Nil
  ).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
    case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
    case l => s ++ l.asInstanceOf[List[(String,String,String)]]
  }}


  // @LINE:6
  private[this] lazy val controllers_HomeController_index0_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix)))
  )
  private[this] lazy val controllers_HomeController_index0_invoker = createInvoker(
    HomeController_1.index,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "index",
      Nil,
      "GET",
      this.prefix + """""",
      """ An example controller showing a sample home page""",
      Seq()
    )
  )

  // @LINE:7
  private[this] lazy val controllers_HomeController_getLivros1_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("livros")))
  )
  private[this] lazy val controllers_HomeController_getLivros1_invoker = createInvoker(
    HomeController_1.getLivros,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "getLivros",
      Nil,
      "GET",
      this.prefix + """livros""",
      """""",
      Seq()
    )
  )

  // @LINE:8
  private[this] lazy val controllers_HomeController_addLivroG2_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("addLivro")))
  )
  private[this] lazy val controllers_HomeController_addLivroG2_invoker = createInvoker(
    HomeController_1.addLivroG,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "addLivroG",
      Nil,
      "GET",
      this.prefix + """addLivro""",
      """""",
      Seq()
    )
  )

  // @LINE:9
  private[this] lazy val controllers_HomeController_addLivro3_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("addLivro")))
  )
  private[this] lazy val controllers_HomeController_addLivro3_invoker = createInvoker(
    HomeController_1.addLivro,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "addLivro",
      Nil,
      "POST",
      this.prefix + """addLivro""",
      """""",
      Seq()
    )
  )

  // @LINE:10
  private[this] lazy val controllers_VitrineController_viewCarrinho4_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("carrinho")))
  )
  private[this] lazy val controllers_VitrineController_viewCarrinho4_invoker = createInvoker(
    VitrineController_4.viewCarrinho,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.VitrineController",
      "viewCarrinho",
      Nil,
      "GET",
      this.prefix + """carrinho""",
      """""",
      Seq()
    )
  )

  // @LINE:12
  private[this] lazy val controllers_CountController_count5_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("count")))
  )
  private[this] lazy val controllers_CountController_count5_invoker = createInvoker(
    CountController_0.count,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.CountController",
      "count",
      Nil,
      "GET",
      this.prefix + """count""",
      """ An example controller showing how to use dependency injection""",
      Seq()
    )
  )

  // @LINE:14
  private[this] lazy val controllers_AsyncController_message6_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("message")))
  )
  private[this] lazy val controllers_AsyncController_message6_invoker = createInvoker(
    AsyncController_2.message,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.AsyncController",
      "message",
      Nil,
      "GET",
      this.prefix + """message""",
      """ An example controller showing how to write asynchronous code""",
      Seq()
    )
  )

  // @LINE:17
  private[this] lazy val controllers_Assets_versioned7_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("assets/"), DynamicPart("file", """.+""",false)))
  )
  private[this] lazy val controllers_Assets_versioned7_invoker = createInvoker(
    Assets_3.versioned(fakeValue[String], fakeValue[Asset]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Assets",
      "versioned",
      Seq(classOf[String], classOf[Asset]),
      "GET",
      this.prefix + """assets/""" + "$" + """file<.+>""",
      """ Map static resources from the /public folder to the /assets URL path""",
      Seq()
    )
  )


  def routes: PartialFunction[RequestHeader, Handler] = {
  
    // @LINE:6
    case controllers_HomeController_index0_route(params@_) =>
      call { 
        controllers_HomeController_index0_invoker.call(HomeController_1.index)
      }
  
    // @LINE:7
    case controllers_HomeController_getLivros1_route(params@_) =>
      call { 
        controllers_HomeController_getLivros1_invoker.call(HomeController_1.getLivros)
      }
  
    // @LINE:8
    case controllers_HomeController_addLivroG2_route(params@_) =>
      call { 
        controllers_HomeController_addLivroG2_invoker.call(HomeController_1.addLivroG)
      }
  
    // @LINE:9
    case controllers_HomeController_addLivro3_route(params@_) =>
      call { 
        controllers_HomeController_addLivro3_invoker.call(HomeController_1.addLivro)
      }
  
    // @LINE:10
    case controllers_VitrineController_viewCarrinho4_route(params@_) =>
      call { 
        controllers_VitrineController_viewCarrinho4_invoker.call(VitrineController_4.viewCarrinho)
      }
  
    // @LINE:12
    case controllers_CountController_count5_route(params@_) =>
      call { 
        controllers_CountController_count5_invoker.call(CountController_0.count)
      }
  
    // @LINE:14
    case controllers_AsyncController_message6_route(params@_) =>
      call { 
        controllers_AsyncController_message6_invoker.call(AsyncController_2.message)
      }
  
    // @LINE:17
    case controllers_Assets_versioned7_route(params@_) =>
      call(Param[String]("path", Right("/public")), params.fromPath[Asset]("file", None)) { (path, file) =>
        controllers_Assets_versioned7_invoker.call(Assets_3.versioned(path, file))
      }
  }
}

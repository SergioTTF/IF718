// @GENERATOR:play-routes-compiler
// @SOURCE:C:/Users/arthu/Desktop/play-java-starter-example/conf/routes
// @DATE:Tue Oct 02 05:41:28 BRT 2018


package router {
  object RoutesPrefix {
    private var _prefix: String = "/"
    def setPrefix(p: String): Unit = {
      _prefix = p
    }
    def prefix: String = _prefix
    val byNamePrefix: Function0[String] = { () => prefix }
  }
}

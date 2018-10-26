// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/SergioTorres/Documents/IF718/Implementacao/play-java-starter-example/conf/routes
// @DATE:Tue Oct 02 07:36:15 BRT 2018


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

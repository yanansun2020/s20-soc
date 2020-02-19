// @GENERATOR:play-routes-compiler
// @SOURCE:F:/Documents/a-cmu/18655 SOC/Lab-4-Ebean/Lab-4-Ebean/Frontend/conf/routes
// @DATE:Tue Feb 18 15:12:24 PST 2020


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

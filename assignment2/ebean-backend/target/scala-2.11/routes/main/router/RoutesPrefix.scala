
// @GENERATOR:play-routes-compiler
// @SOURCE:F:/Documents/a-cmu/18655 SOC/18655_Yanan Sun_lab2/assignment2-source code/ebean-backend/conf/routes
// @DATE:Tue Feb 18 16:58:48 PST 2020


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

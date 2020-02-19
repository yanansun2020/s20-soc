// @GENERATOR:play-routes-compiler
// @SOURCE:F:/Documents/a-cmu/18655 SOC/Lab-4-Ebean/Lab-4-Ebean/Frontend/conf/routes
// @DATE:Tue Feb 18 15:12:24 PST 2020

import play.api.routing.JavaScriptReverseRoute


import _root_.controllers.Assets.Asset
import _root_.play.libs.F

// @LINE:7
package controllers.javascript {

  // @LINE:7
  class ReverseHomeController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:12
    def signupHandler: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.signupHandler",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "register"})
        }
      """
    )
  
    // @LINE:10
    def signup: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.signup",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "signup"})
        }
      """
    )
  
    // @LINE:7
    def index: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.index",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + """"})
        }
      """
    )
  
    // @LINE:8
    def loginHandler: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.loginHandler",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "login"})
        }
      """
    )
  
  }

  // @LINE:34
  class ReverseAssets(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:34
    def at: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Assets.at",
      """
        function(file1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "assets/" + (""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("file", file1)})
        }
      """
    )
  
  }

  // @LINE:14
  class ReversePubController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:16
    def pubbytitle: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.PubController.pubbytitle",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "pubbytitle"})
        }
      """
    )
  
    // @LINE:22
    def pubbyresearchyear: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.PubController.pubbyresearchyear",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "pubbyresearchyear"})
        }
      """
    )
  
    // @LINE:29
    def greatCoAuthors: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.PubController.greatCoAuthors",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "authorgreatco"})
        }
      """
    )
  
    // @LINE:20
    def alltitle: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.PubController.alltitle",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "alltitle"})
        }
      """
    )
  
    // @LINE:14
    def coAuthor: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.PubController.coAuthor",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "coauthor"})
        }
      """
    )
  
    // @LINE:24
    def greatAuthors: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.PubController.greatAuthors",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "greatauthor"})
        }
      """
    )
  
    // @LINE:18
    def pubbyyear: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.PubController.pubbyyear",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "pubbyyear"})
        }
      """
    )
  
    // @LINE:32
    def altLot: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.PubController.altLot",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "altlot"})
        }
      """
    )
  
    // @LINE:26
    def pubByResearcherAndYear: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.PubController.pubByResearcherAndYear",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "pubbynameyear"})
        }
      """
    )
  
  }


}

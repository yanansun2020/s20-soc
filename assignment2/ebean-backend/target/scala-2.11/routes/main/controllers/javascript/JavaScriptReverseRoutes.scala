
// @GENERATOR:play-routes-compiler
// @SOURCE:F:/Documents/a-cmu/18655 SOC/18655_Yanan Sun_lab2/assignment2-source code/ebean-backend/conf/routes
// @DATE:Tue Feb 18 16:58:48 PST 2020

import play.api.routing.JavaScriptReverseRoute
import play.api.mvc.{ QueryStringBindable, PathBindable, Call, JavascriptLiteral }
import play.core.routing.{ HandlerDef, ReverseRouteContext, queryString, dynamicString }


import _root_.controllers.Assets.Asset
import _root_.play.libs.F

// @LINE:6
package controllers.javascript {
  import ReverseRouteContext.empty

  // @LINE:6
  class ReverseHomeController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:14
    def getByVolumeAndNumber: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.getByVolumeAndNumber",
      """
        function(journal0,volume1,number2) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "pubbyyear" + _qS([(""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("journal", journal0), (""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("volume", volume1), (""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("number", number2)])})
        }
      """
    )
  
    // @LINE:20
    def getAuthors: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.getAuthors",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "authorsgreat"})
        }
      """
    )
  
    // @LINE:25
    def getCoAuthorsOfProductiveAuthors: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.getCoAuthorsOfProductiveAuthors",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "greatcoauthor"})
        }
      """
    )
  
    // @LINE:12
    def publicationsByTitle: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.publicationsByTitle",
      """
        function(title0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "pubbytitle" + _qS([(""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("title", title0)])})
        }
      """
    )
  
    // @LINE:9
    def coAuthors: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.coAuthors",
      """
        function(author0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "coauthor" + _qS([(""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("author", author0)])})
        }
      """
    )
  
    // @LINE:16
    def getAllSOCArticleTitles: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.getAllSOCArticleTitles",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "alltitle"})
        }
      """
    )
  
    // @LINE:22
    def getPubByResearcherAndYear: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.getPubByResearcherAndYear",
      """
        function(researcher0,year1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "pubbyry" + _qS([(""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("researcher", researcher0), (""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("year", year1)])})
        }
      """
    )
  
    // @LINE:18
    def getByResearcherAndYear: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.getByResearcherAndYear",
      """
        function(researcher0,year1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "pubbyresearcher" + _qS([(""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("researcher", researcher0), (""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("year", year1)])})
        }
      """
    )
  
    // @LINE:27
    def getAltLot: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.getAltLot",
      """
        function(conferenceName0,startYear1,endYear2) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "getAltLot" + _qS([(""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("conferenceName", conferenceName0), (""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("startYear", startYear1), (""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("endYear", endYear2)])})
        }
      """
    )
  
    // @LINE:6
    def index: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.index",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + """"})
        }
      """
    )
  
  }

  // @LINE:30
  class ReverseUserController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:34
    def registerNew: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.UserController.registerNew",
      """
        function(username0) {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "signup" + _qS([(""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("username", username0)])})
        }
      """
    )
  
    // @LINE:30
    def authenticate: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.UserController.authenticate",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "login"})
        }
      """
    )
  
  }


}

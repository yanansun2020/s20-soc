// @GENERATOR:play-routes-compiler
// @SOURCE:F:/Documents/a-cmu/18655 SOC/Lab-4-Ebean/Lab-4-Ebean/Frontend/conf/routes
// @DATE:Tue Feb 18 15:12:24 PST 2020

import play.api.mvc.Call


import _root_.controllers.Assets.Asset
import _root_.play.libs.F

// @LINE:7
package controllers {

  // @LINE:7
  class ReverseHomeController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:12
    def signupHandler(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "register")
    }
  
    // @LINE:10
    def signup(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "signup")
    }
  
    // @LINE:7
    def index(): Call = {
      
      Call("GET", _prefix)
    }
  
    // @LINE:8
    def loginHandler(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "login")
    }
  
  }

  // @LINE:34
  class ReverseAssets(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:34
    def at(file:String): Call = {
      implicit lazy val _rrc = new play.core.routing.ReverseRouteContext(Map(("path", "/public"))); _rrc
      Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[play.api.mvc.PathBindable[String]].unbind("file", file))
    }
  
  }

  // @LINE:14
  class ReversePubController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:16
    def pubbytitle(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "pubbytitle")
    }
  
    // @LINE:22
    def pubbyresearchyear(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "pubbyresearchyear")
    }
  
    // @LINE:29
    def greatCoAuthors(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "authorgreatco")
    }
  
    // @LINE:20
    def alltitle(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "alltitle")
    }
  
    // @LINE:14
    def coAuthor(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "coauthor")
    }
  
    // @LINE:24
    def greatAuthors(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "greatauthor")
    }
  
    // @LINE:18
    def pubbyyear(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "pubbyyear")
    }
  
    // @LINE:32
    def altLot(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "altlot")
    }
  
    // @LINE:26
    def pubByResearcherAndYear(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "pubbynameyear")
    }
  
  }


}

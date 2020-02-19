
// @GENERATOR:play-routes-compiler
// @SOURCE:F:/Documents/a-cmu/18655 SOC/18655_Yanan Sun_lab2/assignment2-source code/ebean-backend/conf/routes
// @DATE:Tue Feb 18 16:58:48 PST 2020

import play.api.mvc.{ QueryStringBindable, PathBindable, Call, JavascriptLiteral }
import play.core.routing.{ HandlerDef, ReverseRouteContext, queryString, dynamicString }


import _root_.controllers.Assets.Asset
import _root_.play.libs.F

// @LINE:6
package controllers {

  // @LINE:6
  class ReverseHomeController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:14
    def getByVolumeAndNumber(journal:String, volume:String, number:String): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "pubbyyear" + queryString(List(Some(implicitly[QueryStringBindable[String]].unbind("journal", journal)), Some(implicitly[QueryStringBindable[String]].unbind("volume", volume)), Some(implicitly[QueryStringBindable[String]].unbind("number", number)))))
    }
  
    // @LINE:20
    def getAuthors(): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "authorsgreat")
    }
  
    // @LINE:25
    def getCoAuthorsOfProductiveAuthors(): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "greatcoauthor")
    }
  
    // @LINE:12
    def publicationsByTitle(title:String): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "pubbytitle" + queryString(List(Some(implicitly[QueryStringBindable[String]].unbind("title", title)))))
    }
  
    // @LINE:9
    def coAuthors(author:String): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "coauthor" + queryString(List(Some(implicitly[QueryStringBindable[String]].unbind("author", author)))))
    }
  
    // @LINE:16
    def getAllSOCArticleTitles(): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "alltitle")
    }
  
    // @LINE:22
    def getPubByResearcherAndYear(researcher:String, year:String): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "pubbyry" + queryString(List(Some(implicitly[QueryStringBindable[String]].unbind("researcher", researcher)), Some(implicitly[QueryStringBindable[String]].unbind("year", year)))))
    }
  
    // @LINE:18
    def getByResearcherAndYear(researcher:String, year:String): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "pubbyresearcher" + queryString(List(Some(implicitly[QueryStringBindable[String]].unbind("researcher", researcher)), Some(implicitly[QueryStringBindable[String]].unbind("year", year)))))
    }
  
    // @LINE:27
    def getAltLot(conferenceName:String, startYear:String, endYear:String): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "getAltLot" + queryString(List(Some(implicitly[QueryStringBindable[String]].unbind("conferenceName", conferenceName)), Some(implicitly[QueryStringBindable[String]].unbind("startYear", startYear)), Some(implicitly[QueryStringBindable[String]].unbind("endYear", endYear)))))
    }
  
    // @LINE:6
    def index(): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix)
    }
  
  }

  // @LINE:30
  class ReverseUserController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:34
    def registerNew(username:String): Call = {
      import ReverseRouteContext.empty
      Call("POST", _prefix + { _defaultPrefix } + "signup" + queryString(List(Some(implicitly[QueryStringBindable[String]].unbind("username", username)))))
    }
  
    // @LINE:30
    def authenticate(): Call = {
      import ReverseRouteContext.empty
      Call("POST", _prefix + { _defaultPrefix } + "login")
    }
  
  }


}

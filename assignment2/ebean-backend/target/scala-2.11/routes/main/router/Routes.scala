
// @GENERATOR:play-routes-compiler
// @SOURCE:F:/Documents/a-cmu/18655 SOC/18655_Yanan Sun_lab2/assignment2-source code/ebean-backend/conf/routes
// @DATE:Tue Feb 18 16:58:48 PST 2020

package router

import play.core.routing._
import play.core.routing.HandlerInvokerFactory._
import play.core.j._

import play.api.mvc._

import _root_.controllers.Assets.Asset
import _root_.play.libs.F

class Routes(
  override val errorHandler: play.api.http.HttpErrorHandler, 
  // @LINE:6
  HomeController_0: controllers.HomeController,
  // @LINE:30
  UserController_1: controllers.UserController,
  val prefix: String
) extends GeneratedRouter {

   @javax.inject.Inject()
   def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:6
    HomeController_0: controllers.HomeController,
    // @LINE:30
    UserController_1: controllers.UserController
  ) = this(errorHandler, HomeController_0, UserController_1, "/")

  import ReverseRouteContext.empty

  def withPrefix(prefix: String): Routes = {
    router.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, HomeController_0, UserController_1, prefix)
  }

  private[this] val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation = List(
    ("""GET""", this.prefix, """controllers.HomeController.index"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """coauthor""", """controllers.HomeController.coAuthors(author:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """pubbytitle""", """controllers.HomeController.publicationsByTitle(title:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """pubbyyear""", """controllers.HomeController.getByVolumeAndNumber(journal:String, volume:String, number:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """alltitle""", """controllers.HomeController.getAllSOCArticleTitles"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """pubbyresearcher""", """controllers.HomeController.getByResearcherAndYear(researcher:String, year:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """authorsgreat""", """controllers.HomeController.getAuthors"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """pubbyry""", """controllers.HomeController.getPubByResearcherAndYear(researcher:String, year:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """greatcoauthor""", """controllers.HomeController.getCoAuthorsOfProductiveAuthors"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """getAltLot""", """controllers.HomeController.getAltLot(conferenceName:String, startYear:String, endYear:String)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """login""", """controllers.UserController.authenticate()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """signup""", """controllers.UserController.registerNew(username:String)"""),
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
    HomeController_0.index,
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "index",
      Nil,
      "GET",
      """ An example controller showing a sample home page""",
      this.prefix + """"""
    )
  )

  // @LINE:9
  private[this] lazy val controllers_HomeController_coAuthors1_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("coauthor")))
  )
  private[this] lazy val controllers_HomeController_coAuthors1_invoker = createInvoker(
    HomeController_0.coAuthors(fakeValue[String]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "coAuthors",
      Seq(classOf[String]),
      "GET",
      """1.1 Given author name A, list all of her co-authors.""",
      this.prefix + """coauthor"""
    )
  )

  // @LINE:12
  private[this] lazy val controllers_HomeController_publicationsByTitle2_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("pubbytitle")))
  )
  private[this] lazy val controllers_HomeController_publicationsByTitle2_invoker = createInvoker(
    HomeController_0.publicationsByTitle(fakeValue[String]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "publicationsByTitle",
      Seq(classOf[String]),
      "GET",
      """1.2 Given a paper name (i.e., title), list its publication metadata.""",
      this.prefix + """pubbytitle"""
    )
  )

  // @LINE:14
  private[this] lazy val controllers_HomeController_getByVolumeAndNumber3_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("pubbyyear")))
  )
  private[this] lazy val controllers_HomeController_getByVolumeAndNumber3_invoker = createInvoker(
    HomeController_0.getByVolumeAndNumber(fakeValue[String], fakeValue[String], fakeValue[String]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "getByVolumeAndNumber",
      Seq(classOf[String], classOf[String], classOf[String]),
      "GET",
      """1.3 Given a journal name and a year (volume) and an issue (number),""",
      this.prefix + """pubbyyear"""
    )
  )

  // @LINE:16
  private[this] lazy val controllers_HomeController_getAllSOCArticleTitles4_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("alltitle")))
  )
  private[this] lazy val controllers_HomeController_getAllSOCArticleTitles4_invoker = createInvoker(
    HomeController_0.getAllSOCArticleTitles,
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "getAllSOCArticleTitles",
      Nil,
      "GET",
      """1.4 Display all the article titles published in the area of SOC;""",
      this.prefix + """alltitle"""
    )
  )

  // @LINE:18
  private[this] lazy val controllers_HomeController_getByResearcherAndYear5_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("pubbyresearcher")))
  )
  private[this] lazy val controllers_HomeController_getByResearcherAndYear5_invoker = createInvoker(
    HomeController_0.getByResearcherAndYear(fakeValue[String], fakeValue[String]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "getByResearcherAndYear",
      Seq(classOf[String], classOf[String]),
      "GET",
      """1.5 Display the titles of the articles published by a researcher in a specific year;""",
      this.prefix + """pubbyresearcher"""
    )
  )

  // @LINE:20
  private[this] lazy val controllers_HomeController_getAuthors6_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("authorsgreat")))
  )
  private[this] lazy val controllers_HomeController_getAuthors6_invoker = createInvoker(
    HomeController_0.getAuthors,
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "getAuthors",
      Nil,
      "GET",
      """1.6 Display all the authors who have published more than 10 papers in the area of SOC to date""",
      this.prefix + """authorsgreat"""
    )
  )

  // @LINE:22
  private[this] lazy val controllers_HomeController_getPubByResearcherAndYear7_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("pubbyry")))
  )
  private[this] lazy val controllers_HomeController_getPubByResearcherAndYear7_invoker = createInvoker(
    HomeController_0.getPubByResearcherAndYear(fakeValue[String], fakeValue[String]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "getPubByResearcherAndYear",
      Seq(classOf[String], classOf[String]),
      "GET",
      """2.1 Given a researcher's name and a year, list all published papers' metadata;""",
      this.prefix + """pubbyry"""
    )
  )

  // @LINE:25
  private[this] lazy val controllers_HomeController_getCoAuthorsOfProductiveAuthors8_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("greatcoauthor")))
  )
  private[this] lazy val controllers_HomeController_getCoAuthorsOfProductiveAuthors8_invoker = createInvoker(
    HomeController_0.getCoAuthorsOfProductiveAuthors,
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "getCoAuthorsOfProductiveAuthors",
      Nil,
      "GET",
      """2.2 For the productive authors (e.g., published more than 10 papers) in the area of SOC,
list all of their co-authors;""",
      this.prefix + """greatcoauthor"""
    )
  )

  // @LINE:27
  private[this] lazy val controllers_HomeController_getAltLot9_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getAltLot")))
  )
  private[this] lazy val controllers_HomeController_getAltLot9_invoker = createInvoker(
    HomeController_0.getAltLot(fakeValue[String], fakeValue[String], fakeValue[String]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "getAltLot",
      Seq(classOf[String], classOf[String], classOf[String]),
      "GET",
      """2.3 Given a conference name, and a range of years (between 2003-2019), mark the locations of where the conference was held in a map.""",
      this.prefix + """getAltLot"""
    )
  )

  // @LINE:30
  private[this] lazy val controllers_UserController_authenticate10_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("login")))
  )
  private[this] lazy val controllers_UserController_authenticate10_invoker = createInvoker(
    UserController_1.authenticate(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.UserController",
      "authenticate",
      Nil,
      "POST",
      """Login""",
      this.prefix + """login"""
    )
  )

  // @LINE:34
  private[this] lazy val controllers_UserController_registerNew11_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("signup")))
  )
  private[this] lazy val controllers_UserController_registerNew11_invoker = createInvoker(
    UserController_1.registerNew(fakeValue[String]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.UserController",
      "registerNew",
      Seq(classOf[String]),
      "POST",
      """ Add User  {"name":name, "password":password}""",
      this.prefix + """signup"""
    )
  )


  def routes: PartialFunction[RequestHeader, Handler] = {
  
    // @LINE:6
    case controllers_HomeController_index0_route(params) =>
      call { 
        controllers_HomeController_index0_invoker.call(HomeController_0.index)
      }
  
    // @LINE:9
    case controllers_HomeController_coAuthors1_route(params) =>
      call(params.fromQuery[String]("author", None)) { (author) =>
        controllers_HomeController_coAuthors1_invoker.call(HomeController_0.coAuthors(author))
      }
  
    // @LINE:12
    case controllers_HomeController_publicationsByTitle2_route(params) =>
      call(params.fromQuery[String]("title", None)) { (title) =>
        controllers_HomeController_publicationsByTitle2_invoker.call(HomeController_0.publicationsByTitle(title))
      }
  
    // @LINE:14
    case controllers_HomeController_getByVolumeAndNumber3_route(params) =>
      call(params.fromQuery[String]("journal", None), params.fromQuery[String]("volume", None), params.fromQuery[String]("number", None)) { (journal, volume, number) =>
        controllers_HomeController_getByVolumeAndNumber3_invoker.call(HomeController_0.getByVolumeAndNumber(journal, volume, number))
      }
  
    // @LINE:16
    case controllers_HomeController_getAllSOCArticleTitles4_route(params) =>
      call { 
        controllers_HomeController_getAllSOCArticleTitles4_invoker.call(HomeController_0.getAllSOCArticleTitles)
      }
  
    // @LINE:18
    case controllers_HomeController_getByResearcherAndYear5_route(params) =>
      call(params.fromQuery[String]("researcher", None), params.fromQuery[String]("year", None)) { (researcher, year) =>
        controllers_HomeController_getByResearcherAndYear5_invoker.call(HomeController_0.getByResearcherAndYear(researcher, year))
      }
  
    // @LINE:20
    case controllers_HomeController_getAuthors6_route(params) =>
      call { 
        controllers_HomeController_getAuthors6_invoker.call(HomeController_0.getAuthors)
      }
  
    // @LINE:22
    case controllers_HomeController_getPubByResearcherAndYear7_route(params) =>
      call(params.fromQuery[String]("researcher", None), params.fromQuery[String]("year", None)) { (researcher, year) =>
        controllers_HomeController_getPubByResearcherAndYear7_invoker.call(HomeController_0.getPubByResearcherAndYear(researcher, year))
      }
  
    // @LINE:25
    case controllers_HomeController_getCoAuthorsOfProductiveAuthors8_route(params) =>
      call { 
        controllers_HomeController_getCoAuthorsOfProductiveAuthors8_invoker.call(HomeController_0.getCoAuthorsOfProductiveAuthors)
      }
  
    // @LINE:27
    case controllers_HomeController_getAltLot9_route(params) =>
      call(params.fromQuery[String]("conferenceName", None), params.fromQuery[String]("startYear", None), params.fromQuery[String]("endYear", None)) { (conferenceName, startYear, endYear) =>
        controllers_HomeController_getAltLot9_invoker.call(HomeController_0.getAltLot(conferenceName, startYear, endYear))
      }
  
    // @LINE:30
    case controllers_UserController_authenticate10_route(params) =>
      call { 
        controllers_UserController_authenticate10_invoker.call(UserController_1.authenticate())
      }
  
    // @LINE:34
    case controllers_UserController_registerNew11_route(params) =>
      call(params.fromQuery[String]("username", None)) { (username) =>
        controllers_UserController_registerNew11_invoker.call(UserController_1.registerNew(username))
      }
  }
}

// @GENERATOR:play-routes-compiler
// @SOURCE:F:/Documents/a-cmu/18655 SOC/Lab-4-Ebean/Lab-4-Ebean/Frontend/conf/routes
// @DATE:Tue Feb 18 15:12:24 PST 2020

package router

import play.core.routing._
import play.core.routing.HandlerInvokerFactory._

import play.api.mvc._

import _root_.controllers.Assets.Asset
import _root_.play.libs.F

class Routes(
  override val errorHandler: play.api.http.HttpErrorHandler, 
  // @LINE:7
  HomeController_2: controllers.HomeController,
  // @LINE:14
  PubController_0: controllers.PubController,
  // @LINE:34
  Assets_1: controllers.Assets,
  val prefix: String
) extends GeneratedRouter {

   @javax.inject.Inject()
   def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:7
    HomeController_2: controllers.HomeController,
    // @LINE:14
    PubController_0: controllers.PubController,
    // @LINE:34
    Assets_1: controllers.Assets
  ) = this(errorHandler, HomeController_2, PubController_0, Assets_1, "/")

  def withPrefix(addPrefix: String): Routes = {
    val prefix = play.api.routing.Router.concatPrefix(addPrefix, this.prefix)
    router.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, HomeController_2, PubController_0, Assets_1, prefix)
  }

  private[this] val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation = List(
    ("""GET""", this.prefix, """controllers.HomeController.index()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """login""", """controllers.HomeController.loginHandler()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """signup""", """controllers.HomeController.signup()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """register""", """controllers.HomeController.signupHandler()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """coauthor""", """controllers.PubController.coAuthor()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """pubbytitle""", """controllers.PubController.pubbytitle()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """pubbyyear""", """controllers.PubController.pubbyyear()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """alltitle""", """controllers.PubController.alltitle()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """pubbyresearchyear""", """controllers.PubController.pubbyresearchyear()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """greatauthor""", """controllers.PubController.greatAuthors()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """pubbynameyear""", """controllers.PubController.pubByResearcherAndYear()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """authorgreatco""", """controllers.PubController.greatCoAuthors()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """altlot""", """controllers.PubController.altLot()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """assets/""" + "$" + """file<.+>""", """controllers.Assets.at(path:String = "/public", file:String)"""),
    Nil
  ).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
    case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
    case l => s ++ l.asInstanceOf[List[(String,String,String)]]
  }}


  // @LINE:7
  private[this] lazy val controllers_HomeController_index0_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix)))
  )
  private[this] lazy val controllers_HomeController_index0_invoker = createInvoker(
    HomeController_2.index(),
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

  // @LINE:8
  private[this] lazy val controllers_HomeController_loginHandler1_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("login")))
  )
  private[this] lazy val controllers_HomeController_loginHandler1_invoker = createInvoker(
    HomeController_2.loginHandler(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "loginHandler",
      Nil,
      "GET",
      this.prefix + """login""",
      """""",
      Seq()
    )
  )

  // @LINE:10
  private[this] lazy val controllers_HomeController_signup2_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("signup")))
  )
  private[this] lazy val controllers_HomeController_signup2_invoker = createInvoker(
    HomeController_2.signup(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "signup",
      Nil,
      "GET",
      this.prefix + """signup""",
      """""",
      Seq()
    )
  )

  // @LINE:12
  private[this] lazy val controllers_HomeController_signupHandler3_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("register")))
  )
  private[this] lazy val controllers_HomeController_signupHandler3_invoker = createInvoker(
    HomeController_2.signupHandler(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "signupHandler",
      Nil,
      "GET",
      this.prefix + """register""",
      """""",
      Seq()
    )
  )

  // @LINE:14
  private[this] lazy val controllers_PubController_coAuthor4_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("coauthor")))
  )
  private[this] lazy val controllers_PubController_coAuthor4_invoker = createInvoker(
    PubController_0.coAuthor(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.PubController",
      "coAuthor",
      Nil,
      "GET",
      this.prefix + """coauthor""",
      """1.1 Given author name A, list all of her co-authors.""",
      Seq()
    )
  )

  // @LINE:16
  private[this] lazy val controllers_PubController_pubbytitle5_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("pubbytitle")))
  )
  private[this] lazy val controllers_PubController_pubbytitle5_invoker = createInvoker(
    PubController_0.pubbytitle(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.PubController",
      "pubbytitle",
      Nil,
      "GET",
      this.prefix + """pubbytitle""",
      """1.2 Given a paper name (i.e., title), list its publication metadata.""",
      Seq()
    )
  )

  // @LINE:18
  private[this] lazy val controllers_PubController_pubbyyear6_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("pubbyyear")))
  )
  private[this] lazy val controllers_PubController_pubbyyear6_invoker = createInvoker(
    PubController_0.pubbyyear(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.PubController",
      "pubbyyear",
      Nil,
      "GET",
      this.prefix + """pubbyyear""",
      """1.3 Given a journal name and a year (volume) and an issue (number),""",
      Seq()
    )
  )

  // @LINE:20
  private[this] lazy val controllers_PubController_alltitle7_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("alltitle")))
  )
  private[this] lazy val controllers_PubController_alltitle7_invoker = createInvoker(
    PubController_0.alltitle(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.PubController",
      "alltitle",
      Nil,
      "GET",
      this.prefix + """alltitle""",
      """1.4 Display all the article titles published in the area of SOC;""",
      Seq()
    )
  )

  // @LINE:22
  private[this] lazy val controllers_PubController_pubbyresearchyear8_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("pubbyresearchyear")))
  )
  private[this] lazy val controllers_PubController_pubbyresearchyear8_invoker = createInvoker(
    PubController_0.pubbyresearchyear(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.PubController",
      "pubbyresearchyear",
      Nil,
      "GET",
      this.prefix + """pubbyresearchyear""",
      """1.5 Display the titles of the articles published by a researcher in a specific year;""",
      Seq()
    )
  )

  // @LINE:24
  private[this] lazy val controllers_PubController_greatAuthors9_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("greatauthor")))
  )
  private[this] lazy val controllers_PubController_greatAuthors9_invoker = createInvoker(
    PubController_0.greatAuthors(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.PubController",
      "greatAuthors",
      Nil,
      "GET",
      this.prefix + """greatauthor""",
      """1.6 Display all the authors who have published more than 10 papers in the area of SOC to date""",
      Seq()
    )
  )

  // @LINE:26
  private[this] lazy val controllers_PubController_pubByResearcherAndYear10_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("pubbynameyear")))
  )
  private[this] lazy val controllers_PubController_pubByResearcherAndYear10_invoker = createInvoker(
    PubController_0.pubByResearcherAndYear(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.PubController",
      "pubByResearcherAndYear",
      Nil,
      "GET",
      this.prefix + """pubbynameyear""",
      """2.1 Given a researcher's name and a year, list all published papers' metadata;""",
      Seq()
    )
  )

  // @LINE:29
  private[this] lazy val controllers_PubController_greatCoAuthors11_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("authorgreatco")))
  )
  private[this] lazy val controllers_PubController_greatCoAuthors11_invoker = createInvoker(
    PubController_0.greatCoAuthors(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.PubController",
      "greatCoAuthors",
      Nil,
      "GET",
      this.prefix + """authorgreatco""",
      """2.2  For the productive authors (e.g., published more than 10 papers)
#in the area of SOC, list all of their co-authors;""",
      Seq()
    )
  )

  // @LINE:32
  private[this] lazy val controllers_PubController_altLot12_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("altlot")))
  )
  private[this] lazy val controllers_PubController_altLot12_invoker = createInvoker(
    PubController_0.altLot(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.PubController",
      "altLot",
      Nil,
      "GET",
      this.prefix + """altlot""",
      """2.3 Given a conference name, and a range of years (between 2003-2019),
mark the locations of where the conference was held in a map.""",
      Seq()
    )
  )

  // @LINE:34
  private[this] lazy val controllers_Assets_at13_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("assets/"), DynamicPart("file", """.+""",false)))
  )
  private[this] lazy val controllers_Assets_at13_invoker = createInvoker(
    Assets_1.at(fakeValue[String], fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Assets",
      "at",
      Seq(classOf[String], classOf[String]),
      "GET",
      this.prefix + """assets/""" + "$" + """file<.+>""",
      """ Map static resources from the /public folder to the /assets URL path""",
      Seq()
    )
  )


  def routes: PartialFunction[RequestHeader, Handler] = {
  
    // @LINE:7
    case controllers_HomeController_index0_route(params@_) =>
      call { 
        controllers_HomeController_index0_invoker.call(HomeController_2.index())
      }
  
    // @LINE:8
    case controllers_HomeController_loginHandler1_route(params@_) =>
      call { 
        controllers_HomeController_loginHandler1_invoker.call(HomeController_2.loginHandler())
      }
  
    // @LINE:10
    case controllers_HomeController_signup2_route(params@_) =>
      call { 
        controllers_HomeController_signup2_invoker.call(HomeController_2.signup())
      }
  
    // @LINE:12
    case controllers_HomeController_signupHandler3_route(params@_) =>
      call { 
        controllers_HomeController_signupHandler3_invoker.call(HomeController_2.signupHandler())
      }
  
    // @LINE:14
    case controllers_PubController_coAuthor4_route(params@_) =>
      call { 
        controllers_PubController_coAuthor4_invoker.call(PubController_0.coAuthor())
      }
  
    // @LINE:16
    case controllers_PubController_pubbytitle5_route(params@_) =>
      call { 
        controllers_PubController_pubbytitle5_invoker.call(PubController_0.pubbytitle())
      }
  
    // @LINE:18
    case controllers_PubController_pubbyyear6_route(params@_) =>
      call { 
        controllers_PubController_pubbyyear6_invoker.call(PubController_0.pubbyyear())
      }
  
    // @LINE:20
    case controllers_PubController_alltitle7_route(params@_) =>
      call { 
        controllers_PubController_alltitle7_invoker.call(PubController_0.alltitle())
      }
  
    // @LINE:22
    case controllers_PubController_pubbyresearchyear8_route(params@_) =>
      call { 
        controllers_PubController_pubbyresearchyear8_invoker.call(PubController_0.pubbyresearchyear())
      }
  
    // @LINE:24
    case controllers_PubController_greatAuthors9_route(params@_) =>
      call { 
        controllers_PubController_greatAuthors9_invoker.call(PubController_0.greatAuthors())
      }
  
    // @LINE:26
    case controllers_PubController_pubByResearcherAndYear10_route(params@_) =>
      call { 
        controllers_PubController_pubByResearcherAndYear10_invoker.call(PubController_0.pubByResearcherAndYear())
      }
  
    // @LINE:29
    case controllers_PubController_greatCoAuthors11_route(params@_) =>
      call { 
        controllers_PubController_greatCoAuthors11_invoker.call(PubController_0.greatCoAuthors())
      }
  
    // @LINE:32
    case controllers_PubController_altLot12_route(params@_) =>
      call { 
        controllers_PubController_altLot12_invoker.call(PubController_0.altLot())
      }
  
    // @LINE:34
    case controllers_Assets_at13_route(params@_) =>
      call(Param[String]("path", Right("/public")), params.fromPath[String]("file", None)) { (path, file) =>
        controllers_Assets_at13_invoker.call(Assets_1.at(path, file))
      }
  }
}

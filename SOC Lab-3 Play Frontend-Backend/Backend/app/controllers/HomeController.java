package controllers;

import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;

/**
 * Software Service Market Place
 */
public class HomeController extends Controller {

    public Result index() {
        return ok(Json.toJson("Welcome to backend!"));
    }

}

package controllers;

import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;

/**
 * Software Service Market Place
 */
public class HomeController extends Controller {
    public Result home(){
        return ok(Json.toJson("welcome to backend"));
    }

    public Result getServiceCombine() {
        try {
            BestServiceFeature bestServiceFeature = CalculateServiceCluster.makeChangeForAmount(true);
            return ok(Json.toJson(bestServiceFeature));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ok(Json.toJson(new BestServiceFeature()));
    }

}

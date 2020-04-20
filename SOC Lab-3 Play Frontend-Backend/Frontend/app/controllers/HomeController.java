package controllers;

import com.google.gson.Gson;
import play.mvc.Controller;
import play.mvc.Result;
import utils.HttpResponse;
import utils.HttpUtil;

/**
 * Software Service Market Place
 */
public class HomeController extends Controller {

    private static final Gson gson = new Gson();
    /**
     * Index page
     */
    public Result index() {
        return ok(views.html.index.render());
    }


    /**
     * handle index
     */
    public Result getServicehandler() {
        String url = "/getsetvice";
        HttpResponse response = HttpUtil.makeRequest(url, "GET", null);
        if (response.getStatusCode() == 200) {
            String responseStr = response.getResponse();
            BestServiceFeature bestServiceFeature = gson.fromJson(responseStr, BestServiceFeature.class);
            return ok(views.html.service.render(bestServiceFeature));
        }
        return ok(views.html.index.render());
    }
}
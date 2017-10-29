package controllers;

import play.mvc.*;

import views.html.*;

import com.mongodb.*;
import com.mongodb.client.*;
import org.bson.Document;

public class AudaryController extends Controller {
    public Result index() {
        return ok(index.render());
    }

    public Result profs() {
        return ok(loggedin.render());
    }

    public Result curtis() {
        return ok(curtis.render());
    }

    public Result norman() {
        return ok(norman.render());
    }
}


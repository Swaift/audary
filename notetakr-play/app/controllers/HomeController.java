package controllers;

import play.mvc.*;

import views.html.*;

import com.mongodb.*;
import com.mongodb.client.*;
import org.bson.Document;

/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
public class HomeController extends Controller {

    /**
     * An action that renders an HTML page with a welcome message.
     * The configuration in the <code>routes</code> file means that
     * this method will be called when the application receives a
     * <code>GET</code> request with a path of <code>/</code>.
     */
    public Result index() {
        MongoClientURI connectionString = new MongoClientURI("mongodb://swaift:572sNC1WSeF4VpJxZpxv@notetakr-shard-00-00-uybf1.mongodb.net:27017,notetakr-shard-00-01-uybf1.mongodb.net:27017,notetakr-shard-00-02-uybf1.mongodb.net:27017/default?ssl=true&replicaSet=notetakr-shard-0&authSource=admin");
        MongoClient mongoClient = new MongoClient(connectionString);
        MongoDatabase database = mongoClient.getDatabase("default");
        MongoCollection<Document> collection = database.getCollection("users");
        Document myDoc = collection.find().first();
        System.out.println(myDoc.toJson());
        // return ok(index.render("Your new application is ready."));
        return ok(index.render(myDoc.get("name").toString()));
    }
}

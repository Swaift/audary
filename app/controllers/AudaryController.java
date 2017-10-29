package controllers;

import play.mvc.*;

import views.html.*;

import com.mongodb.*;
import com.mongodb.client.*;
import com.mongodb.client.model.*;
import static com.mongodb.client.model.Filters.*;
import org.bson.Document;
import java.util.*;
import org.bson.codecs.configuration.*;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;
import org.bson.codecs.pojo.*;
import models.*;
import play.data.*;


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

		public Result upload() {
			DynamicForm dynamicForm = Form.form().bindFromRequest();
			String file = dynamicForm.get("lecture");
			System.out.println(file);
			return ok("");
		}

    public Result newLecture(String lastName) {
        return ok(newLecture.render());
    }

    public Result prof(String lastName) {
        CodecRegistry pojoCodecRegistry = fromRegistries(MongoClient.getDefaultCodecRegistry(), fromProviders(PojoCodecProvider.builder().automatic(true).build()));
        MongoClientURI connectionString = new MongoClientURI("mongodb://swaift:572sNC1WSeF4VpJxZpxv@notetakr-shard-00-00-uybf1.mongodb.net:27017,notetakr-shard-00-01-uybf1.mongodb.net:27017,notetakr-shard-00-02-uybf1.mongodb.net:27017/default?ssl=true&replicaSet=notetakr-shard-0&authSource=admin");
        MongoClient mongoClient = new MongoClient(connectionString);
        MongoDatabase database = mongoClient.getDatabase("default");
        database = database.withCodecRegistry(pojoCodecRegistry);
        MongoCollection<Lecture> lectureCollection = database.getCollection("lectures", Lecture.class);
        List<Lecture> lectures = new ArrayList<Lecture>();
				Block<Lecture> lectureBlock = new Block<Lecture>() {
						@Override
						public void apply(final Lecture lecture) {
								System.out.println(lecture);
								lectures.add(lecture);
						}
				};
				lectureCollection.find().forEach(lectureBlock);

        MongoCollection<Professor> profCollection = database.getCollection("profs", Professor.class);
        Professor professor = profCollection.find(eq("lastName", lastName)).first();
        return ok(prof.render(professor, lectures));
    }

    public Result norman() {
        CodecRegistry pojoCodecRegistry = fromRegistries(MongoClient.getDefaultCodecRegistry(), fromProviders(PojoCodecProvider.builder().automatic(true).build()));
        MongoClientURI connectionString = new MongoClientURI("mongodb://swaift:572sNC1WSeF4VpJxZpxv@notetakr-shard-00-00-uybf1.mongodb.net:27017,notetakr-shard-00-01-uybf1.mongodb.net:27017,notetakr-shard-00-02-uybf1.mongodb.net:27017/default?ssl=true&replicaSet=notetakr-shard-0&authSource=admin");
        MongoClient mongoClient = new MongoClient(connectionString);
        MongoDatabase database = mongoClient.getDatabase("default");
        database = database.withCodecRegistry(pojoCodecRegistry);
        MongoCollection<Lecture> collection = database.getCollection("lectures", Lecture.class);
        List<Lecture> list = new ArrayList<Lecture>();
				Block<Lecture> lectureBlock = new Block<Lecture>() {
						@Override
						public void apply(final Lecture lecture) {
								System.out.println(lecture);
								list.add(lecture);
						}
				};

				collection.find().forEach(lectureBlock);

        return ok(norman.render(list));
    }
}

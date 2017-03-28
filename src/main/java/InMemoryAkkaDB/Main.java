package InMemoryAkkaDB;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;

/**
 * Created by ahmed on 28/03/17.
 */
public class Main {

    public static void main(String[] args) {
        ActorSystem actorSystem = ActorSystem.create("system");
        ActorRef db = actorSystem.actorOf(AkkaDbActor.props(), "AkkaDB");

 

    }
}

package Ch1;

import InMemoryAkkaDB.AkkaDbActor;
import InMemoryAkkaDB.messages.Set;
import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.testkit.TestActorRef;
import junit.framework.Assert;
import org.junit.Test;

/**
 * Created by ahmed on 22/03/17.
 */
public class MyAkkaDbTest {

    ActorSystem actorSystem = ActorSystem.create();

    @Test
    public void itShouldPlaceKeyValueFromMessageToMap(){
        TestActorRef<AkkaDbActor> testActorRef = TestActorRef.create(actorSystem, Props.create(AkkaDbActor.class));
        testActorRef.tell(new Set("Key","Value"), ActorRef.noSender());

        AkkaDbActor myAkkaDb =   testActorRef.underlyingActor();

        Assert.assertEquals(myAkkaDb.getMap().get("Key"),"Value");



    }



}

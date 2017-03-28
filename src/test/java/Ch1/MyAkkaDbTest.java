package Ch1;

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
        TestActorRef<MyAkkaDb> testActorRef = TestActorRef.create(actorSystem, Props.create(MyAkkaDb.class));
        testActorRef.tell(new SetRequest("Key","Value"), ActorRef.noSender());

        MyAkkaDb myAkkaDb =   testActorRef.underlyingActor();

        Assert.assertEquals(myAkkaDb.map.get("Key"),"Value");



    }



}

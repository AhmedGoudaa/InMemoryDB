package InMemoryAkkaDB;

import InMemoryAkkaDB.messages.Get;
import InMemoryAkkaDB.messages.NotFound;
import InMemoryAkkaDB.messages.Set;
import akka.actor.AbstractActor;
import akka.actor.Props;
import akka.actor.Status;
import akka.event.Logging;
import akka.event.LoggingAdapter;
import akka.japi.pf.ReceiveBuilder;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ahmed on 28/03/17.
 */
public class AkkaDbActor extends AbstractActor {


    private final LoggingAdapter loggingAdapter = Logging.getLogger(context().system(),this);

    protected final Map<String,Object> map = new HashMap<>();

    ///
    // define pattern matching for messages received and return PartialFunction<Object,BoxedUnit>

    {


        receive(
                     ReceiveBuilder
                                .match(Set.class,message->{

                                loggingAdapter.info("Set message recieved with key= "+message.key+" and value= "+message.value);
                                map.put(message.key,message.value);
                                sender().tell(new Status.Success(message.key),self());

                                })
                                .match(Get.class, message->{

                                    loggingAdapter.info("Get message recieved with key= "+message.key);
                                    Object value = map.get(message.key);
                                    Object response = (value ==null) ? new Status.Failure(new NotFound(message.key)): value;
                                    sender().tell(response,self());

                                })
                                .matchAny(o -> {

                                    loggingAdapter.info("Unknown message received from  "+sender().path().toString());
                                    sender().tell(new Status.Failure(new ClassNotFoundException()),self());


                                })
                                .build()

        );
    }


    public static Props props(){
        return Props.create(AkkaDbActor.class);
    }

    public Map<String,Object> getMap(){
        return map;

    }

}

package InMemoryAkkaDB.messages;

import java.io.Serializable;

/**
 * Created by ahmed on 28/03/17.
 */
public class NotFound extends Exception implements Serializable {

    public final String key;

    public NotFound(String key) {
        this.key = key;
    }
}

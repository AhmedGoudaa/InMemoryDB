package InMemoryAkkaDB.messages;

import java.io.Serializable;

/**
 * Created by ahmed on 28/03/17.
 */
public class Get implements Serializable {

    public final String key;

    public Get(String key) {
        this.key = key;
    }

}

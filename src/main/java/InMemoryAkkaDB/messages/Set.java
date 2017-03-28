package InMemoryAkkaDB.messages;

import java.io.Serializable;

/**
 * Created by ahmed on 28/03/17.
 */
public class Set  implements Serializable{

    public final String key;

    public final Object value;

    public Set(String key, Object value) {
        this.key = key;
        this.value = value;
    }

}

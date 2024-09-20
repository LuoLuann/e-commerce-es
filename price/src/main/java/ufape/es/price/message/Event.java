package ufape.es.price.message;

import lombok.Data;
import java.util.Date;

@Data
public class Event {

    public enum Type {
        CREATE, DELETE, UPDATE
    }

    private Type type;
    private Long key;
    private String data;
    private Date createdAt;

    public Event(Type eventType, Long key, String data) {
        this.type = eventType;
        this.key = key;
        this.data = data;
        this.createdAt = new Date();
    }
}

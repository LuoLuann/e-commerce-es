package ufape.es.core.event;

import java.time.LocalDateTime;
import java.util.UUID;

public abstract class BaseEvent {
    private final String eventId;
    private final LocalDateTime eventTimestamp;

    public BaseEvent() {
        this.eventId = UUID.randomUUID().toString();
        this.eventTimestamp = LocalDateTime.now();
    }

    public String getEventId() {
        return eventId;
    }

    public LocalDateTime getEventTimestamp() {
        return eventTimestamp;
    }
}

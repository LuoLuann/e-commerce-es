package ufape.es.core.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

@Component
public class Publisher {

    @Autowired
    private StreamBridge streamBridge;

    public void sendEvent() {
        Event<Integer, Long> evt = new Event<>(Event.Type.CREATE, 1, 2L);
        sendMessage("inventory-out-0", evt);
    }

    private void sendMessage(String bindingName, Event<Integer, Long> event) {
        Message<Event<Integer, Long>> message = MessageBuilder
                .withPayload(event)
                .setHeader("partitionKey", event.getKey())
                .build();
        streamBridge.send(bindingName, message);
    }
}

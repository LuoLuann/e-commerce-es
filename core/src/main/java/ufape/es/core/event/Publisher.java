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


    public void sendMessage(String bindingName, Event event) {
		Message message = MessageBuilder.withPayload(event)
				.build();
			streamBridge.send(bindingName, message);
	}
}

package ufape.es.catalog.message;

import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.function.StreamBridge;

@Component
public class Publisher {

	@Autowired
	private StreamBridge streamBridge;
	
	
	public void sendMessage(String bindingName, Event event) {
		Message message = MessageBuilder.withPayload(event)
                .setHeader("type", event.getType())
				.build();
			streamBridge.send(bindingName, message);
	}

}


package ufape.es.price.message;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import ufape.es.price.facade.Facade;
import ufape.es.price.model.Price;



import java.math.BigDecimal;
import java.util.function.Consumer;


@Configuration
public class MessageProcessor {
	@Autowired
	private Facade facade;
	
	@Bean
	public Consumer<Event> consumeMessage() { 
		return e -> {
			switch(e.getType()) {
				case CREATE:
					Price price = new Price();
					price.setProductId(e.getKey());
					price.setBasePrice(BigDecimal.valueOf(0));
					facade.createPrice(price);
					break;
				default:
					System.out.println("Ops ...");
			}
		};
	}

}

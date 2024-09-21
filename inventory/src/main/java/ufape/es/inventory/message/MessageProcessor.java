package ufape.es.inventory.message;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import ufape.es.core.event.Event;
import ufape.es.inventory.facade.Facade;
import ufape.es.inventory.model.Inventory;

import java.util.function.Consumer;


@Configuration
public class MessageProcessor {
	@Autowired
	private Facade facade;
	
	@Bean
	public Consumer<Event<Long, Integer>> consumeMessage() { 
		return e -> {
			switch(e.getType()) {
				case CREATE:
				System.out.println(e);
					Inventory inventory = new Inventory();
					inventory.setProductId(e.getKey());
					inventory.setQuantity(0L);
					facade.createInventory(inventory);
					break;
				default:
					System.out.println("Ops ...");
					break;
			}
		};
	}

}

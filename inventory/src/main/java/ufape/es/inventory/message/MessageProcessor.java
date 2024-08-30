package ufape.es.inventory.message;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ufape.es.core.event.Event;
import ufape.es.inventory.facade.Facade;
import ufape.es.inventory.model.Inventory;
import ufape.es.inventory.repository.InventoryRepository;

import java.util.function.Consumer;


@Configuration
public class MessageProcessor {
	@Autowired
	private Facade facade;
	
	@Bean
	public Consumer<Event<Integer,Long>> consumeMessage() { 
		return e -> {
			switch(e.getType()) {
				case CREATE:
					Inventory iv = new Inventory();
					iv.setProductId(e.getData());
					iv.setQuantity(0);
					facade.createInventory(null, iv);
					break;
				default:
					System.out.println("Ops ...");
			}
		};
	}

}

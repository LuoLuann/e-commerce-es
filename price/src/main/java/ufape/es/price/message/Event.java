package ufape.es.price.message;

import java.util.Date;

import lombok.Data;

@Data
public class Event<K, T> {
	public enum Type {CREATE, GET, UPDATE, DELETE};
	private Event.Type type;
	private K key;
	private T data;
	private Date createdAt;
	
	public Event(Type eventType, K key, T data) {
		this.type = eventType;
		this.key = key;
		this.data = data;
		this.createdAt = new Date();
	}
	
	public Event() {
		this.type = null;
		this.key = null;
		this.data = null;
	}

	
	
	
}

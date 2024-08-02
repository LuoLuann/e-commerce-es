package ufape.es.inventory.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Data
public class Inventory {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;	
    private long productId;
    @ManyToOne
    @JoinColumn(name = "warehouse_id")
    private Warehouse warehouse;
    private long quantity;
    private Long maximumProducts; 
    private Long minimumProducts; 
    @ManyToOne
    @JoinColumn(name = "section_id")
    private Section section;

}
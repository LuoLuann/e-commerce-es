package com.example.demo.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Inventory {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;	
    private long productId;
    @ManyToOne
    @JoinColumn(name = "warehouse_id")
    private long warehouseId;
    private long quantity;
    private Long maximumProducts; 
    private Long minimumProducts; 
    @ManyToOne
    @JoinColumn(name = "section_id")
    private Section section;

}
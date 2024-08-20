package ufape.es.price.controller;


import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ufape.es.price.controller.dto.request.PriceRequest;
import ufape.es.price.controller.dto.response.PriceResponse;
import ufape.es.price.facade.Facade;
import ufape.es.price.model.Price;

import java.util.List;

@RestController
public class PriceController{
    @Autowired
    private Facade facade;
    @Autowired
    private ModelMapper modelMapper;

    @PostMapping("/price")
    Price createPrice (@Valid @RequestBody PriceRequest newObj) {
        return facade.createPrice(newObj.convertToEntity());
    }

    @GetMapping("/price")
    List<PriceResponse> getAllPrice() {
        return facade.getAllPrices()
                .stream()
                .map(PriceResponse::new)
                .toList();
    }

    @GetMapping("/price/{id}")
    PriceResponse getPriceById(@PathVariable long id) {
        return new PriceResponse(facade.getPrice(id));
    }

    @PutMapping("/price/{id}")
    public PriceResponse updatePrice(@PathVariable Long id, @Valid @RequestBody PriceRequest obj) {
        Price oldObject = facade.getPrice(id);

        TypeMap<PriceRequest, Price> typeMapper = modelMapper
                .typeMap(PriceRequest.class, Price.class)
                .addMappings(mapper -> mapper.skip(Price::setId));
        typeMapper.map(obj, oldObject);

        return new PriceResponse(facade.updatePrice(oldObject));
    }

    @DeleteMapping("/price/{id}")
    void deletePrice(@PathVariable long id){
        facade.deletePrice(id);
    }

}
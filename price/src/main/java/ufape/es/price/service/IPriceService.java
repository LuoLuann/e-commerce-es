package ufape.es.price.service;


import ufape.es.price.model.Price;

import java.util.List;

public interface IPriceService {
    public Price createPrice(Price price);
    public Price updatePrice(Price price);
    public Price getPrice(long id);
    public List<Price> getAllPrices();
    public void deletePrice(long id);


    
}

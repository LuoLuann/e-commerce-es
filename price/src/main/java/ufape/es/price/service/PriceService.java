package ufape.es.price.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ufape.es.core.exception.DuplicateRecordException;
import ufape.es.price.model.Price;
import ufape.es.price.repository.PriceRepository;
import ufape.es.price.service.exception.ObjectNotFoundException;

import java.util.List;

@Service
public class PriceService implements IPriceService{
    @Autowired
    private PriceRepository priceRepository;


    @Override
    public Price createPrice(Price price) {
        if (priceRepository.findByProductId(price.getProductId()) == null) {
            return priceRepository.save(price);
        } else {
            throw new DuplicateRecordException("The price for product [" + price.getProductId() + "] is already registered in the system.");
        }
    }

    @Override
    public Price updatePrice(Price price) {
        return priceRepository.save(price);
    }

    @Override
    public Price getPrice(long id) {
        return priceRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Preço de produto não encontrada (id: " + id + ")"));
    }

    @Override
    public List<Price> getAllPrices() {
        return priceRepository.findAll();
    }

    @Override
    public void deletePrice(long id) {
        priceRepository.deleteById(id);
    }
}

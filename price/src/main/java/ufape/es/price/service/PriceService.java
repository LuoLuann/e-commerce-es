package ufape.es.price.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ufape.es.price.model.Price;
import ufape.es.price.repository.PriceRepository;

import java.util.List;

@Service
public class PriceService implements IPriceService{
    @Autowired
    private PriceRepository priceRepository;


    @Override
    public Price createPrice(Price price) {
        return priceRepository.save(price);
    }

    @Override
    public Price updatePrice(Price price) {
        return priceRepository.save(price);
    }

    @Override
    public Price getPrice(long id) {
        return priceRepository.findById(id).orElseThrow(() -> new RuntimeException("Preço de produto não encontrada (id: " + id + ")"));
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

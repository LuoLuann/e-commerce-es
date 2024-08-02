package ufape.es.price.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ufape.es.price.model.*;
import ufape.es.price.service.*;

import java.util.List;

@Service
public class Facade{

    //--------------------------Policy----------------------------------------------
    @Autowired
    private IPolicyService policyService;

    public Policy createPolicy(Policy policy) {
        return policyService.createPolicy(policy);
    }
    public Policy updatePolicy(Policy policy) {
        return policyService.updatePolicy(policy);
    }
    public void deletePolicy(Policy policy) {
        policyService.deletePolicy(policy.getId());
    }
    public Policy getPolicy(long id) {
        return policyService.getPolicy(id);
    }
    
    public List<Policy> getAllPolicies() {
        return policyService.getAllPolicies();
    }


    //--------------------------Price----------------------------------------------
    @Autowired
    private IPriceService priceService;
    
    public Price createPrice(Price price) {
        return priceService.createPrice(price);
    }
    public Price updatePrice(Price price) {
        return priceService.updatePrice(price);
    }
    public void deletePrice(Price price) {
        priceService.deletePrice(price.getId());
    }
    
    public Price getPrice(long id) {
        return priceService.getPrice(id);
    }
    
    public List<Price> getAllPrices() {
        return priceService.getAllPrices();
    }



}
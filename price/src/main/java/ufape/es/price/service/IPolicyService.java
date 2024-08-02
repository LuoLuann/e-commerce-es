package ufape.es.price.service;


import ufape.es.price.model.Policy;

import java.util.List;

public interface IPolicyService {

    public Policy createPolicy(Policy policy);
    public Policy updatePolicy(Policy policy);
    public Policy getPolicy(long id);
    public List<Policy> getAllPolicies();
    public void deletePolicy(long id);

}
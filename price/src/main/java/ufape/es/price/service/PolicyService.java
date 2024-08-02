package ufape.es.price.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ufape.es.price.model.Policy;
import ufape.es.price.repository.PolicyRepository;
import ufape.es.price.service.exception.ObjectNotFoundException;

import java.util.List;

@Service
public class PolicyService implements IPolicyService {
    @Autowired
    private PolicyRepository policyRepository;


    @Override
    public Policy createPolicy(Policy policy) {
        return policyRepository.save(policy);
    }

    @Override
    public Policy updatePolicy(Policy policy) {
        return policyRepository.save(policy);
    }

    @Override
    public Policy getPolicy(long id) {
        return policyRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Política de preço não encontrada (id: " + id + ")"));
    }

    @Override
    public List<Policy> getAllPolicies() {
        return policyRepository.findAll();
    }

    @Override
    public void deletePolicy(long id) {
        policyRepository.deleteById(id);
    }

}

package ufape.es.price.controller;

import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import ufape.es.price.controller.dto.request.PolicyRequest;
import ufape.es.price.controller.dto.response.PolicyResponse;
import ufape.es.price.facade.Facade;
import ufape.es.price.model.Policy;


import java.util.List;

@RestController
@RequestMapping("/price")
public class PolicyController {
    @Autowired
    private Facade facade;
    @Autowired
    private ModelMapper modelMapper;

    @PostMapping("/policy")
    Policy createPolicy (@Valid @RequestBody PolicyRequest newObj) {
        return facade.createPolicy(newObj.convertToEntity());
    }

    @PutMapping("/policy/{id}")
    public PolicyResponse updatePolicy(@PathVariable Long id, @Valid @RequestBody PolicyRequest obj) {
        Policy oldObject = facade.getPolicy(id);

        TypeMap<PolicyRequest, Policy> typeMapper = modelMapper
                .typeMap(PolicyRequest.class, Policy.class)
                .addMappings(mapper -> mapper.skip(Policy::setId));
        typeMapper.map(obj, oldObject);

        return new PolicyResponse(facade.updatePolicy(oldObject));
    }

    @GetMapping("/policy")
    List<PolicyResponse> getAllPolicy() {
        return facade.getAllPolicies()
                .stream()
                .map(PolicyResponse::new)
                .toList();
    }

    @GetMapping("/policy/{id}")
    PolicyResponse getPolicyById(@PathVariable long id) {
        return new PolicyResponse(facade.getPolicy(id));
    }

    @DeleteMapping("/policy/{id}")
    void deletePolicy(@PathVariable long id){
        facade.deletePolicy(id);
    }
    
}
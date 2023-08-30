package com.example.Dynamodb.controller;

import com.example.Dynamodb.entity.Customer;
import com.example.Dynamodb.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;

    @PostMapping
    public Customer save(@RequestBody Customer customer){
        return customerRepository.save(customer);
    }
    @GetMapping("/{id}")
    public Customer findById(@PathVariable(value = "id")String id){
        return customerRepository.findById(id);

    }
@GetMapping
    public List<Customer> findAll(){
        return  customerRepository.findAll();
    }
}

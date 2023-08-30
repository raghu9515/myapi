package com.example.Dynamodb.repository;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.example.Dynamodb.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerRepository {
    @Autowired
    private DynamoDBMapper dynamoDBMapper;

    public Customer save(Customer customer){
        dynamoDBMapper.save(customer);
        return customer;
    }

    public Customer findById(String id){
         return dynamoDBMapper.load(Customer.class,id);
    }

    public List<Customer> findAll(){
        return dynamoDBMapper.scan(Customer.class,new DynamoDBScanExpression());
    }
    public String delete(String id){
        dynamoDBMapper.delete(id);
        return "Successfully deleted";
    }
}

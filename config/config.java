package com.example.Dynamodb.config;

import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.security.cert.CertPathBuilder;

@Configuration
public class config {

    @Bean
    public DynamoDBMapper dynamoDBMapper(){
        return new DynamoDBMapper(amazonDynamoDB());
    }

    private AmazonDynamoDB amazonDynamoDB() {
        return AmazonDynamoDBClientBuilder.standard()
                .withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration("dynamodb.us-east-1.amazonaws.com","us-east-1"))
                .withCredentials(amazonDynamoDBCredentials()).build();
    }

    private AWSCredentialsProvider amazonDynamoDBCredentials() {
        return new AWSStaticCredentialsProvider(new BasicAWSCredentials("AKIAR3YRISY6QWFHKTV6","ry3gXeGkH3F8FRdenfsvmj8j7F/HktH6R+nKfXHv")) {
        };
    }


}

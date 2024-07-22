package com.melgo.sysarch.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoClientDatabaseFactory;
import com.mongodb.ConnectionString;
import com.mongodb.client.MongoClients;

@Configuration
public class MongoConfig {

    @Bean
    public MongoTemplate mongoTemplate() throws Exception {
        return new MongoTemplate(mongoDatabaseFactory());
    }

    @Bean
    public SimpleMongoClientDatabaseFactory mongoDatabaseFactory() throws Exception {
        ConnectionString connectionString = new ConnectionString("mongodb+srv://davidmelgo10:22253090@sysarch.qlsb2ji.mongodb.net/sysarch?retryWrites=true&w=majority");
        return new SimpleMongoClientDatabaseFactory(MongoClients.create(connectionString), "signup");
    }
}
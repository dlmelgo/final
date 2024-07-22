package com.melgo.sysarch.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "bangkas")
public class Bangka {

    @Id
    private String id;
    private String name;
    private double price;
    private String portArea;

    // Getters and Setters

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getPortArea() {
        return portArea;
    }

    public void setPortArea(String portArea) {
        this.portArea = portArea;
    }
}

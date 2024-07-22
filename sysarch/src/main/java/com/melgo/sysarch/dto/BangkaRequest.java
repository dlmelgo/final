package com.melgo.sysarch.dto;

public class BangkaRequest {
    private String name;
    private double price;
    private String portArea;

    // Getters and Setters

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

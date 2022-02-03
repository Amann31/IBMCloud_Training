package com.example;

public class Beer {
    private String beerId;
    private String beerName;
    private Double costPerUnit;
    private Integer unitInStock;

    public Beer() {
    }

    public Beer(String beerId, String beerName, Double costPerUnit, Integer unitInStock) {
        this.beerId = beerId;
        this.beerName = beerName;
        this.costPerUnit = costPerUnit;
        this.unitInStock = unitInStock;
    }

    public String getBeerId() {
        return beerId;
    }

    public void setBeerId(String beerId) {
        this.beerId = beerId;
    }

    public String getBeerName() {
        return beerName;
    }

    public void setBeerName(String beerName) {
        this.beerName = beerName;
    }

    public Double getCostPerUnit() {
        return costPerUnit;
    }

    public void setCostPerUnit(Double costPerUnit) {
        this.costPerUnit = costPerUnit;
    }

    public Integer getUnitInStock() {
        return unitInStock;
    }

    public void setUnitInStock(Integer unitInStock) {
        this.unitInStock = unitInStock;
    }

    @Override
    public String toString() {
        return  "beerId= " + beerId + '\'' +
                "beerName= " + beerName + '\'' +
                "costPerUnit= " + costPerUnit +
                " unitInStock= " + unitInStock;
    }
}

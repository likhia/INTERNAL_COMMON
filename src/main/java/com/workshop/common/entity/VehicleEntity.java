package com.workshop.common.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
@Table(name = "VEHICLES")
public class VehicleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String carplate = null;
    private String model = null;
    private String color = null;
    private String engineCapacity = null;
    private String createdYear = null;
    private String used  = null;
    private String type  = null;
    private String user = null;
    
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getEngineCapacity() {
        return engineCapacity;
    }

    public void setEngineCapacity(String engineCapacity) {
        this.engineCapacity = engineCapacity;
    }

    public String getCreatedYear() {
        return createdYear;
    }

    public void setCreatedYear(String createdYear) {
        this.createdYear = createdYear;
    }

    public String getUsed() {
        return used;
    }

    public void setUsed(String used) {
        this.used = used;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCarplate() {
        return carplate;
    }

    public void setCarplate(String carplate) {
        this.carplate = carplate;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

}

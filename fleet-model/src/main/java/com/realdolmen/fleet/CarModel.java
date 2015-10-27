package com.realdolmen.fleet;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.time.Period;

@Entity
public class CarModel extends AbstractEntity{

    public enum FuelType{
        DIESEL,
        GASOLINE
    }

    public enum RimType{
        STEEL,
        ALUMINIUM
    }

    private int category;
    private int co2Emition; // In grams per 100km
    private int fiscalHorsePower;

    @Enumerated(EnumType.STRING)
    private FuelType fuelType;

    private String brand;
    private String type;

    private String pack;

    private Period timeOfDeliveryInMonths;

    private RimType winterTyreRimType;

}

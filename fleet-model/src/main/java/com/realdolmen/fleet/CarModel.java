package com.realdolmen.fleet;

import com.realdolmen.fleet.converters.PeriodConverter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.Period;
import java.util.Map;

@Entity
public class CarModel extends AbstractEntity {

    public enum FuelType{
        DIESEL,
        GASOLINE
    }

    public enum RimType{
        STEEL,
        ALUMINIUM
    }

    private int category;
    private int co2Emission; // In grams per 100km
    private int fiscalHorsePower;

    @Enumerated(EnumType.STRING)
    private FuelType fuelType;

    private String brand;
    private String type;

    private String pack;

    @Convert(converter = PeriodConverter.class)
    private Period deliveryTime;

    @Enumerated(EnumType.STRING)
    private RimType winterTyreRimType;

    private int idealKm;
    private int maxKm;

    @ElementCollection
    private Map<Option, BigDecimal> optionPriceMap;

    private BigDecimal listPriceInclVat;
    private BigDecimal amountUpgradeInclVat;
    private BigDecimal amountDowngradeInclVat;

    @Transient
    final static int VAT = 21;

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public int getCo2Emission() {
        return co2Emission;
    }

    public void setCo2Emission(int co2Emission) {
        this.co2Emission = co2Emission;
    }

    public int getFiscalHorsePower() {
        return fiscalHorsePower;
    }

    public void setFiscalHorsePower(int fiscalHorsePower) {
        this.fiscalHorsePower = fiscalHorsePower;
    }

    public FuelType getFuelType() {
        return fuelType;
    }

    public void setFuelType(FuelType fuelType) {
        this.fuelType = fuelType;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPack() {
        return pack;
    }

    public void setPack(String pack) {
        this.pack = pack;
    }

    public Period getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(Period deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public RimType getWinterTyreRimType() {
        return winterTyreRimType;
    }

    public void setWinterTyreRimType(RimType winterTyreRimType) {
        this.winterTyreRimType = winterTyreRimType;
    }

    public int getIdealKm() {
        return idealKm;
    }

    public void setIdealKm(int idealKm) {
        this.idealKm = idealKm;
    }

    public int getMaxKm() {
        return maxKm;
    }

    public void setMaxKm(int maxKm) {
        this.maxKm = maxKm;
    }

    public Map<Option, BigDecimal> getOptionPriceMap() {
        return optionPriceMap;
    }

    public void setOptionPriceMap(Map<Option, BigDecimal> optionPriceMap) {
        this.optionPriceMap = optionPriceMap;
    }

    public BigDecimal getListPriceInclVat() {
        return listPriceInclVat;
    }

    public void setListPriceInclVat(BigDecimal listPriceInclVat) {
        this.listPriceInclVat = listPriceInclVat;
    }

    public BigDecimal getAmountUpgradeInclVat() {
        return amountUpgradeInclVat;
    }

    public void setAmountUpgradeInclVat(BigDecimal amountUpgradeInclVat) {
        this.amountUpgradeInclVat = amountUpgradeInclVat;
    }

    public BigDecimal getAmountDowngradeInclVat() {
        return amountDowngradeInclVat;
    }

    public void setAmountDowngradeInclVat(BigDecimal amountDowngradeInclVat) {
        this.amountDowngradeInclVat = amountDowngradeInclVat;
    }

    public static int getVAT() {
        return VAT;
    }
}

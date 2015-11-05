package com.realdolmen.fleet;

import com.realdolmen.fleet.converters.PeriodConverter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

@Entity
public class CarModel extends AbstractEntity {

    public enum FuelType{
        DIESEL("Diesel"),
        GASOLINE("Gasoline");

        private final String displayName;

        FuelType(String displayName) {
            this.displayName = displayName;
        }

        public String getDisplayName() {
            return displayName;
        }
    }

    public enum RimType{
        STEEL,
        ALUMINIUM
    }

    private String pictureUrl;

    private int category;
    private int co2Emission; // In grams per 100km
    private int fiscalHorsePower;

    @Enumerated(EnumType.STRING)
    private FuelType fuelType;

    private String brand;
    private String model;

    private String pack;

    @Convert(converter = PeriodConverter.class)
    private Period deliveryTime;

    @Enumerated(EnumType.STRING)
    private RimType winterTyreRimType;

    private int idealKm;
    private int maxKm;

    private BigDecimal listPriceInclVat;
    private BigDecimal amountUpgradeInclVat;
    private BigDecimal amountDowngradeInclVat;

    private BigDecimal benefitInKindPerMonth;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "carmodel_defaultoptions")
    private List<CarOption> defaultOptions;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "carmodel_availableoptions")
    private List<CarOption> availableOptions;

    @Transient
    final static int VAT = 21;

    public CarModel() {
    }

    public CarModel(String pictureUrl, int category, int co2Emission, int fiscalHorsePower,
        FuelType fuelType, String brand, String model, String pack, Period deliveryTime,
        RimType winterTyreRimType, int idealKm, int maxKm, BigDecimal listPriceInclVat,
        BigDecimal amountUpgradeInclVat, BigDecimal amountDowngradeInclVat,
        BigDecimal benefitInKindPerMonth) {
        this.pictureUrl = pictureUrl;
        this.category = category;
        this.co2Emission = co2Emission;
        this.fiscalHorsePower = fiscalHorsePower;
        this.fuelType = fuelType;
        this.brand = brand;
        this.model = model;
        this.pack = pack;
        this.deliveryTime = deliveryTime;
        this.winterTyreRimType = winterTyreRimType;
        this.idealKm = idealKm;
        this.maxKm = maxKm;
        this.listPriceInclVat = listPriceInclVat;
        this.amountUpgradeInclVat = amountUpgradeInclVat;
        this.amountDowngradeInclVat = amountDowngradeInclVat;
        this.benefitInKindPerMonth = benefitInKindPerMonth;
    }

    public List<CarOption> getDefaultOptions() {
        return defaultOptions;
    }

    public void setDefaultOptions(List<CarOption> defaultOptions) {
        this.defaultOptions = defaultOptions;
    }

    public List<CarOption> getAvailableOptions() {
        return availableOptions;
    }

    public void setAvailableOptions(List<CarOption> availableOptions) {
        this.availableOptions = availableOptions;
    }

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

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
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

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }

    public BigDecimal getBenefitInKindPerMonth() {
        return benefitInKindPerMonth;
    }

    public void setBenefitInKindPerMonth(BigDecimal benefitInKindPerMonth) {
        this.benefitInKindPerMonth = benefitInKindPerMonth;
    }


    public void addDefaultOption(CarOption carOption)
    {
        if(defaultOptions == null)
            defaultOptions = new ArrayList<>();
        defaultOptions.add(carOption);
    }

    public void addAvailableOption(CarOption carOption)
    {
        if(availableOptions == null)
            availableOptions = new ArrayList<>();
        availableOptions.add(carOption);
    }

    @Override public String toString() {
        return "CarModel{" +
            "pictureUrl='" + pictureUrl + '\'' +
            ", category=" + category +
            ", co2Emission=" + co2Emission +
            ", fiscalHorsePower=" + fiscalHorsePower +
            ", fuelType=" + fuelType +
            ", brand='" + brand + '\'' +
            ", model='" + model + '\'' +
            ", pack='" + pack + '\'' +
            ", deliveryTime=" + deliveryTime +
            ", winterTyreRimType=" + winterTyreRimType +
            ", idealKm=" + idealKm +
            ", maxKm=" + maxKm +
            ", listPriceInclVat=" + listPriceInclVat +
            ", amountUpgradeInclVat=" + amountUpgradeInclVat +
            ", amountDowngradeInclVat=" + amountDowngradeInclVat +
            ", benefitInKindPerMonth=" + benefitInKindPerMonth +
            ", defaultOptions=" + defaultOptions +
            ", availableOptions=" + availableOptions +
            '}';
    }
}

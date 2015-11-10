package com.realdolmen.fleet.viewmodels.admin.carModel;

import com.realdolmen.fleet.CarModel;
import com.realdolmen.fleet.CarOption;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.Period;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CarModelEditForm {
    private Long id;
    private Long version;

    @Size(max = 255)
    private String pictureUrl;
    private MultipartFile imageFile;

    @NotNull
    @Min(2)
    @Max(7)
    private Integer category;

    @NotNull
    @Min(1)
    private Integer co2Emission; // In grams per 100km

    @NotNull
    @Min(1)
    @Max(44)
    private Integer fiscalHorsePower;

    @NotNull
    private CarModel.FuelType fuelType;

    @NotNull
    @Size(min = 1, max = 255)
    private String brand;

    @NotNull
    @Size(min = 1, max = 255)
    private String model;

    @NotNull
    @Size(min = 1, max = 255)
    private String pack;

    @NotNull
    @Min(0)
    private Integer deliveryTimeMonths;

    @NotNull
    @Min(0)
    private Integer deliveryTimeDays;

    @NotNull
    private CarModel.RimType winterTyreRimType;

    @NotNull
    @Min(0)
    private Integer idealKm;

    @NotNull
    @Min(0)
    private Integer maxKm;

    private List<CarOption> availableOptions;
    private List<CarOption> defaultOptions;

    @NotNull
    @Digits(integer = 8, fraction = 2)
    private BigDecimal listPriceInclVat;

    @Digits(integer = 8, fraction = 2)
    private BigDecimal amountUpgradeInclVat;

    @Digits(integer = 8, fraction = 2)
    private BigDecimal amountDowngradeInclVat;

    @NotNull
    @Digits(integer = 8, fraction = 2)
    private BigDecimal benefitInKindPerMonth;

    private List<Long> optionIds = new ArrayList<>();
    private List<Boolean> optionDefaultList = new ArrayList<>();

    public void mapFrom(CarModel carModel) {
        this.id = carModel.getId();
        this.pictureUrl = carModel.getPictureUrl();
        this.category = carModel.getCategory();
        this.co2Emission = carModel.getCo2Emission();
        this.fiscalHorsePower = carModel.getFiscalHorsePower();
        this.fuelType = carModel.getFuelType();
        this.brand = carModel.getBrand();
        this.model = carModel.getModel();
        this.pack = carModel.getPack();
        this.deliveryTimeMonths = carModel.getDeliveryTime().getMonths();
        this.deliveryTimeDays = carModel.getDeliveryTime().minusMonths(this.deliveryTimeMonths).getDays();
        this.winterTyreRimType = carModel.getWinterTyreRimType();
        this.idealKm = carModel.getIdealKm();
        this.maxKm = carModel.getMaxKm();
        this.listPriceInclVat = carModel.getListPriceInclVat();
        this.amountDowngradeInclVat = carModel.getAmountDowngradeInclVat();
        this.amountUpgradeInclVat = carModel.getAmountUpgradeInclVat();
        this.benefitInKindPerMonth = carModel.getBenefitInKindPerMonth();
        this.version = carModel.getVersion();

        for(Map.Entry<CarOption, Boolean> entry : carModel.getOptionsDefaultMap().entrySet()) {
            this.optionIds.add(entry.getKey().getId());
            this.optionDefaultList.add(entry.getValue());
        }
    }

    public CarModel carModel() {
        CarModel carModel = new CarModel();
        carModel.setId(this.id);
        carModel.setPictureUrl(this.pictureUrl.isEmpty() ? null : this.pictureUrl);
        carModel.setCategory(this.category);
        carModel.setCo2Emission(this.co2Emission);
        carModel.setFiscalHorsePower(this.fiscalHorsePower);
        carModel.setFuelType(this.fuelType);
        carModel.setBrand(this.brand);
        carModel.setModel(this.model);
        carModel.setPack(this.pack);
        carModel.setDeliveryTime(Period.of(0, this.deliveryTimeMonths, this.deliveryTimeDays));
        carModel.setWinterTyreRimType(this.winterTyreRimType);
        carModel.setIdealKm(this.idealKm);
        carModel.setMaxKm(this.maxKm);
        carModel.setListPriceInclVat(this.listPriceInclVat);
        carModel.setAmountDowngradeInclVat(this.amountDowngradeInclVat);
        carModel.setAmountUpgradeInclVat(this.amountUpgradeInclVat);
        carModel.setBenefitInKindPerMonth(this.benefitInKindPerMonth);
        carModel.setVersion(this.version);

        return carModel;
    }

    public List<Long> getOptionIds() {
        return optionIds;
    }

    public void setOptionIds(List<Long> optionIds) {
        this.optionIds = optionIds;
    }

    public List<Boolean> getOptionDefaultList() {
        return optionDefaultList;
    }

    public void setOptionDefaultList(List<Boolean> optionDefaultList) {
        this.optionDefaultList = optionDefaultList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }

    public MultipartFile getImageFile() {
        return imageFile;
    }

    public void setImageFile(MultipartFile imageFile) {
        this.imageFile = imageFile;
    }

    public Integer getCategory() {
        return category;
    }

    public void setCategory(Integer category) {
        this.category = category;
    }

    public Integer getCo2Emission() {
        return co2Emission;
    }

    public void setCo2Emission(Integer co2Emission) {
        this.co2Emission = co2Emission;
    }

    public Integer getFiscalHorsePower() {
        return fiscalHorsePower;
    }

    public void setFiscalHorsePower(Integer fiscalHorsePower) {
        this.fiscalHorsePower = fiscalHorsePower;
    }

    public CarModel.FuelType getFuelType() {
        return fuelType;
    }

    public void setFuelType(CarModel.FuelType fuelType) {
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

    public Integer getDeliveryTimeMonths() {
        return deliveryTimeMonths;
    }

    public void setDeliveryTimeMonths(Integer deliveryTimeMonths) {
        this.deliveryTimeMonths = deliveryTimeMonths;
    }

    public Integer getDeliveryTimeDays() {
        return deliveryTimeDays;
    }

    public void setDeliveryTimeDays(Integer deliveryTimeDays) {
        this.deliveryTimeDays = deliveryTimeDays;
    }

    public CarModel.RimType getWinterTyreRimType() {
        return winterTyreRimType;
    }

    public void setWinterTyreRimType(CarModel.RimType winterTyreRimType) {
        this.winterTyreRimType = winterTyreRimType;
    }

    public Integer getIdealKm() {
        return idealKm;
    }

    public void setIdealKm(Integer idealKm) {
        this.idealKm = idealKm;
    }

    public Integer getMaxKm() {
        return maxKm;
    }

    public void setMaxKm(Integer maxKm) {
        this.maxKm = maxKm;
    }

    public List<CarOption> getAvailableOptions() {
        return availableOptions;
    }

    public void setAvailableOptions(List<CarOption> availableOptions) {
        this.availableOptions = availableOptions;
    }

    public List<CarOption> getDefaultOptions() {
        return defaultOptions;
    }

    public void setDefaultOptions(List<CarOption> defaultOptions) {
        this.defaultOptions = defaultOptions;
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

    public BigDecimal getBenefitInKindPerMonth() {
        return benefitInKindPerMonth;
    }

    public void setBenefitInKindPerMonth(BigDecimal benefitInKindPerMonth) {
        this.benefitInKindPerMonth = benefitInKindPerMonth;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }
}

package com.realdolmen.fleet;

import javax.persistence.Entity;
import java.util.List;

@Entity
public class PhysicalCar {
    private CarModel carModel;
    private List<Option> selectedOptions;

    public CarModel getCarModel() {
        return carModel;
    }

    public void setCarModel(CarModel carModel) {
        this.carModel = carModel;
    }

    public List<Option> getSelectedOptions() {
        return selectedOptions;
    }

    public void setSelectedOptions(List<Option> selectedOptions) {
        this.selectedOptions = selectedOptions;
    }
}

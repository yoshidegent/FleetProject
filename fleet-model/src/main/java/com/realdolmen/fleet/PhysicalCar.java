package com.realdolmen.fleet;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import java.util.List;

@Entity
public class PhysicalCar extends AbstractEntity {
    private CarModel carModel;

    @ElementCollection
    private List<CarOption> selectedCarOptions;

    public CarModel getCarModel() {
        return carModel;
    }

    public void setCarModel(CarModel carModel) {
        this.carModel = carModel;
    }

    public List<CarOption> getSelectedCarOptions() {
        return selectedCarOptions;
    }

    public void setSelectedCarOptions(List<CarOption> selectedCarOptions) {
        this.selectedCarOptions = selectedCarOptions;
    }
}

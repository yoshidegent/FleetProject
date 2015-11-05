package com.realdolmen.fleet;

import org.hibernate.annotations.Where;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.util.List;

@Entity
@Where(clause = "deleted = false")
public class PhysicalCar extends AbstractEntity {
    @ManyToOne
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

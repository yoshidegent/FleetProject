package com.realdolmen.fleet;

import org.hibernate.annotations.Where;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
@Where(clause = "deleted = 0")
public class PhysicalCar extends AbstractEntity {
    @ManyToOne
    private CarModel carModel;

    @OneToMany
    private List<CarOption> selectedCarOptions = new ArrayList<>();

    public PhysicalCar() {}

    public PhysicalCar(CarModel carModel) {
        this.carModel = carModel;
    }

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

package com.realdolmen.fleet.viewmodels.admin.order;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class DeliverForm {
    @NotNull
    @Size(min = 9, max = 9)
    private String licensePlate;

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }
}

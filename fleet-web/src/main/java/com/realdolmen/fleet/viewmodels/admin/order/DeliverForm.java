package com.realdolmen.fleet.viewmodels.admin.order;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class DeliverForm {
    @NotNull
    @Pattern(regexp = "^1-[a-zA-Z]{3}-\\d{3}$", message = "A license plate has to be formatted as 1-AAA-999")
    private String licensePlate;

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }
}

package com.realdolmen.fleet.scheduling;

import com.realdolmen.fleet.CarService;
import com.realdolmen.fleet.PhysicalCar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CarRenewalTask {
    @Autowired private CarService carService;

    @Scheduled(cron = "0 0 * * * *")
    public void checkCarsForRenewal() {
        List<PhysicalCar> cars = carService.findCarsThatExceedMaxKm();
        for(PhysicalCar car : cars) {
            // If the mail was already sent, ignore.
            if(car.getRenewalStatus() == PhysicalCar.RenewalStatus.NEEDS_RENEWAL_MAIL_SENT)
                continue;

            carService.sendRenewalEmail(car);
        }
    }
}

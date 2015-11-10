package com.realdolmen.fleet.endpoints;

import com.realdolmen.fleet.CarService;
import com.realdolmen.fleet.PhysicalCar;
import com.realdolmen.fleet.endpoints.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Endpoint
public class MileageEndpoint {
    private static final String NAMESPACE_URI = "http://fleet.realdolmen.com";

    @Autowired
    private CarService carService;



    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "updateMileageRequest")
    @ResponsePayload
    public UpdateMileageResponse updateCarMileages(@RequestPayload UpdateMileageRequest request) {

        UpdateMileageResponse updateMileageResponse = new UpdateMileageResponse();

        List<UpdateMileageRequestObject> licensePlatesAndMileages = request.getUpdateMileageRequestObject();

        for(UpdateMileageRequestObject element : licensePlatesAndMileages) {

            UpdateMileageResponseObject responseObject = new UpdateMileageResponseObject();

            String licensePlate = element.getLicensePlate();
            Long mileage = element.getMileage();

            PhysicalCar physicalCar = carService.findCarByLicensePlate(licensePlate);
            if(physicalCar != null && mileage != null)
            {
                physicalCar.setMileage(mileage);
                carService.saveCar(physicalCar);
                responseObject.setStatus(Status.SUCCESS);
                responseObject.setMessage(String.format("Mileage of car with licence plate %s updated to %s", licensePlate, mileage.toString()));
            }
            else {
                responseObject.setStatus(Status.FAILED);
                responseObject.setMessage(String.format("Mileage of car with licence plate %s failed to update to %s", licensePlate, mileage.toString()));
            }
            updateMileageResponse.getResponseMileageUpdateObject().add(responseObject);
        }

        return updateMileageResponse;
    }
}

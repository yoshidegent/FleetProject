package com.realdolmen.fleet;

import com.realdolmen.fleet.mail.MailUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@Transactional
public class CarServiceImpl implements CarService {
    @Autowired protected CarModelRepository carModelRepository;
    @Autowired private PhysicalCarRepository physicalCarRepository;
    @Autowired private MailUtil mailUtil;

    @Override
    public void saveCar(PhysicalCar car) {
        physicalCarRepository.save(car);
    }

    @Override
    public List<PhysicalCar> findAllCars() {
        return physicalCarRepository.findAll();
    }

    @Override
    public PhysicalCar findCar(Long id) {
        return physicalCarRepository.findOne(id);
    }

    @Override public PhysicalCar findCarByLicensePlate(String licensePlate) {
        return physicalCarRepository.findByLicensePlate(licensePlate);
    }

    @Override
    public List<PhysicalCar> findCarsThatExceedMaxKm() {
        return physicalCarRepository.findByMileageGreaterThanMaxKm();
    }

    @Override
    public Boolean sendRenewalEmail(PhysicalCar physicalCar) {
        physicalCar.setRenewalStatus(PhysicalCar.RenewalStatus.NEEDS_RENEWAL);

        if(mailUtil.sendRenewalMessage(physicalCar)) {
            physicalCar.setRenewalStatus(PhysicalCar.RenewalStatus.NEEDS_RENEWAL_MAIL_SENT);

            saveCar(physicalCar);
            return true;
        }

        saveCar(physicalCar);
        return false;
    }

    @Override
    public void saveCarModels(List<CarModel> carModels) {
        carModelRepository.save(carModels);
    }

    @Override
    public void saveCarModel(CarModel carModel) {
        carModelRepository.save(carModel);
    }

    @Override
    public List<CarModel> findAllCarModels() {
        return carModelRepository.findAll();
    }

    @Override public List<CarModel> findCarModelsByCategory(int category) {
        return carModelRepository.findByCategory(category);
    }

    @Override
    public CarModel findCarModel(Long id) {
        return carModelRepository.findOne(id);
    }

    @Override public void deleteAllCarModels() {
        carModelRepository.deleteAll();
    }

    @Override
    public void deleteCarModel(Long id) {
        carModelRepository.delete(id);
    }

    @Override
    public void deleteCarModels(Long[] ids) {
        for(Long id : ids)
            carModelRepository.delete(id);
    }
}

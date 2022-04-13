package service_layer;

import db_layer.dao.CarsDAO;
import db_layer.dto.CarDTO;
import db_layer.dto.YearDTO;

import java.util.List;
import java.util.stream.Collectors;

public class CarService {
    private CarsDAO cars;

    public CarService(CarsDAO cars) {
        this.cars = cars;
    }

    public List<CarDTO> getCarsBetweenYears (YearDTO yearDTO) {
        int yearTo = yearDTO.getYearTo();
        int yearFrom = yearDTO.getYearFrom();
        return cars.findAll().stream()
            .filter(cars -> cars.getYear() <= yearTo && cars.getYear() >= yearFrom)
            .collect(Collectors.toList());
    }

    public List<CarDTO> getCarsCostLessThan (int cost) {
        return cars.findAll().stream()
            .filter(cars -> cars.getCost() <= cost)
            .collect(Collectors.toList());
    }


}

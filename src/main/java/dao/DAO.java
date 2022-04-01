package dao;


import dto.CarDTO;

import java.util.List;

public interface DAO {

    void createTable();

    List<CarDTO> findAll();

    CarDTO getById(int id);

    void save(CarDTO usersObject);

    void deleteById(int id);

    void dropTable();

    void update(CarDTO dataForUpdate);
}

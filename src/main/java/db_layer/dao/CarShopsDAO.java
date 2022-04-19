package db_layer.dao;

import db_layer.connection.ConnectionFactory;
import db_layer.dto.CarShopsDTO;
import db_layer.propertiesLoader.PropertiesLoader;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CarShopsDAO {
    private final ConnectionFactory connectionFactory;
    private final PropertiesLoader loader;

    public CarShopsDAO(
        final ConnectionFactory connectionFactory,
        final PropertiesLoader loader
    ) {
        this.connectionFactory = connectionFactory;
        this.loader = loader;
    }

    public List<CarShopsDTO> findAll() {
        final Connection connection = connectionFactory.connectionOpen();
        final List<CarShopsDTO> result = new ArrayList<>();
        try {
            final PreparedStatement statement = connection.prepareStatement(loader.getStatementSelectCarShopById());
            final ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                result.add(CarShopsDTO.of(resultSet));
            }
        } catch (final SQLException e) {
            e.printStackTrace();
        } finally {
            connectionFactory.closeConnection(connection);
        }
        return result;
    }
}

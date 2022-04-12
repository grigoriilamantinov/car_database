package db_layer.propertiesLoader;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesLoader {

    private final String dataSource;

    public PropertiesLoader(String dataSource) {
        this.dataSource = dataSource;
        this.loadDataSourceProperties();
    }

    private static final String CREATE_STATE_ALL_TABLES = "createTables";
    private static final String CREATE_STATE_OWNERS = "createOwners";
    private static final String CREATE_STATE_SHOPS = "createShops";
    private static final String CREATE_STATE_CAR_INTO_SHOPS = "createCarIntoShops";
    private static final String MENU = "menu";
    private static final String USER = "user";
    private static final String PASSWORD = "password";
    private static final String DB_URL = "db_url";
    private static final String DRIVER = "driverName";

    private final Properties properties = new Properties();

    private void loadDataSourceProperties() {
        FileInputStream stream = null;
        try {
            stream = new FileInputStream(dataSource);
            properties.load(stream);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                stream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public String getCreateStateAllTables() {
        return properties.getProperty(CREATE_STATE_ALL_TABLES);
    }

    public String getCreateStateOwners() {
        return properties.getProperty(CREATE_STATE_OWNERS);
    }

    public String getCreateStateShops() {
        return properties.getProperty(CREATE_STATE_SHOPS);
    }

    public String getCreateStateCarIntoShops() {
        return properties.getProperty(CREATE_STATE_CAR_INTO_SHOPS);
    }

    public String getMenu() {
        return properties.getProperty(MENU);
    }

    public String getUser() {
        return properties.getProperty(USER);
    }

    public String getPassword() {
        return properties.getProperty(PASSWORD);
    }

    public String getDbUrl() {
        return properties.getProperty(DB_URL);
    }

    public String getDriver() {
        return properties.getProperty(DRIVER);
    }
}

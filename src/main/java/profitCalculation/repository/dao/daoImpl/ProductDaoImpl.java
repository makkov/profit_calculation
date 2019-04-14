package profitCalculation.repository.dao.daoImpl;

import profitCalculation.pojo.Product;
import profitCalculation.repository.connectionManager.ConnectionManager;
import profitCalculation.repository.connectionManager.ConnectionManagerJdbcImpl;
import profitCalculation.repository.dao.ProductDao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDaoImpl implements ProductDao {

    private static ConnectionManager connectionManager = ConnectionManagerJdbcImpl.getInstance();

    @Override
    public boolean purchaseProduct(Product product) {
        try (Connection connection = connectionManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "INSERT INTO product VALUES (DEFAULT, ?, ?, ?, ?)")) {
            preparedStatement.setInt(1, product.getCategory());
            preparedStatement.setInt(2, product.getPrice());
            preparedStatement.setString(3, product.getDate());
            preparedStatement.setBoolean(4, false);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean demandProduct(Product product) {
        try (Connection connection = connectionManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "UPDATE product SET product_sold = TRUE WHERE id = ?")) {
            preparedStatement.setInt(1, product.getId());
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public List<Product> getProductsInStock() {
        List<Product> result = null;
        try (Connection connection = connectionManager.getConnection();
             Statement statement = connection.createStatement()) {
            try (ResultSet resultSet = statement.executeQuery("SELECT * FROM product WHERE product_sold = FALSE");) {
                result = new ArrayList<>();
                while (resultSet.next()) {
                    result.add(new Product(
                            resultSet.getInt(1),
                            resultSet.getInt(2),
                            resultSet.getInt(3),
                            resultSet.getString(4)));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;

    }
}

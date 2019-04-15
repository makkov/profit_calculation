package profitCalculation.repository.dao.daoImpl;

import profitCalculation.pojo.Category;
import profitCalculation.repository.connectionManager.ConnectionManager;
import profitCalculation.repository.connectionManager.ConnectionManagerJdbcImpl;
import profitCalculation.repository.dao.CategoryDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CategoryDaoImpl implements CategoryDao {

    private static ConnectionManager connectionManager = ConnectionManagerJdbcImpl.getInstance();

    @Override
    public boolean addCategory(Category category) {
        try (Connection connection = connectionManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "INSERT INTO category VALUES (DEFAULT, ?)")) {
            preparedStatement.setString(1, category.getName());
            preparedStatement.execute();
        } catch (SQLException e) {
            return false;
        }
        return true;
    }

    @Override
    public Category getCategoryByName(String name) {
        try (Connection connection = connectionManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "SELECT * FROM category WHERE name = ?")) {
            preparedStatement.setString(1, name);
            try (ResultSet resultSet = preparedStatement.executeQuery();) {
                if (resultSet.next()) {
                    return new Category(
                            resultSet.getInt(1),
                            resultSet.getString(2));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}

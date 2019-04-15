package profitCalculation.repository.dao.daoImpl;

import profitCalculation.pojo.Category;
import profitCalculation.repository.connectionManager.ConnectionManager;
import profitCalculation.repository.connectionManager.ConnectionManagerJdbcImpl;
import profitCalculation.repository.dao.ReportDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ReportDaoImpl implements ReportDao {

    private static ConnectionManager connectionManager = ConnectionManagerJdbcImpl.getInstance();

    @Override
    public String getProfitOnCategoryOnDate(Category category, String date) {
        try {
            try (Connection connection = connectionManager.getConnection();
                 PreparedStatement preparedStatement = connection.prepareStatement(
                         "SELECT SUM(price_demand - price_purchase) " +
                                 "FROM product " +
                                 "WHERE category_id = ? AND to_date(date_demand, 'DD.MM.YYYY') <= to_date(?, 'DD.MM.YYYY')")) {
                preparedStatement.setInt(1, category.getId());
                preparedStatement.setString(2, date);
                try (ResultSet resultSet = preparedStatement.executeQuery();) {
                    if (resultSet.next()) {
                        return String.valueOf(resultSet.getInt(1));
                    }
                } catch (Exception e) {
                    return null;
                }
            }
        } catch (SQLException e) {
            return null;
        }
        return null;
    }
}

package profitCalculation.repository.dao.daoImpl;

import profitCalculation.pojo.Category;
import profitCalculation.pojo.Transaction;
import profitCalculation.repository.connectionManager.ConnectionManager;
import profitCalculation.repository.connectionManager.ConnectionManagerJdbcImpl;
import profitCalculation.repository.dao.TransactionDao;

import java.sql.*;

public class TransactionDaoImpl implements TransactionDao {

    private static ConnectionManager connectionManager = ConnectionManagerJdbcImpl.getInstance();


    @Override
    public boolean spendTransaction(Transaction transaction) {
        try (Connection connection = connectionManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "INSERT INTO transact VALUES (DEFAULT, ?, ?, ?)")) {
            preparedStatement.setInt(1, transaction.getCategory());
            preparedStatement.setInt(2, transaction.getSum());
            preparedStatement.setString(3, transaction.getDate());
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public String getReportByCategoryAndDate(Category category, String date) {
        try (Connection connection = connectionManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "SELECT SUM(summ) FROM transact WHERE (category_id = ? AND to_date(date_operation, 'DD.MM.YYYY') <= to_date(?, 'DD.MM.YYYY'))")) {
            preparedStatement.setInt(1, category.getId());
            preparedStatement.setString(2, date);
            try (ResultSet resultSet = preparedStatement.executeQuery();) {
                if (resultSet.next()) {
                    return resultSet.getString(1);
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

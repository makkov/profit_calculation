package profitCalculation.repository.dao;

import profitCalculation.pojo.Category;
import profitCalculation.pojo.Transaction;

public interface TransactionDao {

    boolean spendTransaction(Transaction transaction);
    String getReportByCategoryAndDate(Category category, String date);
}

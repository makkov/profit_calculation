package profitCalculation.repository.dao;

import profitCalculation.pojo.Category;

public interface ReportDao {

    String getProfitOnCategoryOnDate(Category category, String date);
}

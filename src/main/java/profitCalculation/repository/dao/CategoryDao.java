package profitCalculation.repository.dao;

import profitCalculation.pojo.Category;

public interface CategoryDao {

    boolean addCategory(Category category);
    Category getCategoryByName(String name);
}

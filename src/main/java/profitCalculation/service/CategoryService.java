package profitCalculation.service;

import profitCalculation.pojo.Category;

public interface CategoryService {

    boolean addCategory(String categoryName);
    Category getCategoryByName(String name);
}

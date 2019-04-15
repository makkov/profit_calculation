package profitCalculation.service.serviceImpl;

import profitCalculation.pojo.Category;
import profitCalculation.repository.dao.CategoryDao;
import profitCalculation.repository.dao.daoImpl.CategoryDaoImpl;
import profitCalculation.service.CategoryService;

public class CategoryServiceImpl implements CategoryService {

    private CategoryDao categoryDao = new CategoryDaoImpl();

    @Override
    public boolean addCategory(String categoryName) {
        if (categoryName != null) {
            Category newCategory = new Category(null, categoryName);
            return categoryDao.addCategory(newCategory);
        } else {
            return false;
        }
    }
}

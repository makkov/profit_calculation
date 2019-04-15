package profitCalculation.service.serviceImpl;

import profitCalculation.pojo.Product;
import profitCalculation.repository.dao.CategoryDao;
import profitCalculation.repository.dao.ProductDao;
import profitCalculation.repository.dao.daoImpl.CategoryDaoImpl;
import profitCalculation.repository.dao.daoImpl.ProductDaoImpl;
import profitCalculation.service.ProductService;

import java.util.List;

public class ProductServiceImpl implements ProductService {

    private ProductDao productDao = new ProductDaoImpl();
    private CategoryDao categoryDao = new CategoryDaoImpl();

    @Override
    public boolean purchaseProducts(String category, String amountProducts, String priceProduct, String purchaseDate) {
        if (category != null & amountProducts != null & priceProduct != null & purchaseDate != null & categoryDao.getCategoryByName(category) != null) {
            Product product = new Product(null,
                    categoryDao.getCategoryByName(category).getId(),
                    Integer.parseInt(priceProduct),
                    purchaseDate);
            for (int i = 0; i < Integer.parseInt(amountProducts); i++) {
                productDao.purchaseProduct(product);
            }
            return true;
        }
        return false;
    }

    @Override
    public boolean demandProducts(String category, String amountProducts, String priceProduct, String saleDate) {
        if (category != null & amountProducts != null & priceProduct != null & saleDate != null & categoryDao.getCategoryByName(category) != null) {
            List<Product> productsInStock = productDao.getProductsInStock();
            if (productsInStock.size() >= Integer.parseInt(amountProducts)) {
                for (int i = 0; i < Integer.parseInt(amountProducts); i++) {
                    productsInStock.get(i).setPriceDemand(Integer.parseInt(priceProduct));
                    productsInStock.get(i).setDateDemand(saleDate);
                    productDao.demandProduct(productsInStock.get(i));
                }
                return true;
            }
            return false;
        }
        return false;
    }
}

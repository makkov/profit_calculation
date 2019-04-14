package profitCalculation.service.serviceImpl;

import profitCalculation.pojo.Transaction;
import profitCalculation.pojo.Product;
import profitCalculation.repository.dao.CategoryDao;
import profitCalculation.repository.dao.TransactionDao;
import profitCalculation.repository.dao.ProductDao;
import profitCalculation.repository.dao.daoImpl.CategoryDaoImpl;
import profitCalculation.repository.dao.daoImpl.TransactionDaoImpl;
import profitCalculation.repository.dao.daoImpl.ProductDaoImpl;
import profitCalculation.service.ProductService;

import java.util.List;

public class ProductServiceImpl implements ProductService {

    private ProductDao productDao = new ProductDaoImpl();
    private CategoryDao categoryDao = new CategoryDaoImpl();
    private TransactionDao transactionDao = new TransactionDaoImpl();

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
            Transaction transaction = new Transaction(null,
                    categoryDao.getCategoryByName(category).getId(),
                    (-1) * Integer.parseInt(amountProducts) * Integer.parseInt(priceProduct),
                    purchaseDate);
            return transactionDao.spendTransaction(transaction);
        }
        return false;
    }

    @Override
    public boolean demandProducts(String category, String amountProducts, String priceProduct, String saleDate) {
        if (category != null & amountProducts != null & priceProduct != null & saleDate != null & categoryDao.getCategoryByName(category) != null) {
            List<Product> productsInStock = productDao.getProductsInStock();
            if (productsInStock.size() >= Integer.parseInt(amountProducts)) {

                for (int i = 0; i < Integer.parseInt(amountProducts); i++) {
                    productDao.demandProduct(productsInStock.get(i));
                }
                Transaction transaction = new Transaction(null,
                        categoryDao.getCategoryByName(category).getId(),
                        Integer.parseInt(amountProducts) * Integer.parseInt(priceProduct),
                        saleDate);
                transactionDao.spendTransaction(transaction);
                return true;
            }
            return false;
        }
        return false;
    }
}

package profitCalculation.repository.dao;

import profitCalculation.pojo.Product;

import java.util.List;

public interface ProductDao {

    boolean purchaseProduct(Product product);
    boolean demandProduct(Product product);
    List<Product> getProductsInStock();
}

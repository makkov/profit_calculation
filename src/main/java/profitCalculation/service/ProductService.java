package profitCalculation.service;

public interface ProductService {

    boolean purchaseProducts(String category, String amountProducts, String priceProduct, String purchaseDate);
    boolean demandProducts(String category, String amountProducts, String priceProduct, String saleDate);
}

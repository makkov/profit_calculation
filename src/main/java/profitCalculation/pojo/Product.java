package profitCalculation.pojo;

public class Product {

    Integer id;
    Integer category;
    Integer price;
    String date;
    boolean productIsSold;

    public Product(Integer id, Integer category, Integer price, String date) {
        this.id = id;
        this.category = category;
        this.price = price;
        this.date = date;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCategory() {
        return category;
    }

    public void setCategory(Integer category) {
        this.category = category;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public boolean isProductIsSold() {
        return productIsSold;
    }

    public void setProductIsSold(boolean productIsSold) {
        this.productIsSold = productIsSold;
    }
}

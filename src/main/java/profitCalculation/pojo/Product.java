package profitCalculation.pojo;

public class Product {

    private Integer id;
    private Integer categoryId;
    private Integer pricePurchase;
    private String datePurchase;
    private Integer priceDemand;
    private String dateDemand;

    public Product(Integer id, Integer categoryId, Integer pricePurchase, String datePurchase) {
        this.id = id;
        this.categoryId = categoryId;
        this.pricePurchase = pricePurchase;
        this.datePurchase = datePurchase;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public Integer getPricePurchase() {
        return pricePurchase;
    }

    public void setPricePurchase(Integer pricePurchase) {
        this.pricePurchase = pricePurchase;
    }

    public String getDatePurchase() {
        return datePurchase;
    }

    public void setDatePurchase(String datePurchase) {
        this.datePurchase = datePurchase;
    }

    public Integer getPriceDemand() {
        return priceDemand;
    }

    public void setPriceDemand(Integer priceDemand) {
        this.priceDemand = priceDemand;
    }

    public String getDateDemand() {
        return dateDemand;
    }

    public void setDateDemand(String dateDemand) {
        this.dateDemand = dateDemand;
    }
}

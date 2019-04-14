package profitCalculation.pojo;

public class Transaction {

    Integer id;
    Integer category;
    Integer sum;
    String date;

    public Transaction(Integer id, Integer category, Integer sum, String date) {
        this.id = id;
        this.category = category;
        this.sum = sum;
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

    public Integer getSum() {
        return sum;
    }

    public void setSum(Integer sum) {
        this.sum = sum;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}

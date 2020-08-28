package model.bean;


public class Product {
    private int id;
    private String description;
    private int amount;
    private double value;
    private Category category;

    public Product(){
        
    }
    public Product( String description, int amount, double value, Category category) {
        this.description = description;
        this.amount = amount;
        this.value = value;
        this.category = category;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
    
    
}

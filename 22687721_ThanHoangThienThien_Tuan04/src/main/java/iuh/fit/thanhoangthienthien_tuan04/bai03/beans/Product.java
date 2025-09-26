package iuh.fit.thanhoangthienthien_tuan04.bai03.beans;

public class Product {

    private int id;
    private String model;
    private double price;
    private int quantity;
    private String description;
    private String image;

    public Product() {
    }


    public Product(int id, String model, double price, int quantity, String description, String image) {
        this.id = id;
        this.model = model;
        this.price = price;
        this.quantity = quantity;
        this.description = description;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModal(String model) {
        this.model = model;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", modal='" + model + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                ", description='" + description + '\'' +
                ", image='" + image + '\'' +
                '}';
    }
}

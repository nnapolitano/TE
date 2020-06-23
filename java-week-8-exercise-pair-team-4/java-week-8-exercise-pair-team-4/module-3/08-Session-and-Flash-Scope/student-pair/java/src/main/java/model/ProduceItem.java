package model;

public class ProduceItem {

    private int id;
    private String name;
    private Double price;
    private String imageName;

    public ProduceItem(String name, Double price) {
        this.name = name;
        this.price = price;

    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }
}

package product;

public class Product {
    private int codeProduct;
    private static int autoId = 1;
    private String nameProduct;
    private double price;
    private int quantity;
    private String describe;



    public Product(String nameProduct, double price, int quantity, String describe) {
        this.codeProduct = autoId++;
        this.nameProduct = nameProduct;
        this.price = price;
        this.quantity = quantity;
        this.describe = describe;
    }

    public Product(int i, String ch, double v, int i1, String ch1) {
    }

    public int getCodeProduct() {
        return codeProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }


    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }


    public void setDescribe(String describe) {
        this.describe = describe;
    }

    @Override
    public String toString() {
        return "Product{" +
                "codeProduct=" + codeProduct +
                ", nameProduct='" + nameProduct + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                ", describe='" + describe + '\'' +
                '}';
    }
    public String writeFileCSV(){
        return codeProduct + "," + nameProduct + "," + price + "," + quantity + "," + describe;
    }
}

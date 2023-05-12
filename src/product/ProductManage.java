package product;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class ProductManage implements ProductInterface<Product>{
    public static Scanner scanner;
    private ArrayList<Product> products;

    public ProductManage(Scanner scanner, ArrayList<Product> products) {
        this.scanner = scanner;
        this.products = products;
    }

    public ProductManage() {
        products = new ArrayList<>();
        scanner =new Scanner(System.in);
    }

    @Override
    public Product create() {
        System.out.println("Nhập tên sản phẩm: ");
        String name = scanner.nextLine();

        System.out.println("Nhập giá sản phẩm: ");
        double price = Double.parseDouble(scanner.nextLine());

        System.out.println("Nhập số lượng sản phẩm: ");
        int quantity = Integer.parseInt(scanner.nextLine());

        System.out.println("Nhập mô tả sản phẩm: ");
        String describe = scanner.nextLine();

        Product product = new Product(name,price,quantity,describe);
        products.add(product);
        System.out.println("Đã thêm thành công.");
        return null;
    }

    @Override
    public Product update() {
        displayAll();
        System.out.println("Nhập mã cần sửa: ");
        int codeProduct = Integer.parseInt(scanner.nextLine());
        for (Product product:products) {
            if(product.getCodeProduct() == codeProduct) {
                System.out.println("Nhập tên sản phẩm mới: ");
                String name = scanner.nextLine();
                product.setNameProduct(name);

                System.out.println("Nhập giá mới cho sản phẩm: ");
                double price = Double.parseDouble(scanner.nextLine());
                product.setPrice(price);

                System.out.println("Nhập số lượng mới cho sản phẩm: ");
                int quantity = Integer.parseInt(scanner.nextLine());
                product.setQuantity(quantity);

                System.out.println("Nhập mô tả mới cho sản phẩm: ");
                String describe = scanner.nextLine();
                product.setDescribe(describe);
                System.out.println("Đã sửa thành công!");
            }
            else {
                System.out.println("Không tìm thấy mã sản phẩm.");
            }
        }

        return null;
    }

    @Override
    public Product delete() {
        System.out.println("Nhập mã cần xoá:");
        int codeProduct = Integer.parseInt(scanner.nextLine());

        for (Product product:products) {
            if(product.getCodeProduct() == codeProduct){
                System.out.println("Bạn có chắc chắn muốn xoá: (Y)");
                String confirmation = scanner.nextLine();
                if(confirmation.equalsIgnoreCase("Y")) {
                    products.remove(product);
                    System.out.println("Đã xoá thành công.");
                }
            }
        }
        return null;
    }

    @Override
    public Product getByID() {
        return null;
    }

    @Override
    public void displayAll() {
        for (Product product:products) {
            System.out.println(product);
        }
    }
    public void sortByPriceIncrease(){
        products.sort((o1, o2) -> {
            if (o1.getPrice() > o2.getPrice())
            return 1;
            else if(o1.getPrice() < o2.getPrice())
                return -1;
            else return 0;
        });
    }

    public void sortByPriceDecrease(){
        products.sort(new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                if(o1.getPrice() <  o2.getPrice())
                    return 1;
                else if(o1.getPrice() > o2.getPrice())
                    return -1;
                else
                return 0;
            }
        });
    }

    public void searchByMaxPrice(){
        double maxPrice = Double.parseDouble(scanner.nextLine());
        for (Product product:products) {
            if (product.getPrice() > maxPrice) {
                maxPrice = product.getPrice();
            }
        }
            for(Product product:products){
                if(product.getPrice() == maxPrice){
                    System.out.println(product);
                }
            }
    }


    public void writeFileCSV(){
        File file = new File("/Users/viquoclam/IdeaProjects/casestudy2/src/product/product.csv");
        try{
            if(!file.exists()){
                throw new FileNotFoundException();
            }
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
            for (Product product:products) {
                bufferedWriter.write(product.writeFileCSV() + "\n");
            }
                bufferedWriter.close();
        }catch (IOException e){
            System.out.println("Error" + e.getMessage());
        }
    }

    public void readFileCSV(){
        File file = new File("/Users/viquoclam/IdeaProjects/casestudy2/src/product/product.csv");
        try{
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null){
                String[] ch = line.split(",");
                products.add(new Product(Integer.parseInt(ch[0]), ch[1], Double.parseDouble(ch[2]) , Integer.parseInt(ch[3]),
                        ch[4]));
            }
        }catch (IOException e){

        }
    }
}

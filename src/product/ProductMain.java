package product;

import java.util.Scanner;

public class ProductMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ProductManage productManage = new ProductManage();

        do{
            System.out.println("---- CHƯƠNG TRÌNH QUẢN LÝ SẢN PHẨM ----");
            System.out.println("Chọn chức năng theo số (để tiếp tục)");
            System.out.println("1. Xem danh sách.");
            System.out.println("2. Thêm mới.");
            System.out.println("3. Cập nhật");
            System.out.println("4. Xoá.");
            System.out.println("5. Sắp xếp giá tăng dần: ");
            System.out.println("6. Sắp xếp giá giảm dần: ");
            System.out.println("7. Tìm sản phẩm có giá đắt nhất.");
            System.out.println("8. Đọc từ file.");
            System.out.println("9. Ghi vào file.");
            System.out.println("10. Thoát.");
            System.out.println("Chọn chức năng:");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice){
                case 1:
                    productManage.displayAll();
                    break;
                case 2:
                    productManage.create();
                    break;
                case 3:
                    productManage.update();
                    break;
                case 4:
                    productManage.delete();
                    break;
                case 5:
                    productManage.sortByPriceIncrease();
                    break;
                case 6:
                    productManage.sortByPriceDecrease();
                    break;
                case 7:
                    productManage.searchByMaxPrice();
                    break;
                case 8:
                    productManage.writeFileCSV();
                    break;
                case 9:

                    break;
                case 0:
                    System.exit(0);
                    System.out.println("Thoát!");
            }
        }while (true);
    }
}

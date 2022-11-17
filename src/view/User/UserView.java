package view.User;

import model.User;
import service.UserService;
import view.Product.ManagerProductView;

import java.util.Scanner;

public class UserView {
    public static Scanner scanner = new Scanner(System.in);
    public static ManagerProductView managerProductView = new ManagerProductView();

    public static User user = new User();
    public static UserService userService = new UserService();
    public static OrderView OrderView = new OrderView();


    public void MenuUser() {
        try {
        System.out.println("\t----------------------------------------------------------");
        System.out.println("\t--░░░░░░░░░░░░░░░[TRANG CÁ NHÂN CỦA BẠN]░░░░░░░░░░░░░░░░--");
        System.out.println("\t----------------------------------------------------------");
        System.out.println("\t--                                                      --");
        System.out.println("\t--               【1】. HIỂN THỊ DANH SÁCH SẢN PHẨM      --");
        System.out.println("\t--               【2】. TẠO ĐƠN HÀNG                     --");
        System.out.println("\t--               【3】. LỊCH SỬ ORDER SẢN PHẨM           --");
        System.out.println("\t--               【0】. THOÁT                            --");
        System.out.println("\t--                                                      --");
        System.out.println("\t----------------------------------------------------------");
        int choice;

        do {
            System.out.print("CHỌN SỐ : ");
             choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        managerProductView.showALl();
                        MenuUser();
                        break;
                    case 2:
                        OrderView.MenutaoDonHang();
                        MenuUser();
                        break;
                    case 3:
                        OrderView.getHistoryOrder();
                        MenuUser();
                        break;
                    case 0:
                        System.out.println("HẸN GẶP LẠI");
                        System.exit(5);
                }

        } while (choice != 0);
        } catch (Exception e) {
            System.out.println("NHẬP SAI , XIN NHẬP LẠI");
        }
    }

}

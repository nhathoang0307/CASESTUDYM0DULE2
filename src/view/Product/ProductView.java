package view.Product;

import utils.AppUtils;
import view.User.OrderView;

import java.util.Scanner;

public class ProductView {
    public static Scanner scanner = new Scanner(System.in);
    public static ManagerUserView managerUserView = new ManagerUserView();
    public static ManagerProductView managerProductView = new ManagerProductView();

    OrderView OrderView = new OrderView();
    String choice;
    public void MenuAdmin() {
        System.out.println("\t|»»»»»»»»»»»»»»»»»»»»»[DANH SÁCH QUẢN LÝ CỦA ADMIN]«««««««««««««««««««|");
        System.out.println("\t|                                                                     |");
        System.out.println("\t|                     【1】. QUẢN LÝ SẢN PHẨM                          |");
        System.out.println("\t|                     【2】. QUẢN LÍ ĐƠN ĐẶT HÀNG                      |");
        System.out.println("\t|                     【3】. QUẢN LÍ NGƯỜI DÙNG                        |");
        System.out.println("\t|                     【0】. THOÁT CHƯƠNG TRÌNH                        |");
        System.out.println("\t|                                                                     |");
        System.out.println("\t|*********************************************************************|");
        System.out.print("►►►►►► Chọn số: ");
        do {
            try {
                choice = AppUtils.beNotEmply("");
                switch (choice) {
                    case "1":
                        managerProductView.menuProduct();
                        break;
                    case "2":
                        OrderView.hienThiDonHang();
                        break;
                    case "3":
                        managerUserView.menuUser();;
                        break;
                    case "0":
                        System.out.println("♫♫♫♫♫♫ HẸN GẶP LẠI ♫♫♫♫♫♫");
                        System.exit(5);
                }
            } catch (Exception e) {
                System.out.println("☼☼☼ NHẬP KHÔNG ĐÚNG, XIN NHẬP LẠI (CHỌN SỐ THEO DANH SÁCH Ở TRÊN) ☼☼☼");
            }
        } while (choice != "0");
    }
}

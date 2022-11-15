package view.User;

import com.sun.javafx.css.PseudoClassState;
import model.User;
import service.UserService;
import view.Product.QuanLiSanPhamView;

import java.util.Scanner;

public class UserView {
    public static Scanner scanner = new Scanner(System.in);
    public static QuanLiSanPhamView quanLiSanPhamView = new QuanLiSanPhamView();

    public static User user = new User();
    public static UserService userService = new UserService();
    public static taoDonHangView taoDonHangView = new taoDonHangView();


    public void MenuUser() {
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
        System.out.print("CHỌN SỐ : ");
        int choice = Integer.parseInt(scanner.nextLine());
        do {
            try {
                switch (choice) {
                    case 1:
                        quanLiSanPhamView.showALl();
                        MenuUser();
                        break;
                    case 2:
                        taoDonHangView.MenutaoDonHang();
                        MenuUser();
                        break;
                    case 3:
                        taoDonHangView.getHistoryOrder();
                        MenuUser();
                        break;
                    case 0:
                        System.out.println("HẸN GẶP LẠI");
                        System.exit(5);
                }
            } catch (Exception e) {
                System.out.println("NHẬP SAI , XIN NHẬP LẠI");
            }
        } while (choice != 0);

    }

}

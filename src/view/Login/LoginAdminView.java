package view.Login;

import service.UserService;
import utils.AppUtils;
import view.Product.ProductView;

import java.util.Scanner;

public class LoginAdminView {
    public static Scanner scanner = new Scanner(System.in);
    private static UserService userService = new UserService();
    private static LoginView loginView = new LoginView();

    private static ProductView productView = new ProductView();



    public static void loginAdmin() {
        boolean checkLogin;
        System.out.println("**************************** [ĐĂNG NHẬP ADMIN] ****************************");
        do {
            System.out.print("►►►►►► NHẬP TÀI KHOẢN: ");
            String name = AppUtils.beNotEmply(" ☼☼☼ TÀI KHOẢN");
            System.out.print("►►►►►► NHẬP MẬT KHẨU: ");
            String password = AppUtils.beNotEmply("☼☼☼ MẬT KHẨU");
            if (userService.adminLogin(name, password) != null) {
                System.out.println("»»»»»» ĐĂNG NHẬP THÀNH CÔNG ««««««");
                productView.MenuAdmin();
                checkLogin = false;
            } else {
                System.out.println("»»»»»» TÀI KHOẢN KHÔNG HỢP LỆ, VUI LÒNG CHỌN LẠI ««««««" );
                checkLogin = retryLogin();
            }
        }while (checkLogin);

    }

    public static boolean retryLogin() {
        do {
            try {

                System.out.println("\t**************************************************");
                System.out.println("\t|            【1】. ĐĂNG NHẬP LẠI                 |");
                System.out.println("\t|            【2】. QUAY LẠI                      |");
                System.out.println("\t|            【3】. THOÁT CHƯƠNG TRÌNH            |");
                System.out.println("\t**************************************************");
                System.out.print("►►►►►► Chọn số: ");
                String choice = scanner.nextLine();
                switch (choice) {
                    case "1":
                        return true;
                    case "2":
                        loginView.login();
                        break;
                    case "0":
                        System.out.println("♫♫♫♫♫ CHÀO TẠM BIỆT, HẸN GẶP LẠI ♫♫♫♫♫");
                        System.exit(5);
                        break;
                    default:
                        System.out.println("☼☼☼ NHẬP KHÔNG ĐÚNG, XIN NHẬP LẠI (CHỌN SỐ THEO DANH SÁCH Ở TRÊN) ☼☼☼");
                }
            } catch (Exception e) {
                System.out.println("☼☼☼ NHẬP KHÔNG ĐÚNG, XIN NHẬP LẠI (CHỌN SỐ THEO DANH SÁCH Ở TRÊN) ☼☼☼");
            }
        } while (true);
    }


}

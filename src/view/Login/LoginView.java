package view.Login;

import java.util.Scanner;

public class LoginView {
    public static Scanner scanner = new Scanner(System.in);
    public static LoginAdminView loginAdminView = new LoginAdminView();
    public static LoginUserView loginUserView = new LoginUserView();
    public void login() {
        System.out.println("\t-------------------------------------------------");
        System.out.println("\t--      【1】. ĐĂNG NHẬP ADMIN                  --");
        System.out.println("\t--      【2】. ĐĂNG NHẬP USER                   --");
        System.out.println("\t--      【3】. THOÁT                            --");
        System.out.println("\t-------------------------------------------------");
        System.out.print("Chọn số: ");
        boolean check = false;
        do {
            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    loginAdminView.loginAdmin();
                    check = true;
                    break;
                case "2":
                    loginUserView.loginUser();
                    check = true;
                    break;
                case "3":
                    System.exit(5);
                    break;
                default:
                    check = false;
                    System.out.println("NHẬP KHÔNG ĐÚNG, XIN NHẬP LẠI");

            }
        } while (check == false);

    }

}
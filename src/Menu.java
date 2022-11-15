import com.sun.org.apache.xpath.internal.operations.Or;
import model.Order;
import model.OrderItem;
import model.Product;
import model.User;
import service.OrderItemService;
import service.OrderService;
import service.ProductService;
import service.UserService;
import view.Login.LoginUserView;
import view.Login.LoginView;

import java.util.Scanner;

public class Menu {
    public static Scanner scanner = new Scanner(System.in);
    public static OrderService orderService;

    public static void main(String[] args) {
        LoginView loginView = new LoginView();
        loginView.login();

//        LoginUserView loginUserView = new LoginUserView();
    }
}
//                if (userName.equals() && password.equals())
//                System.out.println("ĐĂNG NHẬP THÀNH CÔNG");
//                System.out.println("\t----------------------------------------------------------");
//                System.out.println("\t--░░░░░░░░░░░░░░░░░░░░[DANH SÁCH QUẢN LÝ]░░░░░░░░░░░░░░░--");
//                System.out.println("\t----------------------------------------------------------");
//                System.out.println("\t--                                                      --");
//                System.out.println("\t--               【1】. QUẢN LÍ NGƯỜI DÙNG               --");
//                System.out.println("\t--               【2】. QUẢN LÝ SẢN PHẨM                 --");
//                System.out.println("\t--               【3】. QUẢN LÍ ĐƠN ĐẶT HÀNG             --");
//                System.out.println("\t--               【0】. THOÁT CHƯƠNG TRÌNH               --");
//                System.out.println("\t--                                                      --");
//                System.out.println("\t----------------------------------------------------------");
//                System.out.print("░░░░░░░░░░░░░░░░░░░░░░░░░░  CHỌN SỐ : ");
//                int chonDSQL = Integer.parseInt(scanner.nextLine());
//                switch (chonDSQL) {
//                    case 1:
//                        System.out.println("------------------------ [QUẢN LÍ NGƯỜI DÙNG] ------------------------");
//                        System.out.println("1. THÊM NGƯỜI DÙNG");
//                        System.out.println("2. SỬA THÔNG TIN NGƯỜI DÙNG");
//                        System.out.println("3. XÓA NGƯỜI DÙNG");
//                        System.out.println("4. HIỂN THỊ THÔNG TIN NGƯỜI DÙNG");
//                        System.out.println("5. QUAY LẠI MENU");
//                        System.out.println("0. THOÁT CHƯƠNG TRÌNH");
//                        Integer chonQLNG = Integer.parseInt(scanner.nextLine());
//                        switch (chonQLNG) {
//                            case 1:
//                                System.out.println("1. THÊM NGƯỜI DÙNG");
//                                break;
//                            case 2:
//                                System.out.println("2. SỬA THÔNG TIN NGƯỜI DÙNG");
//                                break;
//                            case 3:
//                                System.out.println("3. XÓA NGƯỜI DÙNG");
//                                break;
//                            case 4:
//                                System.out.println("4. HIỂN THỊ THÔNG TIN NGƯỜI DÙNG");
//                                break;
//                            case 5:
//                                System.out.println("5. QUAY LẠI");
//                                break;
//                            case 6:
//                                System.out.println("0. THOÁT CHƯƠNG TRÌNH");
//                                break;
//                        }
//                    case 2:
//                        System.out.println("\t--               【2】. QUẢN LÝ SẢN PHẨM                 --");
//                        System.out.println("\t--------------------------------------------------------------------------------------");
//                        System.out.println("\t--                                                                                  --");
//                        System.out.println("\t--                             【1】. HIỂN THỊ SẢN PHẨM                              --");
//                        System.out.println("\t--                             【2】. THÊM SẢN PHẨM                                  --");
//                        System.out.println("\t--                             【3】. SỬA SẢN PHẨM                                   --");
//                        System.out.println("\t--                             【4】. XÓA SẢN PHẨM                                   --");
//                        System.out.println("\t--                             【5】. SẮP XẾP TĂNG DẦN THEO GIÁ                      --");
//                        System.out.println("\t--                             【6】. SẮP XẾP GIẢM DẦN THEO GIÁ                      --");
//                        System.out.println("\t--                             【7】. TÌM KIẾM THEO ID                               --");
//                        System.out.println("\t--                             【8】. QUAY LẠI MENU                                  --");
//                        System.out.println("\t--                             【0】. THOÁT CHƯƠNG TRÌNH                             --");
//                        System.out.println("\t--                                                                                  --");
//                        System.out.println("\t--------------------------------------------------------------------------------------");
//                        Integer chonQLSP = Integer.parseInt(scanner.nextLine());
//                        switch (chonQLSP) {
//                            case 1:
//                                System.out.println("\t--  【1】. HIỂN THỊ SẢN PHẨM                              --");
//                                break;
//                            case 2:
//                                System.out.println("\t--  【2】. THÊM SẢN PHẨM                                  --");
//                                break;
//                            case 3:
//                                System.out.println("\t--   【3】. SỬA SẢN PHẨM                                   --");
//                                break;
//                            case 4:
//                                System.out.println("\t--   【4】. XÓA SẢN PHẨM                                   --");
//                                break;
//                            case 5:
//                                System.out.println("\t--   【5】. SẮP XẾP TĂNG DẦN THEO GIÁ                      --");
//                                break;
//                            case 6:
//                                System.out.println("\t--   【6】. SẮP XẾP GIẢM DẦN THEO GIÁ                      --");
//                                break;
//                            case 7:
//                                System.out.println("\t--   【7】. TÌM KIẾM THEO ID                               --");
//                                break;
//                            case 8:
//                                System.out.println("\t--   【8】. QUAY LẠI MENU                                  --");
//                                break;
//                            case 0:
//                                System.out.println("\t--   【0】. THOÁT CHƯƠNG TRÌNH                             --");
//                                break;
//                        }
//                    case 3:
//                        System.out.println("\t--               【3】. QUẢN LÍ ĐƠN ĐẶT HÀNG             --");
//                        System.out.println("1. XEM DANH SÁCH ĐƠN HÀNG");
//                        System.out.println("2. QUAY LẠI MENU");
//                        System.out.println("3. THOÁT CHƯƠNG TRÌNH");
//                        int chonQLDDH = Integer.parseInt(scanner.nextLine());
//                        switch (chonQLDDH) {
//                            case 1:
//                                System.out.println("XEM DANH SÁCH ĐƠN HÀNG");
//                                break;
//                            case 2:
//                                System.out.println("QUAY LẠI");
//                                break;
//                            case 3:
//                                System.out.println("THOÁT");
//                                break;
//                        }
//                }
//            case 2:
//                System.out.println("------------------------ [ĐĂNG NHẬP USER] ------------------------");
//                System.out.print("Nhập tài khoản: ");
//                String tkUser = scanner.nextLine();
//                System.out.print("Nhập mật khẩu: ");
//                String mkUser = scanner.nextLine();
//                System.out.println("ĐĂNG NHẬP THÀNH CÔNG");
//                System.out.println("\t----------------------------------------------------------");
//                System.out.println("\t--░░░░░░░░░░░░░░░░░░░░[TẠO ĐƠN SẢN PHẨM]░░░░░░░░░░░░░░░--");
//                System.out.println("\t----------------------------------------------------------");
//                System.out.println("\t--                                                      --");
//                System.out.println("\t--               【1】. HIỂN THỊ DANH SÁCH SẢN PHẨM      --");
//                System.out.println("\t--               【2】. TẠO ĐƠN SẢN PHẨM                 --");
//                System.out.println("\t--               【3】. LỊCH SỬ TẠO ĐƠN HÀNG             --");
//                System.out.println("\t--               【0】. THOÁT CHƯƠNG TRÌNH               --");
//                System.out.println("\t--                                                      --");
//                System.out.println("\t----------------------------------------------------------");
//                int chonQLDH = Integer.parseInt(scanner.nextLine());
//                switch (chonQLDH) {
//                    case 1:
//                        System.out.println("\t--               【1】. HIỂN THỊ DANH SÁCH SẢN PHẨM      --");
//                        break;
//                    case 2:
//                        System.out.println("\t--               【2】. TẠO ĐƠN SẢN PHẨM                 --");
//                        System.out.print("NHẬP TÊN KHÁCH HÀNG: ");
//                        String tenKH = scanner.nextLine();
//                        System.out.print("NHẬP SỐ ĐIỆN THOẠI: ");
//                        String sdtKH = scanner.nextLine();
//                        System.out.print("NHẬP ĐỊA CHỈ: ");
//                        String diachiKH = scanner.nextLine();
//                        System.out.println("ĐÂY LÀ DANH SÁCH SẢN PHẨM");
//                        System.out.print("NHẬP ID SẢN PHẨM CẦN MUA:");
//                        int idSanPham = Integer.parseInt(scanner.nextLine());
//                        System.out.print("NHẬP SỐ LƯỢNG: ");
//                        int soLuong = Integer.parseInt(scanner.nextLine());
//                        break;
//                    case 3:
//                        System.out.println("\t--               【3】. LỊCH SỬ TẠO ĐƠN HÀNG             --");
//                        break;
//                    case 0:
//                        System.out.println("\t--               【0】. THOÁT CHƯƠNG TRÌNH               --");
//                        break;
//                }


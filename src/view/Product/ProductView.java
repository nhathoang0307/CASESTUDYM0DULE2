package view.Product;

import view.User.taoDonHangView;

import java.util.Scanner;

public class ProductView {
    public static Scanner scanner = new Scanner(System.in);
    public static QuanLiNguoiDungView quanLiNguoiDungView = new QuanLiNguoiDungView();
    public static QuanLiSanPhamView quanLiSanPhamView = new QuanLiSanPhamView();

    taoDonHangView taoDonHangView = new taoDonHangView();
    int choice;
    public void MenuAdmin() {
        System.out.println("\t----------------------------------------------------------");
        System.out.println("\t--░░░░░░░░░░░░░░░░░░░░[DANH SÁCH QUẢN LÝ]░░░░░░░░░░░░░░░--");
        System.out.println("\t----------------------------------------------------------");
        System.out.println("\t--                                                      --");
        System.out.println("\t--               【1】. QUẢN LÝ SẢN PHẨM                 --");
        System.out.println("\t--               【2】. QUẢN LÍ ĐƠN ĐẶT HÀNG             --");
        System.out.println("\t--               【3】. QUẢN LÍ NGƯỜI DÙNG               --");
        System.out.println("\t--               【0】. THOÁT CHƯƠNG TRÌNH               --");
        System.out.println("\t--                                                      --");
        System.out.println("\t----------------------------------------------------------");
        System.out.print("░░░░░░░░░░░░░░░░░░░░░░░░░░  CHỌN SỐ : ");
        do {
            try {
                choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        quanLiSanPhamView.menuProduct();
                        break;
                    case 2:
                        taoDonHangView.hienThiDonHang();
                        break;
                    case 3:
                        quanLiNguoiDungView.menuUser();;
                        break;
                    case 0:
                        System.out.println("HẸN GẶP LẠI");
                        System.exit(5);
                }
            } catch (Exception e) {
                System.out.println("NHẬP SAI, XIN NHẬP LẠI");
            }
        } while (choice != 0);
    }
}

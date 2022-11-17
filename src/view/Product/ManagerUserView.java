package view.Product;

import model.Role;
import model.User;
import service.IUserService;
import service.UserService;
import utils.AppUtils;
import utils.InstantUtils;
import utils.ValidateUtils;

import java.util.Scanner;

public class ManagerUserView {
    public static Scanner scanner = new Scanner(System.in);
    private final IUserService userService;
    public static ProductView productView = new ProductView();


    public ManagerUserView() {
        userService = UserService.getUserService();
    }

    public void menuUser() {
        int number;
        System.out.println("");
        System.out.println("\t|»»»»»»»»»»»»»»»»»»»»»[DANH SÁCH NGƯỜI DÙNG]«««««««««««««««««««|");
        System.out.println("\t|                                                              |");
        System.out.println("\t|               【1】. HIỂN THỊ NGƯỜI DÙNG                      |");
        System.out.println("\t|               【2】. THÊM NGƯỜI DÙNG                          |");
        System.out.println("\t|               【3】. SỬA NGƯỜI DÙNG                           |");
        System.out.println("\t|               【4】. XÓA NGƯỜI DÙNG                           |");
        System.out.println("\t|               【5】. QUAY LẠI MENU                            |");
        System.out.println("\t|               【0】. THOÁT CHƯƠNG TRÌNH                       |");
        System.out.println("\t|                                                              |");
        System.out.println("\t|**************************************************************|");
        do {
            System.out.print("►►►►►► Chọn số: ");
            number = Integer.parseInt(scanner.nextLine());
            switch (number) {
                case 1:
                    showAllUser();
                    menuUser();
                    break;
                case 2:
                    addUser();
                    menuUser();
                    break;
                case 3:
                    updateUser();
                    menuUser();
                    break;
                case 4:
                    removeUser();
                    menuUser();
                    break;
                case 5:
                    productView.MenuAdmin();
                    break;
                case 0:
                    AppUtils.exit();
                    break;
            }
        } while (number != 0);
    }

    public void removeUser() {
        do {
            showAllUser();
            System.out.print("►►►►►► NHẬP ID CẦN XÓA: ");
            Long idUserDel = inputId();
            userService.removeUser(idUserDel);
            System.out.println("»»»»»» BẠN ĐÃ XÓA SẢN PHẨM THÀNH CÔNG ««««««");
        } while (AppUtils.isRetry());
    }

    public void updateUser() {
        boolean isRetry = false;
        do {
            try {
                showAllUser();
                System.out.print("►►►►►► NHẬP ID CẦN THAY ĐỔI: ");
                Long id = inputId();
                System.out.println("\t----------------------------------------------------------");
                System.out.println("\t--░░░░░░░░░░░░░░░░░░░[THAY ĐỔI NGƯỜI DÙNG]░░░░░░░░░░░░░░--");
                System.out.println("\t----------------------------------------------------------");
                System.out.println("\t--                                                      --");
                System.out.println("\t--               【1】. THAY ĐỔI TÊN                     --");
                System.out.println("\t--               【2】. THAY ĐỔI SỐ ĐIỆN THOẠI           --");
                System.out.println("\t--               【3】. THAY ĐỔI ĐỊA CHỈ                 --");
                System.out.println("\t--               【4】. THAY ĐỔI EMAIL                   --");
                System.out.println("\t--               【5】. THAY ĐỔI TẤT CẢ                  --");
                System.out.println("\t--               【6】. QUAY LẠI                         --");
                System.out.println("\t--               【0】. THOÁT CHƯƠNG TRÌNH               --");
                System.out.println("\t--                                                      --");
                System.out.println("\t----------------------------------------------------------");

                System.out.println("\t|»»»»»»»»»»»»»»»»»»»»»[THAY ĐỔI NGƯỜI DÙNG]«««««««««««««««««««|");
                System.out.println("\t|                                                             |");
                System.out.println("\t|                    【1】. THAY ĐỔI TÊN                       |");
                System.out.println("\t|                    【2】. THAY ĐỔI SỐ ĐIỆN THOẠI             |");
                System.out.println("\t|                    【3】. THAY ĐỔI ĐỊA CHỈ                   |");
                System.out.println("\t|                    【4】. THAY ĐỔI EMAIL                     |");
                System.out.println("\t|                    【5】. THAY ĐỔI TẤT CẢ                    |");
                System.out.println("\t|                    【6】. QUAY LẠI MENU                      |");
                System.out.println("\t|                    【0】. THOÁT CHƯƠNG TRÌNH                 |");
                System.out.println("\t|                                                             |");
                System.out.println("\t|*************************************************************|");
                System.out.print("►►►►►► Chọn số: ");
                int option = AppUtils.retryChoose(0, 6);
                User newUser = new User();
                newUser.setId(id);
                String name;
                String phone;
                String address;
                String email;
                switch (option) {
                    case 1:
                        name = inputFullName();
                        newUser.setFullName(name);
                        userService.update(newUser);
                        System.out.println("»»»»»» THAY ĐỔI TÊN THÀNH CÔNG ««««««");
                        break;
                    case 2:
                        phone = inputPhone();
                        newUser.setMobile(phone);
                        userService.update(newUser);
                        System.out.println("»»»»»» THAY ĐỔI SỐ ĐIỆN THOẠI THÀNH CÔNG ««««««");
                        break;
                    case 3:
                        address = inputAddress();
                        newUser.setAddress(address);
                        userService.update(newUser);
                        System.out.println("»»»»»» THAY ĐỔI ĐỊA CHỈ THÀNH CÔNG ««««««");
                        break;
                    case 4:
                        email = inputEmail();
                        newUser.setEmail(email);
                        userService.update(newUser);
                        System.out.println("»»»»»» THAY ĐỔI EMAIL THÀNH CÔNG ««««««");
                        break;
                    case 5:
                        name = inputFullName();
                        newUser.setFullName(name);
                        phone = inputPhone();
                        newUser.setMobile(phone);
                        address = inputAddress();
                        newUser.setAddress(address);
                        email = inputEmail();
                        newUser.setEmail(email);
                        userService.update(newUser);
                        System.out.println("»»»»»» THAY ĐỔI THÀNH CÔNG ««««««");
                }
                isRetry = option != 5 && AppUtils.isRetry();

            } catch (Exception e) {
                System.out.println("☼☼☼ NHẬP KHÔNG ĐÚNG, XIN NHẬP LẠI (CHỌN SỐ THEO DANH SÁCH Ở TRÊN) ☼☼☼");
            }
        } while (isRetry);
    }

    public void addUser() {
        try {
            Long id = System.currentTimeMillis() / 1000;
            String username = inputUsername();
            String password = inputPassword();
            String fullName = inputFullName();
            String phone = inputPhone();
            String address = inputAddress();
            String email = inputEmail();
            User user = new User(id, username, password, fullName, phone, email, address, Role.USER);
            setRole(user);
            userService.add(user);
            System.out.println("»»»»»» ĐÃ THÊM USER THÀNH CÔNG ««««««");
        } catch (Exception ex) {
            System.out.println("☼☼☼ NHẬP SAI, XIN NHẬP LẠI☼☼☼ ");
        }
    }

    public void setRole(User user) {
        System.out.println("\t----------------------------------------------------------");
        System.out.println("\t--░░░░░░░░░░░░░░░░░[PHÂN QUYỀN NGƯỜI DÙNG]░░░░░░░░░░░░░░--");
        System.out.println("\t----------------------------------------------------------");
        System.out.println("\t--                                                      --");
        System.out.println("\t--               【1】. THÀNH VIÊN                       --");
        System.out.println("\t--               【2】. QUẢN TRỊ VIÊN                    --");
        System.out.println("\t--                                                      --");
        System.out.println("\t----------------------------------------------------------");
        System.out.println("");
        System.out.println("\t|»»»»»»»»»»»»»»»»»»»»»[PHÂN QUYỀN NGƯỜI DÙNG]«««««««««««««««««««|");
        System.out.println("\t|                                                               |");
        System.out.println("\t|                      【1】. THÀNH VIÊN                         |");
        System.out.println("\t|                      【2】. QUẢN TRỊ VIÊN                      |");
        System.out.println("\t|                                                               |");
        System.out.println("\t|***************************************************************|");
        System.out.print("►►►►►► Chọn số: ");
        String option = scanner.nextLine();
        switch (option) {
            case "1":
                user.setRole(Role.USER);
                break;
            case "2":
                user.setRole(Role.ADMIN);
                break;
            default:
                System.out.println("NHẬP KHÔNG ĐÚNG, XIN NHẬP LẠI (CHỌN SỐ THEO DANH SÁCH Ở TRÊN)");
                setRole(user);
        }
    }

    private String inputEmail() {
        System.out.print("►►►►►► NHẬP EMAIL: ");
        String email;
        do {
            if (!ValidateUtils.isEmailValid(email = scanner.nextLine())) {
                System.out.println("☼☼☼ EMAIL CỦA BẠN KHÔNG ĐÚNG ĐỊNH DẠNG (nhathoang@gmail.com) ☼☼☼");
                System.out.print("►►►►►► NHẬP LẠI EMAIL: ");
                continue;
            }
            if (userService.existsByEmail(email)) {
                System.out.println("☼☼☼ EMAIL CỦA BẠN ĐÃ TỒN TẠI, XIN NHẬP LẠI ☼☼☼");
                System.out.print("►►►►►► NHẬP LẠI EMAIL: ");
                continue;
            }
            break;
        } while (true);
        return email;
    }

    private String inputAddress() {
        String address;
        System.out.print("►►►►►► NHẬP ĐỊA CHỈ: ");
        address = scanner.nextLine();
        do {
            if (address.trim().isEmpty()) {
                System.out.println("☼☼☼ ĐỊA CHỈ KHÔNG ĐƯỢC BỎ TRỐNG ☼☼☼");
                System.out.print("►►►►►► NHẬP LẠI ĐỊA CHỈ: ");
                address = scanner.nextLine();
            }
        } while (address.trim().isEmpty());
        return address;
    }

    public String inputPhone() {
        String phone;
        do {
            System.out.print("►►►►►► NHẬP SỐ ĐIỆN THOẠI: ");
            phone = scanner.nextLine();
            if (!ValidateUtils.isPhoneValid(phone)) {
                System.out.println("☼☼☼ SỐ CỦA BẠN KHÔNG ĐÚNG ĐỊNH DẠNG (BẮT ĐẦU LÀ SỐ 0, VÀ ĐỦ 10 SỐ) ☼☼☼ ");
                continue;
            }
            if (userService.existsByPhone(phone)) {
                System.out.println("☼☼☼ SỐ NÀY ĐÃ TỒN TẠI, XIN NHẬP LẠI ☼☼☼");
                System.out.print("►►►►►► NHẬP SỐ ĐIỆN THOẠI: ");
                continue;
            }
            break;
        } while (AppUtils.isRetry());
        return phone;
    }

    public String inputUsername() {
        System.out.print("►►►►►► NHẬP TÊN TÀI KHOẢN: ");
        String username;

        do {
            if (!ValidateUtils.isUsernameValid(username = AppUtils.retryString("TÊN TÀI KHOẢN"))) {
                System.out.println("☼☼☼ TÊN TÀI KHOẢN CỦA BẠN NHẬP KHÔNG ĐÚNG ĐỊNH DẠNG (>7 KÝ TỰ, KHÔNG BAO GỒM KÍ TỰ ĐẶC BIỆT,...) ☼☼☼");
                System.out.println("►►►►►► NHẬP TÊN TÀI KHOẢN: ");
                continue;
            }
            if (userService.existsByUsername(username)) {
                System.out.println("☼☼☼ TÊN TÀI KHOẢN NÀY ĐÃ TỒN TẠI, XIN NHẬP LẠI ☼☼☼");
                System.out.println("►►►►►► NHẬP TÊN TÀI KHOẢN: ");
                continue;
            }
            break;
        } while (true);
        return username;
    }

    private String inputPassword() {
        System.out.print("►►►►►► NHẬP MẬT KHẨU : ");
        String password;
        while (!ValidateUtils.isPasswordValid(password = scanner.nextLine())) {
            System.out.println("☼☼☼ MẬT KHẨU PHẢI > 7 KÍ TỰ ☼☼☼");
            System.out.print("►►►►►► NHẬP LẠI MẬT KHẨU: ");
        }
        return password;
    }

    private String inputFullName() {
        System.out.print("►►►►►► NHẬP HỌ VÀ TÊN: ");
        String fullName;
        while (!ValidateUtils.isNameValid(fullName = scanner.nextLine())) {
            System.out.println("☼☼☼ TÊN KHÔNG ĐÚNG ĐỊNH DẠNG (PHẢI VIẾT HOA CHỮ CÁI ĐẦU TIÊN) ☼☼☼");
            System.out.print("►►►►►► NHẬP LẠI: ");
        }
        return fullName;
    }

    private Long inputId() {
        Long id;
        boolean isRetry = false;
        do {
            id = AppUtils.retryParseLong();
            boolean exist = userService.existById(id);
            if (!exist) {
                System.out.println("☼☼☼ ID NÀY KHÔNG CÓ TRONG DANH SÁCH CẦN TÌM ☼☼☼");
                System.out.println("NHẤN 1 ĐỂ TIẾP TỤC \t|\t NHẤN 2 ĐỂ QUAY LẠI \t|\t NHẤN 0 ĐỂ THOÁT CHƯƠNG TRÌNH");
                do {
                    String choice = scanner.nextLine();
                    switch (choice) {
                        case "1":
                            inputId();
                            break;
                        case "2":
                            menuUser();
                            break;
                        case "0":
                            System.out.println("♫♫♫♫♫ CHÀO TẠM BIỆT, HẸN GẶP LẠI ♫♫♫♫♫");
                            System.exit(5);
                        default:
                            System.out.println("☼☼☼ NHẬP KHÔNG ĐÚNG, XIN NHẬP LẠI (CHỌN SỐ THEO DANH SÁCH Ở TRÊN) ☼☼☼");
                            break;
                    }
                } while (true);
            }

        } while (isRetry);
        return id;
    }

    public void showAllUser() {
        System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("%-18s %-20s %-20s %-30s %-15s %-17s %-20s",
                " ID",
                "TÊN",
                "SỐ ĐIỆN THOẠI",
                "EMAIL",
                "ĐỊA CHỈ",
                "NGƯỜI DÙNG",
                "NGÀY TẠO");
        System.out.println();
        for (User user : userService.showAllUser()) {
            System.out.printf("%-17s %-20s %-20s %-30s %-15s %-17s %-20s\n",
                    "【" + user.getId() + "】",
                    user.getFullName(),
                    user.getMobile(),
                    user.getEmail(),
                    user.getAddress(),
                    user.getRole(),
                    InstantUtils.instantToString(user.getCreatedAt()));
        }
        System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------");
    }
}

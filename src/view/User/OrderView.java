package view.User;

import model.Order;
import model.OrderItem;
import model.Product;
import model.User;
import service.*;
import utils.AppUtils;
import utils.InstantUtils;
import utils.ValidateUtils;
import view.Login.LoginUserView;
import view.Product.ManagerUserView;
import view.Product.ProductView;
import view.Product.ManagerProductView;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class OrderView {
    public static Scanner scanner = new Scanner(System.in);

    private final IProductService productService;
    private final IOrderService orderService;
    private final IOderItemService oderItemService;
    public static UserView userView = new UserView();
    public static LoginUserView loginUserView;

    public static ProductView productView = new ProductView();

    public static UserService userService = new UserService();

    public static ManagerUserView managerUserView = new ManagerUserView();

    public void changePasswordtest() {
        String checkPassOld = null;
        String passNew;
        String passNewCheck;
        User user = new User();
        user.setUsername(loginUserView.name);
        System.out.println("►►►►►► NHẬP MẬT KHẨU CŨ: ");
        String passOld = AppUtils.beNotEmply("MẬT KHẨU");
        List<User> newUser = new ArrayList<>();
        int checkcount = 0;
        for (User u : userService.showAllUser()) {
            if (passOld.equals(u.getPassword())) {
                newUser.add(u);
                checkcount++;
                break;
            }
        }
        if (checkcount == 0) {
            System.out.println("☼☼☼ MẬT KHẨU KHÔNG ĐÚNG ☼☼☼");
            userView.MenuUser();
        }

        boolean checkFlag = true;
        do {
            passNew = managerUserView.inputPassword("MỚI");
            if (passNew.equals(checkPassOld)) {
                System.out.println("►►►►►► TRÙNG MẬT KHẨU CŨ, VUI LÒNG NHẬP MẬT KHẨU MỚI ");
            } else {
                checkFlag = false;
            }
        } while (checkFlag);
        System.out.println("☼☼☼ NHẬP LẠI ĐỂ XÁC NHẬN ☼☼☼☼☼☼");
        boolean checkAgain = true;
        do {
            passNewCheck = scanner.nextLine();
            if (passNew.equals(passNewCheck)) {
                System.out.println("»»»»»» ĐỔI MẬT KHẨU THÀNH CÔNG ««««««");
                user.setPassword(passNewCheck);
                userService.updatePW(user);
                break;
            } else {
                System.out.println("☼☼☼ MẬT KHẨU KHÔNG TRÙNG ☼☼☼");
                System.out.println("►►►►►► VUI LÒNG NHẬP LẠI: ");
                checkAgain = true;
            }
        } while (checkAgain);
    }

    public void changePassword() {
        do {
            System.out.println("►►►►►► NHẬP MẬT KHẨU CŨ: ");
            String passOld = AppUtils.beNotEmply("MẬT KHẨU");
            for (User u : userService.showAllUser()) {
                if (u.getPassword().equals(passOld)) {
                    break;
                }
                System.out.println("☼☼☼ MẬT KHẨU KHÔNG ĐÚNG ☼☼☼");
                break;
            }
            String checkPassOld = null;
            String passNew = null;
            String passNewCheck = null;
            User user = new User();
            user.setUsername(loginUserView.name);
            for (User u : userService.showAllUser()) {
                if (loginUserView.name.equals(u.getUsername())) {
                    checkPassOld = u.getPassword();
                    if (passOld.equals(checkPassOld)) {
                        boolean checkFlag = true;
                        do {
                            passNew = managerUserView.inputPassword("MỚI");
                            if (passNew.equals(checkPassOld)) {
                                System.out.println("►►►►►► TRÙNG MẬT KHẨU CŨ, VUI LÒNG NHẬP MẬT KHẨU MỚI ");
                            } else {
                                checkFlag = false;
                            }
                        } while (checkFlag);
                        System.out.println("☼☼☼ NHẬP LẠI ĐỂ XÁC NHẬN ☼☼☼☼☼☼");
                        passNewCheck = managerUserView.inputPassword("MỚI");
                        if (passNew.equals(passNewCheck)) {
                            System.out.println("»»»»»» ĐỔI MẬT KHẨU THÀNH CÔNG ««««««");
                        } else {
                            System.out.println("☼☼☼ MẬT KHẨU KHÔNG TRÙNG ☼☼☼");
                        }
                        user.setPassword(passNewCheck);
                        userService.updatePW(user);
                        break;
                    }
                } else {
                    System.out.println("☼☼☼ MẬT KHẨU CŨ KHÔNG ĐÚNG ☼☼☼");
                }
                break;
            }
        } while (AppUtils.isRetry());
    }

    public OrderView() {
        productService = ProductService.getProductService();
        orderService = OrderService.getInstance();
        oderItemService = OrderItemService.getInstance();
    }

    public void MenutaoDonHang() {
        ArrayList<OrderItem> orderItemArrays = new ArrayList<>();
        try {
            long orderId = System.currentTimeMillis() / 1000;
            long idUser = UserService.getUserService().getIdUser(loginUserView.name);
            System.out.print("►►►►►► NHẬP TÊN KHÁCH HÀNG: ");
            String name = AppUtils.beNotEmply("☼☼☼ TÊN");
            while (!ValidateUtils.isNameValid(name)) {
                System.out.println("☼☼☼ TÊN PHẢI VIẾT CHỮ CÁI HOA ĐẦU TIÊN VÀ VIẾT KHÔNG DẤU ☼☼☼ ");
                System.out.print("►►►►►► NHẬP LẠI TÊN KHÁCH HÀNG: ");
                name = scanner.nextLine();
            }
            System.out.print("►►►►►► NHẬP SỐ ĐIỆN THOẠI: ");
            String phone = scanner.nextLine();
            while (!ValidateUtils.isPhoneValid(phone)) {
                System.out.println("☼☼☼ SỐ CỦA BẠN KHÔNG ĐÚNG ĐỊNH DẠNG (BẮT ĐẦU LÀ SỐ 0, VÀ ĐỦ 10 SỐ) ☼☼☼ ");
                System.out.print(" ►►►►►► NHẬP LẠI SỐ ĐIỆN THOẠI: ");
                phone = scanner.nextLine();
            }
            System.out.print("►►►►►► NHẬP ĐỊA CHỈ: ");
            String address = scanner.nextLine();
            do {
                if (address.trim().isEmpty()) {
                    System.out.println("☼☼☼ ĐỊA CHỈ KHÔNG ĐƯỢC BỎ TRỐNG ☼☼☼");
                    System.out.print("►►►►►► NHẬP LẠI ĐỊA CHỈ: ");
                    address = scanner.nextLine();
                }
            } while (address.trim().isEmpty());
            OrderItem orderItem = addOrderItems(orderId);
            Instant createAT = Instant.now();
            Order order = new Order(orderId, name, phone, address, idUser, createAT);
            oderItemService.add(orderItem);
            orderService.add(order);
            orderItemArrays.add(orderItem);
            System.out.println("»»»»»» TẠO ĐƠN HÀNG THÀNH CÔNG ««««««");
            do {
                System.out.println();
                System.out.println("\t|»»»»»»»»»»»»»»»»»»»»»[QUẢN LÍ HÓA ĐƠN]«««««««««««««««««««|");
                System.out.println("\t|                                                         |");
                System.out.println("\t|              【1】. TẠO ĐƠN HÀNG TIẾP                    |");
                System.out.println("\t|              【2】. IN HÓA ĐƠN                           |");
                System.out.println("\t|              【3】. QUAY LẠI MENU                        |");
                System.out.println("\t|              【0】. THOÁT CHƯƠNG TRÌNH                   |");
                System.out.println("\t|                                                         |");
                System.out.println("\t|*********************************************************|");
                System.out.print("►►►►►► Chọn số: ");
                String choice = scanner.nextLine();
                switch (choice) {
                    case "1":
//                        addOrderItems(System.currentTimeMillis() / 1000);
                        addOrderMore(orderId, name, phone, address, idUser, createAT, orderItemArrays);
                        break;
                    case "2":
                        showPaymentInfo(orderItemArrays, order);
                        break;
                    case "3":
                        userView.MenuUser();
                    case "0":
                        AppUtils.exit();
                        break;
                    default:
                        System.out.println("☼☼☼ NHẬP KHÔNG ĐÚNG, XIN NHẬP LẠI (CHỌN SỐ THEO DANH SÁCH Ở TRÊN) ☼☼☼");
                }
            } while (true);
        } catch (Exception e) {
            System.out.println("☼☼☼ NHẬP KHÔNG ĐÚNG, XIN NHẬP LẠI (CHỌN SỐ THEO DANH SÁCH Ở TRÊN) ☼☼☼");
        }
    }

    public void addOrderMore(long orderId, String name, String phone, String address, Long idUser, Instant createAT, ArrayList<OrderItem> orderItemArrayList) {
        try {
            OrderItem orderItem = addOrderItems(orderId);
            Order order = new Order(orderId, name, phone, address, idUser, createAT);
            oderItemService.add(orderItem);
            orderItemArrayList.add(orderItem);
            System.out.println("»»»»»» TẠO ĐƠN HÀNG THÀNH CÔNG ««««««");
            do {
                System.out.println();
                System.out.println("\t|»»»»»»»»»»»»»»»»»»»»»[QUẢN LÍ HÓA ĐƠN]«««««««««««««««««««|");
                System.out.println("\t|                                                         |");
                System.out.println("\t|              【1】. TẠO ĐƠN HÀNG TIẾP                    |");
                System.out.println("\t|              【2】. IN HÓA ĐƠN                           |");
                System.out.println("\t|              【3】. QUAY LẠI MENU                        |");
                System.out.println("\t|              【0】. THOÁT CHƯƠNG TRÌNH                   |");
                System.out.println("\t|                                                         |");
                System.out.println("\t|*********************************************************|");
                System.out.print("►►►►►► Chọn số: ");
                String choice = scanner.nextLine();
                switch (choice) {
                    case "1":
//                        addOrderItems(System.currentTimeMillis() / 1000);
                        addOrderMore(orderId, name, phone, address, idUser, createAT, orderItemArrayList);
                        break;
                    case "2":
                        showPaymentInfo(orderItemArrayList, order);
                        break;
                    case "3":
                        AppUtils.exit();
                        break;
                    default:
                        System.out.println("☼☼☼ NHẬP KHÔNG ĐÚNG, XIN NHẬP LẠI (CHỌN SỐ THEO DANH SÁCH Ở TRÊN) ☼☼☼");
                }
            } while (true);
        } catch (Exception e) {
            System.out.println("☼☼☼ NHẬP KHÔNG ĐÚNG, XIN NHẬP LẠI (CHỌN SỐ THEO DANH SÁCH Ở TRÊN) ☼☼☼");
        }
    }


    public OrderItem addOrderItems(Long orderId) {
        ManagerProductView managerProductView = new ManagerProductView();
        managerProductView.showALl();
        Long id = System.currentTimeMillis() / 1000;
        System.out.print("►►►►►► NHẬP ID SẢN PHẨM CẦN MUA: ");
        Long bakeryId = Long.parseLong(scanner.nextLine());

        while (!productService.existsById(bakeryId)) {
            System.out.println("☼☼☼ ID SẢN PHẨM NÀY KHÔNG TỒN TẠI ☼☼☼");
            System.out.print("►►►►►► NHẬP ID SẢN PHẨM CẦN MUA: ");
            bakeryId = Long.parseLong(scanner.nextLine());
        }
        Product product = productService.findById(bakeryId);
        float price = product.getPrice();
        System.out.print("►►►►►► NHẬP SỐ LƯỢNG: ");
        Long quantity = Long.parseLong(scanner.nextLine());
        do {
            if (quantity <= 0) {
                System.out.println("☼☼☼ SỐ LƯỢNG PHẢI LỚN HƠN 0 ☼☼☼");
                System.out.print("►►►►►► NHẬP LẠI SỐ LƯỢNG: ");
                quantity = Long.parseLong(scanner.nextLine());
            }
        } while (quantity <= 0);

        while (!checkQualityBakery(product, quantity)) {
            System.out.println("☼☼☼ SỐ LƯỢNG KHÔNG ĐỦ, XIN NHẬP LẠI ☼☼☼");
            System.out.print("►►►►►► NHẬP LẠI SỐ LƯỢNG : ");
            quantity = Long.parseLong(scanner.nextLine());
        }
        String bakeryName = product.getName();
        double total = quantity * price;
        product.setQuantity(product.getQuantity() - quantity);
        productService.update(product);
        OrderItem orderItem = new OrderItem(id, price, quantity, orderId, bakeryId, bakeryName, total);
        return orderItem;
    }

    public boolean checkQualityBakery(Product product, Long quantity) {
        if (quantity <= product.getQuantity())
            return true;
        else
            return false;
    }

    public void showPaymentInfo(ArrayList<OrderItem> orderItems, Order order) {
        double total = 0;
        try {

            System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.printf("%-17s %-20s %-20s %-15s %-15s %-17s %-15s %-20s\n",
                    " ID",
                    "TÊN KHÁCH HÀNG",
                    "SỐ ĐIỆN THOẠI",
                    "ĐỊA CHỈ",
                    "TÊN SẢN PHẨM",
                    "SỐ LƯỢNG",
                    "GIÁ",
                    "THÀNH TIỀN"
            );
            for (OrderItem orderItem : orderItems) {
                System.out.printf("%-17s %-20s %-20s %-15s %-15s %-17s %-15s %-20s\n",
                        "【" + order.getIdOrder() + "】",
                        order.getName(),
                        order.getPhonenumber(),
                        order.getAddress(),
                        orderItem.getProductName(),
                        orderItem.getQuantity(),
                        AppUtils.doubleToVND(orderItem.getPrice()),
                        AppUtils.doubleToVND(orderItem.getTotal())
                );
                total = orderItem.getTotal();
                System.out.println("\t\t\t\t\t\t\t\t\t\t\t TỔNG TIỀN CỦA HÓA ĐƠN: " + AppUtils.doubleToVND(total));
                System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------");
            }
            boolean is = true;
            do {
                System.out.println("NHẤN 1 ĐÊ TIẾP TỤC \t| NHẤN 2 QUAY VỀ MENU \t | NHẤN 0 ĐỂ THOÁT CHƯƠNG TRÌNH");
                System.out.print("");
                String choice = scanner.nextLine();
                switch (choice) {
                    case "1":
                        addOrderMore(order.getIdOrder(), order.getName(), order.getPhonenumber(), order.getAddress(), order.getIdUser(), order.getCreateAT(), orderItems);
                        break;
                    case "2":
                        userView.MenuUser();
                        break;
                    case "0":
                        AppUtils.exit();
                        break;
                    default:
                        System.out.println("☼☼☼ NHẬP KHÔNG ĐÚNG, XIN NHẬP LẠI (CHỌN SỐ THEO DANH SÁCH Ở TRÊN) ☼☼☼");
                        is = false;
                }
            } while (!is);
        } catch (Exception e) {
            System.out.println("☼☼☼ NHẬP KHÔNG ĐÚNG, XIN NHẬP LẠI (CHỌN SỐ THEO DANH SÁCH Ở TRÊN) ☼☼☼");
        }
    }

    public void getHistoryOrder() {
        Long userId = UserService.getUserService().getIdUser(loginUserView.name);
        List<Order> orders = orderService.orderHistory(userId);
        List<OrderItem> orderItems = OrderItemService.getInstance().showAll();
        OrderItem newOrderItem = new OrderItem();
        double total = 0;
        System.out.println("--------------------------------------------------LỊCH SỬ ĐƠN HÀNG CỦA BẠN----------------------------------------------------------------------------------------------------------------------");
        System.out.printf("%-17s %-20s %-20s %-15s %-15s %-12s %-12s %-15s %-20s\n",
                " ID",
                "TÊN KHÁCH HÀNG",
                "SỐ ĐIỆN THOẠI",
                "ĐỊA CHỈ",
                "TÊN SẢN PHẨM",
                "SỐ LƯỢNG",
                "GIÁ",
                "THÀNH TIỀN",
                "THỜI GIAN"
        );
        for (Order order : orders) {
            boolean checkContinue = true;
            for (OrderItem orderItem : orderItems) {
                if (orderItem.getOrderId().equals(order.getIdOrder())) {
                    newOrderItem = orderItem;
                    checkContinue = false;
                }
                if (checkContinue == false) {
                    System.out.printf("%-17s %-20s %-20s %-15s %-15s %-12s %-12s %-15s %-20s\n",
                            "【" + newOrderItem.getIdItem() + "】",
                            order.getName(),
                            order.getPhonenumber(),
                            order.getAddress(),
                            newOrderItem.getProductName(),
                            newOrderItem.getQuantity(),
                            AppUtils.doubleToVND(newOrderItem.getPrice()),
                            AppUtils.doubleToVND(newOrderItem.getTotal()),
                            InstantUtils.instantToString(order.getCreateAT())
                    );
                    checkContinue = true;
                    AppUtils.doubleToVND(total += newOrderItem.getTotal());
                }
            }

        }
        System.out.println("\t\t\t\t\t\t\t\t\t\t\t---------------------------");
        System.out.println("\t\t\t\t\t\t\t\t\t\t\t--  TỔNG TIỀN:  " + AppUtils.doubleToVND(total) + " --");
        System.out.println("\t\t\t\t\t\t\t\t\t\t\t---------------------------");
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------");


    }

    public void hienThiDonHang() {
        List<Order> orders = orderService.showAllOrder();
        List<OrderItem> orderItems = oderItemService.showAll();
        OrderItem newOrderItem = new OrderItem();
        double a = 0;
        try {
            System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.printf("%-17s %-20s %-20s %-15s %-15s %-17s %-15s %-20s\n",
                    " ID",
                    "TÊN KHÁCH HÀNG",
                    "SỐ ĐIỆN THOẠI",
                    "ĐỊA CHỈ",
                    "TÊN SẢN PHẨM",
                    "SỐ LƯỢNG",
                    "GIÁ",
                    "THÀNH TIỀN"
            );
            for (Order order : orders) {
                boolean checkContinue = true;
                for (OrderItem orderItem : orderItems) {
                    if (orderItem.getOrderId().equals(order.getIdOrder())) {
                        newOrderItem = orderItem;
                        checkContinue = false;
                    }
                    if (checkContinue == false) {
                        System.out.printf("%-17s %-20s %-20s %-15s %-15s %-17s %-15s %-20s\n",
                                "【" + order.getIdOrder() + "】",
                                order.getName(),
                                order.getPhonenumber(),
                                order.getAddress(),
                                newOrderItem.getProductName(),
                                newOrderItem.getQuantity(),
                                AppUtils.doubleToVND(newOrderItem.getPrice()),
                                AppUtils.doubleToVND(newOrderItem.getTotal())
                        );
                        checkContinue = true;
                        AppUtils.doubleToVND(a += newOrderItem.getTotal());
                    }
                }

            }
            System.out.println("-- ══════════════════════════════════════════");
            System.out.println("-- TỔNG TIỀN :  " + AppUtils.doubleToVND(a));
            System.out.println("-- ══════════════════════════════════════════");
            System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------");
            boolean is = true;
            do {
                System.out.println("NHẤN 1 ĐỂ QUAY LẠI \t|\t NHẤN 0 ĐỂ THOÁT CHƯƠNG TRÌNH");
                System.out.print("░░░ ");
                String choice = scanner.nextLine();
                switch (choice) {
                    case "1":
                        productView.MenuAdmin();
                        break;
                    case "0":
                        AppUtils.exit();
                        break;
                    default:
                        System.out.println("☼☼☼ NHẬP KHÔNG ĐÚNG, XIN NHẬP LẠI (CHỌN SỐ THEO DANH SÁCH Ở TRÊN) ☼☼☼");
                        is = false;
                }
            } while (!is);
        } catch (Exception e) {
            System.out.println("☼☼☼ NHẬP KHÔNG ĐÚNG, XIN NHẬP LẠI (CHỌN SỐ THEO DANH SÁCH Ở TRÊN) ☼☼☼");
        }
    }
}

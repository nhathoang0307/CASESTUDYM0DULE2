package view.User;

import model.Order;
import model.OrderItem;
import model.Product;
import service.*;
import utils.AppUtils;
import utils.ValidateUtils;
import view.Login.LoginUserView;
import view.Product.QuanLiSanPhamView;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class taoDonHangView {
    public static Scanner scanner = new Scanner(System.in);

    private final IProductService productService;
    private final IOrderService orderService;
    private final IOderItemService oderItemService;
    public static UserView userView = new UserView();
    public static LoginUserView loginUserView;

    public taoDonHangView() {
        productService = ProductService.getProductService();
        orderService = OrderService.getInstance();
        oderItemService = OrderItemService.getInstance();
    }

    public void MenutaoDonHang() {
        ArrayList<OrderItem> orderItemArrays = new ArrayList<>();
        try {
            long orderId = UserService.getUserService().getIdUser(loginUserView.name);
            System.out.print("NHẬP TÊN KHÁCH HÀNG: ");
            String name = scanner.nextLine();
            while (!ValidateUtils.isNameValid(name)) {
                System.out.println("TÊN PHẢI VIẾT CHỮ CÁI HOA ĐẦU TIÊN VÀ VIẾT KHÔNG DẤU");
                System.out.print("NHẬP TÊN KHÁCH HÀNG: ");
                name = scanner.nextLine();
            }
            System.out.print("NHẬP SỐ ĐIỆN THOẠI : ");
            String phone = scanner.nextLine();
            while (!ValidateUtils.isPhoneValid(phone)) {
                System.out.println("SỐ CỦA BẠN KHÔNG ĐÚNG ĐỊNH DẠNG (BẮT ĐẦU LÀ SỐ 0, VÀ ĐỦ 10 SỐ)");
                System.out.print("NHẬP SỐ ĐIỆN THOẠI : ");
                phone = scanner.nextLine();
            }
            System.out.print("NHẬP ĐỊA CHỈ : ");
            String address = scanner.nextLine();
            do {
                if (address.trim().isEmpty()) {
                    System.out.println("ĐỊA CHỈ KHÔNG ĐƯỢC BỎ TRỐNG, XIN NHẬP NGHIÊM TÚC");
                    System.out.print("NHẬP ĐỊA CHỈ : ");
                    address = scanner.nextLine();
                }
            } while (address.trim().isEmpty());
            OrderItem orderItem = addOrderItems(orderId);
            Order order = new Order(orderId, name, phone, address);
            oderItemService.add(orderItem);
            orderService.add(order);
            orderItemArrays.add(orderItem);
            System.out.println("TẠO ĐƠN HÀNG THÀNH CÔNG");
            do {
                System.out.println("\t----------------------------------------------------------");
                System.out.println("\t--░░░░░░░░░░░░░░░░░░░░[QUẢN LÍ HÓA ĐƠN]░░░░░░░░░░░░░░░░░--");
                System.out.println("\t----------------------------------------------------------");
                System.out.println("\t--                                                      --");
                System.out.println("\t--               【1】. TẠO ĐƠN HÀNG TIẾP                --");
                System.out.println("\t--               【2】. IN HÓA ĐƠN                       --");
                System.out.println("\t--               【3】. QUAY LẠI MENU                    --");
                System.out.println("\t--               【0】. THOÁT                            --");
                System.out.println("\t--                                                      --");
                System.out.println("\t----------------------------------------------------------");
                System.out.print("CHỌN SỐ : ");
                String choice = scanner.nextLine();
                switch (choice) {
                    case "1":
//                        addOrderItems(System.currentTimeMillis() / 1000);
                        addOrderMore(orderId, name, phone, address, orderItemArrays);
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
                        System.out.println("NHẬP KHÔNG ĐÚNG, XIN NHẬP LẠI");
                }
            } while (true);
        } catch (Exception e) {
            System.out.println("NHẬP SAI, XIN NHẬP LẠI");
        }
    }

    public void addOrderMore(long orderId, String name, String phone, String address, ArrayList<OrderItem> orderItemArrayList) {
        try {
            OrderItem orderItem = addOrderItems(orderId);
            Order order = new Order(orderId, name, phone, address);
            oderItemService.add(orderItem);
            orderItemArrayList.add(orderItem);
            System.out.println("TẠO ĐƠN HÀNG THÀNH CÔNG");
            do {
                System.out.println("\t----------------------------------------------------------");
                System.out.println("\t--░░░░░░░░░░░░░░░░░░░░[QUẢN LÍ HÓA ĐƠN]░░░░░░░░░░░░░░░░░--");
                System.out.println("\t----------------------------------------------------------");
                System.out.println("\t--                                                      --");
                System.out.println("\t--               【1】. TẠO ĐƠN HÀNG TIẾP                --");
                System.out.println("\t--               【2】. IN HÓA ĐƠN                       --");
                System.out.println("\t--               【3】. THOÁT                            --");
                System.out.println("\t--                                                      --");
                System.out.println("\t----------------------------------------------------------");
                System.out.print("CHỌN SỐ : ");
                String choice = scanner.nextLine();
                switch (choice) {
                    case "1":
//                        addOrderItems(System.currentTimeMillis() / 1000);
                        addOrderMore(orderId, name, phone, address, orderItemArrayList);
                        break;
                    case "2":
                        showPaymentInfo(orderItemArrayList, order);
                        break;
                    case "3":
                        AppUtils.exit();
                        break;
                    default:
                        System.out.println("NHẬP KHÔNG ĐÚNG, XIN NHẬP LẠI");
                }
            } while (true);
        } catch (Exception e) {
            System.out.println("NHẬP SAI, XIN NHẬP LẠI");
        }
    }


    public OrderItem addOrderItems(Long orderId) {
        QuanLiSanPhamView quanLiSanPhamView = new QuanLiSanPhamView();
        quanLiSanPhamView.showALl();
        Long id = System.currentTimeMillis() / 1000;
        System.out.print("NHẬP ID SẢN PHẨM CẦN MUA : ");
        Long bakeryId = Long.parseLong(scanner.nextLine());

        while (!productService.existsById(bakeryId)) {
            System.out.println("ID SẢN PHẨM NÀY KHÔNG TỒN TẠI");
            System.out.print("NHẬP ID SẢN PHẨM CẦN MUA : ");
            bakeryId = Long.parseLong(scanner.nextLine());
        }
        Product product = productService.findById(bakeryId);
        float price = product.getPrice();
        System.out.print("NHẬP SỐ LƯỢNG : ");
        Long quantity = Long.parseLong(scanner.nextLine());
        do {
            if (quantity <= 0) {
                System.out.println("SỐ LƯỢNG PHẢI LỚN HƠN 0");
                System.out.print("NHẬP SỐ LƯỢNG : ");
                quantity = Long.parseLong(scanner.nextLine());
            }
        } while (quantity <= 0);

        while (!checkQualityBakery(product, quantity)) {
            System.out.println("SỐ LƯỢNG KHÔNG ĐỦ, XIN NHẬP LẠI");
            System.out.print("NHẬP SỐ LƯỢNG : ");
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
                System.out.print("░░░ ");
                String choice = scanner.nextLine();
                switch (choice) {
                    case "1":
                        addOrderMore(order.getIdOrder(), order.getName(), order.getPhonenumber(), order.getAddress(), orderItems);
                        break;
                    case "2":
                        userView.MenuUser();
                        break;
                    case "0":
                        AppUtils.exit();
                        break;
                    default:
                        System.out.println("NHẬP SAI, XIN NHẬP LẠI");
                        is = false;
                }
            } while (!is);
        } catch (Exception e) {
            System.out.println("NHẬP SAI, XIN NHẬP LẠI");
        }
    }
    public void getHistoryOrder() {
        Long orderId = UserService.getUserService().getIdUser(loginUserView.name);
        List<OrderItem> list = OrderItemService.getInstance().getHistory(orderId);
        double total = 0;
        
        System.out.println("--------------------------------------------LỊCH SỬ ORDER SẢN PHẨM-------------------------------------------");
        System.out.printf("%-20s %-20s %-20s %-20s\n",
                "TÊN SẢN PHẨM",
                "GIÁ",
                "SỐ LƯỢNG",
                "THÀNH TIỀN"
        );
        for (OrderItem order : list) {
            System.out.printf("%-20s %-20s %-20s %-20s\n",
                    order.getProductName(),
                    AppUtils.doubleToVND(order.getPrice()),
                    order.getQuantity(),
                    order.getTotal(),
                    total += order.getTotal()
            );
        }
        System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t------------");
        System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t    TỔNG TIỀN: " + AppUtils.doubleToVND(total));
        System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------");
    }
}

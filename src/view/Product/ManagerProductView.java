<<<<<<< HEAD
package view.Product;
=======
package view;
>>>>>>> 351f5e68de170d8ade4b0b9be27a6846e63567dc

import model.Product;
import service.ProductService;
import utils.AppUtils;
<<<<<<< HEAD
import utils.InstantUtils;

import java.time.Instant;
=======

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.time.Instant;
import java.util.ArrayList;
>>>>>>> 351f5e68de170d8ade4b0b9be27a6846e63567dc
import java.util.List;
import java.util.Scanner;

public class ManagerProductView {
    public static Scanner scanner = new Scanner(System.in);

    private final ProductService productService;
<<<<<<< HEAD
    public static ProductView productView = new ProductView();
=======
>>>>>>> 351f5e68de170d8ade4b0b9be27a6846e63567dc

    public ManagerProductView() {
        productService = ProductService.getProductService();
    }

<<<<<<< HEAD

    public void menuProduct() {
        System.out.println();
        System.out.println("\t|»»»»»»»»»»»»»»»»»»»»»[DANH SÁCH QUẢN LÝ SẢN PHẨM]«««««««««««««««««««|");
        System.out.println("\t|                                                                    |");
        System.out.println("\t|                     【1】. HIỂN THỊ SẢN PHẨM                        |");
        System.out.println("\t|                     【2】. THÊM SẢN PHẨM                            |");
        System.out.println("\t|                     【3】. SỬA SẢN PHẨM                             |");
        System.out.println("\t|                     【4】. XÓA SẢN PHẨM                             |");
        System.out.println("\t|                     【5】. SẮP XẾP                                  |");
        System.out.println("\t|                     【6】. TÌM KIẾM THEO ID                         |");
        System.out.println("\t|                     【7】. TÌM KIẾM THEO TÊN SẢN PHẨM               |");
        System.out.println("\t|                     【8】. QUAY LẠI MENU                            |");
        System.out.println("\t|                     【0】. THOÁT CHƯƠNG TRÌNH                       |");
        System.out.println("\t|                                                                    |");
        System.out.println("\t|********************************************************************|");

        String choice;
        do {
            System.out.print("►►►►►► Chọn số: ");
            choice = AppUtils.beNotEmply("☼☼☼");
=======
    public static Sort sort = new Sort();
    public static Update update = new Update();


    public void menuProduct() {
        System.out.println("\t--------------------------------------------------------------------------------------");
        System.out.println("\t--░░░░░░░░░░░░░░░░░░░░░░░░░[CHƯƠNG TRÌNH QUẢN LÍ SẢN PHẨM]░░░░░░░░░░░░░░░░░░░░░░░░░---");
        System.out.println("\t-------------------------CHỌN CHỨC NĂNG THEO SỐ (ĐỂ TIẾP TỤC)-------------------------");
        System.out.println("\t--                                                                                  --");
        System.out.println("\t--                             【1】. XEM DANH SÁCH                                  --");
        System.out.println("\t--                             【2】. THÊM MỚI                                       --");
        System.out.println("\t--                             【3】. CẬP NHẬT                                       --");
        System.out.println("\t--                             【4】. XÓA                                            --");
        System.out.println("\t--                             【5】. SẮP XẾP                                        --");
        System.out.println("\t--                             【6】. TÌM KIẾM SẢN PHẨM CÓ GIÁ ĐẮT NHẤT              --");
        System.out.println("\t--                             【7】. ĐỌC TỪ FILE                                    --");
        System.out.println("\t--                             【8】. GHI TỪ FILE                                    --");
        System.out.println("\t--                             【0】. THOÁT CHƯƠNG TRÌNH                             --");
        System.out.println("\t--                                                                                  --");
        System.out.println("\t--------------------------------------------------------------------------------------");
        String choice;
        do {
            System.out.print("░░░░░░░░░░░░░░░░░░░░░░░░░░  CHỌN CHỨC NĂNG: ");
            choice = scanner.nextLine();
>>>>>>> 351f5e68de170d8ade4b0b9be27a6846e63567dc
            switch (choice) {
                case "1":
                    showALl();
                    menuProduct();
                    break;
                case "2":
                    addProduct();
                    menuProduct();
                    break;
                case "3":
<<<<<<< HEAD
                    update();
=======
                    update.Menuupdate();
>>>>>>> 351f5e68de170d8ade4b0b9be27a6846e63567dc
                    menuProduct();
                    break;
                case "4":
                    removeProduct();
                    menuProduct();
                    break;
                case "5":
<<<<<<< HEAD
                    menuSort();
                    menuProduct();
                    break;
                case "6":
                    searchById();
                    menuProduct();
                    break;
                case "7":
                    searchByName();
                    menuProduct();
                    break;
                case "8":
                    productView.MenuAdmin();
                    break;
                case "0":
                    AppUtils.exit();
                    break;
                default:
                    System.out.println("NHẬP KHÔNG ĐÚNG, XIN NHẬP LẠI (CHỌN SỐ THEO DANH SÁCH)");
=======
                    sort.menuSort();
                    menuProduct();
                    break;
                case "6":
                    findExProduct();
                    menuProduct();
                case "7":
                    readProduct();
                    menuProduct();
                    break;
                case "8":
                    writeProduct();
                    menuProduct();
                    break;
                case "0":
                    System.exit(5);
                default:
                    System.out.println("NHẬP KHÔNG ĐÚNG, XIN NHẬP LẠI");
>>>>>>> 351f5e68de170d8ade4b0b9be27a6846e63567dc
            }
        } while (choice != "0");
    }

<<<<<<< HEAD
    public void menuSort() {
        System.out.println("");
        System.out.println("\t|»»»»»»»»»»»»»»»»»»»»»[DANH SÁCH QUẢN LÝ SẢN PHẨM]«««««««««««««««««««|");
        System.out.println("\t|                                                                    |");
        System.out.println("\t|               【1】. SẮP XẾP TĂNG DẦN THEO GIÁ                      |");
        System.out.println("\t|               【2】. SẮP XẾP GIẢM DẦN THEO GIÁ                      |");
        System.out.println("\t|               【3】. SẮP XẾP TĂNG DẦN THEO TÊN                      |");
        System.out.println("\t|               【4】. SẮP XẾP GIẢM DẦN THEO TÊN                      |");
        System.out.println("\t|               【5】. SẮP XẾP GIẢM DẦN THEO SỐ LƯỢNG                 |");
        System.out.println("\t|               【6】. SẮP XẾP TĂNG DẦN THEO SỐ LƯỢNG                 |");
        System.out.println("\t|               【7】. QUAY LẠI MENU                                  |");
        System.out.println("\t|               【0】. THOÁT CHƯƠNG TRÌNH                             |");
        System.out.println("\t|                                                                    |");
        System.out.println("\t|********************************************************************|");
        String choice;
        do {
            System.out.print("►►►►►► Chọn số: ");
            choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    sortPriceASC();
                    menuSort();
                    break;
                case "2":
                    sortPriceDESC();
                    menuSort();
                    break;
                case "3":
                    sortNameDESC();
                    menuSort();
                    break;
                case "4":
                    sortNameASC();
                    menuSort();
                    break;
                case "5":
                    sortQuantityASC();
                    menuSort();
                    break;
                case "6":
                    sortQuantityDESC();
                    menuSort();
                    break;
                case "7":
                    productView.MenuAdmin();
                    break;
                case "0":
                    AppUtils.exit();
                    break;
                default:
                    System.out.println("NHẬP KHÔNG ĐÚNG, XIN NHẬP LẠI (CHỌN SỐ THEO DANH SÁCH)");
            }
        } while (choice != "0");
    }


    public void searchByName() {
        do {
            System.out.print("►►►►►► NHẬP TÊN SẢN PHẨM CẦN TÌM: ");
            String name = AppUtils.beNotEmply("TÊN SẢN PHẨM");
            while (productService.findByName(name) == null) {
                System.out.println(" ☼☼☼KHÔNG TÌM THẤY SẢN PHẨM CẦN TÌM ☼☼☼");
                System.out.println("NHẤN 1 ĐỂ TIẾP TỤC \t|\t NHẤN 2 ĐỂ QUAY LẠI \t|\t NHẤN 0 ĐỂ THOÁT CHƯƠNG TRÌNH");
                String choice = scanner.nextLine();
                switch (choice) {
                    case "1":
                        searchByName();
                        break;
                    case "2":
                        menuProduct();
                        break;
                    case "0":
                        System.out.println("♫♫♫♫♫ CHÀO TẠM BIỆT, HẸN GẶP LẠI ♫♫♫♫♫");
                        System.exit(5);
                    default:
                        System.out.println("☼☼☼ NHẬP KHÔNG ĐÚNG, XIN NHẬP LẠI (CHỌN SỐ THEO DANH SÁCH Ở TRÊN) ☼☼☼");
                        break;
                }

            }
            System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.printf("%-17s %-20s %-15s %-20s %-15s %-25s %-25s\n",
                    " ID",
                    "TÊN SẢN PHẨM",
                    "SỐ LƯỢNG",
                    "GIÁ",
                    "NHÀ SẢN XUẤT",
                    "THỜI GIAN TẠO",
                    "THỜI GIAN CẬP NHẬT");
            System.out.println();

            List<Product> result = productService.findByName(name);
            for (Product product1 : result) {
                System.out.printf("%-17s %-20s %-15s %-20s %-15S %-25s %-25s\n",
                        "【" + product1.getId() + "】",
                        product1.getName(),
                        product1.getQuantity(),
                        AppUtils.doubleToVND(product1.getPrice()),
                        product1.getManufacturer(),
                        InstantUtils.instantToString(product1.getCreateAt()),
                        product1.getUpdateAt() == null ? "" : InstantUtils.instantToString(product1.getUpdateAt()));
            }

            System.out.println("»»»»»» TÌM KIẾM THÀNH CÔNG ««««««" );
        } while (AppUtils.isRetry());

    }

    public void searchById() {
        do {
            System.out.print("►►►►►► NHẬP ID CẦN TÌM: ");
            Long id = AppUtils.retryParseLong();
            while (productService.findById(id) == null) {
                System.out.println("☼☼☼ KHÔNG TÌM THẤY ID CẦN TÌM ☼☼☼");
                System.out.println("NHẤN 1 ĐỂ TIẾP TỤC \t|\t NHẤN 2 ĐỂ QUAY LẠI \t|\t NHẤN 0 ĐỂ THOÁT CHƯƠNG TRÌNH");
                String choice = scanner.nextLine();
                switch (choice) {
                    case "1":
                        searchById();
                        break;
                    case "2":
                        menuProduct();
                        break;
                    case "0":
                        System.out.println("♫♫♫♫♫ CHÀO TẠM BIỆT, HẸN GẶP LẠI ♫♫♫♫♫");
                        System.exit(5);
                    default:
                        System.out.println("☼☼☼ NHẬP KHÔNG ĐÚNG, XIN NHẬP LẠI (CHỌN SỐ THEO DANH SÁCH Ở TRÊN) ☼☼☼");
                        break;
                }

            }
            System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.printf("%-17s %-20s %-15s %-20s %-15s %-25s %-25s\n",
                    " ID",
                    "TÊN SẢN PHẨM",
                    "SỐ LƯỢNG",
                    "GIÁ",
                    "NHÀ SẢN XUẤT",
                    "THỜI GIAN TẠO",
                    "THỜI GIAN CẬP NHẬT");
            System.out.println();
            Product product = productService.findById(id);
            System.out.printf("%-17s %-20s %-15s %-20s %-15S %-25s %-25s\n",
                    "【" + product.getId() + "】",
                    product.getName(),
                    product.getQuantity(),
                    AppUtils.doubleToVND(product.getPrice()),
                    product.getManufacturer(),
                    InstantUtils.instantToString(product.getCreateAt()),
                    product.getUpdateAt() == null ? "" : InstantUtils.instantToString(product.getUpdateAt()));
            System.out.println("»»»»»» TÌM KIẾM THÀNH CÔNG ««««««" );
        } while (AppUtils.isRetry());
    }

    public void sortQuantityASC() {
            System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.printf("%-17s %-20s %-15s %-20s %-15s %-25s %-25s\n",
                    " ID",
                    "TÊN SẢN PHẨM",
                    "SỐ LƯỢNG",
                    "GIÁ",
                    "NHÀ SẢN XUẤT",
                    "THỜI GIAN TẠO",
                    "THỜI GIAN CẬP NHẬT");
            System.out.println();
            for (Product product : productService.sortQuantityASC()) {
                System.out.printf("%-17s %-20s %-15s %-20s %-15S %-25s %-25s\n",
                        "【" + product.getId() + "】",
                        product.getName(),
                        product.getQuantity(),
                        AppUtils.doubleToVND(product.getPrice()),
                        product.getManufacturer(),
                        InstantUtils.instantToString(product.getCreateAt()),
                        product.getUpdateAt() == null ? "" : InstantUtils.instantToString(product.getUpdateAt()));
            }
    }

    public void sortQuantityDESC() {
            System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.printf("%-17s %-20s %-15s %-20s %-15s %-25s %-25s\n",
                    " ID",
                    "TÊN SẢN PHẨM",
                    "SỐ LƯỢNG",
                    "GIÁ",
                    "NHÀ SẢN XUẤT",
                    "THỜI GIAN TẠO",
                    "THỜI GIAN CẬP NHẬT");
            System.out.println();
            for (Product product : productService.sortQuantityDESC()) {
                System.out.printf("%-17s %-20s %-15s %-20s %-15S %-25s %-25s\n",
                        "【" + product.getId() + "】",
                        product.getName(),
                        product.getQuantity(),
                        AppUtils.doubleToVND(product.getPrice()),
                        product.getManufacturer(),
                        InstantUtils.instantToString(product.getCreateAt()),
                        product.getUpdateAt() == null ? "" : InstantUtils.instantToString(product.getUpdateAt()));
            }
    }

    public void sortNameASC() {
            System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.printf("%-17s %-20s %-15s %-20s %-15s %-25s %-25s\n",
                    " ID",
                    "TÊN SẢN PHẨM",
                    "SỐ LƯỢNG",
                    "GIÁ",
                    "NHÀ SẢN XUẤT",
                    "THỜI GIAN TẠO",
                    "THỜI GIAN CẬP NHẬT");
            System.out.println();
            for (Product product : productService.sortNameASC()) {
                System.out.printf("%-17s %-20s %-15s %-20s %-15S %-25s %-25s\n",
                        "【" + product.getId() + "】",
                        product.getName(),
                        product.getQuantity(),
                        AppUtils.doubleToVND(product.getPrice()),
                        product.getManufacturer(),
                        InstantUtils.instantToString(product.getCreateAt()),
                        product.getUpdateAt() == null ? "" : InstantUtils.instantToString(product.getUpdateAt()));
            }
    }

    public void sortNameDESC() {
            System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.printf("%-17s %-20s %-15s %-20s %-15s %-25s %-25s\n",
                    " ID",
                    "TÊN SẢN PHẨM",
                    "SỐ LƯỢNG",
                    "GIÁ",
                    "NHÀ SẢN XUẤT",
                    "THỜI GIAN TẠO",
                    "THỜI GIAN CẬP NHẬT");
            System.out.println();
            for (Product product : productService.sortNameDESC()) {
                System.out.printf("%-17s %-20s %-15s %-20s %-15S %-25s %-25s\n",
                        "【" + product.getId() + "】",
                        product.getName(),
                        product.getQuantity(),
                        AppUtils.doubleToVND(product.getPrice()),
                        product.getManufacturer(),
                        InstantUtils.instantToString(product.getCreateAt()),
                        product.getUpdateAt() == null ? "" : InstantUtils.instantToString(product.getUpdateAt()));
            }
    }

    public void sortPriceDESC() {
            System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.printf("%-17s %-20s %-15s %-20s %-15s %-25s %-25s\n",
                    " ID",
                    "TÊN SẢN PHẨM",
                    "SỐ LƯỢNG",
                    "GIÁ",
                    "NHÀ SẢN XUẤT",
                    "THỜI GIAN TẠO",
                    "THỜI GIAN CẬP NHẬT");
            System.out.println();
            for (Product product : productService.sortPriceDESC()) {
                System.out.printf("%-17s %-20s %-15s %-20s %-15S %-25s %-25s\n",
                        "【" + product.getId() + "】",
                        product.getName(),
                        product.getQuantity(),
                        AppUtils.doubleToVND(product.getPrice()),
                        product.getManufacturer(),
                        InstantUtils.instantToString(product.getCreateAt()),
                        product.getUpdateAt() == null ? "" : InstantUtils.instantToString(product.getUpdateAt()));
            }
    }

    public void sortPriceASC() {
            System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.printf("%-17s %-20s %-15s %-20s %-15s %-25s %-25s\n",
                    " ID",
                    "TÊN SẢN PHẨM",
                    "SỐ LƯỢNG",
                    "GIÁ",
                    "NHÀ SẢN XUẤT",
                    "THỜI GIAN TẠO",
                    "THỜI GIAN CẬP NHẬT");
            System.out.println();
            for (Product product : productService.sortPriceASC()) {
                System.out.printf("%-17s %-20s %-15s %-20s %-15S %-25s %-25s\n",
                        "【" + product.getId() + "】",
                        product.getName(),
                        product.getQuantity(),
                        AppUtils.doubleToVND(product.getPrice()),
                        product.getManufacturer(),
                        InstantUtils.instantToString(product.getCreateAt()),
                        product.getUpdateAt() == null ? "" : InstantUtils.instantToString(product.getUpdateAt()));
            }
    }
=======
>>>>>>> 351f5e68de170d8ade4b0b9be27a6846e63567dc

    public void removeProduct() {
        do {
            showALl();
<<<<<<< HEAD
            System.out.print("►►►►►► NHẬP ID CẦN XÓA: ");
            Long idProductDel = AppUtils.retryParseLong();
            productService.removeProductById(idProductDel);
            System.out.println("»»»»»» BẠN ĐÃ XÓA SẢN PHẨM THÀNH CÔNG ««««««");
=======
            System.out.println("NHẬP ID CẦN XÓA:");
            Long idProductDel = AppUtils.retryParseLong();
            productService.removeProductById(idProductDel);
            System.out.println("BẠN ĐÃ XÓA SẢN PHẨM THÀNH CÔNG");
>>>>>>> 351f5e68de170d8ade4b0b9be27a6846e63567dc
        } while (AppUtils.isRetry());

    }


    public void showALl() {
        System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------");
<<<<<<< HEAD
        System.out.printf("%-17s %-20s %-15s %-20s %-15s %-25s %-25s\n",
=======
        System.out.printf("%-17s %-20s %-15s %-20s %-15s\n",
>>>>>>> 351f5e68de170d8ade4b0b9be27a6846e63567dc
                " ID",
                "TÊN SẢN PHẨM",
                "SỐ LƯỢNG",
                "GIÁ",
<<<<<<< HEAD
                "NHÀ SẢN XUẤT",
                "THỜI GIAN TẠO",
                "THỜI GIAN CẬP NHẬT");
        System.out.println();
        for (Product product : productService.showAllProduct()) {
            System.out.printf("%-17s %-20s %-15s %-20s %-15S %-25s %-25s\n",
=======
                "MÔ TẢ");
        System.out.println();
        for (Product product : productService.showAllProduct()) {
            System.out.printf("%-17s %-20s %-15s %-20s %-15S\n",
>>>>>>> 351f5e68de170d8ade4b0b9be27a6846e63567dc
                    "【" + product.getId() + "】",
                    product.getName(),
                    product.getQuantity(),
                    AppUtils.doubleToVND(product.getPrice()),
<<<<<<< HEAD
                    product.getManufacturer(),
                    InstantUtils.instantToString(product.getCreateAt()),
                    product.getUpdateAt() == null ? "" : InstantUtils.instantToString(product.getUpdateAt()));
=======
                    product.getDescription());
>>>>>>> 351f5e68de170d8ade4b0b9be27a6846e63567dc
        }
    }

    public void addProduct() {
        do {
            long id = System.currentTimeMillis() / 1000;
<<<<<<< HEAD
            System.out.print("►►►►►► NHẬP TÊN SẢN PHẨM: ");
            String name = AppUtils.beNotEmply("☼☼☼ TÊN SẢN PHẨM");
            System.out.print("►►►►►► NHẬP GIÁ: ");
            float price = AppUtils.retryParseFloat();
            System.out.print("►►►►►► NHẬP SỐ LƯỢNG: ");
            Long quantity = AppUtils.retryParseLong();
            System.out.print("►►►►►► NHẬP NHÀ SẢN XUẤT: ");
            String manufacturer = AppUtils.retryString("☼☼☼ NHÀ SẢN XUẤT");
            Instant createAT = Instant.now();
            Product product = new Product(id, name, price, quantity, manufacturer, createAT);
            productService.addProduct(product);
            System.out.println("»»»»»» ĐÃ THÊM SẢN PHẨM THÀNH CÔNG ««««««");
=======
            System.out.println("NHẬP TÊN SẢN PHẨM");
            String name = AppUtils.beNotEmply("TÊN SẢN PHẨM");
            System.out.println("NHẬP GIÁ");
            float price = AppUtils.retryParseFloat();
            System.out.println("NHẬP SỐ LƯỢNG");
            Long quantity = AppUtils.retryParseLong();
            System.out.println("NHẬP MÔ TẢ");
            String description = AppUtils.retryString("MÔ TẢ");
            Instant createAT = Instant.now();
            Product product = new Product(id, name, price, quantity, description);
            productService.addProduct(product);
            System.out.println("ĐÃ THÊM SẢN PHẨM THÀNH CÔNG ");
>>>>>>> 351f5e68de170d8ade4b0b9be27a6846e63567dc
        } while (AppUtils.isRetry());
    }

    public void update() {
        do {

            showALl();
<<<<<<< HEAD
            System.out.print("►►►►►► NHẬP ID SẢN PHẨM CẦN SỬA: ");
            Long idProductEdit = Long.parseLong(scanner.nextLine());
            System.out.println("\t|»»»»»»»»»»»»»»»»»»»»»[THAY ĐỔI SẢN PHẨM]«««««««««««««««««««|");
            System.out.println("\t|                                                           |");
            System.out.println("\t|               【1】. THAY ĐỔI TÊN SẢN PHẨM                 |");
            System.out.println("\t|               【2】. THAY ĐỔI SỐ LƯỢNG                     |");
            System.out.println("\t|               【3】. THAY ĐỔI GIÁ                          |");
            System.out.println("\t|               【4】. THAY ĐỔI NHÀ SẢN XUÂT                 |");
            System.out.println("\t|               【5】. THAY ĐỔI TẤT CẢ                       |");
            System.out.println("\t|               【6】. QUAY LẠI MEUNU                        |");
            System.out.println("\t|               【0】. THOÁT CHƯƠNG TRÌNH                    |");
            System.out.println("\t|                                                           |");
            System.out.println("\t|***********************************************************|");
            System.out.print("►►►►►► Chọn số: ");
=======
            System.out.println("NHẬP ID SẢN PHẨM CẦN SỬA");
            Long idProductEdit = Long.parseLong(scanner.nextLine());
            System.out.println("\t----------------------------------------------------------");
            System.out.println("\t--░░░░░░░░░░░░░░░░░░░░[THAY ĐỔI SẢN PHẨM]░░░░░░░░░░░░░░░--");
            System.out.println("\t----------------------------------------------------------");
            System.out.println("\t--                                                      --");
            System.out.println("\t--               【1】. THAY ĐỔI TÊN SẢN PHẨM            --");
            System.out.println("\t--               【2】. THAY ĐỔI SỐ LƯỢNG                --");
            System.out.println("\t--               【3】. THAY ĐỔI GIÁ                     --");
            System.out.println("\t--               【4】. THAY ĐỔI MÔ TẢ                   --");
            System.out.println("\t--               【5】. THAY ĐỔI TẤT CẢ                  --");
            System.out.println("\t--               【6】. QUAY LẠI                         --");
            System.out.println("\t--               【0】. THOÁT CHƯƠNG TRÌNH               --");
            System.out.println("\t--                                                      --");
            System.out.println("\t----------------------------------------------------------");
            System.out.print("░░░░░░░░░░░░░░░░░░░░░░░░░░  CHỌN SỐ: ");
>>>>>>> 351f5e68de170d8ade4b0b9be27a6846e63567dc
            Product newProduct = new Product();
            newProduct.setId(idProductEdit);
            String nameEdit;
            float priceEdit;
            Long quantityEdit;
            String manufacturerEdit;
<<<<<<< HEAD
            String choice = AppUtils.beNotEmply("");
            switch (choice) {
                case "1":
                    System.out.print("►►►►►► NHẬP TÊN SẢN PHẨM MỚI: ");
                    nameEdit = AppUtils.beNotEmply("☼☼☼ TÊN SẢN PHẨM: ");
                    newProduct.setName(nameEdit);
                    productService.update(newProduct);
                    System.out.println("»»»»»» BẠN ĐÃ THAY ĐỔI TÊN THÀNH CÔNG ««««««");

                    break;
                case "2":
                    System.out.print("►►►►►► NHẬP SỐ LƯỢNG MỚI: ");
                    quantityEdit = AppUtils.retryParseLong();
                    newProduct.setQuantity(quantityEdit);
                    productService.update(newProduct);
                    System.out.println("»»»»»» BẠN ĐÃ THAY ĐỔI SỐ LƯỢNG THÀNH CÔNG ««««««");
                    break;
                case "3":
                    System.out.print("►►►►►► NHẬP GIÁ MỚI: ");
                    priceEdit = AppUtils.retryParseFloat();
                    newProduct.setPrice(priceEdit);
                    productService.update(newProduct);
                    System.out.println("»»»»»» BẠN ĐÃ THAY ĐỔI GIÁ THÀNH CÔNG ««««««");
                    break;
                case "4":
                    System.out.print("►►►►►► NHẬP TÊN NHÀ SẢN XUẤT MỚI: ");
                    manufacturerEdit = AppUtils.beNotEmply("☼☼☼ TÊN NHÀ SẢN XUẤT");
                    newProduct.setManufacturer(manufacturerEdit);
                    productService.update(newProduct);
                    System.out.println("»»»»»» BẠN ĐÃ THAY ĐỔI TÊN NHÀ SẢN XUẤT THÀNH CÔNG ««««««");
                    break;
                case "5":
                    System.out.print("►►►►►► NHẬP TÊN SẢN PHẨM MỚI: ");
                    nameEdit = AppUtils.beNotEmply("☼☼☼ TÊN SẢN PHẨM ");
                    System.out.print("►►►►►► NHẬP SỐ LƯỢNG MỚI: ");
                    quantityEdit = AppUtils.retryParseLong();
                    System.out.print("►►►►►► NHẬP GIÁ MỚI: ");
                    priceEdit = AppUtils.retryParseFloat();
                    System.out.print("►►►►►► NHẬP TÊN NHÀ SẢN XUẤT MỚI: ");
                    manufacturerEdit = AppUtils.beNotEmply(" ☼☼☼ TÊN NHÀ SẢN XUẤT");
                    newProduct.setName(nameEdit);
                    newProduct.setPrice(priceEdit);
                    newProduct.setQuantity(quantityEdit);
                    newProduct.setManufacturer(manufacturerEdit);
                    productService.update(newProduct);
                    System.out.println("»»»»»» BẠN ĐÃ THAY ĐỔI THÀNH CÔNG ««««««");
=======
            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    System.out.print("NHẬP TÊN SẢN PHẨM MỚI: ");
                    nameEdit = AppUtils.beNotEmply("TÊN SẢN PHẨM: ");
                    newProduct.setName(nameEdit);
                    productService.update(newProduct);
                    System.out.println("BẠN ĐÃ THAY TÊN THÀNH CÔNG");

                    break;
                case "2":
                    System.out.print("NHẬP SỐ LƯỢNG MỚI: ");
                    quantityEdit = Long.parseLong(scanner.nextLine());
                    newProduct.setQuantity(quantityEdit);
                    productService.update(newProduct);
                    System.out.println("BẠN ĐÃ THAY ĐỔI SỐ LƯỢNG THÀNH CÔNG");
                    break;
                case "3":
                    System.out.print("NHẬP GIÁ MỚI: ");
                    priceEdit = Float.parseFloat(scanner.nextLine());
                    newProduct.setPrice(priceEdit);
                    productService.update(newProduct);
                    System.out.println("BẠN ĐÃ THAY ĐỔI SẢN LƯỢNG THÀNH CÔNG");
                    break;
                case "4":
                    System.out.print("NHẬP MÔ TẢ MỚI: ");
                    manufacturerEdit = AppUtils.beNotEmply("MÔ TẢ");
                    newProduct.setDescription(manufacturerEdit);
                    productService.update(newProduct);
                    System.out.println("BẠN ĐÃ THAY ĐỔI MÔ TẢ THÀNH CÔNG");
                    break;
                case "5":
                    System.out.print("NHẬP TÊN SẢN PHẨM MỚI: ");
                    nameEdit = AppUtils.beNotEmply("TÊN SẢN PHẨM: ");
                    System.out.print("NHẬP SỐ LƯỢNG MỚI: ");
                    quantityEdit = Long.parseLong(scanner.nextLine());
                    System.out.print("NHẬP GIÁ MỚI: ");
                    priceEdit = Float.parseFloat(scanner.nextLine());
                    System.out.print("NHẬP MÔ TẢ MỚI: ");
                    manufacturerEdit = AppUtils.beNotEmply("MÔ TẢ");
                    newProduct.setName(nameEdit);
                    newProduct.setPrice(priceEdit);
                    newProduct.setQuantity(quantityEdit);
                    newProduct.setDescription(manufacturerEdit);
                    productService.update(newProduct);
                    System.out.println("BẠN ĐÃ THAY ĐỔI THÀNH CÔNG");
>>>>>>> 351f5e68de170d8ade4b0b9be27a6846e63567dc

                    break;
                case "6":
                    menuProduct();
                    break;
                case "0":
                    System.exit(5);
            }
        } while (AppUtils.isRetry());
    }

<<<<<<< HEAD
=======
    public void findExProducttest() {
        System.out.println("\t----------------SẢN PHẨM CÓ GIÁ ĐẮT NHẤT-------------------------");
        System.out.printf("%-17s %-20s %-15s %-20s %-15s\n",
                " ID",
                "TÊN SẢN PHẨM",
                "SỐ LƯỢNG",
                "GIÁ",
                "NHÀ SẢN XUẤT");
        System.out.println();
        for (Product product : productService.sortPriceDESC()) {
            System.out.printf("%-17s %-20s %-15s %-20s %-15S\n",
                    "【" + product.getId() + "】",
                    product.getName(),
                    product.getQuantity(),
                    AppUtils.doubleToVND(product.getPrice()),
                    product.getDescription());
            break;
        }
    }

    public void findExProduct() {
        List<Product> productssort = productService.sortPriceDESC();
        List<Product> producthigh = new ArrayList<>();
        for (Product p : productssort) {
            producthigh.add(p);
            break;
        }
        System.out.println("\t----------------SẢN PHẨM CÓ GIÁ ĐẮT NHẤT-------------------------");
        System.out.printf("%-17s %-20s %-15s %-20s %-15s\n",
                " ID",
                "TÊN SẢN PHẨM",
                "SỐ LƯỢNG",
                "GIÁ",
                "NHÀ SẢN XUẤT");
        System.out.println();
        for (Product phigh : producthigh) {
            for (Product product : productService.sortPriceDESC()) {
                if (phigh.getPrice() == product.getPrice()) {
                System.out.printf("%-17s %-20s %-15s %-20s %-15S\n",
                        "【" + product.getId() + "】",
                        product.getName(),
                        product.getQuantity(),
                        AppUtils.doubleToVND(product.getPrice()),
                        product.getDescription());
            }
        }
    }
}

    public void readProduct() {
        List<Product> productList = ProductService.getProductService().showAllProduct();
        System.out.println("ĐỌC FILE SẼ XÓA HẾT DANH SÁCH TRONG BỘ NHỚ!");
        System.out.println("NHẤN 'Q' ĐỂ HỦY:  ");
        String chosen = scanner.nextLine().toLowerCase();
        if (chosen.equals("q")) {
            return;
        }
        productList.clear();
        FileInputStream fis;
        InputStreamReader reader;
        BufferedReader bufferedReader;
        try {
            fis = new FileInputStream("data/produc.csv");

            reader = new InputStreamReader(fis, StandardCharsets.UTF_8);

            bufferedReader = new BufferedReader(reader);

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                if (line.isEmpty()) {
                    continue;
                }
                Product product = new Product();
                product.parseProduct(line);

                productList.add(product);
            }

            fis.close();
            reader.close();
            bufferedReader.close();
            System.out.println("ĐỌC THÀNH CÔNG!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void writeProduct() {
        List<Product> productList = ProductService.getProductService().showAllProduct();
        System.out.println("LƯU VÀO FILE!");
        System.out.println("NHẤN 'Y' ĐỂ BẮT ĐẦU LƯU: ");
        String chosen = scanner.nextLine().toLowerCase();
        if (!(chosen.equals("y"))) {
            return;
        }
        System.out.println("Bắt đầu lưu: ");
        FileOutputStream file;
        try {
            file = new FileOutputStream("data/produc.csv");

            for (Product product : productList) {
                String line = product.toString();
                byte[] b = line.getBytes(StandardCharsets.UTF_8);
                file.write(b);
            }

            file.close();
            System.out.println("=> LƯU THÀNH CÔNG, NHẤN PHÍM BẤT KÌ ĐỂ QUAY TRỞ LẠI");
            scanner.nextLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
>>>>>>> 351f5e68de170d8ade4b0b9be27a6846e63567dc
}

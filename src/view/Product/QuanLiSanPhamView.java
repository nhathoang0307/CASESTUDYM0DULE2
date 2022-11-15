package view.Product;

import model.Product;
import service.ProductService;
import utils.AppUtils;
import utils.InstantUtils;

import java.time.Instant;
import java.util.List;
import java.util.Scanner;

public class QuanLiSanPhamView {
    public static Scanner scanner = new Scanner(System.in);

    private final ProductService productService;
    public static ProductView productView = new ProductView();

    public QuanLiSanPhamView() {
        productService = ProductService.getProductService();
    }


    public void menuProduct() {
        System.out.println("\t--------------------------------------------------------------------------------------");
        System.out.println("\t--░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░[DANH SÁCH SẢN PHẨM]░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░--");
        System.out.println("\t--------------------------------------------------------------------------------------");
        System.out.println("\t--                                                                                  --");
        System.out.println("\t--                             【1】. HIỂN THỊ SẢN PHẨM                              --");
        System.out.println("\t--                             【2】. THÊM SẢN PHẨM                                  --");
        System.out.println("\t--                             【3】. SỬA SẢN PHẨM                                   --");
        System.out.println("\t--                             【4】. XÓA SẢN PHẨM                                   --");
        System.out.println("\t--                             【5】. SẮP XẾP TĂNG DẦN THEO GIÁ                      --");
        System.out.println("\t--                             【6】. SẮP XẾP GIẢM DẦN THEO GIÁ                      --");
        System.out.println("\t--                             【7】. SẮP XẾP TĂNG DẦN THEO TÊN                      --");
        System.out.println("\t--                             【8】. SẮP XẾP GIẢM DẦN THEO TÊN                      --");
        System.out.println("\t--                             【9】. SẮP XẾP TĂNG DẦN THEO SỐ LƯỢNG                 --");
        System.out.println("\t--                             【10】. SẮP XẾP GIẢM DẦN THEO SỐ LƯỢNG                --");
        System.out.println("\t--                             【11】. TÌM KIẾM THEO ID                              --");
        System.out.println("\t--                             【12】. TÌM KIẾM THEO TÊN SẢN PHẨM                    --");
        System.out.println("\t--                             【13】. QUAY LẠI MENU                                 --");
        System.out.println("\t--                             【0】. THOÁT CHƯƠNG TRÌNH                             --");
        System.out.println("\t--                                                                                  --");
        System.out.println("\t--------------------------------------------------------------------------------------");
        String choice;
        do {
            System.out.print("░░░░░░░░░░░░░░░░░░░░░░░░░░  CHỌN SỐ : ");
            choice = scanner.nextLine();
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
                    update();
                    menuProduct();
                    break;
                case "4":
                    removeProduct();
                    menuProduct();
                    break;
                case "5":
                    sortPriceASC();
                    menuProduct();
                    break;
                case "6":
                    sortPriceDESC();
                    menuProduct();
                    break;
                case "7":
                    sortNameASC();
                    menuProduct();
                    break;
                case "8":
                    sortNameDESC();
                    menuProduct();
                    break;
                case "9":
                    sortQuantityASC();
                    menuProduct();
                    break;
                case "10":
                    sortQuantityDESC();
                    menuProduct();
                    break;
                case "11":
                    searchById();
                    menuProduct();
                    break;
                case "12":
                    searchByName();
                    menuProduct();
                    break;
                case "13":
                    productView.MenuAdmin();
                    break;
                case "0":
                    AppUtils.exit();
                    break;
                default:
                    System.out.println("NHẬP KHÔNG ĐÚNG, XIN NHẬP LẠI");
            }
        } while (choice != "0");
    }

    public void searchByName() {
        do {
        System.out.print("NHẬP TÊN SẢN PHẨM CẦN TÌM: ");
        String name = AppUtils.beNotEmply("TÊN SẢN PHẨM");
        while (productService.findByName(name)== null) {
            System.out.println("KHÔNG TÌM THẤY SẢN PHẨM CẦN TÌM");
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
                    System.out.println("CHÀO TẠM BIỆT, HẸN GĂP LẠI");
                    System.exit(5);
                default:
                    System.out.println("NHẬP SAI, XIN NHẬP LẠI");
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

            System.out.println("TÌM KIẾM THÀNH CÔNG");
    } while (AppUtils.isRetry());

    }

    public void searchById() {
        do {
            System.out.println("NHẬP ID CẦN TÌM");
            Long id = AppUtils.retryParseLong();
            while (productService.findById(id) == null) {
                System.out.println("KHÔNG TÌM THẤY ID CẦN TÌM");
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
                        System.out.println("CHÀO TẠM BIỆT, HẸN GĂP LẠI");
                        System.exit(5);
                    default:
                        System.out.println("NHẬP SAI, XIN NHẬP LẠI");
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
            System.out.println("TÌM KIẾM THÀNH CÔNG");
        } while (AppUtils.isRetry());
    }

    public void sortQuantityASC() {
        do {
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
        } while (AppUtils.isRetry());
    }

    public void sortQuantityDESC() {
        do {
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
        } while (AppUtils.isRetry());
    }

    public void sortNameASC() {
        do {
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
        } while (AppUtils.isRetry());
    }

    public void sortNameDESC() {
        do {
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
        } while (AppUtils.isRetry());
    }

    public void sortPriceDESC() {
        do {
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
        } while (AppUtils.isRetry());
    }

    public void sortPriceASC() {
        do {
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
        } while (AppUtils.isRetry());
    }

    public void removeProduct() {
        do {
            showALl();
            System.out.println("NHẬP ID CẦN XÓA:");
            Long idProductDel = Long.parseLong(scanner.nextLine());
            productService.removeProductById(idProductDel);
            System.out.println("BẠN ĐÃ XÓA SẢN PHẨM THÀNH CÔNG");
        } while (AppUtils.isRetry());

    }


    public void showALl() {
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
            for (Product product : productService.showAllProduct()) {
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

//    public void showALlNotRetry() {
//        System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------");
//        System.out.printf("%-17s %-20s %-15s %-20s %-15s %-25s %-25s\n",
//                " ID",
//                "TÊN SẢN PHẨM",
//                "SỐ LƯỢNG",
//                "GIÁ",
//                "NHÀ SẢN XUẤT",
//                "THỜI GIAN TẠO",
//                "THỜI GIAN CẬP NHẬT");
//        System.out.println();
//        for (Product product : productService.showAllProduct()) {
//            System.out.printf("%-17s %-20s %-15s %-20s %-15S %-25s %-25s\n",
//                    "【" + product.getId() + "】",
//                    product.getName(),
//                    product.getQuantity(),
//                    AppUtils.doubleToVND(product.getPrice()),
//                    product.getManufacturer(),
//                    InstantUtils.instantToString(product.getCreateAt()),
//                    product.getUpdateAt() == null ? "" : InstantUtils.instantToString(product.getUpdateAt()));
//        }
//    }

    //    private Long id;
//    private String name;
//    private float price;
//    private int quantity;
//    private String manufacturer;
//    private Instant createAt;
//    private Instant updateAt;
    public void addProduct() {
        do {
            long id = System.currentTimeMillis() / 1000;
            System.out.println("NHẬP TÊN SẢN PHẨM");
            String name = scanner.nextLine();
            System.out.println("NHẬP GIÁ");
            float price = Float.parseFloat(scanner.nextLine());
            System.out.println("NHẬP SỐ LƯỢNG");
            Long quantity = Long.parseLong(scanner.nextLine());
            System.out.println("NHẬP NHÀ SẢN XUẤT");
            String manufacturer = scanner.nextLine();
            Instant createAT = Instant.now();
            Product product = new Product(id, name, price, quantity, manufacturer, createAT);
            productService.addProduct(product);
            System.out.println("ĐÃ THÊM SẢN PHẨM THÀNH CÔNG ");
        } while (AppUtils.isRetry());
    }

    public void update() {
        do {

            showALl();
            System.out.println("NHẬP ID SẢN PHẨM CẦN SỬA");
            Long idProductEdit = Long.parseLong(scanner.nextLine());
            System.out.println("\t----------------------------------------------------------");
            System.out.println("\t--░░░░░░░░░░░░░░░░░░░░[THAY ĐỔI SẢN PHẨM]░░░░░░░░░░░░░░░--");
            System.out.println("\t----------------------------------------------------------");
            System.out.println("\t--                                                      --");
            System.out.println("\t--               【1】. THAY ĐỔI TÊN SẢN PHẨM            --");
            System.out.println("\t--               【2】. THAY ĐỔI SỐ LƯỢNG                --");
            System.out.println("\t--               【3】. THAY ĐỔI GIÁ                     --");
            System.out.println("\t--               【4】. THAY ĐỔI NHÀ SẢN XUẤT            --");
            System.out.println("\t--               【5】. THAY ĐỔI TẤT CẢ                  --");
            System.out.println("\t--               【6】. QUAY LẠI                         --");
            System.out.println("\t--               【0】. THOÁT CHƯƠNG TRÌNH               --");
            System.out.println("\t--                                                      --");
            System.out.println("\t----------------------------------------------------------");
            System.out.print("░░░░░░░░░░░░░░░░░░░░░░░░░░  CHỌN SỐ : ");
            Product newProduct = new Product();
            newProduct.setId(idProductEdit);
            String nameEdit;
            float priceEdit = 0;
            long quantityEdit = 0;
            String manufacturerEdit = null;
            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    System.out.println("NHẬP TÊN SẢN PHẨM MỚI: ");
                    nameEdit = AppUtils.beNotEmply("TÊN SẢN PHẨM");
                    newProduct.setName(nameEdit);
                    productService.update(newProduct);
                    System.out.println("BẠN ĐÃ ĐỔI TÊN THÀNH CÔNG");
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
                    System.out.print("NHẬP TÊN NHÀ SẢN XUẤT MỚI: ");
                    manufacturerEdit = AppUtils.beNotEmply("TÊN NHÀ SẢN XUẤT");
                    newProduct.setManufacturer(manufacturerEdit);
                    productService.update(newProduct);
                    System.out.println("BẠN ĐÃ THAY ĐỔI TÊN NHÀ SẢN XUẤT THÀNH CÔNG");
                    break;
                case "5":
                    System.out.println("NHẬP TÊN SẢN PHẨM MỚI");
                    nameEdit = AppUtils.beNotEmply("TÊN SẢN PHẨM");
                    System.out.print("NHẬP SỐ LƯỢNG MỚI: ");
                    quantityEdit = Long.parseLong(scanner.nextLine());
                    System.out.print("NHẬP GIÁ MỚI: ");
                    priceEdit = Float.parseFloat(scanner.nextLine());
                    System.out.print("NHẬP TÊN NHÀ SẢN XUẤT MỚI: ");
                    manufacturerEdit = AppUtils.beNotEmply("TÊN NHÀ SẢN XUẤT");
                    newProduct.setName(nameEdit);
                    newProduct.setPrice(priceEdit);
                    newProduct.setQuantity(quantityEdit);
                    newProduct.setManufacturer(manufacturerEdit);
                    productService.update(newProduct);
                    break;
                case "6":
                    menuProduct();
                    break;
                case "0":
                    System.exit(5);
            }
        } while (AppUtils.isRetry());
    }
}

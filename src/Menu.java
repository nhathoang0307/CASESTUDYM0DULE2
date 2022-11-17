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
    public static void main(String[] args) {
        LoginView loginView = new LoginView();
        loginView.login();
    }
}



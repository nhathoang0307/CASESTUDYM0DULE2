package service;

import com.sun.org.apache.xpath.internal.operations.Or;
import model.Order;
import model.User;
import utils.CSVUtils;

import java.util.ArrayList;
import java.util.List;

public class OrderService implements IOrderService {
    public static final String PATH = "G:\\Module2\\case_module2\\daTa\\orders.csv";

    //Singleton Design Pattern
    private static OrderService instance;

    private OrderService() {
    }

    public static OrderService getInstance() {
        if (instance == null)
            instance = new OrderService();
        return instance;
    }

    @Override
    public List<Order> showAllOrder() {
        List<Order> orders = new ArrayList<>();
        List<String> records = CSVUtils.read(PATH);
        for (String record : records) {
            orders.add(Order.parse(record));
        }
        return orders;
    }

    @Override
    public void add(Order newOrder) {
        List<Order> orders = showAllOrder();
        orders.add(newOrder);
        CSVUtils.writeUpdate(PATH, orders);
    }

    @Override
    public void update() {
        List<Order> orders = showAllOrder();
        CSVUtils.writeUpdate(PATH, orders);
    }


    @Override
    public Order findById(long id) {
        List<Order> orders = showAllOrder();
        for (Order a : orders) {
            if (a.getIdOrder().equals(id))
                return a;
        }
        return null;
    }

    @Override
    public List<Order> findByUserId(long id) {
        List<Order> newOrders = new ArrayList<>();
        for (Order order : showAllOrder()) {
            if (order.getIdOrder() == id)
                newOrders.add(order);
        }
        return newOrders;
    }

    @Override
    public boolean existById(long id) {
        return findById(id) != null;
    }

    public Long getIdOrder(Long id) {
        List<Order> orders = showAllOrder();
        for (Order order : orders) {
            if (order.getIdUser().equals(id)) {
                return order.getIdOrder();
            }
        }
        return null;
    }
    public List<Order> orderHistory(Long id) {
        List<Order> orders = showAllOrder();
        List<Order> lists = new ArrayList<>();
        for (Order order : orders) {
            if (order.getIdUser().equals(id)) {
                lists.add(order);
            }
        }
        return lists;
    }
}

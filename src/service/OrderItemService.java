package service;

import model.OrderItem;
import utils.CSVUtils;

import java.util.ArrayList;
import java.util.List;

public class OrderItemService implements IOderItemService{
    public static final String PATH = "G:\\Module2\\case_module2\\daTa\\orderItems.csv";
    private static OrderItemService instance;

    private OrderItemService() {
    }

    public static OrderItemService getInstance() {
        if (instance == null)
            instance = new OrderItemService();
        return instance;
    }

    @Override
    public List<OrderItem> showAll() {
        List<OrderItem> orderItems = new ArrayList<>();
        List<String> records = CSVUtils.read(PATH);
        for (String record : records) {
            orderItems.add(new OrderItem(record));
        }
        return orderItems;
    }

    @Override
    public void add(OrderItem newOrderItem) {
        List<OrderItem> orderItems = showAll();
        orderItems.add(newOrderItem);
        CSVUtils.writeUpdate(PATH, orderItems);
    }


    @Override
    public void update(OrderItem newOrderItem) {
        List<OrderItem> orderItems = showAll();
        CSVUtils.writeUpdate(PATH, orderItems);
    }


    @Override
    public List<OrderItem> getHistory(Long idOrder) {
        List<OrderItem> orderItems = showAll();
        List<OrderItem> result = new ArrayList<>();
        for (OrderItem orderItem : orderItems) {
            if (orderItem.getOrderId().equals(idOrder))
                 result.add(orderItem);
        }
        return result;
    }
}

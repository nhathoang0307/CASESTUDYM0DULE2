package service;

import model.OrderItem;

import java.util.List;

public interface IOderItemService {
    List<OrderItem> showAll();

    void add(OrderItem newOrderItem);

    void update(OrderItem newOrderItem);

    List<OrderItem> getHistory(Long idOrder);
}

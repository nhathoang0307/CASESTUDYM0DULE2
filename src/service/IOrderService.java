package service;

import model.Order;

import java.util.List;

public interface IOrderService{
    List<Order> showAllOrder();

    void add(Order newOrder);

    void update();

    Order findById(long id);

    List<Order> findByUserId(long id);

    boolean existById(long id);

     Long getIdOrder(Long id);

     List<Order> orderHistory(Long id);
}

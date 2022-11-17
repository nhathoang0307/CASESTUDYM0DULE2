package model;

import java.time.Instant;
import java.util.List;

public class Order {
    private Long idOrder;
    private String name;
    private String phonenumber;
    private String address;

    private Long idUser;

    private Instant createAT;

    public Instant getCreateAT() {
        return createAT;
    }

    public void setCreateAT(Instant createAT) {
        this.createAT = createAT;
    }

    public Order() {
    }

    public Order(Long idOrder, String name, String phonenumber, String address, Long idUser, Instant createAT) {
        this.idOrder = idOrder;
        this.name = name;
        this.phonenumber = phonenumber;
        this.address = address;
        this.idUser = idUser;
        this.createAT = createAT;
    }

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    //    public static Order parseOrder(String record) {
//        Order order = new Order();
//        String[] fields = record.split(",");
//        order.idOrder = Long.parseLong(fields[0]);
//    }
    public Long getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(Long idOrder) {
        this.idOrder = idOrder;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public static Order parse(String record) {
        Order order = new Order();
        String[] field = record.split(",");
        order.idOrder = Long.parseLong(field[0]);
        order.name = field[1];
        order.phonenumber = field[2];
        order.address = field[3];
        order.idUser = Long.parseLong(field[4]);
        order.createAT = Instant.parse(field[5]);
        return order;
    }



    @Override
    public String toString() {
        return idOrder + "," + name + "," + phonenumber + "," + address + "," + idUser + "," + createAT;
    }
}

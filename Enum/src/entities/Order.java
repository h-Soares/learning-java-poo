package entities;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import entities.enums.OrderStatus;

public class Order {
    private Integer id;
    private LocalDateTime moment;
    private OrderStatus status;
    
    public Order() {
    }

    public Order(Integer id, LocalDateTime moment, OrderStatus status) {
        this.id = id;
        this.moment = moment;
        this.status = status;
    }

    @Override
    public String toString()
    {
        return "id: " + id + "  moment: " + getMoment() + "  status: " + status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMoment() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        return formatter.format(moment);
    }

    public void setMoment(LocalDateTime moment) {
        this.moment = moment;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    


    


    
}

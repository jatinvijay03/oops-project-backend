package com.example.oopsprojectbackend.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Component
public class OrderService {

    private final OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }


    public List<Order> getOrders(){
        return orderRepository.findAll();
    }

    public Optional<Order[]> getOrdersForDate(LocalDate date){
        return orderRepository.findByOrderDate(date);
    }


    public void addNewOrders(Order[] orders) {
        for(int i = 0; i< orders.length; i++) {
            Optional<Order> orderOptional = orderRepository.findOrderbyId(orders[i].getId());
            if (orderOptional.isPresent()) {
                throw new IllegalStateException("order exists");
            }
            else{
                orderRepository.save(orders[i]);
            }
        }
    }
}

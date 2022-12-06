package com.example.oopsprojectbackend.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @CrossOrigin("http://localhost:3000/")
    @RequestMapping(path = "oops/api/order")
    public List<Order> getOrders(){return orderService.getOrders();
    }

    @RequestMapping(path = "oops/api/order/{date}")
    @CrossOrigin("http://localhost:3000/")
    public Optional<Order[]> getOrdersForDate(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date){return orderService.getOrdersForDate(date);
    }

    @RequestMapping(path = "oops/api/order/user={uid}")
    @CrossOrigin("http://localhost:3000/")
    public Optional<Order[]> getOrdersForUser(@PathVariable Long uid){return orderService.getOrdersForUid(uid);
    }

    @RequestMapping(path = "oops/api/order", method = RequestMethod.POST)
    @CrossOrigin("http://localhost:3000/")
    public void registerNewOrders(@RequestBody Order[] orders) {
        orderService.addNewOrders(orders);
    }
}

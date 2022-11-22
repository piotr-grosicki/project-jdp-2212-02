package com.kodilla.ecommercee.controller;



import com.kodilla.ecommercee.domain.OrderDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/shop/order")
public class OrderController {

@GetMapping
    public List<OrderDto> getAllOrders(){
    return new ArrayList<OrderDto>();
}
    @GetMapping(value = "{orderId}")
    public OrderDto getOrder(@PathVariable Long orderId){
    return new OrderDto();

    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createOrder(@RequestBody OrderDto orderDto){

    }

    @PutMapping
    public OrderDto updateOrder(@RequestBody  OrderDto orderDto){
        return new OrderDto();
    }

    @DeleteMapping(value = "{orderId}")
    public void deleteOrder(@PathVariable long orderId){

    }
}

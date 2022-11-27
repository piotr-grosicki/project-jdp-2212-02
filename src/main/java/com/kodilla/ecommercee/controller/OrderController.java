package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.domain.OrderDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/shop/order")
@RequiredArgsConstructor
public class OrderController {

@GetMapping
    public List<OrderDto> getAllOrders(){
    return new ArrayList<OrderDto>();
}
    @GetMapping(value = "{orderId}")
    public OrderDto getOrder(@PathVariable Long orderId){
        System.out.println("Get");
    return new OrderDto(1L,"Order Test");

    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createOrder(@RequestBody OrderDto orderDto){
        System.out.println("Post");
    }

    @PutMapping
    public OrderDto updateOrder(@RequestBody OrderDto orderDto){
        System.out.println("put");
        return new OrderDto(1L,"Order Test");

    }

    @DeleteMapping(value = "{orderId}")
    public void deleteOrder(@PathVariable long orderId){
        System.out.println("Delete");
    }
}
package com.naekang.orderdemo.controller;

import com.naekang.orderdemo.dto.OrderItemsRequestDTO;
import com.naekang.orderdemo.service.OrderRestService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.ServletWebRequest;

import javax.validation.Valid;

@Slf4j
@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class OrderRestController {

    private final OrderRestService orderRestService;

    @PostMapping("/order")
    public ResponseEntity<Void> orderItems(@Valid @RequestBody OrderItemsRequestDTO orderItemsRequestDTO,
                                           Errors errors,
                                           ServletWebRequest servletWebRequest) {

        return orderRestService.orderItems(orderItemsRequestDTO);
    }
}

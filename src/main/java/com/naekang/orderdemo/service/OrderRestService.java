package com.naekang.orderdemo.service;

import com.naekang.orderdemo.dto.OrderItemsRequestDTO;
import org.springframework.http.ResponseEntity;

public interface OrderRestService {

    public ResponseEntity<Void> orderItems(OrderItemsRequestDTO orderItemsRequestDTO);

}

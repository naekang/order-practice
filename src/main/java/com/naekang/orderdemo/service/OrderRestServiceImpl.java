package com.naekang.orderdemo.service;

import com.naekang.orderdemo.dto.OrderItemsRequestDTO;
import com.naekang.orderdemo.entity.ItemEntity;
import com.naekang.orderdemo.entity.OrderEntity;
import com.naekang.orderdemo.entity.OrderStatus;
import com.naekang.orderdemo.entity.UserEntity;
import com.naekang.orderdemo.exception.ErrorCode;
import com.naekang.orderdemo.repository.ItemRepository;
import com.naekang.orderdemo.repository.OrderRepository;
import com.naekang.orderdemo.repository.UserRepository;
import com.naekang.orderdemo.util.PrintLogAndThrowException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrderRestServiceImpl implements OrderRestService{

    private final UserRepository userRepository;

    private final ItemRepository itemRepository;

    private final OrderRepository orderRepository;

    @Override
    @Transactional
    public ResponseEntity<Void> orderItems(OrderItemsRequestDTO orderItemsRequestDTO) {

        Optional<UserEntity> userResult = userRepository.findByUsername(orderItemsRequestDTO.getUsername());

        Optional<ItemEntity> itemResult = itemRepository.findById(orderItemsRequestDTO.getItemId());

        OrderEntity orderEntity = null;

        if (userResult.isEmpty()) {
            PrintLogAndThrowException.printLogAndThrowCustomException(ErrorCode.USER_NOT_FOUND);
        } else {

            if (itemResult.get().getItemQuantity() < orderItemsRequestDTO.getOrderCount()) {
                PrintLogAndThrowException.printLogAndThrowCustomException(ErrorCode.RESOURCE_NOT_FOUND);
            } else {

                try {

                    UserEntity userEntity = userResult.get();

                    ItemEntity itemEntity = itemResult.get();

                    itemEntity.updateItemInfo(itemEntity.getItemQuantity() - orderItemsRequestDTO.getOrderCount());

                    itemRepository.save(itemEntity);

                    System.out.println(itemEntity);
                    System.out.println(LocalDateTime.now());
                    System.out.println(OrderStatus.ConfirmOrder);
                    System.out.println(orderItemsRequestDTO.getOrderCount());
                    System.out.println(userEntity.getId());
                    System.out.println(orderItemsRequestDTO.getItemId());

                    OrderEntity newOrderEntity = OrderEntity.builder()
                            .orderDate(LocalDateTime.now())
                            .orderStatus(OrderStatus.ConfirmOrder)
                            .count(orderItemsRequestDTO.getOrderCount())
                            .userId(userEntity.getId())
                            .itemId(orderItemsRequestDTO.getItemId())
                            .build();

                    orderRepository.save(newOrderEntity);

                } catch (Exception e) {

                    PrintLogAndThrowException.printLogAndThrowCustomException(ErrorCode.UNEXPECTED_EXCEPTION);
                }
            }
        }

        assert orderEntity != null;

        return ResponseEntity.ok().build();
    }


}

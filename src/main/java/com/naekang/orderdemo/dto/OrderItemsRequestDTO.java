package com.naekang.orderdemo.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
public class OrderItemsRequestDTO {

    @NotNull
    private String username;

    @NotNull
    private Long itemId;

    @NotNull
    private int orderCount;

}

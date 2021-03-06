package com.example.demo.mapper;

import com.example.demo.dto.Order;
import com.example.demo.entity.OrderEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrderMapper {
    OrderEntity sourceToDestination(Order source);
    Order destinationToSource(OrderEntity destination);
}

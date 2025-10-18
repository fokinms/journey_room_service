package org.fokinms.journey.room_service.mapper;

import org.fokinms.journey.room_service.dto.OrderDto;
import org.fokinms.journey.room_service.entity.Order;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface OrderMapper {

    OrderDto toDto(Order order);
    Order toEntity(OrderDto orderDto);
}

package org.fokinms.journey.room_service.mapper;

import org.fokinms.journey.room_service.dto.RoomDto;
import org.fokinms.journey.room_service.entity.Room;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface RoomMapper {

    RoomDto toDto(Room room);
    Room toEntity(RoomDto roomDto);

    List<RoomDto> toDtos(List<Room> rooms);
}

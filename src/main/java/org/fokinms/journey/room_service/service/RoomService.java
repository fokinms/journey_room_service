package org.fokinms.journey.room_service.service;

import lombok.RequiredArgsConstructor;
import org.fokinms.journey.room_service.CreateRoomRequest;
import org.fokinms.journey.room_service.GetRoomRequest;
import org.fokinms.journey.room_service.RoomResponse;
import org.fokinms.journey.room_service.entity.RoomStatus;
import org.fokinms.journey.room_service.dto.RoomDto;
import org.fokinms.journey.room_service.entity.Room;
import org.fokinms.journey.room_service.exception.RoomNotFoundException;
import org.fokinms.journey.room_service.mapper.RoomMapper;
import org.fokinms.journey.room_service.repository.RoomRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RoomService {

    private final RoomRepository roomRepository;
    private final RoomMapper roomMapper;

    public RoomDto findRoomById(Long roomId) {
        return roomMapper.toDto(roomRepository.findById(roomId)
                .orElseThrow(() -> new RoomNotFoundException(String.format("Room not found with id: %d", roomId))));
    }

    public List<RoomDto> findAllRooms() {
        return roomMapper.toDtos(roomRepository.findAll());
    }

    public RoomResponse createRoom(CreateRoomRequest createRoomRequest) {
        Room room = roomRepository.save(Room.builder()
                .apartmentName(createRoomRequest.getApartmentName())
                .city(createRoomRequest.getCity())
                .numberOfRooms((byte) createRoomRequest.getNumberOfRooms())
                .price(BigDecimal.valueOf(Double.parseDouble(createRoomRequest.getPrice())))
                .roomStatus(RoomStatus.valueOf(createRoomRequest.getRoomStatus().name()))
                .build());
        return buildFrom(room);
    }

    private RoomResponse buildFrom(Room room) {
        return RoomResponse.newBuilder()
                .setId(room.getId())
                .setApartmentName(room.getApartmentName())
                .setCity(room.getCity())
                .setNumberOfRooms(room.getNumberOfRooms())
                .setPrice(room.getPrice().toString())
                .setRoomStatus(org.fokinms.journey.room_service.RoomStatus.valueOf(room.getRoomStatus().toString()))
                .setOrderId(room.getOrderId() == null ? -1 : room.getOrderId())
                .build();
    }

    public RoomResponse getRoom(GetRoomRequest getRoomRequest) {
        Room room = roomRepository.findById(getRoomRequest.getId()).orElseThrow(
                () -> new RoomNotFoundException(String.format("Room not found with id: %d", getRoomRequest.getId()))
        );
        return buildFrom(room);
    }
}
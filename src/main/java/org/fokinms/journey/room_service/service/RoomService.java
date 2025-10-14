package org.fokinms.journey.room_service.service;

import lombok.RequiredArgsConstructor;
import org.fokinms.journey.room_service.dto.RoomDto;
import org.fokinms.journey.room_service.exception.RoomNotFoundException;
import org.fokinms.journey.room_service.mapper.RoomMapper;
import org.fokinms.journey.room_service.repository.RoomRepository;
import org.springframework.stereotype.Service;

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
}
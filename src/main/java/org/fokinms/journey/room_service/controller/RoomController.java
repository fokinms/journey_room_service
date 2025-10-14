package org.fokinms.journey.room_service.controller;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.fokinms.journey.room_service.dto.RoomDto;
import org.fokinms.journey.room_service.service.RoomService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/rooms")
@RequiredArgsConstructor
public class RoomController {

    private final RoomService roomService;

    @GetMapping("/room/{roomId}")
    public RoomDto findRoomById(@NonNull @PathVariable Long roomId) {
        return roomService.findRoomById(roomId);
    }

    @GetMapping("/all")
    public List<RoomDto> findAllRooms() {
        return roomService.findAllRooms();
    }
}

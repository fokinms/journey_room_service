package org.fokinms.journey.room_service.service.grpc;

import io.grpc.stub.StreamObserver;
import lombok.RequiredArgsConstructor;
import org.fokinms.journey.room_service.CreateRoomRequest;
import org.fokinms.journey.room_service.DeleteRoomRequest;
import org.fokinms.journey.room_service.DeleteRoomResponse;
import org.fokinms.journey.room_service.GetRoomRequest;
import org.fokinms.journey.room_service.RoomResponse;
import org.fokinms.journey.room_service.RoomServiceGrpc;
import org.fokinms.journey.room_service.UpdateRoomRequest;
import org.fokinms.journey.room_service.service.RoomService;
import org.springframework.grpc.server.service.GrpcService;

@GrpcService
@RequiredArgsConstructor
public class GrpcRoomService extends RoomServiceGrpc.RoomServiceImplBase {
    private final RoomService roomService;

    @Override
    public void createRoom(CreateRoomRequest request, StreamObserver<RoomResponse> responseObserver) {
        RoomResponse response = roomService.createRoom(request);
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void getRoom(GetRoomRequest request, StreamObserver<RoomResponse> responseObserver) {
        RoomResponse response = roomService.getRoom(request);
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void updateRoom(UpdateRoomRequest request, StreamObserver<RoomResponse> responseObserver) {
        super.updateRoom(request, responseObserver);
    }

    @Override
    public void deleteRoom(DeleteRoomRequest request, StreamObserver<DeleteRoomResponse> responseObserver) {
        super.deleteRoom(request, responseObserver);
    }
}

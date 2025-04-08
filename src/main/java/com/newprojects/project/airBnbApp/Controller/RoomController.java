package com.newprojects.project.airBnbApp.Controller;

import com.newprojects.project.airBnbApp.Dto.RoomDto;
import com.newprojects.project.airBnbApp.Service.RoomService;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("admin/hotels/{hotelId}/rooms")
@RestController
@RequiredArgsConstructor
@Slf4j
public class RoomController {


    private final RoomService roomService;




    @PostMapping
    public ResponseEntity<RoomDto> createNewRoom(@PathVariable Long hotelId , @RequestBody RoomDto roomDto)
    {

        log.info("Attempting to create a new room with ID:"+roomDto.getId());
        RoomDto newroomDto = roomService.createNewRoom(hotelId ,roomDto);

        return new ResponseEntity<>(newroomDto , HttpStatus.CREATED);

    }

    @GetMapping()
    public ResponseEntity<List<RoomDto>> getAllRoomsOfHotel(@PathVariable Long hotelId)
    {
        log.info("Attempting to get all the room in Hotel by hotelID:"+hotelId);
        List<RoomDto> roomdto =roomService.getAllRoomsOfHotel(hotelId);

        return new ResponseEntity<>(roomdto , HttpStatus.FOUND);
    }

    @GetMapping("/{roomId}")
    public ResponseEntity<RoomDto> getRoomById(@PathVariable Long roomId)
    {
        log.info("Attempting to get all the room in Hotel by RoomID:"+roomId);
        RoomDto roomDto =roomService.getRoomById(roomId);

        return new ResponseEntity<>(roomDto ,HttpStatus.FOUND);
    }

    @DeleteMapping("/{roomId}")
    public ResponseEntity deleteRoomById(@PathVariable Long roomId)
    {
        log.info("Attempting to delete room in Hotel by RoomID:"+roomId);
        roomService.deleteRoomById(roomId);

        return ResponseEntity.noContent().build();
    }
}

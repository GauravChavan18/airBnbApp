package com.newprojects.project.airBnbApp.Controller;

import com.newprojects.project.airBnbApp.Dto.RoomDto;
import com.newprojects.project.airBnbApp.Service.RoomService;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("admin/hotels/{hotelId}/rooms")
@RestController
@RequiredArgsConstructor
public class RoomController {


    private final RoomService roomService;




    @PostMapping()
    public ResponseEntity<RoomDto> createNewRoom(@PathVariable Long HotelId , @RequestBody RoomDto roomDto)
    {

        RoomDto newroomDto = roomService.createNewRoom(HotelId ,roomDto);

        return new ResponseEntity<>(newroomDto , HttpStatus.CREATED);

    }

    @GetMapping()
    public ResponseEntity<RoomDto> getHotelById(@PathVariable Long hotelId)
    {
        RoomDto roomdto =roomService.getRoomById(hotelId);

        return new ResponseEntity<>(roomdto , HttpStatus.FOUND);
    }

    @GetMapping("/{roomId}")
    public ResponseEntity<RoomDto> getRoomById(@PathVariable Long roomId)
    {
        RoomDto roomDto =roomService.getRoomById(roomId);

        return new ResponseEntity<>(roomDto ,HttpStatus.FOUND);
    }

    @DeleteMapping("/{roomId}")
    public ResponseEntity deleteRoomById(@PathVariable Long roomId)
    {
        roomService.deleteRoomById(roomId);

        return ResponseEntity.noContent().build();
    }
}

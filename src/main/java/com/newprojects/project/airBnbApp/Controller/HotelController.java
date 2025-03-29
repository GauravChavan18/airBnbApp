package com.newprojects.project.airBnbApp.Controller;

import com.newprojects.project.airBnbApp.Dto.HotelDto;
import com.newprojects.project.airBnbApp.ServiceImpl.HotelServiceImpl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/admin/hotels")
@Slf4j
public class HotelController {

    private final HotelServiceImpl hotelService;


    @GetMapping("/hi")
    public String hi()
    {
        return "Hi Working";
    }


    @PostMapping
    public ResponseEntity<HotelDto> createNewHotel(@RequestBody HotelDto hotelDto)
    {
        log.info("Attempting to create a new hotel with name:"+hotelDto.getName());
        HotelDto hotelDto1 = hotelService.createNewHotel(hotelDto);

        return new ResponseEntity<>(hotelDto1 , HttpStatus.CREATED);
    }

    @GetMapping("/{hotelId}")
    public ResponseEntity<HotelDto> getHotelById(@PathVariable Long hotelId)
    {
        log.info("Attempting to finding the hotel with ID:"+hotelId);
        HotelDto hotel = hotelService.getHotelById(hotelId);

        return new ResponseEntity<>(hotel,HttpStatus.FOUND);
    }

    @PutMapping("/{hotelId}")
    public ResponseEntity<HotelDto> updateHotelById(@PathVariable Long hotelId , @RequestBody HotelDto hotelDto)
    {
        log.info("Attempting to Updating the hotel with ID:"+hotelId);
        HotelDto hotel=hotelService.updateHotelById(hotelId , hotelDto);

        return ResponseEntity.ok(hotel);
    }

    @DeleteMapping("/{hotelId}")
    public ResponseEntity deleteHotelById(@PathVariable Long hotelId)
    {
        log.info("Attempting to Deleting the hotel with ID:"+hotelId);
        hotelService.deleteHotelById(hotelId);

        return ResponseEntity.noContent().build();
    }
}

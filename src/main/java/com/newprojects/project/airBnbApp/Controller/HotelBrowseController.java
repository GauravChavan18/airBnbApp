package com.newprojects.project.airBnbApp.Controller;

import com.newprojects.project.airBnbApp.Dto.HotelDto;
import com.newprojects.project.airBnbApp.Dto.HotelInfoDto;
import com.newprojects.project.airBnbApp.Dto.HotelSearchRequest;
import com.newprojects.project.airBnbApp.Service.HotelService;
import com.newprojects.project.airBnbApp.Service.InvetoryService;
import com.newprojects.project.airBnbApp.ServiceImpl.HotelServiceImpl;
import lombok.RequiredArgsConstructor;
import org.hibernate.query.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/hotels")
public class HotelBrowseController {



    private final InvetoryService invetoryService;
    private final HotelService hotelService;

//    @GetMapping("/search")
//    public ResponseEntity<Page<HotelDto>> searchHotel(@RequestBody HotelSearchRequest hotelSearchRequest)
//    {
//            Page<HotelDto> page = invetoryService.searchHotel(hotelSearchRequest);
//            return ResponseEntity.ok(page);
//    }

        @GetMapping("{hotelId}/info")
        public ResponseEntity<HotelInfoDto> getHotelInfo(@PathVariable Long hotelId)
        {
            return ResponseEntity.ok(hotelService.getHotelInfo(hotelId));
        }
}

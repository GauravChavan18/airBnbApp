package com.newprojects.project.airBnbApp.Service;

import com.newprojects.project.airBnbApp.Dto.HotelDto;
import com.newprojects.project.airBnbApp.Entity.Hotel;

public interface HotelService {

    HotelDto createNewHotel(HotelDto hotelDto);

    HotelDto getHotelById(Long id);

    HotelDto updateHotelById(Long id ,HotelDto hotelDto);

    Boolean deleteHotelById(Long id);
}

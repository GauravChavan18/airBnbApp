package com.newprojects.project.airBnbApp.ServiceImpl;

import com.newprojects.project.airBnbApp.Dto.HotelDto;
import com.newprojects.project.airBnbApp.Entity.Hotel;
import com.newprojects.project.airBnbApp.Repository.HotelRepository;
import com.newprojects.project.airBnbApp.Service.HotelService;
import com.newprojects.project.airBnbApp.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

@Service
@Slf4j
@RequiredArgsConstructor
public class HotelServiceImpl implements HotelService {

    private final HotelRepository hotelRepository;
    private final ModelMapper modelMapper;


    @Override
    public HotelDto createNewHotel(HotelDto hotelDto) {

        log.info("Creating a new hotel with NAME: {}",hotelDto.getName());
       Hotel hotel= modelMapper.map(hotelDto,Hotel.class);
       hotel.setActive(false);
       hotelRepository.save(hotel);
        log.info("Created a new hotel with ID: {}",hotel.getId());
       return modelMapper.map(hotel,HotelDto.class);
    }

    @Override
    public HotelDto getHotelById(Long id) {

        log.info("Getting the hotel with ID: {}",id);

        Hotel hotel = hotelRepository.findById(id).
                orElseThrow(() ->new ResourceNotFoundException("Hotel not found with id :"+id));

        log.info("Found the hotel with id: {} and name: {} ",id,hotel.getName());

        return modelMapper.map(hotel,HotelDto.class);
    }

    @Override
    public HotelDto updateHotelById(Long id, HotelDto hotelDto) {

        log.info("Updating a hotel of name {}",hotelDto.getName());

        Hotel hotel = hotelRepository.
                findById(id).
                orElseThrow(()-> new ResourceNotFoundException("Hotel not found with id :"+id));
        modelMapper.map(hotelDto,hotel);
        hotel.setId(id);
        hotelRepository.save(hotel);
        return modelMapper.map(hotel,HotelDto.class);

    }

    @Override
    public Boolean deleteHotelById(Long id) {

        Boolean exists=hotelRepository.existsById(id);
        if(!exists) throw new ResourceNotFoundException("Hotel not found with id :"+id);
        log.info("Deleting a hotel with id:{}",id);
        hotelRepository.deleteById(id);

        log.info("Hotel Deleted Sucessfully !!");

        return true;

    }
}

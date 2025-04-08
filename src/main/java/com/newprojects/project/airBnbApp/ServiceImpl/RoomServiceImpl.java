package com.newprojects.project.airBnbApp.ServiceImpl;

import com.newprojects.project.airBnbApp.Dto.RoomDto;
import com.newprojects.project.airBnbApp.Entity.Hotel;
import com.newprojects.project.airBnbApp.Entity.Room;
import com.newprojects.project.airBnbApp.Repository.HotelRepository;
import com.newprojects.project.airBnbApp.Repository.RoomRepository;
import com.newprojects.project.airBnbApp.Service.RoomService;
import com.newprojects.project.airBnbApp.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class RoomServiceImpl implements RoomService {

    final RoomRepository roomRepository;
    final ModelMapper modelMapper;
    final HotelRepository hotelRepository;




    @Override
    public RoomDto createNewRoom(Long hotelId,RoomDto roomDto) {

        log.info("Creating a room in hotel with Id:{}",roomDto.getId());

        Hotel hotel =hotelRepository.
                findById(hotelId)
                .orElseThrow(()-> new ResourceNotFoundException("Hotel not found with id :"+hotelId));


        Room room = modelMapper.map(roomDto,Room.class);

        room.setHotel(hotel);

        roomRepository.save(room);
        log.info("Room is created in hotel with Id:{}",room.getId());
        return modelMapper.map(room,RoomDto.class);

    }

    @Override
    public List<RoomDto> getAllRoomsOfHotel(Long hotelId) {

        log.info("Finding a hotel with Id:{}",hotelId);
        Hotel hotel =hotelRepository.
                findById(hotelId)
                .orElseThrow(()-> new ResourceNotFoundException("Hotel not found with id :"+hotelId));

        List<Room> rooms = hotel.getRooms();

        List<RoomDto> roomdtos =rooms.
                stream()
                .map( room -> modelMapper.map(room,RoomDto.class))
                .collect(Collectors.toList());

        log.info("Searching all the rooms in a hotel with Id:{}",hotelId);
        return roomdtos;
    }

    @Override
    public RoomDto getRoomById(Long roomId) {

        log.info("Searching the rooms in a hotel with room Id:{}",roomId);
        Room room = roomRepository
                .findById(roomId)
                .orElseThrow(()-> new ResourceNotFoundException("Room not found with Id :"+roomId));

        return modelMapper.map(room,RoomDto.class);

    }

    @Override
    public void deleteRoomById(Long roomId) {
        log.info("Deleting the room with id :",roomId);

        Boolean exists = roomRepository.existsById(roomId);

        log.info("deleting the room with id",roomId);

        if(exists)
        {
            roomRepository.deleteById(roomId);
        }
        else{
            throw new ResourceNotFoundException("Room not found with Id :"+roomId);
        }
    }
}

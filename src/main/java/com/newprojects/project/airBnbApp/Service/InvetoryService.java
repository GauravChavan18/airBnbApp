package com.newprojects.project.airBnbApp.Service;

import com.newprojects.project.airBnbApp.Dto.HotelSearchRequest;
import com.newprojects.project.airBnbApp.Entity.Room;
import org.hibernate.query.Page;

public interface InvetoryService {

    void initializedRoomForYear(Room room);

    void deleteAllInvetories(Room room);

    Page searchHotel(HotelSearchRequest hotelSearchRequest);
}

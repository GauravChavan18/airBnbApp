package com.newprojects.project.airBnbApp.Service;

import com.newprojects.project.airBnbApp.Entity.Room;

public interface InvetoryService {

    void initializedRoomForYear(Room room);

    void deleteAllInvetories(Room room);
}

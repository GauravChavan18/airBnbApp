package com.newprojects.project.airBnbApp.Repository;

import com.newprojects.project.airBnbApp.Entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends JpaRepository<Room,Long> {
}

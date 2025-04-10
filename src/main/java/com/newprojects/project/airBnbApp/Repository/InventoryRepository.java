package com.newprojects.project.airBnbApp.Repository;

import com.newprojects.project.airBnbApp.Entity.Inventory;
import com.newprojects.project.airBnbApp.Entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory, Long> {


    void deleteByRoom( Room room);
}

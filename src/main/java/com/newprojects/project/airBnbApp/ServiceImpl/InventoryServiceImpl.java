package com.newprojects.project.airBnbApp.ServiceImpl;

import com.newprojects.project.airBnbApp.Entity.Inventory;
import com.newprojects.project.airBnbApp.Entity.Room;
import com.newprojects.project.airBnbApp.Repository.InventoryRepository;
import com.newprojects.project.airBnbApp.Service.InvetoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;

@Service
@RequiredArgsConstructor
@Slf4j
public class InventoryServiceImpl implements InvetoryService {

    private final InventoryRepository inventoryRepository;

    @Override
    public void initializedRoomForYear(Room room) {

        LocalDate today = LocalDate.now();
        LocalDate endDate =LocalDate.now().plusYears(1);
        log.info("here in the inventory creation");
        for(;!today.isAfter(endDate);today=today.plusDays(1))
        {
            Inventory inventory = Inventory.builder()
                    .hotel(room.getHotel())
                    .room(room)
                    .city(room.getHotel().getCity())
                    .bookedCount(0)
                    .surgeFactor(BigDecimal.ONE)
                    .price(room.getBasePrice())
                    .totalCount(room.getTotalCount())
                    .closed(false)
                    .date(today)
                    .build();
            log.info("here in the inventory creation");
            inventoryRepository.save(inventory);
        }

    }

    @Override
    public void deleteAllInvetories(Room room) {

        inventoryRepository.deleteByRoom(room);

    }
}

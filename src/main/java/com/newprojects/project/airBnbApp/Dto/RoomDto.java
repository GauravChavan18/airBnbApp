package com.newprojects.project.airBnbApp.Dto;


import com.newprojects.project.airBnbApp.Entity.Hotel;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class RoomDto {

    private Long id;


    private String type;
    private BigDecimal basePrice;
    private Integer totalCount;
    private Integer capacity;
    private String[] photos;
    private  String[] amenities;



}

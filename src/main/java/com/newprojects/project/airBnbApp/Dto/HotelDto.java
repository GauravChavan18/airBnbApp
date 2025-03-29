package com.newprojects.project.airBnbApp.Dto;

import com.newprojects.project.airBnbApp.Entity.HotelContactInfo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Data
@Getter
@Setter
public class HotelDto {

    private Long id;
    private String name;
    private  String city;
    private String[] photos;
    private  String[] amenities;
    private HotelContactInfo contactInfo;
    private Boolean active;


}

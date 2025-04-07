package com.newprojects.project.airBnbApp.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;


import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Table(
        uniqueConstraints= @UniqueConstraint(
                name = "unique_hotel_room_date",
                columnNames = {"hotel_id","room_id" ,"date"}
        ))
@Entity
@Getter
@Setter
public class Inventory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name = "hotel_id" , nullable = false)
    private Hotel hotel;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "room_id" , nullable = false)
    private Room room;

    @Column(nullable = false)
    private LocalDate date;

    @Column(nullable = false , columnDefinition = "INTEGER DEfAULT 0")
    private Integer bookedCount;

    @Column(nullable = false)
    private Integer totalCount;

    @Column(nullable = false , precision = 5 , scale = 2)
    private BigDecimal surgeFactor;

    @Column(nullable = false , precision = 5 , scale = 2)
    private BigDecimal price;

    @Column(nullable = false)
    private String city;

    @Column(nullable = false)
    private Boolean closed;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

}

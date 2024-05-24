package com.vmieres.msrepair.entities;

import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "detail")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DetailEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long detailId;

    private String repairType;
    private LocalDateTime date;
    private int cost;
    private boolean checkOut;

    private Long repairId;
}
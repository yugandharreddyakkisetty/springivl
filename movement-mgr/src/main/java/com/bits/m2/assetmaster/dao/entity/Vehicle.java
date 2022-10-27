package com.bits.m2.assetmaster.dao.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "t_vehicle")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String vehicleNumber;
    private String displayName;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "transporter_id", referencedColumnName = "id")
    private Transporter transporter;

}

package com.bits.m2.assetmaster.dao.entity;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "t_transporter")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Transporter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name= "code", nullable = false)
    private String code;
    @Column(name= "display_name", nullable = false)
    private String displayName;
    @OneToMany(mappedBy = "transporter")
    private Set<Vehicle> vehicleSet;

}

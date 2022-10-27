package com.bits.m2.assetmaster.sdo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VehicleSdo {
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    private Long vehicleId;
    private String vehicleNumber;
    private String displayName;
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    private Long transporterId;
}

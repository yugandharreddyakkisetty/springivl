package com.bits.m2.assetmaster.util;

import com.bits.m2.assetmaster.dao.entity.Transporter;
import com.bits.m2.assetmaster.sdo.TransporterSdo;

import java.util.List;
import java.util.stream.Collectors;

public class TransporterConverter {
    public static TransporterSdo convertToTransporterSdo(Transporter transporter) {
        TransporterSdo transporterSdo = new TransporterSdo();
        transporterSdo.setId(transporter.getId());
        transporterSdo.setCode(transporter.getCode());
        transporterSdo.setDisplayName(transporter.getDisplayName());
        return transporterSdo;
    }
    public static List<TransporterSdo> convertToTransporterSdo(List<Transporter> transporterList) {
        return transporterList.stream().map(t->convertToTransporterSdo(t)).collect(Collectors.toList());
    }
}

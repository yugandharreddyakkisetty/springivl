package com.bits.m2.assetmaster.service;

import com.bits.m2.assetmaster.dao.entity.Transporter;
import com.bits.m2.common.RapidGenericException;

import java.util.List;
import java.util.Optional;

public interface TransporterService {
    List<Transporter> listOfTransporters();
    Transporter transporterByCode(String code) throws RapidGenericException;
    Transporter transporterByCode1(String code) throws RapidGenericException;
    Transporter transporterByCodeSpec(String code) throws RapidGenericException;
    List<Transporter> transporterList(Optional<List<String>> code,Optional<List<Long>> id);
}

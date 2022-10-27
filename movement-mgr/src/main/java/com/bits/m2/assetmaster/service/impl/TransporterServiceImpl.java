package com.bits.m2.assetmaster.service.impl;

import com.bits.m2.assetmaster.dao.TransporterRepo;
import com.bits.m2.assetmaster.dao.entity.Transporter;
import com.bits.m2.assetmaster.dao.impl.TransporterSpec;
import com.bits.m2.assetmaster.service.TransporterService;
import com.bits.m2.common.RapidGenericException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.GetMapping;


import java.util.List;
import java.util.Optional;



@Service
public class TransporterServiceImpl implements TransporterService {

    @Autowired
    private TransporterRepo transporterRepo;

    @Override
    public List<Transporter> listOfTransporters() {
       return transporterRepo.findAll();

    }
    @Override
    public Transporter transporterByCode(String code) throws RapidGenericException {
        Optional<Transporter> transporter= transporterRepo.findByCode(code);
        if (transporter.isPresent()) return transporter.get();
        else throw new RapidGenericException("No transporter found with the given id");

    }
    @Override
    public Transporter transporterByCode1(String code) throws RapidGenericException {
        List<Transporter> transporterList = transporterRepo.transporterByCode(code);
        if(transporterList.isEmpty()) throw new RapidGenericException("No transporter found with the given id");
        else return transporterList.get(0);
    }
    @Override
    public Transporter transporterByCodeSpec(String code) throws RapidGenericException {
        List<Transporter> transporterList = transporterRepo.findAll(Specification.where(TransporterSpec.hasCode(code)));
        return transporterList.get(0);
    }
    @Override
    public List<Transporter> transporterList(Optional<List<String>> code,Optional<List<Long>> id) {
        List<Transporter> transporterList = transporterRepo.findAll(Specification.where(TransporterSpec.hasCode(code)).and(TransporterSpec.hasId(id)));
        return transporterList;
    }
}

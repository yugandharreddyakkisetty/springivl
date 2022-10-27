package com.bits.m2.assetmaster.controller;

import com.bits.m2.assetmaster.dao.entity.Transporter;
import com.bits.m2.assetmaster.sdo.TransporterSdo;
import com.bits.m2.assetmaster.service.TransporterService;
import com.bits.m2.assetmaster.util.TransporterConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.util.List;
import java.util.Optional;

@RestController
public class TransporterController {

    @Autowired
    private TransporterService transporterService;

    @GetMapping("/transporters")
    public List<TransporterSdo> listOfTransporters() {
        List<Transporter> transporterList= transporterService.listOfTransporters();
        List<TransporterSdo> transporterSdoList = TransporterConverter.convertToTransporterSdo(transporterList);
        return transporterSdoList;
    }

    @GetMapping("/transporters/{code}")
    public ResponseEntity<TransporterSdo> transporterByCode(@PathVariable("code") String code ) {
        TransporterSdo transporterSdo = TransporterConverter.convertToTransporterSdo(transporterService.transporterByCode(code));
        TransporterSdo transporterSdo1 = TransporterConverter.convertToTransporterSdo(transporterService.transporterByCode1(code));
        return new ResponseEntity<>(transporterSdo1, HttpStatus.OK);
    }

    @GetMapping("/transporter/{code}")
    public ResponseEntity<TransporterSdo> transporterByCodeSpec(@PathVariable("code") String code) {
        TransporterSdo transporterSdo = TransporterConverter.convertToTransporterSdo(transporterService.transporterByCodeSpec(code));
        return new ResponseEntity<>(transporterSdo, HttpStatus.OK);
    }
    @GetMapping("/trans")
    public ResponseEntity<List<TransporterSdo>> transporterList(@RequestParam("code") Optional<List<String>> codeList,@RequestParam("id") Optional<List<Long>> id) {
        List<TransporterSdo> transporterSdoList = TransporterConverter.convertToTransporterSdo(transporterService.transporterList(codeList,id));
        return new ResponseEntity<>(transporterSdoList,HttpStatus.OK);
    }

}

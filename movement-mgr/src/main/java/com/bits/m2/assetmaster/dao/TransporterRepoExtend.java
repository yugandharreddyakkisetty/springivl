package com.bits.m2.assetmaster.dao;

import com.bits.m2.assetmaster.dao.entity.Transporter;

import java.util.List;
import java.util.Optional;

public interface TransporterRepoExtend {
     List<Transporter> transporterByCode(String code);
}

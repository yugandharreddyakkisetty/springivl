package com.bits.m2.assetmaster.dao.impl;

import com.bits.m2.assetmaster.dao.entity.Transporter;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class TransporterSpec {

    public static Specification<Transporter> hasCode(String code) {
        return ((root, query, criteriaBuilder) ->{
            return criteriaBuilder.equal(root.get("code"),code);
        });
    }

    public static Specification<Transporter> hasCode(Optional<List<String>> code){
        return ((root, query, criteriaBuilder) -> {
           if(code.isPresent()) return criteriaBuilder.isTrue(root.get("code").in(code.get()));
           else return criteriaBuilder.isTrue(criteriaBuilder.literal(true));
        });
    }
    public static Specification<Transporter> hasId(Optional<List<Long>> id) {
        return ((root, query, criteriaBuilder) -> {
            if(id.isPresent()) return criteriaBuilder.isTrue(root.get("id").in(id.get()));
            else return criteriaBuilder.isTrue(criteriaBuilder.literal(true));
        });
    }
}

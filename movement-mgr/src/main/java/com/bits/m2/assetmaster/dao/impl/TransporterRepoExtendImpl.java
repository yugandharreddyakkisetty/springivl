package com.bits.m2.assetmaster.dao.impl;

import com.bits.m2.assetmaster.dao.TransporterRepoExtend;
import com.bits.m2.assetmaster.dao.entity.Transporter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Optional;

@Repository
public class TransporterRepoExtendImpl implements TransporterRepoExtend {
    @Autowired
    private EntityManager entityManager;
    @Override
    public List<Transporter> transporterByCode(String code){
        CriteriaBuilder cBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Transporter> cQuery = cBuilder.createQuery(Transporter.class);
        Root<Transporter> transporterRoot = cQuery.from(Transporter.class);

        Predicate predicate = cBuilder.equal(transporterRoot.get("code"),code);
        Predicate predicate1 = cBuilder.equal(transporterRoot.get("code"),code);
        cQuery.select(transporterRoot).where(cBuilder.and(predicate,predicate1));
        TypedQuery<Transporter> query = entityManager.createQuery(cQuery);
        return query.getResultList();



    }
}

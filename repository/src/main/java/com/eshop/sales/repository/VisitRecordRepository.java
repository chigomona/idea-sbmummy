package com.eshop.sales.repository;

import com.eshop.sales.model.VisitRecord;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VisitRecordRepository extends CrudRepository<VisitRecord, Long> {

    //implement by Spring via method definition
    VisitRecord findTopByVisitorNameOrderByVisitTimeDesc(String visitorName) ;

    //implement by Spring via method definition
    long countByVisitorName(String visitorName) ;
}

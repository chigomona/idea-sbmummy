package com.eshop.sales.serviceapi;

import com.eshop.sales.model.VisitRecord;

public interface VisitService {

   VisitRecord findLastVisit(String visitorName) ;

   VisitRecord createVisitRecord(String visitorName) ;

   long countVisitTimes(String visitorName) ;
}

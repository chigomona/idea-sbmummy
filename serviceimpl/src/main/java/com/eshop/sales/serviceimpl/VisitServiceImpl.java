package com.eshop.sales.serviceimpl;

import com.eshop.sales.model.VisitRecord;
import com.eshop.sales.repository.VisitRecordRepository;
import com.eshop.sales.serviceapi.VisitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class VisitServiceImpl implements VisitService {

    @Autowired
    private VisitRecordRepository visitRecordRepository;

    @Override
    public VisitRecord findLastVisit(String visitorName) {
        VisitRecord lastVisit = visitRecordRepository.findTopByVisitorNameOrderByVisitTimeDesc(visitorName);
        return lastVisit;
    }

    @Override
    public VisitRecord createVisitRecord(String visitorName) {
        String currentTime = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(new Date());
        VisitRecord visitRecord = new VisitRecord();
        visitRecord.setVisitorName(visitorName);
        visitRecord.setVisitTime(currentTime);
        visitRecordRepository.save(visitRecord);
        return visitRecord;
    }

    @Override
    public long countVisitTimes(String visitorName) {
        long visitCount = visitRecordRepository.countByVisitorName(visitorName);
        visitCount++;
        return visitCount;
    }


}

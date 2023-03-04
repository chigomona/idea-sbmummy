package com.eshop.sales.web;

import com.eshop.sales.model.VisitRecord;
import com.eshop.sales.serviceapi.VisitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class VisitController {

    @Autowired
    protected VisitService visitService;

    @RequestMapping("/visitorsign")
    public String visitorsign(Map<String, Object> model) {
        return "visitor/sign";
    }

    @RequestMapping(value = "/welcomevisitor", method = RequestMethod.POST)
    public String welcomevisitor(@RequestParam(value = "visitorname") String visitorName, Map<String, Object> model) {
        VisitRecord lastVisit = visitService.findLastVisit(visitorName);
        long visitCount = visitService.countVisitTimes(visitorName);
        VisitRecord currentVisit = visitService.createVisitRecord(visitorName) ;
        model.put("visitorName", visitorName);
        model.put("visitCount", visitCount) ;
        model.put("lastVisitTime", (lastVisit != null) ? lastVisit.getVisitTime() : "");
        model.put("currentTime", currentVisit.getVisitTime());
        return "visitor/welcome";
    }

}

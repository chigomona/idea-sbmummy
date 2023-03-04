package com.eshop.sales.model;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "visitrecord")
public class VisitRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private Long id;

    private String visitorName;

    private String visitTime;

    public Long getId() {
        return id;
    }

    public String getVisitorName() {
        return visitorName;
    }

    public String getVisitTime() {
        return visitTime;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setVisitorName(String visitorName) {
        this.visitorName = visitorName;
    }

    public void setVisitTime(String visitTime) {
        this.visitTime = visitTime;
    }
}

package com.knowledgebase.company.tripadvisor;

public class Coupon {
    public int id;
    public String subject;
    public String description;
    public int locationId;

    public Coupon(int id, String subject, String description, int locationId) {
        this.id = id;
        this.subject = subject;
        this.description = description;
        this.locationId = locationId;
    }
}
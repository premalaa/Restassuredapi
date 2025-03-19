package com.premalaanand.ex010_PayloadManagement.tool02;

import java.util.LinkedHashMap;
import java.util.Map;



public class Booking {

    private String firstname;
    private String lastname;
    private Integer totalprice;
    private Boolean depositpaid;
    private BookingDates bookingdates;
    private String additionalneeds;
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Integer gettotalprice() {
        return totalprice;
    }

    public void settotalprice(Integer totalprice) {
        this.totalprice = totalprice;
    }

    public Boolean getdepositpaid() {
        return depositpaid;
    }

    public void setdepositpaid(Boolean depositpaid) {
        this.depositpaid = depositpaid;
    }

    public BookingDates getBookingdates() {
        return bookingdates;
    }

    public void setBookingDates(BookingDates bookingdates) {
        this.bookingdates = bookingdates;
    }

    public String getadditionalneeds() {
        return additionalneeds;
    }

    public void setadditionalneeds(String additionalneeds) {
        this.additionalneeds = additionalneeds;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setadditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
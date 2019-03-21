package com.company;

import java.util.Date;

public class AbroadTrip extends Trip {

    private Long insurance;

    public AbroadTrip(Date start, Date end, String destination, Long price, Long insurance) {
        super(start, end, destination, price);
        this.insurance = insurance;
    }

    @Override
    public Long getPrice() {
        return (super.getPrice() + insurance);
    }

    public void setInsurance(Long insurance) {
        this.insurance = insurance;
    }
}

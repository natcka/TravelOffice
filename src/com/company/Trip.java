package com.company;

import java.util.Date;

public class Trip {

    private Date start;
    private Date end;
    private String destination;
    private Long price;

    public Trip() {
    }

    public Trip(Date start, Date end, String destination, Long price) {
        this.start = start;
        this.end = end;
        this.destination = destination;
        this.price = price;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Trip: \n");
        if (destination != null) {
            sb.append("\tdestination: " + destination);
        }
        if (start != null) {
            sb.append(",\n\tfrom: " + start.toString());
        }
        if (end != null) {
            sb.append(",\n\tto: " + end.toString());
        }
        if (price != null) {
            sb.append(",\n\tprice: " + price.toString());
        }
        return sb.toString();
    }
}

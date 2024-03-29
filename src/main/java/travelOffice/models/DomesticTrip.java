package travelOffice.models;

import java.time.LocalDate;

public class DomesticTrip extends Trip {

    private Long ownArrivalDiscount; //w procentach

    public DomesticTrip(LocalDate start, LocalDate end, String destination, Long price, Long ownArrivalDiscount, boolean domestic) {
        super(start, end, destination, price, domestic);
        this.ownArrivalDiscount = ownArrivalDiscount;
    }

    @Override
    public Long getPrice() {
        return super.getPrice() - ((super.getPrice() * ownArrivalDiscount) / 100);
    }

    public void setOwnArrivalDiscount(Long ownArrivalDiscount) {
        this.ownArrivalDiscount = ownArrivalDiscount;
    }
}

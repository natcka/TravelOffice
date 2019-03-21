package travelOffice.models;

import java.time.LocalDate;
import java.util.Date;

public class DomesticTrip extends Trip {

    private Long ownArrivalDiscount; //w procentach
    private final boolean domestic = true;

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

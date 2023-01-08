package org.parking;

public class test {
    private Integer id;
    private Integer score;
    private Integer zoneId;

    public Integer getId() {
        return id;
    }

    public Integer getScore() {
        return score;
    }

    public Integer getZoneId() {
        return zoneId;
    }

    public test(ParkingLot parkingLot,Integer score) {
        this.id = parkingLot.getParkingLotId();
        this.score = score;
        this.zoneId = parkingLot.getZoneId();
    }
}

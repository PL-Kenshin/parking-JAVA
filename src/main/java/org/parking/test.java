package org.parking;

public class test {
    private Integer id;
    private Integer score;
    private Integer cordX;
    private Integer cordY;
    private Integer zoneId;

    public Integer getId() {
        return id;
    }

    public Integer getScore() {
        return score;
    }

    public Integer getCordX() {
        return cordX;
    }

    public Integer getCordY() {
        return cordY;
    }

    public Integer getZoneId() {
        return zoneId;
    }

    public test(ParkingLot parkingLot, int x, int y) {
        this.id = parkingLot.getParkingLotId();
        this.score = (100-parkingLot.getDistanceTo(x,y));
        this.cordX = parkingLot.getCordX();
        this.cordY = parkingLot.getCordY();
        this.zoneId = parkingLot.getZoneId();
    }
}

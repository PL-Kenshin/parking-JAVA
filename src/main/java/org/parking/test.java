package org.parking;

public class test {
    private Integer id;
    private long score;
    private Integer zoneId;

    public Integer getId() {
        return id;
    }

    public long getScore() {
        return score;
    }

    public Integer getZoneId() {
        return zoneId;
    }

    public test(ParkingLot parkingLot,long score) {
        this.id = parkingLot.getParkingLotId();
        this.score = score;
        this.zoneId = parkingLot.getZoneId();
    }

    @Override
    public String toString() {
        return "test{" +
                "id=" + id +
                ", score=" + score +
                ", zoneId=" + zoneId +
                '}';
    }
}

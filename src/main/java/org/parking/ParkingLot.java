package org.parking;

public class ParkingLot {
    private Integer parkingLotId;
    private Integer zoneId;
    private Double cordX;
    private Double cordY;
    private boolean isForHandicapped;
    private boolean isGuarded;
    private boolean isPaid;
    private Integer freeSpaces;

    public Integer getParkingLotId() {
        return parkingLotId;
    }

    public void setParkingLotId(Integer parkingLotId) {
        this.parkingLotId = parkingLotId;
    }

    public Integer getZoneId() {
        return zoneId;
    }

    public void setZoneId(Integer zoneId) {
        this.zoneId = zoneId;
    }

    public Double getCordX() {
        return cordX;
    }

    public void setCordX(Double cordX) {
        this.cordX = cordX;
    }

    public Double getCordY() {
        return cordY;
    }

    public void setCordY(Double cordY) {
        this.cordY = cordY;
    }

    public boolean isForHandicapped() {
        return isForHandicapped;
    }

    public void setForHandicapped(boolean forHandicapped) {
        isForHandicapped = forHandicapped;
    }

    public boolean isGuarded() {
        return isGuarded;
    }

    public void setGuarded(boolean guarded) {
        isGuarded = guarded;
    }

    public boolean isPaid() {
        return isPaid;
    }

    public void setPaid(boolean paid) {
        isPaid = paid;
    }

    public Integer getFreeSpaces() {
        return freeSpaces;
    }

    public void setFreeSpaces(Integer freeSpaces) {
        this.freeSpaces = freeSpaces;
    }

    public ParkingLot(Integer parkingLotId, Integer zoneId, Double cordX, Double cordY, boolean isForHandicapped, boolean isGuarded, boolean isPaid, Integer freeSpaces) {
        this.parkingLotId = parkingLotId;
        this.zoneId = zoneId;
        this.cordX = cordX;
        this.cordY = cordY;
        this.isForHandicapped = isForHandicapped;
        this.isGuarded = isGuarded;
        this.isPaid = isPaid;
        this.freeSpaces = freeSpaces;
    }
}

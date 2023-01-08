package org.parking;

public class ParkingLot {
    private Integer parkingLotId;
    private Integer zoneId;
    private Integer cordX;
    private Integer cordY;
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

    public Integer getCordX() {
        return cordX;
    }

    public void setCordX(Integer cordX) {
        this.cordX = cordX;
    }

    public Integer getCordY() {
        return cordY;
    }

    public void setCordY(Integer cordY) {
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

    int getDistanceTo(int x, int y){
        return Math.abs(x - cordX) + Math.abs(y - cordY);
    }

    public ParkingLot(Integer parkingLotId, Integer zoneId, Integer cordX, Integer cordY, boolean isForHandicapped, boolean isGuarded, boolean isPaid, Integer freeSpaces) {
        this.parkingLotId = parkingLotId;
        this.zoneId = zoneId;
        this.cordX = cordX;
        this.cordY = cordY;
        this.isForHandicapped = isForHandicapped;
        this.isGuarded = isGuarded;
        this.isPaid = isPaid;
        this.freeSpaces = freeSpaces;
    }

    @Override
    public String toString() {
        return "ParkingLot{" +
                "parkingLotId=" + parkingLotId +
                ", zoneId=" + zoneId +
                ", cordX=" + cordX +
                ", cordY=" + cordY +
                ", isForHandicapped=" + isForHandicapped +
                ", isGuarded=" + isGuarded +
                ", isPaid=" + isPaid +
                ", freeSpaces=" + freeSpaces +
                '}';
    }
}

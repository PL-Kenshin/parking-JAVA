package org.parking;

public class Zone {
    private Integer zoneId;
    private String city;
    private Integer cordX;
    private Integer cordY;
    private Double occupiedRatio;
    private Double attractivenessRatio;

    public Integer getZoneId() {
        return zoneId;
    }

    public void setZoneId(Integer zoneId) {
        this.zoneId = zoneId;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
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

    public Double getOccupiedRatio() {
        return occupiedRatio;
    }

    public void setOccupiedRatio(Double occupiedRatio) {
        this.occupiedRatio = occupiedRatio;
    }

    public Double getAttractivenessRatio() {
        return attractivenessRatio;
    }

    public void setAttractivenessRatio(Double attractivenessRatio) {
        this.attractivenessRatio = attractivenessRatio;
    }

    public Zone(Integer zoneId, String city, Integer cordX, Integer cordY, Double occupiedRatio, Double attractivenessRatio) {
        this.zoneId = zoneId;
        this.city = city;
        this.cordX = cordX;
        this.cordY = cordY;
        this.occupiedRatio = occupiedRatio;
        this.attractivenessRatio = attractivenessRatio;
    }
}

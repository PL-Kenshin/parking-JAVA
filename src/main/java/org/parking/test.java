package org.parking;

public class test {
    private Integer id;
    private Integer score;
    private Integer cordX;
    private Integer cordY;

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

    public test(Integer id, Integer score, Integer cordX, Integer cordY) {
        this.id = id;
        this.score = score;
        this.cordX = cordX;
        this.cordY = cordY;

    }
}

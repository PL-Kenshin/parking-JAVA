package org.parking;

public class User {
    private Integer userId;
    private Integer preferableZone;
    private String selectedCity;
    private String name;
    private String surname;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getPreferableZone() {
        return preferableZone;
    }

    public void setPreferableZone(Integer preferableZone) {
        this.preferableZone = preferableZone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getSelectedCity() {
        return selectedCity;
    }

    public void setSelectedCity(String selectedCity) {
        this.selectedCity = selectedCity;
    }

    public User(Integer userId, String selectedCity, String name, String surname) {
        this.userId = userId;
        this.selectedCity = selectedCity;
        this.name = name;
        this.surname = surname;
    }
}

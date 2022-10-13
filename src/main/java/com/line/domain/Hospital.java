package com.line.domain;

public class Hospital {
    private String id;
    private String address;
    private String district;
    private String category;
    private Integer emergencyRoom;
    private String name;
//    private String subdivision;

    public Hospital(String id, String address, String district, String category, Integer emergencyRoom, String name){
        this.id = id;
        this.address = address;
        this.district = district;
        this.category = category;
        this.emergencyRoom = emergencyRoom;
        this.name = name;
    }
    public String getAddress() {
        return address;
    }

    public String getDistrict() {
        String[] splitted = this.address.split(" ");
        return String.format("%s %s", splitted[0], splitted[1]);
    }

    public String getCategory() {
        return category;
    }

    public Integer getEmergencyRoom() {
        return emergencyRoom;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

}

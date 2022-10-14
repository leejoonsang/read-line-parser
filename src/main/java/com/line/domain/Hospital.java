package com.line.domain;

public class Hospital {
    private String id;
    private String address;
    private String district;
    private String category;
    private Integer emergencyRoom;
    private String name;
    private String subdivision;

    public Hospital(String id, String address, String district, String category, Integer emergencyRoom, String name, String subdivision){
        this.id = id;
        this.address = address;
        this.district = setDistrict();
        this.category = category;
        this.emergencyRoom = emergencyRoom;
        this.name = name;
        this.subdivision = subdivision;
    }

    public String getSqlInsertQuery(){
        String sql = String.format("INSERT INTO `bes2-db`.`seoul_hospital`\n" +
                "(`id`, `address`, `district`, `category`, `emergency_room`, `name`, `subdivision`)\n" +
                "VALUES\n" +
                "(\"%s\",\n" +
                "\"%s\",\n" +
                "\"%s\",\n" +
                "\"%s\",\n" +
                "%d,\n" +
                "\"%s\",\n" +
                "\"%s\");", this.id, this.address, this.district, this.category, this.emergencyRoom, this.name, this.subdivision);
        return sql;
    }

    public String getId() {
        return id;
    }
    public String getAddress() {
        return address;
    }

    public String setDistrict(){
        String[] splitted = this.address.split(" ");
        return String.format("%s %s", splitted[0], splitted[1]);
    }

    public String getDistrict() {
        return district;
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

    public String getSubdivision() {
        return subdivision;
    }
}

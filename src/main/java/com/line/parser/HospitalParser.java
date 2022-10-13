package com.line.parser;

import com.line.domain.Hospital;

public class HospitalParser implements Parser<Hospital>{

    private String replaceAllQuot(String str){
        return str.replaceAll("\"", "");
    }
    @Override
    public Hospital parse(String str) {
        String[] splitted = str.split(",");
        String district = splitted[0] + " " + splitted[1];
        return new Hospital(splitted[0],splitted[1], district, splitted[2], Integer.parseInt(splitted[6]), splitted[10]);
    }

}

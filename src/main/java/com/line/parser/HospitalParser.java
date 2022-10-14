package com.line.parser;

import com.line.domain.Hospital;

public class HospitalParser implements Parser<Hospital>{

    private String getSubdivision(String name){
        String[] subdivisions = {"소아", "피부", "성형", "정형외과", "척추", "교정", "산부인과", "관절", "봉합", "화상", "골절", "영유아", "안과", "가정의학과", "비뇨기과", "치과", "내과", "외과"};

        for(String subdivision : subdivisions){
            if(name.contains(subdivision)){
                return subdivision;
            }
        }
        return "";
    }

    private String replaceAllQuot(String str){
        return str.replaceAll("\"", "");
    }
    @Override
    public Hospital parse(String str) {
        String[] splitted = str.split(",");
        String district = splitted[0] + " " + splitted[1];

        String name = splitted[10];
        String subdivision = getSubdivision(name);
        return new Hospital(splitted[0],splitted[1], district, splitted[2], Integer.parseInt(splitted[6]), name, subdivision);
    }

}

package com.line;

import com.line.domain.Hospital;
import com.line.parser.HospitalParser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) throws IOException {
        FileController<Hospital> hospitalFileController = new FileController<>(new HospitalParser());
        String filename = "/Users/sangjoonlee/Desktop/BES2/week4/서울시_병의원_위치_정보.csv";
        List<Hospital> hospitals = hospitalFileController.readLines(filename);

        List<String> sqlStatements = new ArrayList<>();
        for(Hospital hospital : hospitals) {
            sqlStatements.add(hospital.getSqlInsertQuery());
        }
        String sqlFilename = "seoul_hospital_insert.sql";
        hospitalFileController.createANewFile(sqlFilename);
        hospitalFileController.writeLines(sqlStatements, sqlFilename);


//        System.out.println(hospitals.size());
//        for (Hospital hospital : hospitals) {
//            System.out.printf("%s, %s, %s, %s, %s, %s, %s\n", hospital.getId(), hospital.getAddress(), hospital.getDistrict(),
//                    hospital.getCategory(), hospital.getEmergencyRoom(), hospital.getName(), hospital.getSubdivision());

    }
}
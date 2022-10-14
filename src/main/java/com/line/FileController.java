package com.line;

import com.line.parser.Parser;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileController<T> {
    Parser<T> parser;
    boolean isRemoveColumnName = true;

    public FileController(Parser<T> parser) {
        this.parser = parser;
    }

    public FileController(Parser<T> parser, boolean isRemoveColumnName) {
        this.parser = parser;
        this.isRemoveColumnName = isRemoveColumnName;
    }

    public void createANewFile(String filename) throws IOException {
        File file = new File(filename);
        file.createNewFile();
        System.out.println("Does a file generated?:" + file.exists());
    }

    List<T> readLines(String filename) throws IOException {
        List<T> result = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(filename));
        String str;
        if (isRemoveColumnName) {
            br.readLine();
        }
        while ((str = br.readLine()) != null) {
            System.out.println(str);
            result.add(parser.parse(str));
        }
        return result;
    }

    public void writeLines(List<String> lines, String filename){
        File file = new File(filename);

        try{
            BufferedWriter writer =
                    new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), "utf-8"));

            for(String str : lines){
                writer.write(str);
            }
            writer.close();
        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }

}
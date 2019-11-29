package com.opencsv;

import com.opencsv.CSVReader;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class ReadAllOpenCsv {

    private static final String SAMPLE_CSV_FILE_PATH = "/home/admin97/Ayush/github/OpenCsv/src/main/resources/myData.csv";

    public static void main(String[] args) throws IOException {
        try {
            Reader reader = Files.newBufferedReader(Paths.get(SAMPLE_CSV_FILE_PATH));
            CSVReader csvReader = new CSVReader(reader);
            List<String[]> records = csvReader.readAll();
            for (String[] record: records) {
                System.out.println("NAME : " + record[0]);
                System.out.println("EMAIL : " + record[1]);
                System.out.println("CONTACT : " + record[2]);
                System.out.println("COUNTRY : " + record[3]);
                System.out.println("===========================");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

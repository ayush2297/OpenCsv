package com.opencsv;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;

public class OpenCsvReader {
    private static final String SAMPLE_CSV_FILE_PATH = "/home/admin97/Ayush/github/OpenCsv/src/main/resources/myData.csv";

    public static void main(String[] args) throws IOException {
        CSVReader csvReader;
        try {
            Reader reader = Files.newBufferedReader(Paths.get(SAMPLE_CSV_FILE_PATH));
            csvReader = new CSVReader(reader);
            String[] nextRecord;
            while ( (nextRecord = csvReader.readNext()) != null){
                System.out.println("NAME : " + nextRecord[0]);
                System.out.println("EMAIL : " + nextRecord[1]);
                System.out.println("CONTACT : " + nextRecord[2]);
                System.out.println("COUNTRY : " + nextRecord[3]);
                System.out.println("===========================");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

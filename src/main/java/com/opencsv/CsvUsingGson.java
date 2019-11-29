package com.opencsv;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class CsvUsingGson {
    private static final String SAMPLE_CSV_FILE_PATH = "/home/admin97/Ayush/github/OpenCsv/src/main/resources/data.csv";
    private static final String SAMPLE_JSON_FILE_PATH = "/home/admin97/Ayush/github/OpenCsv/src/main/resources/dataUsingGson.csv";

    public static void main(String[] args) throws IOException {
        try {
            Reader reader = Files.newBufferedReader(Paths.get(SAMPLE_CSV_FILE_PATH));
            CsvToBeanBuilder<CsvUser> csvToBeanBuilder = new CsvToBeanBuilder<>(reader);
            csvToBeanBuilder.withType(CsvUser.class);
            csvToBeanBuilder.withIgnoreLeadingWhiteSpace(true);
            CsvToBean<CsvUser> csvToBean = csvToBeanBuilder.build();
            List<CsvUser> csvUsers = csvToBean.parse();
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            String json = gson.toJson(csvUsers);
            FileWriter writer = new FileWriter(SAMPLE_JSON_FILE_PATH);
            writer.write(json);
            writer.close();
            BufferedReader br = new BufferedReader(new FileReader(SAMPLE_JSON_FILE_PATH));
            CsvUser[] userObj = gson.fromJson(br, CsvUser[].class);
            List<CsvUser> csvUserList = Arrays.asList(userObj);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


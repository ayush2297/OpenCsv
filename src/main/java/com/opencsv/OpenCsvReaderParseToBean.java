
package com.opencsv;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;

public class OpenCsvReaderParseToBean {
    private static final String SAMPLE_CSV_FILE_PATH = "/home/admin97/Ayush/github/OpenCsv/src/main/resources/myData.csv";

    public static void main(String[] args) throws IOException {
        try (
                Reader reader = Files.newBufferedReader(Paths.get(SAMPLE_CSV_FILE_PATH));
        ) {
            CsvToBean<CsvUser> csvToBean = new CsvToBeanBuilder(reader)
                    .withType(CsvUser.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();

            Iterator<CsvUser> csvUserIterator = csvToBean.iterator();

            while (csvUserIterator.hasNext()) {
                CsvUser csvUser = csvUserIterator.next();
                System.out.println("Name : " + csvUser.getName());
                System.out.println("Email : " + csvUser.getEmail());
                System.out.println("PhoneNo : " + csvUser.getPhoneNo());
                System.out.println("Country : " + csvUser.getCountry());
                System.out.println("==========================");
            }
        }
    }
}
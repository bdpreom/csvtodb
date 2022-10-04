package com.qv.csvtodb.helper;

import com.qv.csvtodb.model.Subscriber;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.web.multipart.MultipartFile;

public class CSVHelper {
    public static String TYPE = "text/csv";
    public String[] HEADERS = {"id"};

    public static boolean hasCSVFormat(MultipartFile file) {
        if (!TYPE.equals(file.getContentType())) {
            return false;
        }

        return true;
    }

    public static List<Subscriber> csvToSubscriber(InputStream is) {
        try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
             CSVParser csvParser = new CSVParser(fileReader,
                     CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());) {

            List<Subscriber> subscribers = new ArrayList<Subscriber>();
            Iterable<CSVRecord> csvRecords = csvParser.getRecords();
            for (CSVRecord csvRecord : csvRecords) {
                Subscriber subscriber = new Subscriber(
                  Long.parseLong(csvRecord.get("id")),
                  csvRecord.get("username"),
                  csvRecord.get("subscriber_name")
                        //Boolean.parseBoolean(csvRecord.get("Published"))

                );

                subscribers.add(subscriber);

            }

            return  subscribers;

        }

        catch (IOException e) {
            throw new RuntimeException("fail to parse CSV file: " + e.getMessage());
        }

    }


}

package com.qv.csvtodb.service;

import com.qv.csvtodb.helper.CSVHelper;
import com.qv.csvtodb.model.Subscriber;
import com.qv.csvtodb.repository.SubscriberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;


@Service
public class CSVService {
    @Autowired
    SubscriberRepository subscriberRepository;

    public void save(MultipartFile file) {
        try {
            List<Subscriber> subscribers = CSVHelper.csvToSubscriber(file.getInputStream());
            subscriberRepository.saveAll(subscribers);
        } catch (IOException e) {
            throw new RuntimeException("fail to store csv data: " + e.getMessage());
        }



    }


    public List<Subscriber> getAllSubscribers(){
        return subscriberRepository.findAll();
    }



}


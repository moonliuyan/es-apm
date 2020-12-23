package com.liuyan.javaapmdemon.service;

import co.elastic.apm.api.ElasticApm;
import co.elastic.apm.api.Span;
import co.elastic.apm.api.Transaction;
import com.liuyan.javaapmdemon.annotation.Esspan;
import org.springframework.stereotype.Service;

@Service
public class ApmService2 {



    @Esspan
    public void Method0_5002() {

        try {

            Thread.sleep(333);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
